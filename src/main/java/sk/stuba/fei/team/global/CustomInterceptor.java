package sk.stuba.fei.team.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sk.stuba.fei.team.global.security.CustomUser;
import sk.stuba.fei.team.global.service.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("customInterceptor")
public class CustomInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    PatientService patientService;

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response, final Object handler,
                           final ModelAndView modelAndView) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                CustomUser userDetails = (CustomUser) principal;
                if (modelAndView != null) {
                    modelAndView.getModelMap().addAttribute("user", patientService.findByUsername(userDetails.getUsername()));
                }
            }
        }
    }
}
