package pl.edu.wszib.ats.applicanttrackingsystem.mappers;

import pl.edu.wszib.ats.applicanttrackingsystem.entities.SelectedJobOffer;
import pl.edu.wszib.ats.applicanttrackingsystem.models.JobModel;

public class JobMapper {
    public static JobModel toModel(SelectedJobOffer entity) {
        return new JobModel(
                entity.getId(),
                entity.getJobOffer(),
                entity.getCtime()
    );
    }
}
