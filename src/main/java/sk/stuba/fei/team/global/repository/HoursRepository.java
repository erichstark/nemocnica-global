package sk.stuba.fei.team.global.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.global.domain.Hours;

import java.util.List;

/**
 * Created by jakubrehak on 07/05/15.
 */
public interface HoursRepository extends CrudRepository<Hours, Long> {

    List<Hours> findByOfficeId(Long id);

    List<Hours> findByEmployeeId(Long id);

    List<Hours> findByEmployeeIdAndOfficeId(Long id, Long officeid);

}
