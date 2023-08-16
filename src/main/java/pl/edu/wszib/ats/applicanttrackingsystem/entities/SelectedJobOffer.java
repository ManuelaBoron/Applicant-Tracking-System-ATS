package pl.edu.wszib.ats.applicanttrackingsystem.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SelectedJobOffers", schema = "applicanttrackingsystem")
public class SelectedJobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String jobOffer;
    private Date ctime;

    public SelectedJobOffer(String jobOffer, Date ctime) {
        this.id = id;
        this.jobOffer = jobOffer;
        this.ctime = ctime;
    }

    public SelectedJobOffer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(String jobOffer) {
        this.jobOffer = jobOffer;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
