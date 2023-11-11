package softlab.homework.location.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softlab.homework.location.entities.InfoHistory;
import softlab.homework.location.repositories.CurrentCoordinatesRepository;
import softlab.homework.location.repositories.InfoHistoryRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UpdateServiceImpl implements UpdateService {
private final CurrentCoordinatesRepository currentCoordinatesRepository;
private final InfoHistoryRepository infoHistoryRepository;









    @Override
    public List<InfoHistory> getAllInfoHistory() {
        return null;
    }


}
