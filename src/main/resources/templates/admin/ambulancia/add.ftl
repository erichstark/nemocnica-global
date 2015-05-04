<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Pridanie novej ambulancie</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/ambulancia'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

    <#if zariadenia?size == 0>
    <h2>Najskôr treba vytvoriť zariadenia!</h2>
    <br>
    <a class="btn btn-warning btn-sm" href="<@spring.url '/admin/zariadenie/add'/>" role="button">Pridať zariadenie</a>
    <#else>
    <div class="table-responsive">

        <form name="ambulancia" action="<@spring.url '/admin/ambulancia/save'/>" method="post">
            <div class="form-group">
                <label for="ambulancia-id">ID</label>
                <input type="text" name="id" class="form-control" id="ambulancia-id" placeholder="ID"
                       value="${ambulancia.id!""}">
            </div>
            <div class="form-group">
                <label for="ambulancia-name">Názov</label>
                <input type="text" name="name" class="form-control" id="ambulancia-name" placeholder="Názov"
                       value="${ambulancia.name!""}">
            </div>
            <div class="form-group">
                <label for="ambulancia-zariadenie">Zariadenie</label>
                <select name="id_zariadenie" class="form-control" id="ambulancia-zariadenie">
                    <#list zariadenia as zariadenie>
                        <option value="${zariadenie.id}">${zariadenie.nazov}</option>
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