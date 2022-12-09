package com.urise.webapp.web;

import com.urise.webapp.Config;
import com.urise.webapp.model.*;
import com.urise.webapp.storage.Storage;
import com.urise.webapp.util.DateUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeServlet extends HttpServlet {

    private Storage storage; // = Config.get().getStorage();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uuid = request.getParameter("uuid");
        String fullName = request.getParameter("fullName").trim();
        if (fullName.length() == 0) {
            doGet(request, response);
            return;
        }
        Resume r;
        if (uuid == null || uuid.length() == 0) {
            r = new Resume(fullName);
        } else {
            r = storage.get(uuid);
            r.setFullName(fullName);
        }
        for (ContactType type : ContactType.values()) {
            String value = request.getParameter(type.name());
            if (value != null && value.trim().length() != 0) {
                r.addContact(type, value.trim());
            } else {
                r.getContacts().remove(type);
            }
        }
        for (SectionType type : SectionType.values()) {
            String value = request.getParameter(type.name());
            String[] values = request.getParameterValues(type.name());
            if (value != null && value.trim().length() != 0) {
                switch (type) {
                    case OBJECTIVE, PERSONAL -> r.addSection(type, new TextSection(value.trim()));
                    case ACHIEVEMENT, QUALIFICATIONS -> {
                        List<String> listValue = Arrays.stream(value.split("\\n"))
                                .map(String::trim)
                                .filter(s -> s.length() > 0)
                                .toList();
                        r.addSection(type, new ListSection(listValue));
                    }
                    case EXPERIENCE, EDUCATION -> {
                        List<Organization> orgs = new ArrayList<>();
                        String[] urls = request.getParameterValues(type.name() + "url");
                        for (int i = 0; i < values.length; i++) {
                            String name = values[i];
                            if (name != null && name.trim().length() != 0) {
                                List<Organization.Position> positions = new ArrayList<>();
                                String[] startDates = request.getParameterValues(type.name() + i + "startDate");
                                String[] endDates = request.getParameterValues(type.name() + i + "endDate");
                                String[] titles = request.getParameterValues(type.name() + i + "title");
                                String[] descriptions = request.getParameterValues(type.name() + i + "description");
                                for (int j = 0; j < titles.length; j++) {
                                    if (titles[j] != null && titles[j].trim().length() != 0) {
                                        positions.add(new Organization.Position(DateUtil.parse(startDates[j]), DateUtil.parse(endDates[j]), titles[j].trim(), descriptions[j].trim()));
                                    }
                                }
                                orgs.add(new Organization(new Link(name, urls[i].trim()), positions));
                            }
                        }
                        r.addSection(type, new OrganizationSection(orgs));
                    }
                }
            } else {
                r.getSections().remove(type);
            }
        }
        if (uuid == null || uuid.length() == 0) {
            storage.save(r);
        } else {
            storage.update(r);
        }
        response.sendRedirect("resume");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("resumes", storage.getAllSorted());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            return;
        }
        Resume r;
        switch (action) {
            case "delete":
                storage.delete(uuid);
                response.sendRedirect("resume");
                return;
            case "view":
                r = storage.get(uuid);
                break;
            case "edit":
                r = storage.get(uuid);
                for (SectionType type : SectionType.values()) {
                    Section section = r.getSection(type);
                    switch (type) {
                        case OBJECTIVE, PERSONAL -> {
                            if (section == null) {
                                section = new TextSection("");
                            }
                        }
                        case ACHIEVEMENT, QUALIFICATIONS -> {
                            if (section == null) {
                                section = new ListSection("");
                            }
                        }
                        case EXPERIENCE, EDUCATION -> {
                            OrganizationSection orgSection = (OrganizationSection) section;
                            Organization emptyOrg = new Organization("", "", new Organization.Position());
                            if (section == null) {
                                section = new OrganizationSection(emptyOrg);
                            } else {
                                orgSection.getOrganizations().add(emptyOrg);
                            }
                        }
                    }
                    r.addSection(type, section);
                }
                break;
            case "add":
                r = new Resume();
                for (ContactType contact : ContactType.values()) {
                    r.addContact(contact, "");
                }
                for (SectionType type : SectionType.values()) {
                    switch (type) {
                        case OBJECTIVE, PERSONAL -> r.addSection(type, new TextSection(""));
                        case ACHIEVEMENT, QUALIFICATIONS -> r.addSection(type, new ListSection(""));
                        case EXPERIENCE, EDUCATION -> {
                            r.addSection(type, new OrganizationSection(new Organization("", "", new Organization.Position())));
                            System.out.println(r);
                        }
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }
        request.setAttribute("resume", r);
        request.getRequestDispatcher(
                ("view".equals(action) ? "/WEB-INF/jsp/view.jsp" : "/WEB-INF/jsp/edit.jsp")
        ).forward(request, response);
    }
}
