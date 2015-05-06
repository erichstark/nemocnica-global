package sk.stuba.fei.team.local.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sk.stuba.fei.team.local.domain.Employee;
import sk.stuba.fei.team.local.service.EmployeeService;

public class CustomUserDetailService implements UserDetailsService {

    private EmployeeService employeeService;


    public CustomUserDetailService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (employeeService == null) {
            throw new UsernameNotFoundException("Failed to autowire employeeService.");
        }
        Employee z = employeeService.findByUsername(username);
        if (z == null) {
            throw new UsernameNotFoundException("User with username " + username + " not found.");
        }
        if (z.getAuthorities() == null || z.getAuthorities().isEmpty()) {
            throw new UsernameNotFoundException("User has no granted authorities.");
        }
        return new User(
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
