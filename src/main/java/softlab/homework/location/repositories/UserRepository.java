package softlab.homework.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softlab.homework.location.entities.UserDomain;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain,Integer> {
    Optional<UserDomain> findAllByUsername(String username);

   }
