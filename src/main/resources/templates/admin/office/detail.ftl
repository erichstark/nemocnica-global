<#import "../../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.dashboardPage>
<h1 class="page-header">Detail ordinácie</h1>

<div class="row">
    <div class="col-md-12">
        <a class="btn btn-info btn-sm" href="<@spring.url '/admin/office'/>" role="button">Naspäť</a>
    </div>
</div>
<hr>
<div class="row">
    <div class="col-md-9">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h4>Všeobecné</h4>
            </div>
            <div class="panel-body">
                <p>
                    <span style="width: 30%; display: inline-block; text-align: right">Názov</span>:
                    <strong>${office.name}</strong>
                </p>
                <p>
                    <span style="width: 30%; display: inline-block; text-align: right">Zariadenie</span>:
                    <strong>${office.facility.getNameWithAddress()}</strong>
                </p>
                <p>
                    <span style="width: 30%; display: inline-block; text-align: right">Stav</span>:
                    <strong><@spring.message "enabled."+office.enabled?c /></strong>
                </p>
                <p>
                    <span style="width: 30%; display: inline-block; text-align: right">Telefón</span>:
                    <strong>${office.phone!""}</strong>
                </p>
                <p>
                    <span style="width: 30%; display: inline-block; text-align: right">Špecializácie</span>:
                    <strong>
                        <#list office.specializations as s>
                            ${s.name},&nbsp;
                        </#list>
                    </strong>
                </p>
                <p>
                    <span style="width: 30%; display: inline-block; text-align: right">Zmluvné poisťovne</span>:
                    <strong>
                        <#list office.insurances as i>
                        ${i.name},&nbsp;
                        </#list>
                    </strong>
                </p>
                <p>
                    <span style="width: 30%; display: inline-block; text-align: right">Pracovníci</span>:
                    <strong>
                        <#list office.employees as e>
                        ${e.getFullName()}(<@spring.message "enabled."+e.enabled?c />),&nbsp;
                        </#list>
                    </strong>
                </p>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-9">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h4>Ordinačné hodiny</h4>
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Deň</th>
                            <th>Doobeda od</th>
                            <th>Doobeda do</th>
                            <th>Poobede od</th>
                            <th>Poobede do</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list hours as h>
                            <tr>
                                <td>${h.getDayFromDate()}</td>
                                <td>${(h.reservationMorningFrom/60)?string["0"]}:${(h.reservationMorningFrom%60)?string["00"]}</td>
                                <td>${(h.reservationMorningTo/60)?string["0"]}:${(h.reservationMorningTo%60)?string["00"]}</td>
                                <td>${(h.reservationFrom/60)?string["0"]}:${(h.reservationFrom%60)?string["00"]}</td>
                                <td>${(h.reservationTo/60)?string["0"]}:${(h.reservationTo%60)?string["00"]}</td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-9">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h4>Objednávky</h4>
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Meno</th>
                            <th>Dátum</th>
                            <th>Čas</th>
                            <th>Poznámka</th>
                            <th>Stav</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list office.appointments as app>
                            <tr>
                                <td>${app.patient.getFullName()}</td>
                                <td>${app.date?date}</td>
                                <td>${(app.intervalStart/60)?string["0"]}:${(app.intervalStart%60)?string["00"]}</td>
                                <td>${app.note}</td>
                                <td><@spring.message "canceled."+app.enabled?c/></td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</@pt.dashboardPage>