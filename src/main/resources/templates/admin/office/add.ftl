<#-- @ftlvariable name="facilities" type="sk.stuba.fei.team.local.domain.Facility[]" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Pridanie novej ambulancie</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/office'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

    <#if facilities?size == 0>
    <h2>Najskôr treba vytvoriť zariadenie!</h2>
    <br>
    <a class="btn btn-warning btn-sm" href="<@spring.url '/admin/facility/add'/>" role="button">Pridať zariadenie</a>
    <#else>
    <div class="table-responsive">

        <form name="office" action="<@spring.url '/admin/office/save'/>" method="post">
            <div class="form-group">
                <label for="office-id">ID</label>
                <input type="text" name="id" class="form-control" id="office-id" placeholder="ID"
                       value="${office.id!""}">
            </div>
            <div class="form-group">
                <label for="office-name">Názov</label>
                <input type="text" name="name" class="form-control" id="office-name" placeholder="Názov"
                       value="${office.name!""}">
            </div>
            <div class="form-group">
                <label for="office-facility">Zariadenie</label>
                <select name="id_facility" class="form-control" id="office-facility">
                    <#list facilities as facility>
                        <option value="${facility.id}">${facility.name}</option>
                    </#list>
                </select>
            </div>

            <div class="form-group">
                <div>
                    <input type="submit" value="Ulož" class="btn btn-success">
                </div>
            </div>

        </form>
    </div>
    </#if>
</@pt.dashboardPage>