<div class="prevNextIcons">
        <div class="control_icons" id="loadPrevIcons">
        <#if hasPrev>
                <a id="loadPrev" class="btn btn-primary" href="${prevPageLink!''}"> << previous </a>
        <#else>
                <span class="btn btn-primary"> previous </span>
        </#if>
        </div>
        <div class="control_icons" id="loadNextIcons">
        <#if hasNext>
              <a id="loadNext" class="btn btn-primary" href="${nextPageLink!''}" data-default-page-size="${defaultPageSize!6}"> next>></a>
        <#else>
            <span class="btn btn-primary"> next </span>
        </#if>
        </div>
</div>