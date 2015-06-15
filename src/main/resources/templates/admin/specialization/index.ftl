<#-- @ftlvariable name="specializations" type="sk.stuba.fei.team.global.domain.Specialization[]" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administrácia špecializácií</h1>

<div class="row">
    <div class="col-md-5">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/specialization/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text" placeholder="Hľadaný text"
                       value="${search!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/specialization/clear'/>">Zruš</a>
        </form>
    </div>
    <div class="col-md-7">
        <form name="specialization" action="<@spring.url '/admin/specialization'/>" method="post" class="form-horizontal">
            <div class="controls form-inline">
                <input type="text" name="id" class="form-control" id="add-specialization-id" placeholder="ID" style="width: 60px;">
                <input type="text" name="name" class="form-control" id="add-specialization-name" placeholder="Názov">
                <input type="submit" value="Pridaj" class="btn btn-success">
            </div>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th style="width: 60px;">ID</th>
            <th>Názov</th>
            <th></th>
            <th style="width: 60px;">Aktívne</th>
        </tr>
        </thead>
        <tbody>
            <#list specializations as specialization>
            <form name="specialization" action="<@spring.url '/admin/specialization/' + specialization.id />" method="post">
                <tr>
                    <td>${specialization.id}</td>
                    <td>
                        <input type="text" name="name" class="form-control" id="edit-specialization-name" value="${specialization.name!""}">
                    </td>
                    <td>
                        <input type="submit" value="Zmeň názov" class="btn btn-success">
                    </td>
                    <td>
                        <div class="checkbox">
                            <label><input type="checkbox" name="specialization-enabled" id="${specialization.id}" onchange="changeEnabled(this);" ${specialization.enabled?string("checked","")}></label>
                        </div>
                    </td>
                </tr>
            </form>
            </#list>
        </tbody>
    </table>
</div>

</@pt.dashboardPage>