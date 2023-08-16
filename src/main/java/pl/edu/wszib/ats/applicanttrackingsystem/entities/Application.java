package pl.edu.wszib.ats.applicanttrackingsystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "applications", schema = "applicanttrackingsystem")
public class Application {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "job_title")
    private String jobTitle;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_details_id")
    private ApplicationDetails applicationDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ApplicationDetails getApplicationDetails() {
        return applicationDetails;
    }

    public void setApplicationDetails(ApplicationDetails applicationDetails) {
        this.applicationDetails = applicationDetails;
    }
}
