<#-- @ftlvariable name="facilities" type="sk.stuba.fei.team.global.domain.Facility[]" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Prehľad zdravotníckych zariadení</h1>

<div class="row">
    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/facility/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text" placeholder="Hľadaný text"
                       value="${search!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/facility/clear'/>">Zruš</a>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">ID</th>
            <th>Názov zariadenia</th>
            <th>Adresa</th>
            <th>Stav</th>
        </tr>
        </thead>
        <tbody>
            <#list facilities as facility>
            <tr>
                <td>${facility.id}</td>
                <td>${facility.name}</td>
                <td>${facility.streetAndNumber+', '+facility.zip+' '+facility.city}</td>
                <td><@spring.message "enabled."+facility.enabled?c /></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>