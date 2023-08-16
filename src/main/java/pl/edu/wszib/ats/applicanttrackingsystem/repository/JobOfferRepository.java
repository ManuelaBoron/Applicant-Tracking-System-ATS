package pl.edu.wszib.ats.applicanttrackingsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.SelectedJobOffer;

@Repository
public interface JobOfferRepository extends CrudRepository<SelectedJobOffer, Integer> {
    SelectedJobOffer findFirstByJobOffer(String jobOffer);
}
