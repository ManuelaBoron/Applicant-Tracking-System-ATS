package pl.edu.wszib.ats.applicanttrackingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:db.properties")
@SpringBootApplication
public class ApplicantTrackingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicantTrackingSystemApplication.class, args);
    }

}
