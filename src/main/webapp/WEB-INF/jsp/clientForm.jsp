<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Client App</title>
    <link href="<c:url value="/resources/css/style.css" />"
          rel="stylesheet">
</head>
<body>
<form:form method="POST" action="add" modelAttribute="client">
    <form:errors path="*" cssClass="errorblock" element="div"/>
    Please enter your name and pick the Sectors you are currently involved in.
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>
                <form:label path="name">Name:</form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="sectors">Sectors:</form:label>
            </td>
            <td>
                <form:select path="sectors" multiple="true" size="10">
                    <c:forEach items="${sectorsList}" var="sector">
                        <form:option value="${sector.id}"
                                     selected="${(client.sectors.contains(sector))?'selected' : ''}">
                            ${sector.name}
                        </form:option>
                        <c:forEach items="${sector.subSectors}" var="subSector">
                            <form:option value="${subSector.id}"
                                         selected="${(client.sectors.contains(subSector))?'selected' : ''}">
                                &nbsp;&nbsp;&nbsp;&nbsp;${subSector.name}
                            </form:option>
                            <c:forEach items="${subSector.subSectors}" var="subSectorLvl2">
                                <form:option value="${subSectorLvl2.id}"
                                             selected="${(client.sectors.contains(subSectorLvl2))?'selected' : ''}">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${subSectorLvl2.name}
                                </form:option>
                                <c:forEach items="${subSectorLvl2.subSectors}" var="subSectorLvl3">
                                    <form:option value="${subSectorLvl3.id}"
                                                 selected="${(client.sectors.contains(subSectorLvl3))?'selected' : ''}">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${subSectorLvl3.name}
                                    </form:option>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="agreedToTerms">Agree to terms</form:label>
            </td>
            <td>
                <form:checkbox path="agreedToTerms"/>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>