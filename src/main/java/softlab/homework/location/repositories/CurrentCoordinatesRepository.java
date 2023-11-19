package softlab.homework.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softlab.homework.location.entities.CurrentCoordinates;

import java.util.Optional;

public interface CurrentCoordinatesRepository extends JpaRepository<CurrentCoordinates,String> {
        Optional<CurrentCoordinates> findByNumber(String number);

}
