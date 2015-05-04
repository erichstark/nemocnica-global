<#import "/spring.ftl" as spring />
<#macro genericPage>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<@spring.url '/fav/fav.ico'/>"/>
    <link type="text/css" href="<@spring.url '/css/bootstrap.min.css'/>" rel="stylesheet"/>
    <link type="text/css" href="<@spring.url '/css/custom.css'/>" rel="stylesheet"/>
    <title>${pageTitle}</title>
</head>
<body>
    <#nested>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="<@spring.url '/js/bootstrap.min.js'/>"></script>
</body>
</html>
</#macro>

<#macro menuFooterPage>
    <@genericPage>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="<@spring.url '/'/>"><@spring.message "ProjectName"/></a>
            </div>
            <div class="navbar-header pull-right">
                <ul class="nav navbar-nav">
                    <li><a href="<@spring.url '/#'/>"><strong>USERNAME</strong></a></li>
                    <li><a href="<@spring.url '/logout'/>">Logout</a></li>
                </ul>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="<@spring.url '/admin'/>">Admin</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <#nested>
    </div>
    <footer class="footer">
        <div class="container">
            <p class="text-muted">Place sticky footer content here.</p>
        </div>
    </footer>
    </@genericPage>
</#macro>

<#macro dashboardPage>
    <@genericPage>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<@spring.url '/'/>"><@spring.message "ProjectName"/></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<@spring.url '/#'/>"><strong>USERNAME</strong></a></li>
                    <li><a href="<@spring.url '/logout'/>">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <li><a href="<@spring.url '/admin'/>">Overview</a></li>
                    <li><a href="<@spring.url '/admin/zamestnanci'/>">Zamestnanci</a></li>
                    <li><a href="<@spring.url '/admin/zariadenie'/>">Zariadenia</a></li>
                    <li><a href="<@spring.url '/admin/ambulancia'/>">Ambulancie</a></li>
                    <li><a href="<@spring.url '/admin/poistovna'/>">Poistovne</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <#nested>
            </div>
        </div>
    </div>
    </@genericPage>
</#macro>