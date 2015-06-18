<#-- @ftlvariable name="specializations" type="sk.stuba.fei.team.global.domain.Specialization[]" -->
<#-- @ftlvariable name="offices" type="sk.stuba.fei.team.global.domain.Office[]" -->
<#-- @ftlvariable name="employee" type="sk.stuba.fei.team.global.domain.Employee" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Editácia zamestnanca</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/employee'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

<div class="table-responsive">
    <form name="patient" action="<@spring.url '/admin/employee/edit'/>" method="post">
        <input type="hidden" name="username" id="employee-username" value="${employee.username}">
        <div class="form-group">
            <label for="employee-prefix_title">Titul pred menom</label>
            <input type="text" name="prefix_title" class="form-control" id="employee-prefix_title"
                   placeholder="Titul pred menom"
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
            <label for="employee-suffix_title">Titul za menom</label>
            <input type="text" name="suffix_title" class="form-control" id="employee-suffix_title"
                   placeholder="Titul za menom"
                   value="${employee.suffix_title!""}">
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Ulož" class="btn btn-success">
            </div>
        </div>

    </form>
</div>

<br>

<div class="row">
    <h2>Špecializácia</h2>
    <hr>

    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/employee/specialization/add'/>">
            <div class="form-group">
                <label for="employee-office">Specializácia:</label>
                <select name="id_specialization" class="form-control" id="employee-office">
                    <#list specializations as specialization>
                        <option value="${specialization.id}">${specialization.name}</option>
                    </#list>
                </select>
                <input type="hidden" name="id_employee" value="${employee.username}">
            </div>
            <input type="submit" value="Pridaj" class="btn btn-success">
        </form>
    </div>

    <div class="col-md-12">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Názov špecializácie</th>
                <th style="width: 60px;">Akcia</th>
            </tr>
            </thead>
            <tbody>
                <#if employee.specializations??>
                    <#list employee.specializations as specialization>
                    <tr>
                        <td>${specialization.name}</td>
                        <td>
                            <a href="<@spring.url '/admin/employee/'+employee.username+'/specialization/'+specialization.id+'/delete' />"
                               onclick="return confirm('Naozaj?');">Zmazať</a></td>
                    </tr>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <h2>Zamestnanec - ambulancie</h2>
    <hr>

    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/employee/office/add'/>">
            <div class="form-group">
                <label for="employee-office">Pridanie ambulancie:</label>
                <select name="id_office" class="form-control" id="employee-office">
                    <#list offices as office>
                        <option value="${office.id}">${office.name}, ${office.facility.nameWithAddress}</option>
                    </#list>
                </select>
                <input type="hidden" name="id_employee" value="${employee.username}">
            </div>
            <input type="submit" value="Pridaj" class="btn btn-success">
        </form>
    </div>

    <div class="col-md-12">
        <table class="table table-striped">
            <thead>
            <tr>
                <th style="width: 60px;">#</th>
                <th style="width: 60px;">ID</th>
                <th>Názov ambulancie</th>
                <th style="width: 60px;">Akcia</th>
            </tr>
            </thead>
            <tbody>
                <#if employee.offices??>
                    <#list employee.offices as office>
                    <tr>
                        <td>${office_index + 1}</td>
                        <td>${office.id}</td>
                        <td>${office.name}, ${office.facility.nameWithAddress}</td>
                        <td>
                            <a href="<@spring.url '/admin/employee/'+employee.username+'/office/'+office.id+'/delete' />"
                               onclick="return confirm('Naozaj?');">Zmazať</a></td>
                    </tr>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>
</div>

</@pt.dashboardPage>