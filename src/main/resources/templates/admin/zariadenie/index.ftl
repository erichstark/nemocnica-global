<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Administracia zariadení</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/zariadenie/add'/>" role="button">Vytvoriť
            zariadenie</a>
    </div>
</div>

<h2 class="sub-header">Zariadenia</h2>

<div class="row">
    <div class="col-md-12">
        <form class="form-inline" method="POST" action="<@spring.url '/admin/zariadenie/search'/>">
            <div class="form-group">
                <label for="text">Vyhľadanie:</label>
                <input type="text" name="text" class="form-control" id="text" placeholder="Hľadaný text"
                       value="${search!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/admin/zariadenie/clear'/>">Reset</a>
        </form>
    </div>
</div>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60px;">#</th>
            <th style="width: 60px;">ID</th>
            <th>Názov zariadenia</th>
            <th>Adresa</th>
            <th style="width: 60px;">Akcia</th>
        </tr>
        </thead>
        <tbody>
            <#list zariadenia as zariadenie>
            <tr>
                <td>${zariadenie_index + 1}</td>
                <td>${zariadenie.id}</td>
                <td><a href="<@spring.url '/admin/zariadenie/edit/' + zariadenie.id />">${zariadenie.nazov}</a></td>
                <td>${zariadenie.ulica+' '+zariadenie.cislo+', '+zariadenie.psc+' '+zariadenie.mesto}</td>
                <td><a href="<@spring.url '/admin/zariadenie/delete/' + zariadenie.id />"
                       onclick="return confirm('!! Zmaz ak si si isty ze toto zariadenie nema ziadnu ambulanciu !!');">Zmazať</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@pt.dashboardPage>