package softlab.homework.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentCoordinatesRepository extends JpaRepository<CurrentCoordinatesRepository,Integer> {
    CurrentCoordinatesRepository findByNumber(String Number);
}
