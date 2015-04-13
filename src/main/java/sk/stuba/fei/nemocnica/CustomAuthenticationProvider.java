package sk.stuba.fei.nemocnica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import sk.stuba.fei.nemocnica.dao.ZamestnanecDAO;
import sk.stuba.fei.nemocnica.model.Zamestnanec;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matus_000 on 6.4.2015.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    ZamestnanecDAO zamestnanecDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        Zamestnanec zamestnanec = zamestnanecDao.getByUsername(name);
        if (zamestnanec != null) {
            try {
                boolean valid = PasswordHash.validatePassword(password, zamestnanec.getPassword());
                if (valid) {
                    return new UsernamePasswordAuthenticationToken(name, authentication, parseRoles(zamestnanec.getRole()));
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ignored) {
            }
        }
        //DEBUG
        if (name.equals("user") && password.equals("user123")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new UsernamePasswordAuthenticationToken(name, authentication, grantedAuths);
        } else if (name.equals("admin") && password.equals("admin123")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new UsernamePasswordAuthenticationToken(name, authentication, grantedAuths);
        }
        //DEBUG
        throw new BadCredentialsException("Invalid credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

    private List<GrantedAuthority> parseRoles(String roles) {
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        for (String token : roles.split(",")) {
            grantedAuths.add(new SimpleGrantedAuthority(token));
        }
        return grantedAuths;
    }

}
