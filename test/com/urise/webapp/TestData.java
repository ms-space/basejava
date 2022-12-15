package com.urise.webapp;

import com.urise.webapp.model.*;
import com.urise.webapp.util.DateUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

public class TestData {

    public static final String UUID_NOT_EXIST = "dummy";
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {

        R1 = new Resume(UUID_1, "Григорий Кислин");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.setContact(ContactType.MOBILE, "+7(921) 855-0482");
        R1.setContact(ContactType.MOBILE, "+7(921) 855-0482");
        R1.setContact(ContactType.SKYPE, "skype:grigory.kislin");
        R1.setContact(ContactType.MAIL, "gkislin@yandex.ru");
        R1.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        R1.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        R1.setContact(ContactType.STATCKOVERFLOW, "https://stackoverflow.com/users/548473");
        R1.setContact(ContactType.HOME_PAGE, "http://gkislin.ru/");

        R1.setSection(SectionType.OBJECTIVE, new TextSection(
                "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        R1.setSection(SectionType.PERSONAL, new TextSection(
                "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        R1.setSection(SectionType.ACHIEVEMENT, new ListSection(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        ));

        R1.setSection(SectionType.QUALIFICATIONS, new ListSection(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Query, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский \"upper intermediate\""
        ));

        R1.setSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("Java Online Projects", "http://javaops.ru/",
                        new Organization.Position(DateUtil.of(2013, Month.of(10)), LocalDate.now(), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.")),
                new Organization("Wrike", "https://www.wrike.com/",
                        new Organization.Position(DateUtil.of(2014, Month.of(10)), DateUtil.of(2016, Month.of(1)), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")),
                new Organization("RIT Center", "",
                        new Organization.Position(DateUtil.of(2012, Month.of(4)), DateUtil.of(2014, Month.of(10)), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")),
                new Organization("Yota", "https://www.yota.ru/",
                        new Organization.Position(DateUtil.of(2008, Month.of(6)), DateUtil.of(2010, Month.of(12)), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)")),
                new Organization("Enkata", "http://enkata.com/",
                        new Organization.Position(DateUtil.of(2007, Month.of(3)), DateUtil.of(2008, Month.of(6)), "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).")),
                new Organization("Siemens AG", "https://www.siemens.com/ru/ru/home.html",
                        new Organization.Position(DateUtil.of(2005, Month.of(1)), DateUtil.of(2007, Month.of(2)), "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).")),
                new Organization("Alcatel", "http://www.alcatel.ru/",
                        new Organization.Position(DateUtil.of(1997, Month.of(9)), DateUtil.of(2005, Month.of(1)), "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."))));


        R1.setSection(SectionType.EDUCATION, new OrganizationSection(
                new Organization("Coursera", "https://www.coursera.org/course/progfun",
                        new Organization.Position(DateUtil.of(2013, Month.of(3)), DateUtil.of(2013, Month.of(5)), "'Functional Programming Principles in Scala' by Martin Odersky", "")),
                new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366",
                        new Organization.Position(DateUtil.of(2011, Month.of(3)), DateUtil.of(2011, Month.of(4)), "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'", "")),
                new Organization("Siemens AG", "http://www.siemens.ru/",
                        new Organization.Position(DateUtil.of(2005, Month.of(1)), DateUtil.of(2005, Month.of(4)), "3 месяца обучения мобильным IN сетям (Берлин)", "")),
                new Organization("Alcatel", "http://www.alcatel.ru/",
                        new Organization.Position(DateUtil.of(1997, Month.of(9)), DateUtil.of(1998, Month.of(3)), "6 месяцев обучения цифровым телефонным сетям (Москва)", "")),
                new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/",
                        new Organization.Position(DateUtil.of(1993, Month.of(9)), DateUtil.of(1996, Month.of(7)), "Аспирантура (программист С, С++)", ""),
                        new Organization.Position(DateUtil.of(1987, Month.of(9)), DateUtil.of(1993, Month.of(7)), "Инженер (программист Fortran, C)", "")),
                new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/",
                        new Organization.Position(DateUtil.of(2013, Month.of(10)), DateUtil.of(2016, Month.of(1)), "Закончил с отличием", ""))));

        R2.setContact(ContactType.MAIL, "mail1@ya.ru");
        R2.setContact(ContactType.PHONE, "11111");
        R2.setSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R2.setSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R2.setSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R2.setSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R2.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R2.setSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization2", "http://Organization2.ru",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));
        R2.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru",
                                new Organization.Position(2002, Month.JANUARY, 2000, Month.DECEMBER, "aspirant1", null),
                                new Organization.Position(2003, Month.MARCH, 2005, Month.JANUARY, "student1", "IT facultet"))
                ));

        R3.setContact(ContactType.SKYPE, "skype2");
        R3.setContact(ContactType.PHONE, "22222");
        R3.setContact(ContactType.MAIL, "mail1@ya.ru");
        R3.setSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R3.setSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R3.setSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R3.setSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R3.setSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("Organization11", "http://Organization11.ru",
                        new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                        new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R3.setSection(SectionType.EDUCATION, new OrganizationSection(
                new Organization("Institute", null,
                        new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                        new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet"))
        ));

        R4.setContact(ContactType.PHONE, "44444");
        R4.setContact(ContactType.SKYPE, "Skype");
    }
}
