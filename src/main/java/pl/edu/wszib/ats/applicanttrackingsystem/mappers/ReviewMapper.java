package pl.edu.wszib.ats.applicanttrackingsystem.mappers;

import pl.edu.wszib.ats.applicanttrackingsystem.entities.Review;
import pl.edu.wszib.ats.applicanttrackingsystem.models.ReviewModel;

public class ReviewMapper {
    public static Review toEntity(ReviewModel model) {
        Review entity = new Review();
        entity.setName(model.getName());
        entity.setReview(model.getReview());

        return entity;
    }
    public static ReviewModel toModel(Review entity) {
        return new ReviewModel(
                entity.getName(),
                entity.getReview()
        );
    }
}
