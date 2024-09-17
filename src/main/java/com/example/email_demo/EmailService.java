package com.example.email_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,"UTF-8");

            // Load Thymeleaf template
            Context context = new Context();
            java.util.Map<String, Object> templateModel = new java.util.HashMap<>();
            templateModel.put("userName", "Shriiiiiiii");
            templateModel.put("email", "shri@examplee.com");
            templateModel.put("registrationDate", "24-8-27");
            context.setVariables(templateModel);  // Inject dynamic data into the template
            String html = templateEngine.process("Regi", context);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);  // true means the email content is HTML

            javaMailSender.send(message);
            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
            // e.printStackTrace();
            // Handle other potential exceptions like authentication issues or invalid SMTP configuration.
        }
    }
}
