<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.example.webapp.model.Data" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome</title>
    <style>
        table {
            border: 2px solid black;
            border-collapse: collapse;
        }

        th, td {
            border: 2px solid black;
            padding: 8px;
        }

        th {
            color: white;
            background-color: blue;
        }
    </style>
</head>
<body>
<h2>
    Welcome
    <%=request.getAttribute("nama")%></h2>
<table>
    <thead>
    <tr>
        <th>Department</th>
        <th>Student ID</th>
        <th>Marks</th>
        <th>Pass%</th>
    </tr>
    </thead>
    <tbody>
    <%
        String dataList = (String) request.getAttribute("dataList");
        Gson gson = new Gson();
        Data[] dataArray = gson.fromJson(dataList, Data[].class);
        String currentDepartment = "";
        for (Data data : dataArray) {
            if (!Data.getDepartment(data).equals(currentDepartment)) {
                currentDepartment = Data.getDepartment(data);
    %>
    <tr>
        <td rowspan="<%=data.getStudentId().size()%>"><%=Data.getDepartment(data)%></td>
        <td><%=data.getStudentId().get(0)%></td>
        <td><%=data.getMarks().get(0)%></td>
        <td rowspan="<%=data.getStudentId().size()%>"><%=data.getPercentage()%></td>
    </tr>
    <%
        for (int i = 1; i < data.getStudentId().size(); i++) {
    %>
    <tr>
        <td><%=data.getStudentId().get(i)%></td>
        <td><%=data.getMarks().get(i)%></td>
    </tr>
    <%
                }
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
