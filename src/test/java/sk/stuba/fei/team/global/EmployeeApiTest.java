package sk.stuba.fei.team.global;

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
import sk.stuba.fei.team.global.api.EmployeeApi;
import sk.stuba.fei.team.global.api.UpdateWrapper;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.repository.EmployeeRepository;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = MainApplication.class)
public class EmployeeApiTest {

    public static final Logger LOGGER = Logger.getLogger(EmployeeApiTest.class.getName());

    @Autowired
    WebApplicationContext context;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeApi controller;

    private MockMvc mvc;

    private String accessToken;

    private static String PATH = "/ws/employee";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(springSecurityFilterChain)
                .build();

        accessToken = getAccessToken("user", "user123");

        employeeRepository.deleteAll();

        Employee ferko = new Employee();
        ferko.setFirstName("Fero");
        ferko.setLastName("Ferovic");
        ferko.setUsername("ferko");
        employeeRepository.save(ferko);

        Employee misko = new Employee();
        misko.setFirstName("Miso");
        misko.setLastName("Misovic");
        misko.setUsername("misko");
        employeeRepository.save(misko);
    }

    @Test
    public void findUnauthorized() throws Exception {
        mvc.perform(get(PATH+"/ferko")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.error", is("unauthorized")));
    }

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

    @Test
    public void findAuthorized() throws Exception {

        mvc.perform(get(PATH+"/ferko")
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("ferko")));

    }

    @Test
    public void updateExpectEmpty() throws Exception {

        Set<String> usernames = new HashSet<String>();
        usernames.add("ferko");

        UpdateWrapper<String> uw = new UpdateWrapper<String>(usernames, new SimpleDateFormat("yyyy-MM-dd").parse("2026-01-01"));

        mvc.perform(post(PATH+"/update")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(uw))
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void updateExpectTwoReturned() throws Exception {

        Set<String> usernames = new HashSet<String>();
        usernames.add("ferko");
        usernames.add("misko");

        UpdateWrapper<String> uw = new UpdateWrapper<String>(usernames, new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));

        mvc.perform(post(PATH+"/update")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(uw))
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username", is("ferko")))
                .andExpect(jsonPath("$[1].username", is("misko")));
    }

    @Test
    public void postOneHappyPath() throws Exception {

        Employee petko = new Employee();
        petko.setFirstName("Peto");
        petko.setLastName("Petovic");
        petko.setUsername("petko");

        mvc.perform(post(PATH)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(petko))
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(content().string("\"petko\""));
    }

}
