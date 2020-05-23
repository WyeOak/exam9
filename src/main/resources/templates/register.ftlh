<#import "macro/main.ftlh" as main />

<@main.renderWith styles=["/css/userForms.css"]>
    <form action="/register" method="post" class="main-form">
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="first_name">First name</label>
                    <input type="text" name="firstName" id="first_name" class="form-control" required value="${(user.firstName)!''}">
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="last_name">Last name</label>
                    <input type="text" name="lastName" id="last_name" class="form-control" required value="${(user.lastName)!''}">
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="username"> Login </label>
            <input type="text" name="username" id="username" class="form-control" required value="${(user.username)!''}">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control" required value="${(user.password)!''}">
        </div>

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <div class="main-form">
        <#if errors??>
            <p class="error_messages">Submitted data contains errors!</p>
            <#list errors as fieldError>
                <p class="error_messages">${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
            </#list>
        </#if>
        <#if exception??>
            <p class="error_messages"> ${exception.message} </p>
        </#if>
    </div>
</@main.renderWith>