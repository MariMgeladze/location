package softlab.homework.location.services;

import softlab.homework.location.entities.UserDomain;
import softlab.homework.location.models.UserCreateModel;

import java.util.List;


public interface UserService {


    void addUser(UserCreateModel data);

    List<UserDomain> search(Integer id, String userName, String firstName);
}




