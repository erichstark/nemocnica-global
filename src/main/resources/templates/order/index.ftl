<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
<div class="head row">
    <h1 class="">Moje objednavky</h1>
</div>
<div class="row">
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Datum</th>
                <th>Ambulancia</th>
                <th>Cas</th>
                <th>Akcia</th>
            </tr>
            </thead>
            <tbody>
                <#list orders as order>
                <tr>
                    <td>${order.date}</td>
                    <td>${order.office.name}</td>
                    <td>${order.intervalStart/60}</td>
                    <td><a href="<@spring.url '/order/delete/'+order.id />">Zmazat</a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</@pt.menuFooterPage>