package sk.stuba.fei.team.global.repository;

import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.PatientOrder;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Created by jakubrehak on 10/05/15.
 */
public interface PatientOrderRepository  extends CrudRepository<PatientOrder, Long> {

    List<PatientOrder> findByDateAndOffice(@Temporal(TemporalType.DATE)Date date ,Office office);
    Iterable<PatientOrder> findByPatient( Patient patient);


}
