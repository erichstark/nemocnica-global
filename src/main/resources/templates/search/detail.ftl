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
                        <div class="col-md-4"><span style="font-weight: bold">Špecializácia :</span></div>
                        <div class="col-md-8">${employee.specializations}</div>
                    </li>
                    <li class="col-md-12">
                        <div class="col-md-4"><span style="font-weight: bold">Ambulancia :</span></div>
                        <div class="col-md-8">${office.name}</div>
                    </li>
                </ul>

            </div>
            <div class="col-md-4">
                <div class="col-md-4">
                    <span style="font-weight: bold">Adresa : </span></div>
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
            </tr>
            </thead>
            <#list days as d>
                <tr>
                    <td style="width:60px;font-weight: bold;">${d.day}</td>
                    <td>${d.date}</td>
                    <#if d.hour??>
                        <td>
                            <div class="time" onclick="showReservations(${d_index})">${d.hour.reservationFrom}
                                - ${d.hour.reservationTo}</div>
                        </td>
                    <#else>
                        <td><span class="not-free">Pre doobedie už nie sú bohužial voľné termíny. </span></td>
                    </#if>


                    <#if d.intervalList??>
                        <div id="${d_index}" class="popup white_content">


                            <h3> ${employee.firstName} ${employee.lastName}</h3>

                            <p> ${office.facility.name},${office.facility.streetAndNumber}
                                ,${office.facility.city}</p>
                            <hr>

                            <form class="create-order" name="order" action="<@spring.url '/search/save'/>" method="post">
                                <div class="form-group">
                                    <span style="color:red;">* Prosím zvoľte si čas objednávky</span>
                                    <div class="objednavka col-md-12">Vytvorenie objednávky na dátum ${d.date} , čas
                                        <select width="150px" name="intervalStart" class="" id="order-interval">
                                            <#list d.intervalList as interval>
                                                <#if interval.free == 1>
                                                    <option value="${interval.s}">${interval.s/60}
                                                        - ${interval.e/60}</option>
                                                </#if>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label >Meno :</label>
                                    <span> Pacient Pacientovic</span>

                                </div>
                                <div class="form-group">
                                    <label >Dátum narodenia :</label>
                                    <span> 10.4.1990 </span>

                                </div>
                                <div class="form-group">
                                    <label >Email :</label>
                                    <span> mail@gmail.com</span>

                                </div>
                                <div class="form-group">
                                    <label >Poistovňa :</label>
                                    <span> VZP</span>

                                </div>
                                <div class="form-group">
                                    <label for="order-note">Poznámka :</label>
                                    <textarea name="note" id="order-note"></textarea>

                                </div>

                                <input type="hidden" value="${d.date}" name="date">

                                <input type="hidden" value="${office.id}" name="office_id">

                                <div class="form-group">
                                    <div class="control-buttons-tab ">
                                        <input type="submit" value="Ulož" class="btn btn-success">
                                        <button type="button" class="btn btn-warning" onclick="showReservations(${d_index})">Zrusit</button>
                                    </div>
                                </div>

                            </form>
                        </div>

                        <div class="fade"></div>
                    </#if>

                </tr>
            </#list>
        </table>
    </div>
    <div class="col-md-4">
        Poznamky
    </div>
</div>
    <#--<#list orders as o>-->
    <#--${o.intervalStart}-->

    <#--</#list>-->
<script>
    function showReservations(id) {
        $("#" + id).toggle();
        $(".fade").toggle();
    }
</script>
</@pt.menuFooterPage>