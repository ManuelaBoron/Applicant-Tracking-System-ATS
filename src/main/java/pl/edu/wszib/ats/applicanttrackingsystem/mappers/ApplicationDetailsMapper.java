package pl.edu.wszib.ats.applicanttrackingsystem.mappers;

import pl.edu.wszib.ats.applicanttrackingsystem.entities.ApplicationDetails;
import pl.edu.wszib.ats.applicanttrackingsystem.models.ApplicationDetailsModel;

public class ApplicationDetailsMapper {

    public static ApplicationDetails toEntity(ApplicationDetailsModel model) {
        ApplicationDetails entity = new ApplicationDetails();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setPhoneNumber(model.getPhoneNumber());
        entity.setEmailAddress(model.getEmailAddress());
        entity.setJobTitle(model.getJobTitle());

        return entity;
    }
}
