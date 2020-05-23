<div class="d-flex mt-auto">
    <#if hasPrev>
            <a href="${prevPageLink!''}" type="button" class="btn-su container  p-2 mb-4">
                    <i class="fas fa-arrow-circle-left"></i>
            </a>
    </#if>

    <#if hasNext>
            <a href="${nextPageLink!''}" type="button" class=" container btn-su  p-2 mb-4">
                    <i class="fas fa-arrow-circle-right""></i>
            </a>
    </#if>
</div>