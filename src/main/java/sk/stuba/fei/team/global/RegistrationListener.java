package sk.stuba.fei.team.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.service.OnRegistrationCompleteEvent;
import sk.stuba.fei.team.global.service.PatientService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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
        String subject = "Registration Confirmation";
        String confirmationUrl = event.getAppUrl() + "/registration/confirm?token=" + token;
        String message = "Registrácia úspešná";

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("timovyprojekt.nemocnica@gmail.com");
            helper.setTo(recipientAddress);
            helper.setSubject(subject);
            helper.setText(message + " rn" + "http://localhost:8180" + confirmationUrl);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new MailParseException(e);
        }
    }
}

