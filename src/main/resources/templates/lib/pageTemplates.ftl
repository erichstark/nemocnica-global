<#-- @ftlvariable name="pageTitle" type="java.lang.String" -->
<#-- @ftlvariable name="menu" type="java.util.List<sk.stuba.fei.nemocnica.menu.MenuItem>" -->
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
    <script src="<@spring.url '/js/jquery-2.1.4.min.js'/>"></script>
    <script src="<@spring.url '/js/custom.js'/>"></script>
    <title>${pageTitle}</title>
</head>
<body>
    <#nested>
<script src="<@spring.url '/js/jquery-2.1.4.min.js'/>"></script>
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
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <#if user??>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <i
                                class="glyphicon glyphicon-user"></i>${user.getUsername()}</a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="<@spring.url '/order'/>">Moje Objednavky</a>
                            </li>

                            <li class="divider"></li>
                            <li>
                                <a href="<@spring.url '/logout'/>"><i class="glyphicon glyphicon-log-out"></i> <@spring.message "SignOut" /></a>
                            </li>
                        </ul>
                        <#else>
                            <a class="btn btn-primary" id="" href="<@spring.url '/login'/>" >Prihlásenie</a>
                        </#if>
                    </li>
                </ul>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <#if user??>
                    <#if user.stringAuthorities?seq_contains("ADMIN")>
                        <li><a href="<@spring.url '/admin'/>">Administrácia</a></li>
                    </#if>
                    </ul>
                    </#if>

                </ul>
            </div>
        </div>
    </nav>
    <div class="container main-content">
        <#nested>
    </div>
    <footer class="footer">
        <div class="container">
         <div class="left-aside">
          <p>Tímovy projekt WeCare 2014-2015</p>
           <p>Fakulta elektrotechniky a informatiky, Slovenská technická univerzita , Bratislava</p>
         </div>
          <div class="footer-nav">
            <ul class="list-unstyled">
                <li><a>Vyhľadávanie</a></li>
                <li><a>Prihlásenie</a></li>
                <li><a>Registrácia</a></li>
                <li><a>Návod</a></li>
            </ul>
          </div>
          <div style="float:left;width:200px;padding-left:50px;">
             <span style="text-decoration: underline;display:block">Kontakt</span>

              Email: mail@mail.com
          </div>
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
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i
                                class="glyphicon glyphicon-user"></i> <#if user??>${user.getUsername()}</#if> </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#"><i class="glyphicon glyphicon-user"></i> Profile</a>
                            </li>
                            <li>
                                <a href="#"><i class="glyphicon glyphicon-envelope"></i> Inbox</a>
                            </li>
                            <li>
                                <a href="#"><i class="glyphicon glyphicon-cog"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="<@spring.url '/logout'/>"><i class="glyphicon glyphicon-log-out"></i> Log
                                    Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="row">
            <div id="side-navbar" class="col-sm-3 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <li><a href="<@spring.url '/admin'/>">Prehľad</a></li>
                    <li><a href="<@spring.url '/admin/facility'/>">Zariadenia</a></li>
                    <li><a href="<@spring.url '/admin/office'/>">Ambulancie</a></li>
                    <li><a href="<@spring.url '/admin/insurance'/>">Poistovne</a></li>
                    <li><a href="<@spring.url '/admin/specialization'/>">Špecializácie</a></li>
                    <li><a href="<@spring.url '/admin/patient'/>">Pacienti</a></li>
                    <li><a href="<@spring.url '/admin/employee'/>">Zamestnanci</a></li>
                </ul>
            </div>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <#nested>
            </div>
        </div>
    </div>
    </@genericPage>
</#macro>

<#macro simpleSearch>

<div class="row">


        <form name="searchUser" class="form-horizontal simpleSearch" method="POST" action="<@spring.url '/search/search'/>" >
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
                <label for="specialization">Špecializácia:</label>
                <input type="text" name="specialization" class="form-control" id="specialization" placeholder="Specializacia"
                       value="${specialization!""}">
            </div>
            <div class="form-group">

                <input type="hidden" name="town" class="form-control" id="town" placeholder="Mesto"
                       value="${town!""}">
            </div>
            <input type="submit" value="Hľadaj" class="btn btn-primary">

        </form>

</div>
</#macro>

<#macro headerBanner>
<header>
    <div class="banner-text alert alert-dismissible alert-success "> Objednajte sa z pohodlia domova rýchlo a jednoducho</div>

</header>
</#macro>