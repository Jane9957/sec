package app.controllers;

import app.servies.MailSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("email")
public class EmailController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    MailSevice mailSevice;

    @GetMapping(value = "/simple-email/{user-email}")
    public @ResponseBody
    ResponseEntity sendSimpleEmail(@PathVariable("user-email") String email) {

        //http://localhost:8080/email/simple-email/forgot_passs00@mail.ru
        try {
            mailSevice.send(email, "Welcome", "Hello, dear friend http://localhost:8080/users");
        } catch (MailException mailException) {
            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
    }

}
