package sk.stuba.fei.team.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import sk.stuba.fei.team.global.security.CustomUserDetailService;
import sk.stuba.fei.team.global.security.PBKDF2WithHmacSHA1;
import sk.stuba.fei.team.global.service.PatientService;

import javax.sql.DataSource;
import java.util.Locale;
import java.util.logging.Logger;

@SpringBootApplication
public class MainApplication extends WebMvcConfigurerAdapter {

    public static final Logger LOGGER = Logger.getLogger(MainApplication.class.getName());

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CustomInterceptor customInterceptor;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        initializeUsers(context);
    }

    private static void initializeUsers(ConfigurableApplicationContext context) {
        PatientService patientService = context.getBean(PatientService.class);
        PasswordEncoder encoder = new PBKDF2WithHmacSHA1();
//        if (patientService.findByUsername("admin") == null) {
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority("ADMIN"));
//            Patient userDetails = new Patient("admin", encoder.encode("admin123"), "admin@fei.stuba.sk", authorities);
//            patientService.save(userDetails);
//        }
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("sk"));
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(customInterceptor);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Configuration
    @EnableWebMvcSecurity
    @EnableWebSecurity
    protected static class MvcSecurityConfig extends WebSecurityConfigurerAdapter {

        @SuppressWarnings("SpringJavaAutowiringInspection")
        @Autowired
        private DataSource dataSource;

        @Autowired
        private PatientService patientService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/admin/**", "/manage").hasAuthority("ADMIN")
                    .antMatchers("/", "/registration", "/registration/save", "/search/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                    .and()
                    .logout().permitAll();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/fonts/**", "/fav/**");
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(new CustomUserDetailService(patientService)).passwordEncoder(new PBKDF2WithHmacSHA1());
            auth.jdbcAuthentication().dataSource(dataSource);
        }

        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }
}
