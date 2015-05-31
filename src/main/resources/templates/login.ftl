<#import "lib/pageTemplates.ftl" as g>
<#import "/spring.ftl" as spring>
<#assign pageTitle in g><@spring.message "SignIn"/></#assign>
<@g.menuFooterPage>
    <@g.headerBanner/>
<div class="">
    <div id="login-panel" class="panel panel-default" style="margin-top: 50px;">
        <div class="panel-heading"><h3 class="panel-title"><strong><@spring.message "SignIn"/></strong></h3></div>
        <div class="panel-body">
            <div class="text-danger">
                <#if RequestParameters.error??>
                    <@spring.message "InvalidCredentials"/>
                </#if>
                <#if RequestParameters.logout??>
                <@spring.message "SignedOut"/>
            </#if>
            </div>
            <div>
               <a href="<@spring.url '/'/>">Späť na hlavnú stránku</a>
            </div>
            <form role="form" action="<@spring.url '/login'/>" method="POST">
                <div class="form-group">
                    <label for="username"><@spring.message "Username"/></label>
                    <input type="text" class="form-control" id="username" name="username" required autofocus>
                </div>
                <div class="form-group">
                    <label for="password"><@spring.message "Password"/></label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <button type="submit" class="btn btn-sm btn-default"><@spring.message "SignIn"/></button>
            </form>
            <hr>
            <div>Ak nie ste zaregistrovaný <a href="<@spring.url '/registration'/> " >kliknite sem</a> . </div>
        </div>
    </div>
</div>
</@g.menuFooterPage>