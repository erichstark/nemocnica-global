<#-- @ftlvariable name="insurances" type="sk.stuba.fei.team.global.domain.Insurance[]" -->
<#-- @ftlvariable name="patient" type="sk.stuba.fei.team.global.domain.Patient" -->
<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
<div class="head row">
    <h1 class="">Zmena hesla</h1>
</div>

<div class="row">

    <form name="password" class="form-horizontal fullSearch" method="POST" action="<@spring.url '/patient/password/new'/>" >

        <div class="form-group">
            <label for="oldPassword">Staré heslo:</label>
            <input type="password" name="oldPassword" class="form-control" id="oldPassword" placeholder="Staré heslo"
                   >
        </div>
        <div class="form-group">
            <label for="newPassword">Nové heslo:</label>
            <input type="password" name="newPassword" class="form-control" id="newPassword" placeholder="Nové heslo"
                  >
        </div>
        <div class="form-group">
            <label for="newPasswordAgain">Nové heslo znovu:</label>
            <input type="password" name="newPasswordAgain" class="form-control" id="newPasswordAgain" placeholder="Nové heslo znovu"
                  >
        </div>

        <div class="floating-buttons">
            <input type="submit" value="Ulož" class="btn btn-primary">
        </div>
    </form>

</div>
</@pt.menuFooterPage>