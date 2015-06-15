<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
<div class="head row">
    <h1 class="">Moje objednávky</h1>
</div>
<div class="row">
    <#if message??>
        <#if message= 'ok'>
            <div class="alert alert-dismissible alert-success">
                Objednávka úspešne vymazaná !
            </div>
        <#elseif message ='nova'>
            <div class="alert alert-dismissible alert-success">
                Nová objednávka úspešne vytvorená !
            </div>
        <#elseif message='fail' >
            <div class="alert alert-dismissible alert-danger">
                Objednávka nemôže byť zrušena! Objednávku môžete zrušiť do 24 hodín pred termínom.
            </div>
        </#if>
    </#if>
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
                <#list orders as appointment>
                <tr>
                    <td>${appointment.date?string["d.M.yyyy"]}</td>
                    <td>${appointment.office.name}</td>
                    <#assign hodina=appointment.intervalStart/60 />
                    <#assign minuta= appointment.intervalStart % 60 />
                    <#if minuta = 30>
                        <#assign  cas = hodina?keep_before(",") + ":30" />
                    <#else>
                        <#assign  cas = hodina?keep_before(",") +":00 " />
                    </#if>


                    <td>${cas}</td>
                    <td><a class="btn btn-danger btn-sm"  href="<@spring.url '/appointment/delete/'+user.username +'/'+appointment.id />" role="button" onclick="return customConfirm('Naozaj chcete zrušiť objednávku?')" >Zrušiť
                        objednávku</a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</@pt.menuFooterPage>