package sk.stuba.fei.team.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stuba.fei.team.global.domain.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);
}