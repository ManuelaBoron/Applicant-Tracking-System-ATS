package pl.edu.wszib.ats.applicanttrackingsystem.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.ats.applicanttrackingsystem.models.ApplicationDetailsModel;
import pl.edu.wszib.ats.applicanttrackingsystem.models.JobModel;
import pl.edu.wszib.ats.applicanttrackingsystem.services.ApplicationService;
import pl.edu.wszib.ats.applicanttrackingsystem.services.JobOfferService;


@Controller
public class ApplicationController {
    @Value("${app.title.apply}")
    private String title;
    private final JobOfferService jobOfferService;
    private final ApplicationService applicationService;

    public ApplicationController(JobOfferService jobOfferService, ApplicationService applicationService) {
        this.jobOfferService = jobOfferService;
        this.applicationService = applicationService;
    }
    @GetMapping("/apply")
    public String applicationPage(Model model) {

        String [] jobOffers = {"HR Specialist", "Treasury Analyst", "Java Developer"};

        model.addAttribute("title", title);
        model.addAttribute("jobOffers", jobOffers);

        return "applicationPage";
    }

    @GetMapping("apply/{job-title}")
    public String applicationForm(@PathVariable("job-title") String jobTitle, Model model) {
        JobModel job = jobOfferService.getById(jobTitle);

        model.addAttribute("applicationDetails", new ApplicationDetailsModel());
        model.addAttribute("job", job);

        return "applyPage";

    }
    @PostMapping("apply/{job-title}")
    public String application(@PathVariable("job-title") String jobTitle,
                              @ModelAttribute("applicationDetails") ApplicationDetailsModel applicationDetailsModel) {
        applicationService.saveApplication(jobTitle, applicationDetailsModel);

        return "applicationConfirmationPage";
    }
}
