package pl.edu.wszib.ats.applicanttrackingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.ats.applicanttrackingsystem.models.ReviewModel;
import pl.edu.wszib.ats.applicanttrackingsystem.services.ReviewService;

import java.util.List;

@Controller
public class ReviewController {
    final
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

        @GetMapping("/review")
        public String reviewPage(Model model) {
            List<ReviewModel> reviews = reviewService.findAll();

            model.addAttribute("review", new ReviewModel());
            model.addAttribute("reviews", reviews);

            return "reviewPage";
        }

        @PostMapping("/review")
        public String reviewPage(@ModelAttribute("review") ReviewModel reviewModel) {
            reviewService.saveReview(reviewModel);

            return "redirect:/review";
        }
}
