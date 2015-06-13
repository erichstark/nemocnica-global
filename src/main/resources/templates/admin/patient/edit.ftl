<#-- @ftlvariable name="insurances" type="sk.stuba.fei.team.global.domain.Insurance[]" -->
<#-- @ftlvariable name="patient" type="sk.stuba.fei.team.global.domain.Patient" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>

<@pt.dashboardPage>
<h1 class="page-header">Pridanie nového pacienta</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/patient'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

<div class="table-responsive">
    <form name="patient" action="<@spring.url '/admin/patient/save'/>" method="post">
        <input type="hidden" name="username" class="form-control" id="patient-username" placeholder="Prihlasovacie meno"
               value="${patient.username!""}">

        <div class="form-group">
            <label for="patient-password">Heslo</label>
            <input type="password" name="password" class="form-control" id="patient-password" placeholder="Heslo"
                   value="${patient.password!""}">
        </div>
        <div class="form-group">
            <label for="patient-prefix_title">Titul pred</label>
            <input type="text" name="prefix_title" class="form-control" id="patient-prefix_title"
                   placeholder="Titul pred"
                   value="${patient.prefix_title!""}">
        </div>
        <div class="form-group">
            <label for="patient-firstName">Meno</label>
            <input type="text" name="firstName" class="form-control" id="patient-firstName" placeholder="Meno"
                   value="${patient.firstName!""}">
        </div>
        <div class="form-group">
            <label for="patient-surname">Priezvisko</label>
            <input type="text" name="surname" class="form-control" id="patient-surname" placeholder="Priezvisko"
                   value="${patient.surname!""}">
        </div>
        <div class="form-group">
            <label for="patient-suffix_title">Titul za</label>
            <input type="text" name="suffix_title" class="form-control" id="patient-suffix_title" placeholder="Titul za"
                   value="${patient.suffix_title!""}">
        </div>
        <div class="form-group">
            <label for="patient-email">Email</label>
            <input type="email" name="email" class="form-control" id="patient-email" placeholder="Email"
                   value="${patient.email!""}">
        </div>
        <div class="form-group">
            <label for="patient-phone">Telefón</label>
            <input type="text" name="phone" class="form-control" id="patient-phone" placeholder="Telefón"
                   value="${patient.phone!""}">
        </div>
        <table class="form-group">
            <tr>
                <td style="width: 300px;">
                    <label class="radio-inline"><input type="radio" name="enabled" value="true"
                                                       <#if  patient.enabled>checked</#if> > Aktivovaný účet</label>
                </td>
                <td>
                    <label class="radio-inline"><input type="radio" name="enabled" value="false"
                                                       <#if !patient.enabled>checked</#if> > Deaktivovaný účet</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="radio-inline">
                        <input type="radio" name="accountNonExpired" value="true"
                               <#if  patient.accountNonExpired>checked</#if> > Platný účet (non expired)
                    </label>
                </td>
                <td>
                    <label class="radio-inline">
                        <input type="radio" name="accountNonExpired" value="false"
                               <#if !patient.accountNonExpired>checked</#if> > Neplatný účet
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="radio-inline">
                        <input type="radio" name="accountNonLocked" value="true"
                               <#if  patient.accountNonLocked>checked</#if> > Odomknutý účet (non locked)
                    </label>
                </td>
                <td>
                    <label class="radio-inline">
                        <input type="radio" name="accountNonLocked" value="false"
                               <#if !patient.accountNonLocked>checked</#if> > Uzamknutý účet
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="radio-inline">
                        <input type="radio" name="credentialsNonExpired" value="true"
                               <#if  patient.credentialsNonExpired>checked</#if> > Platné osobné údaje (non expired)
                    </label>
                </td>
                <td>
                    <label class="radio-inline">
                        <input type="radio" name="credentialsNonExpired" value="false"
                               <#if !patient.credentialsNonExpired>checked</#if> > Neplatné osobné údaje
                    </label>
                </td>
            </tr>
        </table>

        <div class="form-group">
            <label for="patient-insurance">Poisťovňa</label>
            <select name="id_insurance" class="form-control" id="patient-insurance">
                <#if patient.insurance??>
                    <option value="${patient.insurance.id}" selected="selected">${patient.insurance.name}</option>
                <#else>
                    <option value="null" selected></option>
                </#if>
                <#list insurances as insurance>
                    <option value="${insurance.id}">${insurance.name}</option>
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
</@pt.dashboardPage>