<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <#--<link rel="icon" href="img/favicon.ico"/>-->

    <title>Like page</title>

    <style type="text/css">

        <#-- Bootstrap core CSS -->
        /*<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">*/
    <#include "css/bootstrap.min.css">
        <#-- Custom styles for this template -->
        /*<link rel="stylesheet" type="text/css" href="assets/css/style.css">*/
    <#include "css/style.css">

    </style>

</head>

<body style="background-color: #f5f5f5;">
<div class="col-4 offset-4">
    <#if IsAnybodyLogged == true>
    <div class="mt-4">
        <div class="d-flex justify-content-center links">
            <a href="/logout" class="ml-2">Logout</a>
        </div>
    </div>
</#if>
<div class="card">
    <div class="card-body">
        <form method="post">
            <div class="row">

                <div class="col-12 col-lg-6">
                    <button type="submit" class="btn btn-outline-info btn-block" value="skip"
                            formaction="/users?skip"><span
                            class="fa fa-forward"></span> Skip
                    </button>
                </div>
                <div class="col-12 col-lg-12 col-md-12 text-center">
                    <img src="${likedUser.photoLink}" alt="" class="mx-auto rounded-circle img-fluid">
                    <h3 class="mb-0 text-truncated">${likedUser.getFullName()}</h3>
                    <br>
                </div>
                <div class="col-12 col-lg-6">
                    <button type="submit" class="btn btn-outline-danger btn-block" value="dislike"
                            formaction="/users?dislike"><span
                            class="fa fa-times"></span>
                        Dislike
                    </button>
                </div>
                <div class="col-12 col-lg-6">
                    <button type="submit" class="btn btn-outline-success btn-block" value="like"
                            formaction="/users?like"><span
                            class="fa fa-heart"></span> Like
                    </button>
                </div>
                <!--/col-->
            </div>
            <!--/row-->
        </form>
    </div>
    <!--/card-block-->
</div>

</body>
</html>