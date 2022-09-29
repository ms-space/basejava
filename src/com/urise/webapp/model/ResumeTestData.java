package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = new Resume("Григорий Кислин");
        r.getContacts().put(ContactType.TELEPHONE,"+7(921) 855-0482");
        r.getContacts().put(ContactType.SKYPE,"skype:grigory.kislin");

        r.getSections().put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        r.getSections().put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        r.getSections().put(SectionType.ACHIEVEMENT, new ListSection(List.of("qqq","www","eee")));
        r.getSections().put(SectionType.EXPERIENCE
                , new ListPeriodSection(
                        List.of(new Organizations(("org1"), List.of(
                                        new Period(LocalDate.of(2000, 11, 1), LocalDate.of(2002, 7, 15), "eng1", "text1"),
                                        new Period(LocalDate.of(2003, 12, 1), LocalDate.of(2002, 7, 15), "eng2", "text2"))
                                )
                        )
                )
        );

        System.out.println(r);
        System.out.println("=Контакты=");
        r.getContacts().entrySet().forEach(System.out::println);
        System.out.println("=Секции=");
        r.getSections().entrySet(). forEach(System.out::println);
    }
}
