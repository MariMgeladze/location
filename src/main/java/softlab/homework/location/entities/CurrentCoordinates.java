package softlab.homework.location.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "current_coordinates")
public class CurrentCoordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String number;

    private double latitude;

    private double longitude;




}
