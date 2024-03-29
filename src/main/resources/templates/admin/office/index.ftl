<#-- @ftlvariable name="offices" type="sk.stuba.fei.team.global.domain.Office[]" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administracia ordinácii</h1>

<div class="row">
    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/office/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text" placeholder="Hľadaný text"
                       value="${search!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/office/clear'/>">Zruš</a>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">ID</th>
            <th>Názov ordinácie</th>
            <th>Názov zariadenia</th>
            <th>Adresa zariadenia</th>
            <th style="width: 60px;">Stav</th>
        </tr>
        </thead>
        <tbody>
            <#list offices as office>
            <tr>
                <td>${office.id}</td>
                <td><a href="<@spring.url '/admin/office/detail/' + office.id />">${office.name}</a></td>
                <td>${office.facility.name}</td>
                <td>${office.facility.city+', '+office.facility.streetAndNumber}</td>
                <td><@spring.message "enabled."+office.enabled?c /></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>