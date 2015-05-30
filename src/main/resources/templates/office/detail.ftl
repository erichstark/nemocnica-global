<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>
<h1 class="page-header">Ambulancia</h1>


<h2 class="sub-header">${office.name}</h2>


<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Zariadenie</th>
            <th>Adresa</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${office.facility.name}</td>
                <td>${office.facility.city+', '+office.facility.streetAndNumber}</td>
            </tr>
        </tbody>
    </table>
</div>
</@pt.menuFooterPage>