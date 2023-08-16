package pl.edu.wszib.ats.applicanttrackingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
