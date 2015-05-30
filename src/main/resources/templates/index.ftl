<#import "lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
<header>
    <div class="banner-text alert alert-dismissible alert-success "> Objednajte sa z pohodlia domova rýchlo a jednoducho</div>
    <#if user??>
    <#else>
    <a class="btn btn-primary" id="login-button" href="<@spring.url '/login'/>" >Prihlásenie</a>
    </#if>
</header>
<div class="content">
    <aside class="left-aside">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Ako sa objednať k lekárovi ?</h3>
            </div>
            <div class="panel-body">
                <ul>
                    <li>Pre vytvorenie objednávky musíte byť zaregistrovaný</li>
                    <li>Vyhľadajte si svojho lekára</li>
                    <li>V kalendári si zvoľte časť dňa </li>
                    <li>Vo formulári si zvoľte čas objednávky</li>
                    <li>Vyplňte informácie</li>
                </ul>
            </div>
        </div>
    </aside>

    <div class="right-content">
        <h1>Vyhľadajte svojho lekára</h1>
        <@pt.simpleSearch/>
    </div>

</div>
</@pt.menuFooterPage>