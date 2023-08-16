package pl.edu.wszib.ats.applicanttrackingsystem.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.ats.applicanttrackingsystem.entities.Review;
import pl.edu.wszib.ats.applicanttrackingsystem.mappers.ReviewMapper;
import pl.edu.wszib.ats.applicanttrackingsystem.models.ReviewModel;
import pl.edu.wszib.ats.applicanttrackingsystem.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {
    final
    ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Transactional
    public void saveReview(ReviewModel reviewModel) {
        Review reviewEntity = ReviewMapper.toEntity(reviewModel);

        reviewRepository.save(reviewEntity);
    }

    public List<ReviewModel> findAll() {
        List<Review> entities = reviewRepository.findAll();

        return entities.stream().map(ReviewMapper::toModel).toList();
    }
}
