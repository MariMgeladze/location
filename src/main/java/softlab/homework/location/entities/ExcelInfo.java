package softlab.homework.location.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "vehicle_locations")
public class ExcelInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  double Latitude;

    private  double Longitude;

    private  String Number;


    public ExcelInfo() {

    }
}
