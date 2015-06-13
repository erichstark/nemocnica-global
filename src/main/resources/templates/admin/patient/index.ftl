<#-- @ftlvariable name="patient" type="sk.stuba.fei.team.global.domain.Patient" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administrácia pacientov</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/patient/add'/>" role="button">Vytvoriť
            pacienta</a>
    </div>
</div>

<h2 class="sub-header">Zoznam pacientov</h2>

<div class="row">
    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/patient/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text"
                       placeholder="Zadaj prihlasovacie meno, meno alebo priezvisko"
                       value="${search!""}" style="width: 400px;">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/patient/clear'/>">Zruš</a>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Prihlasovacie meno (ID)</th>
            <th>Meno pacienta</th>
            <th>Poistovňa</th>
            <th>Email</th>
            <th>Telefón</th>
            <th>Autorita</th>
            <th>Aktivovaný účet</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <#list patients as patient>
            <tr>
                <td><a href="<@spring.url '/admin/patient/edit/' + patient.username />">${patient.username}</a></td>
                <td>
                    ${patient.prefix_title!"" + ' ' + patient.firstName + ' ' + patient.surname + ', ' + patient.suffix_title!""}
                </td>
                <td><#if patient.insurance??>${patient.insurance.name}<#else></#if></td>
                <td>${patient.email}</td>
                <td>${patient.phone}</td>
                <#if patient.getStringAuthorities()?seq_contains("USER")>
                    <td>USER</td>
                <#else>
                    <td>ADMIN</td>
                </#if>
                <td>
                    <#if patient.enabled!false>
                        <input type="checkbox" checked disabled>
                    <#else>
                        <input type="checkbox" disabled>
                    </#if>
                </td>
                <td><a class="btn btn-danger" href="<@spring.url '/admin/patient/delete/' + patient.username />"
                       onclick="return confirm('Naozaj?');">Vymazať</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>