<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <#--<link rel="icon" href="img/favicon.ico">-->

    <title>People list</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

    <style type="text/css">

        <#-- Bootstrap core CSS -->
        /*<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">*/
    <#include "css/bootstrap.min.css">
        <#-- Custom styles for this template -->
        /*<link rel="stylesheet" type="text/css" href="assets/css/style.css">*/
    <#include "css/style.css">

    </style>

    <!-- Custom Scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
         $(".clickable-row").click(function() {
             window.location = $(this).data("href");
           });
        });


    </script>
</head>
<body>

<div class="container">
    <#if IsAnybodyLogged == true>
    <div class="mt-4">
        <div class="d-flex justify-content-center links">
            <a href="/logout" class="ml-2">Logout</a>
        </div>
    </div>
</#if>
<div class="row">
    <div class="col-8 offset-2">
        <div class="panel panel-default user_panel">
            <div class="panel-heading">
                <h3 class="panel-title">Your (${loginUser.getFullName()}) liked list:</h3>
            </div>
            <div class="panel-body">
                <div class="table-container">
                    <table class="table-users table" border="0">
                        <tbody>
                        <#list likedlist as item2>
                        <tr class="clickable-row" data-href="messages/${item2.userId}">
                            <td width="10">
                                <!--<h1>${item2.getFullName()}</h1>-->
                                <div class="avatar-img">
                                    <img class="img-circle" src=${item2.photoLink}>  
                                </div>
                            </td>
                            <td class="align-middle">
                                ${item2.firstName}
                            </td>
                            <td class="align-middle">
                                ${item2.lastName}
                            </td>
                            <td class="align-middle">
                                Last Login: 6/10/2017<br>
                                <small class="text-muted">5 days ago</small>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>