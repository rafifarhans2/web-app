<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <style>
        input[type="submit"] {
            background-color: grey;
            color: white;
            border: none;
            padding: 10px 20px;
        }

        table {
            border-collapse: collapse;
            border: none;
        }

        tr {
            border: none;
            padding: 16px;
        }
    </style>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#loginForm").validate({
                errorClass: "invalid",
                messages: {
                    password: {
                        required: "Please enter your password"
                    },
                    userID: {
                        required: "Please enter your user ID"
                    }
                }
            });
        });
    </script>
</head>
<body>
<form id="loginForm" action="login" method="post">
    <table>
        <tr>
            <td>User ID</td>
            <td><label>
                <input type="text" name="userID" required>
            </label></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label>
                <input type="password" name="password" required>
            </label></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
<div id="result"></div>
</body>
</html>