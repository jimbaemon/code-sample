package cinema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "city_id")
    private Long id;
    private String city;
}
