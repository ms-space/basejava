<%@ page import="com.urise.webapp.model.ContactType" %>
<%@ page import="com.urise.webapp.model.SectionType" %>
<%@ page import="com.urise.webapp.model.ListSection" %>
<%@ page import="com.urise.webapp.model.OrganizationSection" %>
<%@ page import="com.urise.webapp.util.DateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="com.urise.webapp.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>Имя:</dt>
            <dd><input type="text" required name="fullName" size=50 value="${resume.fullName}"></dd>
        </dl>
        <h3>Контакты:</h3>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <dl>
                <dt>${type.title}</dt>
                <dd><input type="text" name="${type.name()}" size=30 value="${resume.getContact(type)}"></dd>
            </dl>
        </c:forEach>
        <h3>Секции:</h3>
        <c:forEach var="type" items="<%=SectionType.values()%>">
            <c:set var="section" value="${resume.getSection(type)}"/>
            <jsp:useBean id="section" type="com.urise.webapp.model.Section"/>
            <h3>${type.title}</h3>
            <c:choose>
                <c:when test="${type == 'OBJECTIVE' || type == 'PERSONAL'}">
                    <input type="text" name="${type}" size=100 value="${resume.getSection(type)}">
                </c:when>
                <c:when test="${type == 'ACHIEVEMENT' || type == 'QUALIFICATIONS'}">
                    <textarea name="${type}" cols="100"
                              rows="10"><%=String.join("\n", ((ListSection) section).getItems())%></textarea>
                </c:when>
                <c:when test="${type == 'EXPERIENCE' || type == 'EDUCATION'}">
                    <dl>
                        <c:forEach var="org" items="<%=((OrganizationSection)section).getOrganizations()%>"
                                   varStatus="number">
                            <dt>Название организации:</dt>
                            <dd><input type="text" name="${type}" size=100 value="${org.homePage.name}"></dd>
                            <dt>Сайт организации:</dt>
                            <dd><input type="text" name="${type}url" size=100 value="${org.homePage.url}"></dd>
                            <c:forEach var="position" items="${org.positions}">
                                <jsp:useBean id="position" type="com.urise.webapp.model.Organization.Position"/>
                                <dt>Начальная дата:</dt>
                                <dd>
                                    <input type="text" name="${type}${number.index}startDate" size=10
                                           value="<%=DateUtil.format(position.getStartDate())%>" placeholder="MM/yyyy">
                                </dd>
                                <dt>Конечная дата:</dt>
                                <dd>
                                    <input type=" text" name="${type}${number.index}endDate" size=10
                                           value="<%=DateUtil.format(position.getEndDate())%>" placeholder="MM/yyyy">
                                </dd>
                                <dt>Должность:</dt>
                                <dd>
                                    <input type="text" name="${type}${number.index}title" size=100
                                           value="${position.title}">
                                </dd>
                                <dt>Описание:</dt>
                                <dd>
                                      <textarea name="${type}${number.index}description" cols="100"
                                                rows="5">${position.description}</textarea>
                                </dd>
                            </c:forEach>
                            <hr>
                        </c:forEach>
                    </dl>
                </c:when>
            </c:choose>
        </c:forEach>
        <hr>
        <button type="submit">Сохранить</button>
        <button type="reset" onclick="window.history.back()">Отменить</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

