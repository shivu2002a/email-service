package com.example.email_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.email_demo.Dto.ActivationMailDto;
import com.example.email_demo.Dto.RegistrationMailDto;
import com.example.email_demo.Dto.TerminationMailDto;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/registration-mail")
    public ResponseEntity<String> sendRegistrationEmail(@RequestBody RegistrationMailDto regMailDto ) {
        emailService.sendRegistrationMail(regMailDto);
        return ResponseEntity.ok("Registration email sent successfully!");
    }

    @PostMapping("/activation-mail")
    public ResponseEntity<String> sendActivationEmail(@RequestBody ActivationMailDto activationMailDto ) {
        emailService.sendActivationMail(activationMailDto);
        return ResponseEntity.ok("Activation email sent successfully!");
    }

    @PostMapping("/termination-mail")
    public ResponseEntity<String> sendTerminationEmail(@RequestBody TerminationMailDto terminationMailDto ) {
        emailService.sendTerminationMail(terminationMailDto);
        return ResponseEntity.ok("Termination email sent successfully!");
    }
}
