<#import "/spring.ftl" as spring>

<#macro renderWith title="Online forum" scripts=[] styles=[]>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>${title}</title>

        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container">
                <a href="/" class="navbar-brand"> Forum </a>
                <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarMenu">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav">
                        <#if user_status == "anonymousUser">
                            <li class="nav-item">
                                <a href="/register" class="nav-link"> Register </a>
                            </li>
                            <li class="nav-item">
                                <a href="/login" class="nav-link"> Login </a>
                            </li>
                        <#else>
                            <li class="nav-item">
                                <a href="/create/theme" class="nav-link"> Create new theme </a>
                            </li>
                            <li class="nav-item">
                                <a href="/profile" class="nav-link"> My profile </a>
                            </li>
                            <li class="nav-item">
                                <#if _csrf??>
                                    <form action="/logout" method="post">
                                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no token--'}"/>
                                        <button class="btn btn-primary"> Logout </button>
                                    </form>
                                <#else>
                                    <a href="/logout" class="nav-link"> Logout </a>
                                </#if>
                            </li>
                        </#if>
                    </ul>
                </div>

            </div>
        </nav>

        <div class="container flex flex-col align-center">
            <#nested>
        </div>

        <#list scripts as scriptSource>
            <script src="${scriptSource}"></script>
        </#list>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                crossorigin="anonymous"></script>
    </body>
</html>
</#macro>