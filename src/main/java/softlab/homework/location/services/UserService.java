package softlab.homework.location.services;

import softlab.homework.location.entities.UserDomain;
import softlab.homework.location.models.UserCreateModel;

import java.util.List;


public interface UserService{


   //UserDomain userAdd( UserCreateModel userCreateModel);
   // UserDomain userAdd(UserDomain users);
  //  UserDomain userAdd(Integer id, String userName, String password, String firstName, String lastName);

   // UserDomain userAdd(Integer id, UserCreateModel userCreateModel);


    //UserDomain userAdd(Integer id, UserCreateModel userCreateModel);

    void addUser(UserCreateModel data);

    List<UserDomain> search(Integer id, String userName, String firstName);

    //UserDomain addUser(UserDomain userDomain);

    //UserDomain createNewUser(Integer id, UserCreateModel userCreateModel);

    void createNewUser(UserCreateModel userCreateModel);


    // UserDomain userAdd(Integer id, String username, String password, String firstName, String lastName);

    //UserDomain getUserDomain(Integer id);
}
