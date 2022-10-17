package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());

            writeList(dos, r.getContacts().entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });

            writeList(dos, r.getSections().entrySet(), entry -> {
                SectionType type = entry.getKey();
                Section section = entry.getValue();
                dos.writeUTF(type.name());
                switch (type) {
                    case PERSONAL, OBJECTIVE -> dos.writeUTF(((TextSection) section).getContent());
                    case ACHIEVEMENT, QUALIFICATIONS ->
                            writeList(dos, ((ListSection) section).getItems(), dos::writeUTF);
                    case EXPERIENCE, EDUCATION -> writeOrganization(dos, (OrganizationSection) section);
                }
            });
        }
    }

    private void writeOrganization(DataOutputStream dos, OrganizationSection section) throws IOException {
        writeList(dos, section.getOrganizations(), org -> {
            dos.writeUTF(org.getHomePage().getName());
            dos.writeUTF(org.getHomePage().getUrl());
            writePosition(dos, org);
        });
    }

    private void writePosition(DataOutputStream dos, Organization org) throws IOException {
        writeList(dos, org.getPositions(), pos -> {
            dos.writeUTF(pos.getStartDate().toString());
            dos.writeUTF(pos.getEndDate().toString());
            dos.writeUTF(pos.getTitle());
            dos.writeUTF(pos.getDescription());
        });
    }

    private <T> void writeList(DataOutputStream dos, Collection<T> list, Writer<T> writer) throws IOException {
        dos.writeInt(list.size());
        for (T element : list) {
            writer.write(element);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);

            readList(dis, () -> {
                ContactType contactType = ContactType.valueOf(dis.readUTF());
                String value = dis.readUTF();
                resume.addContact(contactType, value);
                return null;
            });

            readList(dis, () -> {
                SectionType section = SectionType.valueOf(dis.readUTF());
                resume.addSection(section, switch (section) {
                    case PERSONAL, OBJECTIVE -> new TextSection(dis.readUTF());
                    case ACHIEVEMENT, QUALIFICATIONS -> new ListSection(readList(dis, dis::readUTF));
                    case EXPERIENCE, EDUCATION -> new OrganizationSection(readList(dis, () -> getOrganization(dis)));
                });
                return null;
            });
            return resume;
        }
    }

    private Organization getOrganization(DataInputStream dis) throws IOException {
        String name = dis.readUTF();
        String url = dis.readUTF();
        return new Organization(new Link(name, url), readList(dis, () -> getPosition(dis)));
    }

    private static Organization.Position getPosition(DataInputStream dis) throws IOException {
        LocalDate startDate = LocalDate.parse(dis.readUTF());
        LocalDate endDate = LocalDate.parse(dis.readUTF());
        String title = dis.readUTF();
        String description = dis.readUTF();
        return new Organization.Position(startDate, endDate, title, description);
    }

    private <T> List<T> readList(DataInputStream dis, Reader<T> reader) throws IOException {
        int size = dis.readInt();
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(reader.read());
        }
        return list;
    }

    private interface Writer<T> {
        void write(T t) throws IOException;
    }

    private interface Reader<T> {
        T read() throws IOException;
    }

}
