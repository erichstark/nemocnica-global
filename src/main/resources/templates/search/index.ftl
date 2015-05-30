<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>


<div class="row head">
    <h1 class="">Zamestnanci</h1>
    <div class="col-md-12">

        <form name="searchUser" class="form-inline" method="POST" action="<@spring.url '/search/search'/>" >
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
            <input type="submit" value="Hľadaj" class="btn btn-default">
            <a class="btn btn-default" href="<@spring.url '/search/clear'/>">Reset</a>

        </form>
    </div>
</div>

<div class="row">

         <#list employees as employee>
         <div class="item col-md-8">
             <div class="item-avatar  col-md-3"><img src="/img/profile/avatar.png" width="100px"></div>
             <div class="item-info  col-md-9">
                <h3>${employee.firstName} ${employee.lastName}</h3>
                <ul>
                    <li class="col-md-12">
                        <div class="col-md-3">Špecializácia : </div>
                        <div class="col-md-9">${employee.specializations}</div>
                    </li>
                    <li class="col-md-12">
                        <div class="col-md-3">Ambulancie : </div>
                        <div class="col-md-9">
                            <ul>
                                <#list employee.offices as of>
                                    <li>
                                        <a href="<@spring.url '/search/detail/' + employee.id +"/"+ of.id />">
                                            <div style="display:block;font-weight: bold;">${of.name}</div>
                                            ${of.facility.city},  ${of.facility.streetAndNumber},  ${of.facility.name}

                                        </a>
                                    </li>
                                </#list>
                            </ul>
                        </div>
                    </li>
                </ul>


             </div>

         </div>
            </#list>
</div>
</@pt.menuFooterPage>