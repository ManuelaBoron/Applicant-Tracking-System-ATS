package pl.edu.wszib.ats.applicanttrackingsystem.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.SelectedJobOffer;
import pl.edu.wszib.ats.applicanttrackingsystem.services.JobOfferService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class DataController {
    @Value("${app.title.data}")
    private String title;

    final
    JobOfferService jobOfferService;

    public DataController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping("/data")
    String dataPage(Model model) {
        List<SelectedJobOffer> selectedJobOffer = jobOfferService.getAllData();
        Map<String, Long> dataMap = selectedJobOffer.stream().collect(Collectors.groupingBy(SelectedJobOffer::getJobOffer, Collectors.counting()));

        model.addAttribute("labels", dataMap.keySet());
        model.addAttribute("data", dataMap.values());
        model.addAttribute("title", title);
        model.addAttribute("selectedJobOffers", jobOfferService.getAllData());

        return "dataPage";
    }
}
