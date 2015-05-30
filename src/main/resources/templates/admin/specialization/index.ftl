<#-- @ftlvariable name="specializations" type="sk.stuba.fei.team.local.domain.Specialization[]" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administracia špecializácií</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/specialization/add'/>" role="button">Vytvoriť
            špecializáciu</a>
    </div>
</div>

<h2 class="sub-header">Zoznam špecializácií</h2>

<div class="row">
    <div class="col-md-12">
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
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">#</th>
            <th style="width: 60px;">ID</th>
            <th>Názov špecializácie</th>
            <th style="width: 60px;">Akcia</th>
        </tr>
        </thead>
        <tbody>
            <#list specializations as specialization>
            <tr>
                <td>${specialization_index + 1}</td>
                <td>${specialization.id}</td>
                <td>
                    <a href="<@spring.url '/admin/specialization/edit/' + specialization.id />">${specialization.name}</a>
                </td>
                <td><a href="<@spring.url '/admin/specialization/delete/' + specialization.id />"
                       onclick="return confirm('Naozaj?');">Zmazať</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>