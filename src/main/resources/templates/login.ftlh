<#import "macro/main.ftlh" as main />

<@main.renderWith styles=["/css/userForms.css"]>
    <form action="/login" class="main-form" method="post">
        <div class="form-group">
            <label for="username"> Login </label>
            <input type="text" name="username" id="username" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>

        <div>
            <#if error??>
                <p class="error_messages"> Wrong username or password! </p>
            </#if>
        </div>
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
    </form>


</@main.renderWith>