package sk.stuba.fei.team.local.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sk.stuba.fei.team.local.domain.Patient;
import sk.stuba.fei.team.local.service.PatientService;

public class CustomUserDetailService implements UserDetailsService {

    private PatientService patientService;


    public CustomUserDetailService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (patientService == null) {
            throw new UsernameNotFoundException("Failed to autowire employeeService.");
        }
        Patient p = patientService.findByUsername(username);
        if (p == null) {
            throw new UsernameNotFoundException("User with username " + username + " not found.");
        }
        if (p.getAuthorities() == null || p.getAuthorities().isEmpty()) {
            throw new UsernameNotFoundException("User has no granted authorities.");
        }
        return new User(
                p.getUsername(),
                p.getPassword(),
                p.isEnabled(),
                p.isAccountNonExpired(),
                p.isCredentialsNonExpired(),
                p.isAccountNonLocked(),
                p.getAuthorities()
        );
    }
}
