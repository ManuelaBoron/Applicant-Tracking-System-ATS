package pl.edu.wszib.ats.applicanttrackingsystem.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.Application;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.ApplicationDetails;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.SelectedJobOffer;
import pl.edu.wszib.ats.applicanttrackingsystem.mappers.ApplicationDetailsMapper;
import pl.edu.wszib.ats.applicanttrackingsystem.models.ApplicationDetailsModel;
import pl.edu.wszib.ats.applicanttrackingsystem.repository.ApplicationRepository;
import pl.edu.wszib.ats.applicanttrackingsystem.repository.JobOfferRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobOfferRepository jobOfferRepository;

    public ApplicationService(ApplicationRepository applicationRepository, JobOfferRepository jobOfferRepository) {
        this.applicationRepository = applicationRepository;
        this.jobOfferRepository = jobOfferRepository;
    }

    public void saveApplication(String jobTitle, ApplicationDetailsModel applicationDetailsModel) {
        SelectedJobOffer selectedJobOffer =  jobOfferRepository.findFirstByJobOffer(jobTitle);

        ApplicationDetails applicationDetails = ApplicationDetailsMapper.toEntity(applicationDetailsModel);

        Application applicationEntity = new Application();
        applicationEntity.setJobTitle(selectedJobOffer.getJobOffer());
        applicationEntity.setApplicationDetails(applicationDetails);

        applicationRepository.save(applicationEntity);
    }
}
