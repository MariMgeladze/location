package softlab.homework.location.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softlab.homework.location.entities.UserDomain;
import softlab.homework.location.models.UserCreateModel;
import softlab.homework.location.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void addUser(UserCreateModel data) {
        var userDomain = new UserDomain();
        //userDomain.setId(data.id());
        userDomain.setUsername(data.username());
        userDomain.setPassword(passwordEncoder.encode(data.password()));
        userDomain.setFirstName(data.firstName());
        userDomain.setLastName(data.lastName());
        userDomain.setActive(true);
        userDomain.setCreatedAt(LocalDateTime.now());
        userRepository.save(userDomain);
    }


    @Override
    public List<UserDomain> search(Integer id, String userName, String firstName) {
          return userRepository.findAll();//ყველა მონაცემის გამოტანა
    }



    /*@Override
    public UserDomain getUserDomain(Integer id) {
        return userRepository.findById(id).orElseThrow();//id-ით მოძებნა
    }*/


}
