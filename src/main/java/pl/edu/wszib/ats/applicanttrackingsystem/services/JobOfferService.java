package pl.edu.wszib.ats.applicanttrackingsystem.services;

import org.springframework.stereotype.Service;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.SelectedJobOffer;
import pl.edu.wszib.ats.applicanttrackingsystem.mappers.JobMapper;
import pl.edu.wszib.ats.applicanttrackingsystem.models.JobModel;
import pl.edu.wszib.ats.applicanttrackingsystem.repository.JobOfferRepository;

import java.util.Date;
import java.util.List;

@Service
public class JobOfferService {

    final
    JobOfferRepository jobOfferRepository;

    public JobOfferService(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    public void save(String jobOffer) {
        jobOfferRepository.save(new SelectedJobOffer(jobOffer, new Date()));

    }
    public void save(SelectedJobOffer selectedJobOffer) {
        this.save(selectedJobOffer.getJobOffer());

    }
    public List<SelectedJobOffer> getAllData() {
        return (List<SelectedJobOffer>) jobOfferRepository.findAll();

    }
    public JobModel getById(String jobTitle) {
        SelectedJobOffer selectedJobOffer = jobOfferRepository.findFirstByJobOffer(jobTitle);

        return JobMapper.toModel(selectedJobOffer);
    }
}
