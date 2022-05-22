package com.gestion_ressource.micro_respo.controller;

import com.gestion_ressource.micro_respo.model.Computer;
import com.gestion_ressource.micro_respo.model.Mail;
import com.gestion_ressource.micro_respo.model.Resource;
import com.gestion_ressource.micro_respo.repository.ResourceRepo;
import com.gestion_ressource.micro_respo.services.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/send-mail")
@Slf4j
public class MailController {

    @Autowired
    MailService mailService;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    ResourceRepo resourceRepo;

    @PostMapping("/{id}")
    public void sendMail(@PathVariable String id) throws MessagingException {
        Resource res = resourceRepo.findResourceById(id);
        String provider = res.getProvider();
        String from = "achraf.zaime@gmail.com";

        String msg = """
            <h1 style="color: #5e9ca0;">Panne de ressource!</h1>
            <p>on vous envoie ce mail pour demander le changement d'un resource en panne qui</p>
            <p>reste encore dans la periode de garanti</p>
            <h2 style="color: #2e6c80;">Details de Panne:</h2>
            <table class="editorDemoTable" style="width: 560px;">
            <thead>
            <tr>
            <td style="width: 190.703px;">Id</td>
            <td style="width: 250.922px;"><strong>""" + res.getId() + """
            </td>
            </tr>
            </thead>
            <tbody>
            <tr>
            <td style="width: 190.703px;">date de panne</td>
            <td style="width: 250.922px;"><strong>""" + res.getPanne().getDateAppartition() + """
            </strong></td>
            </tr>
            <tr>
            <td style="width: 190.703px;">ordre de panne</td>
            <td style="width: 250.922px;"><span style="color: #008000;"><span style="font-size: 13px;"><strong>""" + res.getPanne().getOrdrePanne() + """
            </strong></span></span></td>
            </tr>
            <tr>
            <td style="width: 190.703px;">constat</td>
            <td style="width: 250.922px;"><strong>""" + res.getPanne().getCommentaire() + """
            </strong></td>
            </tr>
            </tbody>
            </table>
            <p><strong>&nbsp;</strong></p>
            <p><strong>Merci!</strong></p>
            <p><strong>&nbsp;</strong></p>
""";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setSubject("Demande de changement de materiel !");
        helper.setFrom(from);
        helper.setTo(provider);

        boolean html = true;
        helper.setText(msg, html);

        mailSender.send(message);
    }
}
