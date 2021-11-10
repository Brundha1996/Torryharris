<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login and register page</title>
    <link rel="stylesheet" href= "simple.css">
<body>
<div class= "login-page">
    <div class= "form">

        <form class= "login-form" action="Traindetails.html" onsubmit="MyFunction()">
            <input type = "text" placeholder="username" value="${user.userName}" required/>
            <input type = "password" placeholder="password" value="${user.password}" required/>
            <input type= "Submit" value="Login" id="bru">
        </form>

        <form class="login-form" action = "RegistrationPage.html">
            <button>Register</button>
        </form>
    </div>
</div>

<script>
    $('.text a').click(function(){
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
</script>
</body>
</html>