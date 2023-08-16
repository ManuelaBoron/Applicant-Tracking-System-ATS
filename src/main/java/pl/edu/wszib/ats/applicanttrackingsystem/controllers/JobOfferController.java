package pl.edu.wszib.ats.applicanttrackingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.util.StringUtils;
import pl.edu.wszib.ats.applicanttrackingsystem.services.JobOfferService;

@Controller
public class JobOfferController {
    @Value("${app.title.select}")
    private String title;

    final
    JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping("/select")
    public String selectedJobOfferPage(Model model) {

        String [] jobOffers = {"HR Specialist", "Treasury Analyst", "Java Developer"};

        model.addAttribute("title", title);
        model.addAttribute("jobOffers", jobOffers);

        return "selectPage";
    }
    @GetMapping("/select/{jobOffer}")
    public String applyPage(@PathVariable(required = false) String jobOffer, Model model) {

        String description = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A accusamus ad beatae blanditiis, dolor doloribus et, exercitationem ipsam iure iusto laboriosam nisi pariatur quo quos reprehenderit suscipit voluptatibus. Amet impedit, incidunt, libero, modi nemo omnis optio perferendis quibusdam quis quo ratione recusandae sed voluptatem. Itaque laborum nobis sapiente suscipit vel!";

        model.addAttribute("description", description);

        if (!StringUtils.isEmpty(jobOffer)) {
            jobOfferService.save(jobOffer);
        }

        return "descriptionPage";
    }
}
