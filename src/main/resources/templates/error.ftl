<#import "lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<#assign pageTitle in pt>${status} ${error}</#assign>
<@pt.genericPage>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>Oops!</h1>

                <h2>${status}</h2>

                <div class="error-details">
                ${error}
                </div>
                <div class="error-actions">
                    <button onclick="history.back()" class="btn btn-primary btn-lg">
                        <span class="glyphicon glyphicon-step-backward"></span> Späť
                    </button>
                    <a href="<@spring.url '/'/>" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-home"></span> Home
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</@pt.genericPage>
