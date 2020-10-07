package cinema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Rental extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "rental_id")
    private Long id;
    @Column(name = "rental_date")
    private LocalDateTime rentalDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;



}
