package com.urise.webapp.web;

import com.urise.webapp.Config;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ResumeServlet extends HttpServlet {

    private Storage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("""
                <html>
                       <head>
                           <meta charset="UTF-8">
                           <title>Таблица резюме</title>
                       </head>
                       <body>
                       <table border="1" cellpadding = "5">
                          <caption><h3>Таблица резюме</h3></caption>
                          <tr>
                           <th>UUID</th>
                           <th>Имя</th>
                          </tr>
                """
        );

        List<Resume> resumes = storage.getAllSorted();
        for (Resume r : resumes) {
            writer.write("" +
                    "<tr ><td >" + r.getUuid() + "</td ><td>" + r.getFullName() + "</td ></tr>");
        }

        writer.write("""
                        </table>
                        </body >
                    </html >
                """
        );

//        String name = request.getParameter("name");
//        response.getWriter().write(name == null ? "Hello Resumes!" : "Hello " + name + '!');
    }
}
