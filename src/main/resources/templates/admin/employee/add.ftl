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
            <label for="employee-prefix_title">Titul pred menom</label>
            <input type="text" name="prefix_title" class="form-control" id="employee-prefix_title" placeholder="Titul pred menom">
        </div>
        <div class="form-group">
            <label for="employee-firstName">Meno*</label>
            <input type="text" name="firstName" class="form-control" id="employee-firstName" placeholder="Meno" required>
        </div>
        <div class="form-group">
            <label for="employee-surname">Priezvisko*</label>
            <input type="text" name="lastName" class="form-control" id="employee-surname" placeholder="Priezvisko" required>
        </div>
        <div class="form-group">
            <label for="employee-suffix_title">Titul za menom</label>
            <input type="text" name="suffix_title" class="form-control" id="employee-suffix_title" placeholder="Titul za menom">
        </div>
        <div class="form-group">
            <label for="employee-phone">Telefón</label>
            <input type="text" name="phone" class="form-control" id="employee-phone" placeholder="Telefón">
        </div>
        <div class="form-group">
            <label for="employee-email">E-mail</label>
            <input type="text" name="email" class="form-control" id="employee-email" placeholder="E-mail">
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Ulož" class="btn btn-success">
            </div>
        </div>

    </form>
</div>

</@pt.dashboardPage>