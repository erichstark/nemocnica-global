<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Pridanie novej poisťovne</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/poistovna'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

<div class="table-responsive">
    <form name="poistovna" action="<@spring.url '/admin/poistovna/save'/>" method="post">
        <div class="form-group">
            <label for="poistovna-id">ID</label>
            <input type="text" name="id" class="form-control" id="poistovna-id" placeholder="ID"
                   value="${poistovna.id!""}">
        </div>
        <div class="form-group">
            <label for="poistovna-nazov">Názov</label>
            <input type="text" name="nazov" class="form-control" id="poistovna-nazov" placeholder="Názov"
                   value="${poistovna.nazov!""}">
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Ulož" class="btn btn-success">
            </div>
        </div>
    </form>
</div>
</@pt.dashboardPage>