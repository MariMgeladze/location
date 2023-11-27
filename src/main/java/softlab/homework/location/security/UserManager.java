package softlab.homework.location.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softlab.homework.location.entities.UserDomain;
import softlab.homework.location.repositories.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class UserManager implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDomain> users = userRepository.findAllByUsername(username);
        if (users.isEmpty()) {
            throw new RuntimeException("user not found");
        }
        return users.get();

    }
}





