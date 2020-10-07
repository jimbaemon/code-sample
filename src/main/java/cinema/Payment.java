package cinema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id @GeneratedValue
    @Column(name = "payment_id")
    private Long id;
    private int amount;
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

}
