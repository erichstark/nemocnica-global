<#-- @ftlvariable name="insurance" type="sk.stuba.fei.team.local.domain.Insurance" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">
    <#if insurance.id??>
        Editácia poisťovne
    <#else>
        Pridanie novej poisťovne
    </#if>
</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/insurance'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

<div class="table-responsive">
    <form name="insurance" action="<@spring.url '/admin/insurance/save'/>" method="post">
        <#if insurance.id??>
        <div class="form-group" style="display: none;">
        <#else>
        <div class="form-group">
        </#if>
            <label for="insurance-id">ID</label>
            <input type="text" name="id" class="form-control" id="insurance-id" placeholder="ID"
                   value="${insurance.id!""}">
        </div>
        <div class="form-group">
            <label for="insurance-name">Názov</label>
            <input type="text" name="name" class="form-control" id="insurance-name" placeholder="Názov"
                   value="${insurance.name!""}">
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Ulož" class="btn btn-success">
            </div>
        </div>
    </form>
</div>
</@pt.dashboardPage>