<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
    <@pt.headerBanner/>

<div class="row">
    <h1 class="">Vyhľadávanie lekárov</h1>
    <div class="col-md-12">

        <form name="searchUser" class="form-horizontal fullSearch" method="POST" action="<@spring.url '/search/search'/>" >
            <div class="form-group">
                <label for="name">Meno:</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="Meno"
                       value="${name!""}">
            </div>
            <div class="form-group">
                <label for="surname">Priezvisko:</label>
                <input type="text" name="surname" class="form-control" id="surname" placeholder="Priezvisko"
                       value="${surname!""}">
            </div>
            <div class="form-group">
                <label for="specialization">Specializacia:</label>
                <input type="text" name="specialization" class="form-control" id="specialization" placeholder="Specializacia"
                       value="${specialization!""}">
            </div>
            <div class="form-group">

                <input type="hidden" name="town" class="form-control" id="town" placeholder="Mesto"
                       value="${town!""}">
            </div>
            <div class="floating-buttons">
                <input type="submit" value="Hľadaj" class="btn btn-primary">
                <a class="btn btn-default" href="<@spring.url '/search/clear'/>">Reset</a>
            </div>
        </form>
    </div>
</div>
<hr>
<div class="row left-content">

         <#list offices as office>
             <#list office.employees as employee>
         <div class="item ">
             <div class="item-avatar  col-md-3"><img src="/img/profile/avatar.png" width="100px"></div>
             <div class="item-info  col-md-9">
                <h3>${employee.firstName} ${employee.lastName}</h3>
                <ul>
                    <li class="col-md-12">
                        <div class="col-md-3">Špecializácia : </div>
                        <#list office.specializations as spec>
                            <div class="col-md-9">${spec.name}
                        </#list>
                    </li>
                    <li class="col-md-12">
                        <div class="col-md-3">Ambulancie : </div>
                        <div class="col-md-9">
                            <ul>

                                    <li>
                                        <a href="<@spring.url '/search/detail/'+employee.username+"/"+office.id />">
                                            <div style="display:block;font-weight: bold;">${office.name}</div>
                                            ${office.facility.city},  ${office.facility.streetAndNumber},  ${office.facility.name}

                                        </a>
                                    </li>

                            </ul>
                        </div>
                    </li>
                </ul>


             </div>

         </div>
             </#list>
            </#list>
</div>
<div class="right-aside">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Ako sa objednať k lekárovi ?</h3>
        </div>
        <div class="panel-body">
            <p>
                Vytvorenie objednávky je úplne zadarmo. Objednanie sa elektronicky je záväzné a vytvorenie objednávky je možné
                najneskôr do 24 hodín pred zvoleným termínom.
            </p>
            <hr>
            <ul>
                <li>Pre vytvorenie objednávky musíte byť zaregistrovaný <a href="<@spring.url '/registration'/>">(Zaregistrovať sa)</a> </li>
                <li>Vyhľadajte si svojho lekára</li>
                <li>V kalendári si zvoľte časť dňa </li>
                <li>Vo formulári si zvoľte čas objednávky</li>
                <li>Vyplňte informácie</li>
            </ul>
        </div>
    </div>


    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Dôležité odkazy</h3>
        </div>
        <div class="panel-body">

            <ul>
                <#if user??>
                <li><a href="<@spring.url '/appointment'/>">Moje objednávky</a> </li>
                </#if>
                <li><a href="<@spring.url '/tutorial'/>">Návod</a> </li>
                <li><a href="<@spring.url '/login'/>">Prihlásenie</a> </li>
                <li><a href="<@spring.url '/registration'/>">Registrácia</a> </li>
            </ul>
        </div>
    </div>

</div>

<#list emps as e>
    ${e.firstName} <br>
</#list>

<br>
    <#list specs as s>
    ${s.name} <br>
    </#list>
</@pt.menuFooterPage>