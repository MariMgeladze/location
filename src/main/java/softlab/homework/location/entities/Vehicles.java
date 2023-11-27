package softlab.homework.location.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(schema = "public", name = "vehicles")
public class Vehicles {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator = "vehicles_seq_generator")
    @SequenceGenerator(name = "vehicles_seq_generator",sequenceName = "vehicles_vehicle_id_seq",allocationSize = 1)
    @Column(name = "vehicle_id")
    private Integer vehicleId;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "vehicle_type")
    private Integer vehicleType;

    @Column(name = "payload")
    private Integer payload;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "length")
    private Integer length;

    @Column(name = "height")
    private Integer height;

    @Column(name = "width")
    private Integer width;

}
