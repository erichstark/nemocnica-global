package sk.stuba.fei.team.global;

import org.junit.Before;
import org.junit.Ignore;
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
import sk.stuba.fei.team.global.api.InsuranceApi;
import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.repository.InsuranceRepository;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = MainApplication.class)
@Ignore
public class InsuranceApiTest {

    public static final Logger LOGGER = Logger.getLogger(EmployeeApiTest.class.getName());

    @Autowired
    WebApplicationContext context;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @InjectMocks
    InsuranceApi controller;

    private MockMvc mvc;

    private String accessToken;

    private static String PATH = "/ws/insurance";

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

        accessToken = getAccessToken("user", "user123");

        insuranceRepository.deleteAll();

        Insurance dovera = new Insurance("Dovera");
        dovera.setEnabled(true);
        insuranceRepository.save(dovera);

        Insurance vzp = new Insurance("Vseobecna zdravotna poistovna");
        vzp.setEnabled(true);
        insuranceRepository.save(vzp);
    }

    @Test
    public void getExpectEmpty() throws Exception {
        mvc.perform(post(PATH+"/update")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(new SimpleDateFormat("yyyy-MM-dd").parse("2026-01-01")))
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void getExpectedCollection() throws Exception {
        mvc.perform(post(PATH+"/update")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01")))
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[1].id").exists());
    }

}
