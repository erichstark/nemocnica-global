<#-- @ftlvariable name="specialization" type="sk.stuba.fei.team.local.domain.Specialization" -->
<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Pridanie novej specializations</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/specialization'/>" role="button">Naspäť</a>
    </div>
</div>

<br>

<div class="table-responsive">
    <form name="specialization" action="<@spring.url '/admin/specialization/save'/>" method="post">
        <div class="form-group">
            <label for="specialization-id">ID</label>
            <input type="text" name="id" class="form-control" id="specialization-id" placeholder="ID"
                   value="${specialization.id!""}">
        </div>
        <div class="form-group">
            <label for="specialization-name">Názov</label>
            <input type="text" name="name" class="form-control" id="specialization-name" placeholder="Názov"
                   value="${specialization.name!""}">
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Ulož" class="btn btn-success">
            </div>
        </div>

    </form>
</div>
</@pt.dashboardPage>