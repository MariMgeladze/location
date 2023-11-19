package softlab.homework.location.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Setter
@Getter
@Table(name = "vehicles")
public class Vehicles {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer vehicleId;

    private String vehicleNumber;

    private Integer driver;

    private Integer vehicleType;

    private Integer payLoad;

    private Boolean status;

    private Integer length;

    private Integer height;

    private Integer width;



}
