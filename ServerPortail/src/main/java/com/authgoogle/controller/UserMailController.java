package com.authgoogle.controller;

import javax.validation.ValidationException;

import com.authgoogle.jpa.*;
import com.authgoogle.jpa.model.Feedback;
import com.authgoogle.payload.SignUpRequest;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authgoogle.config.EmailCfg;
@RestController
@RequestMapping("/feedback")
public class UserMailController {
	
	private EmailCfg emailCfg;

    public UserMailController(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }

    @PostMapping
    public void sendFeedback(@RequestBody SignUpRequest signUpRequest,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback is not valid");
        }

        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("Sab2iPortail@sab2i.com");
        mailMessage.setTo(signUpRequest.getEmail());
        mailMessage.setSubject("New Account to  "+ signUpRequest.getName() +"  From SAB" );
        mailMessage.setText("Votre Password est : "+signUpRequest.getPassword());

        // Send mail
        mailSender.send(mailMessage);
    }

}
