<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administracia zariadení</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/facility/add'/>" role="button">Vytvoriť
            facility</a>
    </div>
</div>

<h2 class="sub-header">Facilities</h2>

<div class="row">
    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/facility/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text" placeholder="Hľadaný text"
                       value="${search!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/facility/clear'/>">Reset</a>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">#</th>
            <th style="width: 60px;">ID</th>
            <th>Názov facilities</th>
            <th>Adresa</th>
            <th style="width: 60px;">Akcia</th>
        </tr>
        </thead>
        <tbody>
            <#list facilities as facility>
            <tr>
                <td>${facility_index + 1}</td>
                <td>${facility.id}</td>
                <td><a href="<@spring.url '/admin/facility/edit/' + facility.id />">${facility.name}</a></td>
                <td>${facility.streetAndNumber+', '+facility.zip+' '+facility.city}</td>
                <td><a href="<@spring.url '/admin/facility/delete/' + facility.id />"
                       onclick="return confirm('!! Zmaz ak si si isty ze toto facility nema ziadnu ambulanciu !!');">Zmazať</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>