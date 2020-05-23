<#import "macro/main.ftlh" as main />

<@main.renderWith styles=["/css/index.css"] scripts=["/js/index.js"]>

    <div class="container">
            <div class="d-flex justify-content-between main-table">
                <div> # </div>
                <div> Title </div>
                <div> Author </div>
                <div> Time </div>
                <div> Answers </div>
            </div>
            <#list items as theme>
                <div class="main">
                    <div class="main-table">
                        <div class="d-flex justify-content-between" onclick="redirect_theme(${theme.id})">
                            <div> ${theme.id} </div>
                            <div> ${theme.title} </div>
                            <div> ${theme.user}  </div>
                            <div> ${theme.timeOfTheme} </div>
                            <div> ${theme.amountOfAnswers} </div>
                        </div>
                    </div>
                </div>
            </#list>
        <#include "macro/pagination.ftlh">
    </div>
</@main.renderWith>