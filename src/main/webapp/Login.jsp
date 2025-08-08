<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pentagon Space - Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f2ff;
            text-align: center;
        }
        h1 {
            color: #4b0082;
        }
        h2 {
            color: #4169e1;
        }
        form {
            background-color: #ffffff;
            display: inline-block;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0,0,0,0.2);
        }
        input[type="email"], input[type="password"] {
            width: 280px;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .button {
            background-color: #28a745;
            color: white;
            padding: 10px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .success{
        color:green;
        }
        .success{
        color:green;
        }
        .button:hover {
            background-color: #218838;
        }
        a {
            text-decoration: none;
            color: blue;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <h1>Pentagon Space</h1>
    <h2>Login</h2> 
    <%if(request.getAttribute("success")!=null){%>
    <h3 class="success"><%=request.getAttribute("success")%></h3>
    <%}%>
    
    <form action="Login" method="post">
        <input type="email" name="mail" placeholder="Enter your mail ID" required><br>
        <input type="password" name="password" placeholder="Enter the password" required><br>
        
        <input type="submit" value="Login" class="button"><br><br>

        <a href="Reset.jsp">forgot password?</a><br><br>
        <span>Don't have an account? <a href="Signup.jsp">signup</a></span>
    </form>
</body>
</html>