package com.TechM.springDemoProject.mailing.Controller;

import com.TechM.springDemoProject.mailing.models.EmailDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmailControllerTest {

  @Autowired
  EmailController emailController;
//        @Test
//        public void testSendMailWithValidDetails() {
//            EmailDetails emailDetails = new EmailDetails();
//            List<String> toList = Arrays.asList("ruq77771@gmail.com");
//            emailDetails.setRecipient(toList);
//            emailDetails.setSubject("Test Email");
//            emailDetails.setMsgBody("This is a test email.");
//            String result = emailController.sendMail(emailDetails);
//            assertEquals("success", result);
//        }


    @Test
    void sendMailToMany() {
    }

    @Test
    void sendMailWithAttachment() {
    }

    @Test
    void sendMailWithAttachmentToMany() {
    }
}