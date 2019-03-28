<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <#--<link rel="icon" href="img/favicon.ico">-->

    <title>Register</title>

    <style type="text/css">

        <#-- Bootstrap core CSS -->
        /*<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">*/
    <#include "css/bootstrap.min.css">
        <#-- Custom styles for this template -->
        /*<link rel="stylesheet" type="text/css" href="assets/css/style.css">*/
    <#include "css/style.css">

    </style>


</head>

<body class="text-center">
<form class="form-signin" method="post">
    <img class="mb-4" src="https://getbootstrap.com/docs/4.1/assets/brand/bootstrap-solid.svg" alt="" width="72"
         height="72">
    <!--<div class="avatar">-->
    <!--<img bk=#70c5c0 src="/assets/img/avatar.png" alt="Avatar">-->
    <!--</div>-->
    <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>
    <label for="firstName" class="sr-only">First Name</label>
    <input type="text" name="firstname" id="firstName" class="form-control" placeholder="First Name"
           required autofocus>
    <label for="lastName" class="sr-only">Last Name</label>
    <input type="text" name="lastname" id="lastName" class="form-control" placeholder="Last Name"
           required autofocus>
    <label for="photoLink" class="sr-only">Photo link (url)</label>
    <input type="text" name="photolink" id="photoLink" class="form-control" placeholder="Photo URL"
           required autofocus>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" name="login" id="inputEmail" class="form-control" placeholder="Email address" required
           autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    <#if IsAnybodyLogged == true>
    <div class="mt-4">
        <div class="d-flex justify-content-center links">
            <a href="/logout" class="ml-2">Logout</a>
        </div>
    </div>
</#if>
    <p class="mt-5 mb-3 text-muted">&copy; FS7 Group (VOM) 2019</p>
</form>

</body>
</html>