<#-- @ftlvariable name="insurances" type="sk.stuba.fei.team.local.domain.Insurance[]" -->
<#-- @ftlvariable name="patient" type="sk.stuba.fei.team.local.domain.Patient" -->
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
    <#if insurances?size == 0>
    <h2>Najskôr treba vytvoriť poisťovňu!</h2>
    <br>
    <a class="btn btn-warning btn-sm" href="<@spring.url '/admin/insurance/add'/>" role="button">Pridať poisťovňu</a>
    <#else>
    <div class="table-responsive">
        <form name="patient" action="<@spring.url '/admin/patient/save'/>" method="post">
            <div class="form-group">
                <label for="patient-username">Prihlasovacie meno (ID)</label>
                <input type="text" name="username" class="form-control" id="patient-username"
                       placeholder="Prihlasovacie meno"
                       value="${patient.username!""}">
            </div>
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
                <input type="text" name="suffix_title" class="form-control" id="patient-suffix_title"
                       placeholder="Titul za"
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

            <table>
                <tr>
                    <td style="width: 300px;">
                        <label class="radio-inline"><input type="radio" name="enabled" value="true" checked> Aktivovaný
                            účet</label>
                    </td>
                    <td>
                        <label class="radio-inline"><input type="radio" name="enabled" value="false"> Deaktivovaný účet</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="radio-inline">
                            <input type="radio" name="accountNonExpired" value="true" checked> Platný účet (non expired)
                        </label>
                    </td>
                    <td>
                        <label class="radio-inline">
                            <input type="radio" name="accountNonExpired" value="false"> Neplatný účet
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="radio-inline">
                            <input type="radio" name="accountNonLocked" value="true" checked> Odomknutý účet (non
                            locked)
                        </label>
                    </td>
                    <td>
                        <label class="radio-inline">
                            <input type="radio" name="accountNonLocked" value="false"> Uzamknutý účet
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="radio-inline">
                            <input type="radio" name="credentialsNonExpired" value="true" checked> Platné osobné údaje
                            (non expired)
                        </label>
                    </td>
                    <td>
                        <label class="radio-inline">
                            <input type="radio" name="credentialsNonExpired" value="false"> Neplatné osobné údaje
                        </label>
                    </td>
                </tr>
            </table>

            <div class="form-group">
                <label for="patient-autority">Autorita</label>
                <select name="autority" class="form-control" id="patient-autority">
                    <option value="USER">USER</option>
                    <option value="ADMIN">ADMIN</option>
                </select>
            </div>

            <div class="form-group">
                <label for="pationt-insurance">Poisťovňa</label>
                <select name="id_insurance" class="form-control" id="pationt-insurance">
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
    </#if>
</@pt.dashboardPage>