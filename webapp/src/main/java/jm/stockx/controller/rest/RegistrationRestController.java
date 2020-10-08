package jm.stockx.controller.rest;


import jm.stockx.MailService;
import jm.stockx.PasswordGeneratorService;
import jm.stockx.UserService;
import jm.stockx.dto.UserRegistrationDto;
import jm.stockx.entity.User;


import jm.stockx.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationRestController {

    private final UserService userService;

    private final MailService mailService;

    public RegistrationRestController(UserService userService, MailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
    }

    @PostMapping
    public Response.BodyBuilder registrationNewUser(@RequestBody UserRegistrationDto user) {

        if (userService.getUserByEmail(user.getEmail()) == null) {
            return Response.error(HttpStatus.BAD_REQUEST);
        } else if (user.getFirstName().isEmpty() | user.getFirstName().isBlank()) {
            return Response.error(HttpStatus.BAD_REQUEST);
        } else if (user.getLastName().isEmpty() | user.getLastName().isBlank()) {
            return Response.error(HttpStatus.BAD_REQUEST);
        }

        String password = new PasswordGeneratorService().generatePassword(8);

        User newUser = new User(user.getFirstName(), user.getLastName(), user.getEmail(), password);

        userService.createUser(newUser);

        mailService.sendSimpleMessage(
                user.getEmail(),
                "Registration success",
                "Thank you for your registration\n" +
                        "your password:\n" + password
        );

        return  Response.ok();
    }

}
