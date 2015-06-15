package sk.stuba.fei.team.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.service.OnRegistrationCompleteEvent;
import sk.stuba.fei.team.global.service.PatientService;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private PatientService patientService;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }


    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        Patient patient = event.getPatient();
        String token = UUID.randomUUID().toString();
        patientService.createVerificationToken(patient, token);

        String recipientAddress = patient.getEmail();
        String subject = "EasyCare - potvrdenie registrácie";
        String confirmationUrl = event.getAppUrl() + "/registration/confirm?token=" + token;
        String message = "Registrácia účtu " + patient.getUsername() + " úspešná, pre pokračovanie použite odkaz - ";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipientAddress);
        mailMessage.setSubject(subject);
        mailMessage.setText(message + "http://" + confirmationUrl);
        mailSender.send(mailMessage);
    }
}

