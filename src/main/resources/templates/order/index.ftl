<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
<div class="head row">
    <h1 class="">Moje objednávky</h1>
</div>
<div class="row">
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Dátum</th>
                <th>Ambulancia</th>
                <th>Čas</th>
                <th>Akcia</th>
            </tr>
            </thead>
            <tbody>
                <#list orders as order>
                <tr>
                    <td>${order.date?string["d.M.yyyy"]}</td>
                    <td>${order.office.name}</td>
                    <#assign hodina=order.intervalStart/60 />
                    <#assign minuta= order.intervalStart % 60 />
                    <#if minuta = 30>
                        <#assign  cas = hodina?string['0'] + ":30" />
                    <#else>
                        <#assign  cas = hodina?string['0'] +":00 " />
                    </#if>


                    <td>${cas}</td>
                    <td><a href="<@spring.url '/order/delete/'+order.id />">Zrušiť objednávku</a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</@pt.menuFooterPage>