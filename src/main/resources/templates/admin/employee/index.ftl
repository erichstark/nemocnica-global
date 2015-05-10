<#-- @ftlvariable name="employees" type="sk.stuba.fei.team.local.domain.Employee[]" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administracia zamestnancov</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/employee/add'/>" role="button">Vytvoriť
            zamestnanca</a>
    </div>
</div>

<h2 class="sub-header">Zoznam zamestnancov</h2>

<div class="row">
    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/employee/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text"
                       placeholder="Zadaj meno alebo prizevisko"
                       value="${search!""}" style="width: 400px;">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/employee/clear'/>">Zruš</a>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">#</th>
            <th>ID</th>
            <th>Titul pred</th>
            <th>Meno</th>
            <th>Priezvisko</th>
            <th>Titul za</th>
            <th style="width: 60px;">Akcia</th>
        </tr>
        </thead>
        <tbody>
            <#list employees as employee>
            <tr>
                <td>${employee_index + 1}</td>
                <td>${employee.id}</td>
                <td>${employee.prefix_title}</td>
                <td><a href="<@spring.url '/admin/employee/edit/' + employee.id />">${employee.firstName}</a></td>
                <td>${employee.lastName}</td>
                <td>${employee.suffix_title}</td>
                <td><a href="<@spring.url '/admin/employee/delete/' + employee.id />"
                       onclick="return confirm('Naozaj?');">Zmazať</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>