package pl.edu.wszib.ats.applicanttrackingsystem.models;

public class ReviewModel {
    private String name;
    private String review;

    public ReviewModel(String name, String review) {
        this.name = name;
        this.review = review;
    }

    public ReviewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
