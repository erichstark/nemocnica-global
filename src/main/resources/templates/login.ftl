<#import "lib/pageTemplates.ftl" as g>
<#import "/spring.ftl" as spring>
<#assign pageTitle in g><@spring.message "SignIn"/></#assign>
<@g.genericPage>
<div class="container">
    <div id="login-panel" class="panel panel-default">
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
        </div>
    </div>
</div>
</@g.genericPage>