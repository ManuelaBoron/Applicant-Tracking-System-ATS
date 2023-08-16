package pl.edu.wszib.ats.applicanttrackingsystem.models;

import java.util.Date;

public class JobModel {
    private Integer id;
    private String jobOffer;
    private Date ctime;

    public JobModel(Integer id, String jobOffer, Date ctime) {
    }


    public Integer getId() {
        return id;
    }

    public String getJobOffer() {
        return jobOffer;
    }

    public Date getCtime() {
        return ctime;
    }
}
