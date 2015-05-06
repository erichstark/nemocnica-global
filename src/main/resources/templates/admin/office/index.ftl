<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administracia ambulancií</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/office/add'/>" role="button">Vytvoriť
            ambulanciu</a>
    </div>
</div>

<h2 class="sub-header">Offices</h2>

<div class="row">
    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/office/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text" placeholder="Hľadaný text"
                       value="${search!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/office/clear'/>">Reset</a>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">#</th>
            <th style="width: 60px;">ID</th>
            <th>Názov offices</th>
            <th>Názov facilities</th>
            <th>Adresa facilities</th>
            <th style="width: 60px;">Akcia</th>
        </tr>
        </thead>
        <tbody>
            <#list offices as office>
            <tr>
                <td>${office_index + 1}</td>
                <td>${office.id}</td>
                <td><a href="<@spring.url '/admin/office/edit/' + office.id />">${office.name}</a></td>
                <td>${office.facility.name}</td>
                <td>${office.facility.city+', '+office.facility.streetAndNumber}</td>
                <td><a href="<@spring.url '/admin/office/delete/' + office.id />"
                       onclick="return confirm('Naozaj?');">Zmazať</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>