package com.urise.webapp.web;

import com.urise.webapp.Config;
import com.urise.webapp.model.*;
import com.urise.webapp.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            storage.save(r);
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
//                    case EXPERIENCE, EDUCATION -> ;
                }
            } else {
                r.getSections().remove(type);
            }
        }
        storage.update(r);
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
                    if (r.getSection(type) == null) {
                        switch (type) {
                            case OBJECTIVE, PERSONAL -> r.addSection(type, new TextSection(""));
                            case ACHIEVEMENT, QUALIFICATIONS -> r.addSection(type, new ListSection(""));
                            case EXPERIENCE, EDUCATION -> r.addSection(type,
                                    new OrganizationSection(new Organization("", "")));
                        }
                    }
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
                        case EXPERIENCE, EDUCATION -> r.addSection(type,
                                new OrganizationSection(new Organization("", "")));
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
