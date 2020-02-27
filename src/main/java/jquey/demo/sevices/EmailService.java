package jquey.demo.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService { // tamim
    @Autowired
    private JavaMailSender mailSender;

    /**
     * This method will send compose and send the message
     */
    public String sendMail(String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("tamim@feedback.com");
        message.setSubject(" Hello Spring boot ");
        message.setText(body);
        mailSender.send(message);
        return "DONE ";
    }
}
