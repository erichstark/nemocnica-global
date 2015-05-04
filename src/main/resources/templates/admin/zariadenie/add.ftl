<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Pridanie nového zariadenia</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/zariadenie'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

<div class="table-responsive">
    <form name="zariadenie" action="<@spring.url '/admin/zariadenie/save'/>" method="post">
        <div class="form-group">
            <label for="zariadenie-id">ID</label>
            <input type="text" name="id" class="form-control" id="zariadenie-id" placeholder="ID"
                   value="${zariadenie.id!""}">
        </div>
        <div class="form-group">
            <label for="zariadenie-nazov">Názov</label>
            <input type="text" name="nazov" class="form-control" id="zariadenie-nazov" placeholder="Názov"
                   value="${zariadenie.nazov!""}">
        </div>
        <div class="form-group">
            <label for="zariadenie-ulica">Ulica</label>
            <input type="text" name="ulica" class="form-control" id="zariadenie-ulica" placeholder="Ulica"
                   value="${zariadenie.ulica!""}">
        </div>
        <div class="form-group">
            <label for="zariadenie-cislo">Číslo</label>
            <input type="text" name="cislo" class="form-control" id="zariadenie-cislo" placeholder="Číslo"
                   value="${zariadenie.cislo!""}">
        </div>
        <div class="form-group">
            <label for="zariadenie-psc">PSČ</label>
            <input type="text" name="psc" class="form-control" id="zariadenie-psc" placeholder="PSČ"
                   value="${zariadenie.psc!""}">
        </div>
        <div class="form-group">
            <label for="zariadenie-mesto">Mesto</label>
            <input type="text" name="mesto" class="form-control" id="zariadenie-mesto" placeholder="Mesto"
                   value="${zariadenie.mesto!""}">
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Ulož" class="btn btn-success">
            </div>
        </div>
    </form>
</div>
</@pt.dashboardPage>