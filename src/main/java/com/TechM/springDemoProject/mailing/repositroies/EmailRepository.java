package com.TechM.springDemoProject.mailing.repositroies;

import com.TechM.springDemoProject.mailing.models.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository {

    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);

    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}
