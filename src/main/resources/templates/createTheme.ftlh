<#import "macro/main.ftlh" as main />

<@main.renderWith styles=["/css/index.css"]>

    <div class="container">
        <div class="row">

            <form action="/create/theme" class="theme-form" method="post">
                <h4>Create theme page</h4>

                <div class="form-group">
                    <label for="title"> Title </label>
                    <input type="text" name="title" id="title" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="main_text"> Main text:</label>
                    <textarea name="main_text" id="main_text" class="form-control" required> </textarea>
                </div>

                <button type="submit" class="btn btn-primary"> Add theme </button>

                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
            </form>
        </div>
    </div>

</@main.renderWith>