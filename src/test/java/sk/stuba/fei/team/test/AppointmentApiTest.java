package sk.stuba.fei.team.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;
import sk.stuba.fei.team.global.MainApplication;
import sk.stuba.fei.team.global.api.AppointmentApi;
import sk.stuba.fei.team.global.api.domain.UpdateWrapper;
import sk.stuba.fei.team.global.domain.Appointment;
import sk.stuba.fei.team.global.repository.AppointmentRepository;
import sk.stuba.fei.team.global.repository.OfficeRepository;
import sk.stuba.fei.team.global.repository.PatientRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = MainApplication.class)
public class AppointmentApiTest {

    public static final Logger LOGGER = Logger.getLogger(AppointmentApiTest.class.getName());

    @Autowired
    WebApplicationContext context;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @InjectMocks
    AppointmentApi controller;

    private Appointment testApp;

    private MockMvc mvc;

    private String accessToken;

    private static String PATH = "/ws/appointment";

    private String getAccessToken(String username, String password) throws Exception {
        String authorization = "Basic " + new String(Base64Utils.encode("local:secret".getBytes()));
        String contentType = MediaType.APPLICATION_JSON + ";charset=UTF-8";

        String content = mvc
                .perform(
                        post("/oauth/token")
                                .header("Authorization", authorization)
                                .contentType(
                                        MediaType.APPLICATION_FORM_URLENCODED)
                                .param("username", username)
                                .param("password", password)
                                .param("grant_type", "password")
                                .param("scope", "read write")
                                .param("client_id", "local")
                                .param("client_secret", "secret"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.access_token", is(notNullValue())))
                .andExpect(jsonPath("$.token_type", is(equalTo("bearer"))))
                .andExpect(jsonPath("$.refresh_token", is(notNullValue())))
                .andExpect(jsonPath("$.expires_in", is(greaterThan(4000))))
                .andExpect(jsonPath("$.scope", is(equalTo("read write"))))
                .andReturn().getResponse().getContentAsString();

        return content.substring(17, 53);
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(springSecurityFilterChain)
                .build();

        accessToken = getAccessToken("admin", "admin123");

        appointmentRepository.deleteAll();


        testApp = new Appointment();
        testApp.setDate(new Date());
        testApp.setIntervalStart(0);
        testApp.setNote("omg");
        testApp.setOffice(officeRepository.findOne(new Long(1)));
        testApp.setPatient(patientRepository.findOne("admin"));
        appointmentRepository.save(testApp);

        Appointment ap2 = new Appointment();
        ap2.setDate(new Date());
        ap2.setIntervalStart(1);
        ap2.setNote("omg");
        ap2.setOffice(officeRepository.findOne(new Long(1)));
        ap2.setPatient(patientRepository.findOne("admin"));
        appointmentRepository.save(ap2);

        Appointment ap3 = new Appointment();
        ap3.setDate(new Date());
        ap3.setIntervalStart(1);
        ap3.setNote("omg");
        ap3.setOffice(officeRepository.findOne(new Long(2)));
        ap3.setPatient(patientRepository.findOne("admin"));
        appointmentRepository.save(ap3);

    }

    @Test
    public void updateExpectTwoReturned() throws Exception {

        Set<Long> ids = new HashSet<>();
        ids.add(testApp.getOffice().getId());

        UpdateWrapper<Long> uw = new UpdateWrapper<>(ids, new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));

        mvc.perform(post(PATH + "/update")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(uw))
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[1].id").exists())
                .andExpect(jsonPath("$[2].id").doesNotExist());
    }

}
