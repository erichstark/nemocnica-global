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
        <form name="specialization-add" action="<@spring.url '/admin/specialization/save'/>" method="post" class="row">
            <div class="form-group col-md-8">
                <input type="text" name="name" class="form-control" id="specialization-name" placeholder="Názov">
            </div>
            <div class="form-group col-md-4">
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
            <form name="specialization" action="<@spring.url '/admin/specialization/update/' + specialization.id />" method="post">
                <tr>
                    <td>${specialization.id}</td>
                    <td>
                        <input type="text" name="name" class="form-control" id="specialization-name" value="${specialization.name!""}">
                    </td>
                    <td>
                        <input type="submit" value="Zmeň názov" class="btn btn-success">
                        <a class="btn btn-danger" href="<@spring.url '/admin/specialization/delete/' + specialization.id />"
                           onclick="return confirm('Naozaj?');">Zmazať</a>
                    </td>
                    <td>
                        <input type="checkbox" name="enabled" class="check-enabled" ${specialization.enabled?string("checked","")}>
                    </td>
                </tr>
            </form>
            </#list>
        </tbody>
    </table>
</div>

</@pt.dashboardPage>