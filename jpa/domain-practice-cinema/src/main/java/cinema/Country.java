package cinema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "country_id")
    private Long id;
    private String country;
}
