<%@ page import="com.urise.webapp.model.TextSection" %>
<%@ page import="com.urise.webapp.model.ListSection" %>
<%@ page import="com.urise.webapp.model.OrganizationSection" %>
<%@ page import="com.urise.webapp.util.DateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <h2>${resume.fullName}&nbsp;<a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png"></a></h2>
    <p>
        <c:forEach var="contactEntry" items="${resume.contacts}">
            <jsp:useBean id="contactEntry"
                         type="java.util.Map.Entry<com.urise.webapp.model.ContactType, java.lang.String>"/>
                <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br/>
        </c:forEach>
    <p>
</section>
<p>
<section>

    <c:forEach var="sectionEntry" items="${resume.sections}">
    <c:set var="type" value="${sectionEntry.key}"/>
    <c:set var="section" value="${sectionEntry.value}" scope="page"/>
    <jsp:useBean id="section" type="com.urise.webapp.model.Section"/>
    <h3>${type.title}</h3>
    <c:choose>
    <c:when test="${type == 'OBJECTIVE' || type == 'PERSONAL'}">
        <%=((TextSection) section).getContent()%>
    </c:when>
    <c:when test="${type == 'ACHIEVEMENT' || type == 'QUALIFICATIONS'}">
        <ul class="list">
            <c:forEach var="items" items="<%=((ListSection)section).getItems()%>">
                <li>${items}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:when test="${type == 'EXPERIENCE' || type == 'EDUCATION'}">
    <p>
        <c:forEach var="org" items="<%=((OrganizationSection)section).getOrganizations()%>">
        <c:choose>
        <c:when test="${empty org.homePage.url}">
            ${org.homePage.name}<br>
        </c:when>
        <c:otherwise>
        <a href="${org.homePage.url}">${org.homePage.name}</a><br>
        </c:otherwise>
        </c:choose>
        <c:forEach var="position" items="${org.positions}">
            <jsp:useBean id="position" type="com.urise.webapp.model.Organization.Position"/>
                <%=DateUtil.format(position.getStartDate())%> <br>
                <%=DateUtil.format(position.getEndDate())%> <br>
            ${position.title}<br/>
            ${position.description}<br/>
        </c:forEach>
        </c:forEach>
        </c:when>
        </c:choose>
        </c:forEach>
</section>
<p>
    <jsp:include page="fragments/footer.jsp"/>
</body>
</html>