package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Slack.SlackClient;
import com.TechM.springDemoProject.mailing.models.EmailDetails;
import com.TechM.springDemoProject.mailing.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Email")
public class EmailController {
    @Autowired
    EmailService emailService;

    @Autowired
    SlackClient slackClient;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendSimpleMail(emailDetails);
        return status;
    }

    @PostMapping("/sendMailToMany")
    public String sendMailToMany(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendSimpleMailToMany(emailDetails);
        slackClient.sendMessage(String.format(status));
        return status;
    }


    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendMailWithAttachment(emailDetails);
        return status;
    }


    @PostMapping("/sendMailWithAttachmentToMany")
    public String sendMailWithAttachmentToMany(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendMailWithAttachmentToMany(emailDetails);
        return status;
    }
}
