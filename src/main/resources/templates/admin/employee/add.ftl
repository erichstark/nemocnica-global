<#-- @ftlvariable name="offices" type="sk.stuba.fei.team.global.domain.Office[]" -->
<#-- @ftlvariable name="employee" type="sk.stuba.fei.team.global.domain.Employee" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Pridanie nového zamestnanca</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/employee'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

<div class="table-responsive">
    <form name="patient" action="<@spring.url '/admin/employee/save'/>" method="post">
        <div class="form-group">
            <label for="employee-id">ID</label>
            <input type="text" name="id" class="form-control" id="employee-id" placeholder="ID"
                   value="${employee.id!""}">
        </div>
        <div class="form-group">
            <label for="employee-prefix_title">Titul pred</label>
            <input type="text" name="prefix_title" class="form-control" id="employee-prefix_title"
                   placeholder="Titul pred"
                   value="${employee.prefix_title!""}">
        </div>
        <div class="form-group">
            <label for="employee-firstName">Meno</label>
            <input type="text" name="firstName" class="form-control" id="employee-firstName" placeholder="Meno"
                   value="${employee.firstName!""}">
        </div>
        <div class="form-group">
            <label for="employee-surname">Priezvisko</label>
            <input type="text" name="lastName" class="form-control" id="employee-surname" placeholder="Priezvisko"
                   value="${employee.lastName!""}">
        </div>
        <div class="form-group">
            <label for="employee-suffix_title">Titul za</label>
            <input type="text" name="suffix_title" class="form-control" id="employee-suffix_title"
                   placeholder="Titul za"
                   value="${employee.suffix_title!""}">
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Ulož" class="btn btn-success">
            </div>
        </div>

    </form>
</div>

</@pt.dashboardPage>