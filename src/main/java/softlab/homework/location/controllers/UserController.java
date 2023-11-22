package softlab.homework.location.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softlab.homework.location.entities.UserDomain;
import softlab.homework.location.models.UserCreateModel;
import softlab.homework.location.services.UserService;

import java.util.List;

@RestController
@AllArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("users")
    public void addUser(@RequestBody UserCreateModel data){
        userService.addUser(data);
    }




    /*@PostMapping("users")
    public UserDomain addNewUser(@RequestParam Integer id, @RequestBody UserCreateModel userCreateModel){
        return userService.userAdd(id,userCreateModel);
    }*/

   /* @PostMapping("users")
    public void addNewUser(@RequestBody UserDomain userDomain){
        userService.userAdd(userDomain.getId(),userDomain.getUsername(),userDomain.getPassword(), userDomain.getFirstName(), userDomain.getLastName());
    }*/

   @GetMapping("users")
    public List<UserDomain> search(Integer id, String userName, String firstName){
        return userService.search(id,userName,firstName);
    }

    /*@GetMapping("users/{id}")
    public UserDomain userDomain(@PathVariable Integer id){
        return userService.getUserDomain(id);
    }*/

}