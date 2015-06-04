<#-- @ftlvariable name="patient" type="sk.stuba.fei.team.global.domain.Patient" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administracia pacientov</h1>

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
                       placeholder="Zadaj prihlasovacie meno, meno alebo prizevisko"
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
            <th style="width: 60px;">#</th>
            <th>Prihlasovacie meno (ID)</th>
            <th>Meno pacienta</th>
            <th>Email</th>
            <th>Telefón</th>
            <th>Autorita</th>
            <th>Aktivovaný účet</th>
            <th style="width: 60px;">Akcia</th>
        </tr>
        </thead>
        <tbody>
            <#list patients as patient>
            <tr>
                <td>${patient_index + 1}</td>
                <td><a href="<@spring.url '/admin/patient/edit/' + patient.username />">${patient.username}</a></td>
                <td>
                ${patient.prefix_title + ' ' + patient.firstName + ' ' + patient.surname}
                    <#if patient.suffix_title?length gt 0>${', ' + patient.suffix_title}</#if>

                </td>
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
                <td><a href="<@spring.url '/admin/patient/delete/' + patient.username />"
                       onclick="return confirm('Naozaj?');">Zmazať</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>