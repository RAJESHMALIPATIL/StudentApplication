<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Application Form</title>
<style>
body{
            font-family: Arial, sans-serif;
            background-color: #e6f2ff;
            text-align: center;
}
h1{
color: #4b0082;
}
h2{
color: #4169e1;
}
form{
            background-color: #ffffff;
            display: inline-block;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0,0,0,0.2);
}
input[type="text"], input[type="email"], input[type="password"], input[type="tel"] {
            width: 300px;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
.button {
            background-color: #007bff;
            color: white;
            padding: 10px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .failure{
        color:red;
        }
        
.button:hover {
            background-color: #0056b3;
        }
        .login-link {
            margin-top: 10px;
            display: block;
        }
</style>
</head>
<body>
     <h1>Pentagon Space</h1>
     <h2>Application form</h2>
     <%if(request.getAttribute("error")!=null){%>
     <h3 class="failure"><%=request.getAttribute("error")%></h3>
     <%}%>
     
    <form action="Signup" method="post">
        <input type="text" name="name" placeholder="Enter your Name" required><br>
        <input type="tel" name="phone" placeholder="Enter the Phone number" required><br>
        <input type="email" name="mail" placeholder="Enter the Mail ID" required><br>
        <input type="text" name="branch" placeholder="Enter the Branch" required><br>
        <input type="text" name="loc" placeholder="Enter the Location" required><br>
        <input type="password" name="password" placeholder="Enter the Password" required><br>
        <input type="password" name="confirm" placeholder="Confirm the Password" required><br>
        
        <input type="submit" value="create account" class="button"><br>
        <span class="login-link">already have an account? <a href="Login.jsp">login</a></span>
    </form>

</body>
</html>