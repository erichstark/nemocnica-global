<#-- @ftlvariable name="insurances" type="sk.stuba.fei.team.global.domain.Insurance[]" -->
<#-- @ftlvariable name="patient" type="sk.stuba.fei.team.global.domain.Patient" -->
<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
<div class="head row">
    <h1 class="">Môj profil  <a class="btn btn-default" href="<@spring.url '/patient/password'/>">Zmeniť heslo</a></h1>
</div>

<div class="row">

    <form name="patient" class="form-horizontal fullSearch" method="POST" action="<@spring.url '/patient/detail/save'/>" >

        <div class="form-group">
            <label for="firstName">Meno:</label>
            <input type="text" name="firstName" class="form-control" id="first_name" placeholder="Meno"
                   value="${patient.firstName!""}">
        </div>
        <div class="form-group">
            <label for="surname">Priezvisko:</label>
            <input type="text" name="surname" class="form-control" id="surname" placeholder="Priezvisko"
                   value="${patient.surname!""}">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" name="email" class="form-control" id="email" placeholder="Email"
                   value="${patient.email!""}">
        </div>
        <div class="form-group">
            <label for="phone">Telefónne číslo:</label>
            <input type="text" name="phone" class="form-control" id="phone" placeholder="Telefónne číslo"
                   value="${patient.phone!""}">
        </div>
        <div class="form-group">
            <label for="prefix_title">Titul pred menom:</label>
            <input type="text" name="prefix_title" class="form-control" id="prefix_title" placeholder="Titul pred menom"
                   value="${patient.prefix_title!""}">
        </div>
        <div class="form-group">
            <label for="suffix_title">Titul za menom:</label>
            <input type="text" name="suffix_title" class="form-control" id="suffix_title" placeholder="Titul za menom"
                   value="${patient.suffix_title!""}">
        </div>
        <div class="form-group">
            <label for="insurance">Poistenie:</label>
            <select  name="insurance" class="" id="insurance">
                <#list insurances as ins>
                    <#if ins.id = patient.insurance>
                        <option value="${ins.id}" selected> ${ins.name} </option>
                    <#else>
                        <option value="${ins.id}"> ${ins.name} </option>
                    </#if>
                </#list>
            </select>
        </div>
        <div class="floating-buttons">
            <input type="submit" value="Ulož" class="btn btn-primary">
        </div>
    </form>

</div>
</@pt.menuFooterPage>