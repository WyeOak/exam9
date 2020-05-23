<#import "macro/main.ftlh" as main />

<@main.renderWith styles=["/css/index.css"] scripts=["/js/comment.js"]>

    <div class="container">
        <input type="hidden" id="user_status" name="user_status" value="${user_status}">

        <div class="d-flex justify-content-start main-table">
            <div class="theme_params"> Title: ${theme.title} </div>
            <div class="theme_params"> Time: ${theme.timeOfTheme} </div>
            <div class="theme_params"> Author: ${theme.user} </div>
            <div class="theme_params">
                <button type="button" class="btn btn-primary" id="myBtn">
                    Add comment
                </button>
            </div>
        </div>

        <div id="comments">
            <#list items as comment>
                <div class="main">
                    <div class="main-table">
                        <div class="d-flex justify-content-between" onclick="redirect_theme(${theme.id})">
                            <div> ${comment.user}  </div>
                            <div> ${comment.timeOfComment} </div>
                            <div> ${comment.text} </div>
                        </div>
                    </div>
                </div>
            </#list>
        </div>

        <#include "macro/pagination.ftlh">
    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Adding comment </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="theme-form">
                        <#if _csrf??>
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                        </#if>
                        <input type="hidden" name="theme_id" value="${theme.id}"/>
                        <div class="form-group">
                            <label for="title"> Write your text below </label>
                            <input type="text" name="text" id="title" class="form-control" required>
                        </div>
                        <button type="button" class="btn btn-primary" onclick="addComment(this.form)" data-dismiss="modal"> Add comment </button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</@main.renderWith>