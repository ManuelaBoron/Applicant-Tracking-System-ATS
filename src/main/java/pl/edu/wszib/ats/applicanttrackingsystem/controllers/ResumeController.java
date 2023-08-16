package pl.edu.wszib.ats.applicanttrackingsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    public static class Resume {
        public byte[] content;
        public String name;
        public String mimeType;
    }

    private List<Resume> resumes = new ArrayList<>();

    @GetMapping
    public String resume(Model model) {
        model.addAttribute("resumes", resumes);
        return "resume";
    }

    @PostMapping
    public String addResume(@RequestParam("resume")MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "redirect:/resume";
        }
        Resume newResume = new Resume();
        newResume.name = file.getOriginalFilename();
        newResume.content = file.getBytes();
        newResume.mimeType = file.getContentType();
        resumes.add(newResume);
        return "resumeConfirmationPage";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public ResponseEntity<byte[]> content(@PathVariable String name) {
        for(Resume o : resumes) {
            if (o.name.equals(name)) {
                return  ResponseEntity.status(HttpStatus.OK)
                        .contentType(MediaType.parseMediaType(o.mimeType))
                        .body(o.content);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new byte[0]);
    }
}
