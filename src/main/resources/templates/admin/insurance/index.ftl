<#-- @ftlvariable name="insurances" type="sk.stuba.fei.team.global.domain.Insurance[]" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administracia poistovní</h1>

<div class="row">
    <div class="col-md-6">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/insurance/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text" placeholder="Hľadaný text"
                       value="${search!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/insurance/clear'/>">Zruš</a>
        </form>
    </div>
    <div class="col-md-6">
        <form name="insurance-add" action="<@spring.url '/admin/insurance'/>" method="post" class="row">
            <div class="form-group col-md-8">
                <input type="text" name="name" class="form-control" id="insurance-name" placeholder="Názov">
            </div>
            <div class="form-group col-md-4">
                <input type="submit" value="Pridaj" class="btn btn-success">
            </div>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">ID</th>
            <th>Názov</th>
            <th></th>
            <th>Aktívna</th>
        </tr>
        </thead>
        <tbody>
            <#list insurances as insurance>
            <form name="insurance" action="<@spring.url '/admin/insurance/' + insurance.id />" method="post">
                <tr>
                    <td>${insurance.id}</td>
                    <td><input type="text" name="name" class="form-control" id="insurance-name" value="${insurance.name!""}"></td>
                    <td>
                        <input type="submit" value="Zmeň meno" class="btn btn-success">
                    </td>
                    <td>
                        <div class="checkbox">
                            <label><input type="checkbox" name="insurance-enabled" id="${insurance.id}" onchange="changeEnabled(this);" ${insurance.enabled?string("checked","")}></label>
                        </div>
                    </td>
                </tr>
            </form>
            </#list>
        </tbody>
    </table>
</div>

<div class="row">
    <div class="col-md-9">

    </div>
</div>

</@pt.dashboardPage>