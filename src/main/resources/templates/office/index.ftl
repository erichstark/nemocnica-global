<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
<h1 class="page-header">Administracia ambulancií</h1>


<h2 class="sub-header">Ambulancie</h2>

<div class="row">
    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/office/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text" placeholder="Hľadaný text"
                       value="${search!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/office/clear'/>">Reset</a>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">#</th>
            <th>Názov offices</th>
            <th>Názov facilities</th>
            <th>Adresa facilities</th>

        </tr>
        </thead>
        <tbody>
            <#list offices as office>
            <tr>
                <td>${office_index + 1}</td>
                <td><a href="<@spring.url '/office/detail/' + office.id />">${office.name}</a></td>
                <td>${office.facility.name}</td>
                <td>${office.facility.city+', '+office.facility.streetAndNumber}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.menuFooterPage>