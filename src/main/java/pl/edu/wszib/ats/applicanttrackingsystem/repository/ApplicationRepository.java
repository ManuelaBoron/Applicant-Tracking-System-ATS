package pl.edu.wszib.ats.applicanttrackingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
