package cinema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Customer extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private boolean activebool;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    private int active;
}
