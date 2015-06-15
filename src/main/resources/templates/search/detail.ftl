<#import "../lib/pageTemplates.ftl" as pt>
<#import "/spring.ftl" as spring>
<@pt.menuFooterPage>


<div class="detail-doktor row head">
    <div class=" col-md-12">
        <div class=" col-md-2"><img src="/img/profile/avatar.png" width="100px"></div>
        <div class="col-md-10">
            <div class="col-md-12"><h3>${employee.firstName} ${employee.lastName}</h3></div>
            <div class="  col-md-6">

                <ul>
                    <li class="col-md-12">
                        <div class="col-md-4"><strong>Špecializácia :</strong></div>
                        <#list office.specializations as spec>
                            <div class="col-md-8">${spec.name!"--"}</div>
                        </#list>
                    </li>
                    <li class="col-md-12">
                        <div class="col-md-4"><strong>Ambulancia :</strong></div>
                        <div class="col-md-8">${office.name}</div>
                    </li>
                </ul>

            </div>
            <div class="col-md-4">
                <div class="col-md-4">
                    <strong>Adresa : </strong></div>
                <div class="col-md-8">
                ${office.facility.name}<br> ${office.facility.streetAndNumber},<br>${office.facility.city}
                </div>
            </div>
        </div>

    </div>
</div>
<div class="row">
    <div class="col-md-8">
        <table class="list-days table-striped col-md-12">
            <thead>
            <tr>
                <th>Deň</th>
                <th>Dátum</th>
                <th>Termíny pre doobedie</th>
                <th>Termíny pre poobedie</th>
            </tr>
            </thead>
            <#list days as d>
                <tr>
                    <td style="width:60px;font-weight: bold;">${d.day}</td>
                    <td>${d.date}</td>
                    <#if d.hour??>
                        <#assign hodinaFrom=d.hour.reservationFrom/60 />
                        <#assign minutaFrom= d.hour.reservationFrom % 60 />
                        <#if minutaFrom = 30>
                            <#assign  casFrom = hodinaFrom?string['0'] + ":30" />
                        <#else>
                            <#assign  casFrom = hodinaFrom?string['0'] +":00 " />
                        </#if>

                        <#assign hodinaTo=d.hour.reservationTo/60 />
                        <#assign minutaTo= d.hour.reservationTo % 60 />
                        <#if minutaTo = 30>
                            <#assign  casTo = hodinaTo?string['0'] + ":30" />
                        <#else>
                            <#assign  casTo = hodinaTo?string['0'] +":00 " />
                        </#if>

                        <#--Morning-->
                        <#assign hodinaMorningFrom=d.hour.reservationMorningFrom/60 />
                        <#assign minutaMorningFrom= d.hour.reservationMorningFrom % 60 />
                        <#if minutaMorningFrom = 30>
                            <#assign  casMorningFrom = hodinaMorningFrom?keep_before(",") + ":30" />
                        <#else>
                            <#assign  casMorningFrom = hodinaMorningFrom?keep_before(",") +":00 " />
                        </#if>

                        <#assign hodinaMorningTo=d.hour.reservationMorningTo/60 />
                        <#assign minutaMorningTo= d.hour.reservationMorningTo % 60 />
                        <#if minutaMorningTo = 30>
                            <#assign  casMorningTo = hodinaMorningTo?keep_before(",") + ":30" />
                        <#else>
                            <#assign  casMorningTo = hodinaMorningTo?keep_before(",") +":00 " />
                        </#if>

                        <td>
                            <#if user??>
                            <div class="time" onclick="showReservations('morning',${d_index})">
                            <#else>
                            <div class="time" onclick="showLoginMessage()">
                            </#if>
                        ${casMorningFrom}
                            - ${casMorningTo}</div>

                        </td>
                        <td>
                            <#if user??>
                            <div class="time" onclick="showReservations('after',${d_index})">
                            <#else>
                            <div class="time" onclick="showLoginMessage()">
                            </#if>
                        ${casFrom}
                            - ${casTo}</div>


                        </td>
                    <#else>
                        <td colspan="2" ><span class="not-free">Bohužial už nie sú voľné termíny. </span></td>
                    </#if>
                    <div class="fade"></div>

                    <#if d.intervalList??>
                        <div id="${'after'+d_index}" class="popup white_content">


                            <h3> ${employee.firstName} ${employee.lastName}</h3>

                            <p> ${office.facility.name},${office.facility.streetAndNumber}
                                ,${office.facility.city}</p>
                            <hr>

                            <form class="create-appointment" name="appointment" action="<@spring.url '/search/save'/>"
                                  method="post">
                                <div class="form-group">
                                    <span style="color:red;">* Prosím zvoľte si čas objednávky</span>

                                    <div class="objednavka col-md-12">Vytvorenie objednávky na dátum ${d.date} , čas
                                        <select width="150px" name="intervalStart" class="" id="appointment-interval">
                                            <#list d.intervalList as interval>
                                                <#if interval.free == 1>
                                                    <#assign hodinaIntervalFrom=interval.s/60 />
                                                    <#assign minutaIntervalFrom= interval.s % 60 />
                                                    <#if minutaIntervalFrom = 30>
                                                        <#assign  casIntervalFrom = hodinaIntervalFrom?keep_before(",") + ":30" />
                                                    <#else>
                                                        <#assign  casIntervalFrom = hodinaIntervalFrom?keep_before(",") +":00 " />
                                                    </#if>

                                                    <#assign hodinaIntervalTo=interval.e/60 />
                                                    <#assign minutaIntervalTo= interval.e % 60 />
                                                    <#if minutaIntervalTo = 30>
                                                        <#assign  casIntervalTo = hodinaIntervalTo?keep_before(",") + ":30" />
                                                    <#else>
                                                        <#assign  casIntervalTo = hodinaIntervalTo?keep_before(",") +":00 " />
                                                    </#if>
                                                    <option value="${interval.s}">${casIntervalFrom}
                                                        - ${casIntervalTo}</option>
                                                </#if>
                                            </#list>
                                        </select>
                                    </div>
                                </div>

                                <#if user??>
                                    <div class="form-group">
                                        <label>Meno :</label>
                                        <span>${user.firstName} ${user.surname}</span>

                                    </div>

                                    <div class="form-group">
                                        <label>Email :</label>
                                        <span> ${user.email}</span>

                                    </div>
                                    <div class="form-group">
                                        <label>Poistovňa :</label>
                                        <span> ${user.insurance.name}</span>

                                    </div>
                                    <div class="form-group">
                                        <label for="appointment-note">Poznámka :</label>
                                        <textarea name="note" id="appointment-note"></textarea>

                                    </div>

                                    <input type="hidden" value="${d.date}" name="date">

                                    <input type="hidden" value="${office.id}" name="office_id">


                                    <input type="hidden" value="${user.username}" name="userName">
                                </#if>

                                <div class="form-group">
                                    <div class="control-buttons-tab ">
                                        <input type="submit" value="Ulož" class="btn btn-success">
                                        <button type="button" class="btn btn-warning"
                                                onclick="showReservations(${d_index})">Zrušiť
                                        </button>
                                    </div>
                                </div>

                            </form>
                        </div>


                    </#if>

                    <#--Formular pre ranne objednavky-->

                    <#if d.intervalList??>
                        <div id="${'morning'+d_index}" class="popup white_content">


                            <h3> ${employee.firstName} ${employee.lastName}</h3>

                            <p> ${office.facility.name},${office.facility.streetAndNumber}
                                ,${office.facility.city}</p>
                            <hr>

                            <form class="create-appointment" name="appointment" action="<@spring.url '/search/save'/>"
                                  method="post">
                                <div class="form-group">
                                    <span style="color:red;">* Prosím zvoľte si čas objednávky</span>

                                    <div class="objednavka col-md-12">Vytvorenie objednávky na dátum ${d.date} , čas
                                        <select width="150px" name="intervalStart" class="" id="appointment-interval">
                                            <#list d.intervalListMorning as interval>
                                                <#if interval.free == 1>
                                                    <#assign hodinaIntervalFrom=interval.s/60 />
                                                    <#assign minutaIntervalFrom= interval.s % 60 />
                                                    <#if minutaIntervalFrom == 30>
                                                        <#assign  casIntervalFrom = hodinaIntervalFrom?keep_before(",") +":30 "  />
                                                    <#else>
                                                        <#assign  casIntervalFrom = hodinaIntervalFrom?keep_before(",") + ":00 "  />
                                                    </#if>

                                                    <#assign hodinaIntervalTo=interval.e/60 />
                                                    <#assign minutaIntervalTo= interval.e % 60 />
                                                    <#if minutaIntervalTo = 30>
                                                        <#assign  casIntervalTo = hodinaIntervalTo?keep_before(",") + ":30" />
                                                    <#else>
                                                        <#assign  casIntervalTo = hodinaIntervalTo?keep_before(",") +":00 " />
                                                    </#if>
                                                    <#--<option value="${interval.s}">${casIntervalFrom}-->
                                                        <#--- ${casIntervalTo}</option>-->
                                                    <option value="${interval.s}">${casIntervalFrom}
                                                        - ${casIntervalTo}</option>
                                                </#if>
                                            </#list>
                                        </select>
                                    </div>
                                </div>

                                <#if user??>
                                    <div class="form-group">
                                        <label>Meno :</label>
                                        <span>${user.firstName} ${user.surname}</span>

                                    </div>

                                    <div class="form-group">
                                        <label>Email :</label>
                                        <span> ${user.email}</span>

                                    </div>
                                    <div class="form-group">
                                        <label>Poistovňa :</label>
                                        <span> ${user.insurance.name}</span>

                                    </div>
                                    <div class="form-group">
                                        <label for="appointment-note">Poznámka :</label>
                                        <textarea name="note" id="appointment-note"></textarea>

                                    </div>

                                    <input type="hidden" value="${d.date}" name="date">

                                    <input type="hidden" value="${office.id}" name="office_id">


                                    <input type="hidden" value="${user.username}" name="userName">
                                </#if>

                                <div class="form-group">
                                    <div class="control-buttons-tab ">
                                        <input type="submit" value="Ulož" class="btn btn-success">
                                        <button type="button" class="btn btn-warning"
                                                onclick="showReservations('morning',${d_index})">Zrušiť
                                        </button>
                                    </div>
                                </div>

                            </form>
                        </div>


                    </#if>



                </tr>
            </#list>
        </table>
    </div>
    <div class="col-md-4">
        Poznamky
    </div>
</div>
<div id="login-message" class="popup white_content_login">
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
                <button type="button" class="btn btn-sm btn-warning" onclick="showLoginMessage()">Zrusit</button>
            </form>
            <hr>
            <div>Ak nie ste zaregistrovaný <a href="<@spring.url '/registration'/> ">kliknite sem</a> .</div>
        </div>
    </div>

</div>
<script>
    function showReservations(part,id) {

        if(part == 'morning'){

            $("#morning" + id).toggle();
        }else{

            $("#after"+id).toggle();
        }

        $(".fade").toggle();
    }
    function showLoginMessage() {
        $("#login-message").toggle();
        $(".fade").toggle();
    }
</script>
</@pt.menuFooterPage>