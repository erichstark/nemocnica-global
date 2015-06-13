package sk.stuba.fei.team.global.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.service.PatientService;

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
        Patient z = patientService.findByUsername(username);
        if (z == null) {
            throw new UsernameNotFoundException("User with username " + username + " not found.");
        }
        if (z.getAuthorities() == null || z.getAuthorities().isEmpty()) {
            throw new UsernameNotFoundException("User has no granted authorities.");
        }
        return new CustomUser(
                z.getUsername(),
                z.getPassword(),
                z.isEnabled(),
                z.isAccountNonExpired(),
                z.isCredentialsNonExpired(),
                z.isAccountNonLocked(),
                z.getAuthorities()
        );
    }
}
