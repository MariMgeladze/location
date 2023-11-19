package softlab.homework.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softlab.homework.location.entities.VehicleLocationHistory;

public interface VehicleLocationHistoryRepository extends JpaRepository<VehicleLocationHistory,Integer> {
}
