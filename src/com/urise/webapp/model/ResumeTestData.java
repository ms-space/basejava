package com.urise.webapp.model;

public class ResumeTestData {

    public Resume setResumeTestData(String uuid, String fullName) {
        Resume r = new Resume(uuid, fullName);

//        r.getContacts().put(ContactType.MOBILE, "+7(921) 855-0482");
//        r.getContacts().put(ContactType.SKYPE, "skype:grigory.kislin");
//        r.getContacts().put(ContactType.MAIL, "gkislin@yandex.ru");
//        r.getContacts().put(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
//        r.getContacts().put(ContactType.GITHUB, "https://github.com/gkislin");
//        r.getContacts().put(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
//        r.getContacts().put(ContactType.HOME_PAGE, "http://gkislin.ru/");
//
//        r.getSections().put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
//
//        r.getSections().put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
//
//        List<String> achievementData = new ArrayList<>();
//        achievementData.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
//        achievementData.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.");
//        achievementData.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
//        achievementData.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
//        achievementData.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
//        achievementData.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
//        achievementData.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
//        r.getSections().put(SectionType.ACHIEVEMENT, new ListSection(achievementData));
//
//        List<String> qualificationsData = new ArrayList<>();
//        qualificationsData.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
//        qualificationsData.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
//        qualificationsData.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
//        qualificationsData.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
//        qualificationsData.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
//        qualificationsData.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
//        qualificationsData.add("Python: Django.");
//        qualificationsData.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
//        qualificationsData.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
//        qualificationsData.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
//        qualificationsData.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
//        qualificationsData.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer");
//        qualificationsData.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
//        qualificationsData.add("Родной русский, английский \"upper intermediate\"");
//        r.getSections().put(SectionType.QUALIFICATIONS, new ListSection(qualificationsData));
//
//        Organization organization1 = new Organization("Java Online Projects", "http://javaops.ru/", List.of(
//                new Position(DateUtil.of(2013, Month.of(10)), LocalDate.now(), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.")));
//        Organization organization2 = (new Organization("Wrike", "https://www.wrike.com/", List.of(
//                new Position(DateUtil.of(2014, Month.of(10)), DateUtil.of(2016, Month.of(1)), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."))));
//        Organization organization3 = new Organization("RIT Center", "", List.of(
//                new Position(DateUtil.of(2012, Month.of(4)), DateUtil.of(2014, Month.of(10)), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")));
//        Organization organization4 = new Organization("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", List.of(
//                new Position(DateUtil.of(2010, Month.of(12)), DateUtil.of(2012, Month.of(4)), "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.")));
//        Organization organization5 = new Organization("Yota", "https://www.yota.ru/", List.of(
//                new Position(DateUtil.of(2008, Month.of(6)), DateUtil.of(2010, Month.of(12)), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)")));
//        Organization organization6 = new Organization("Enkata", "http://enkata.com/", List.of(
//                new Position(DateUtil.of(2007, Month.of(3)), DateUtil.of(2008, Month.of(6)), "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).")));
//        Organization organization7 = new Organization("Siemens AG", "https://www.siemens.com/ru/ru/home.html", List.of(
//                new Position(DateUtil.of(2005, Month.of(1)), DateUtil.of(2007, Month.of(2)), "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).")));
//        Organization organization8 = new Organization("Alcatel", "http://www.alcatel.ru/", List.of(
//                new Position(DateUtil.of(1997, Month.of(9)), DateUtil.of(2005, Month.of(1)), "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")));
//        r.getSections().put(SectionType.EXPERIENCE, new OrganizationSection(
//                List.of(organization1, organization2, organization3, organization4, organization5, organization6, organization7, organization8)));
//
//        Organization educationOrg1 = new Organization("Coursera", "https://www.coursera.org/course/progfun", List.of(
//                new Position(DateUtil.of(2013, Month.of(3)), DateUtil.of(2013, Month.of(5)), "'Functional Programming Principles in Scala' by Martin Odersky", "")));
//        Organization educationOrg2 = new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", List.of(
//                new Position(DateUtil.of(2011, Month.of(3)), DateUtil.of(2011, Month.of(4)), "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'", "")));
//        Organization educationOrg3 = new Organization("Siemens AG", "http://www.siemens.ru/", List.of(
//                new Position(DateUtil.of(2005, Month.of(1)), DateUtil.of(2005, Month.of(4)), "3 месяца обучения мобильным IN сетям (Берлин)", "")));
//        Organization educationOrg4 = new Organization("Alcatel", "http://www.alcatel.ru/", List.of(
//                new Position(DateUtil.of(1997, Month.of(9)), DateUtil.of(1998, Month.of(3)), "6 месяцев обучения цифровым телефонным сетям (Москва)", "")));
//        Organization educationOrg5 = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/", List.of(
//                new Position(DateUtil.of(1993, Month.of(9)), DateUtil.of(1996, Month.of(7)), "Аспирантура (программист С, С++)", ""),
//                new Position(DateUtil.of(1987, Month.of(9)), DateUtil.of(1993, Month.of(7)), "Инженер (программист Fortran, C)", "")));
//        Organization educationOrg6 = new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", List.of(
//                new Position(DateUtil.of(2013, Month.of(10)), DateUtil.of(2016, Month.of(1)), "Закончил с отличием", "")));
//        r.getSections().put(SectionType.EDUCATION, new OrganizationSection(
//                List.of(educationOrg1, educationOrg2, educationOrg3, educationOrg4, educationOrg5, educationOrg6)));

        return r;
    }

}
