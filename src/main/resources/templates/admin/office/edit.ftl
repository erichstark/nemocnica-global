<#-- @ftlvariable name="insurances" type="sk.stuba.fei.team.local.domain.Insurance[]" -->
<#-- @ftlvariable name="office.insurances" type="sk.stuba.fei.team.local.domain.Insurance[]" -->
<#-- @ftlvariable name="office" type="sk.stuba.fei.team.local.domain.Office[]" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Editácia ambulancie</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/office'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

<div class="table-responsive">

    <form name="office" action="<@spring.url '/admin/office/edit'/>" method="post">
        <div class="form-group" style="display: none">
            <label for="office-id">ID</label>
            <input type="text" name="id" class="form-control" id="office-id" placeholder="ID"
                   value="${office.id}">
        </div>
        <div class="form-group">
            <label for="office-name">Názov</label>
            <input type="text" name="name" class="form-control" id="office-name" placeholder="Name"
                   value="${office.name!""}">
        </div>
        <div class="form-group">
            <label for="office-facility">Zariadenie</label>
            <select name="id_facility" class="form-control" id="office-facility">
                <#list facilities as facility>
                    <#if facility.id == office.facility.id>
                        <option value="${facility.id}" selected="selected">${facility.name}</option>
                    <#else>
                        <option value="${facility.id}">${facility.name}</option>
                    </#if>
                </#list>
            </select>
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Ulož" class="btn btn-success">
            </div>
        </div>

    </form>
</div>

<div class="row">

    <h2>Poisťovne ambulancie</h2>
    <hr>

    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/office/insurance/add'/>">
            <div class="form-group">
                <label for="text">Pridanie poisťovne:</label>
                <select name="id_insurance" class="form-control" id="office-facility">
                    <#list insurances as insurance>
                        <option value="${insurance.id}">${insurance.name}</option>
                    </#list>
                </select>
                <input type="hidden" name="id_office" value="${office.id}">
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
                <th>Názov poisťovne</th>
                <th style="width: 60px;">Akcia</th>
            </tr>
            </thead>
            <tbody>
                <#if office.insurances??>
                    <#list office.insurances as insurance>
                    <tr>
                        <td>${insurance_index + 1}</td>
                        <td>${insurance.id}</td>
                        <td>${insurance.name}</td>
                        <td>
                            <a href="<@spring.url '/admin/office/'+office.id+'/insurance/'+insurance.id+'/delete' />"
                               onclick="return confirm('Naozaj?');">Zmazať</a></td>
                    </tr>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>
</div>

</@pt.dashboardPage>