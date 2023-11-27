package softlab.homework.location.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import softlab.homework.location.entities.UserDomain;
import softlab.homework.location.models.UserCreateModel;
import softlab.homework.location.services.UserService;

import java.util.List;

@RestController
@AllArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("users")
    public void addUser(@RequestBody UserCreateModel data) {
        userService.addUser(data);
    }


    @GetMapping("users")
    public List<UserDomain> search(Integer id, String userName, String firstName) {
        return userService.search(id, userName, firstName);
    }


}