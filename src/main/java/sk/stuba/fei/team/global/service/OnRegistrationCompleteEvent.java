package sk.stuba.fei.team.global.service;

import org.springframework.context.ApplicationEvent;
import sk.stuba.fei.team.global.domain.Patient;

import java.util.Locale;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private final String appUrl;
    private final Locale locale;
    private final Patient patient;

    public OnRegistrationCompleteEvent(Patient patient, Locale locale, String appUrl) {
        super(patient);

        this.patient = patient;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public Patient getPatient() {
        return patient;
    }

}
