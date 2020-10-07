package cinema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "address_id")
    private Long id;
    private String address;
    private String address2;
    private String district;
    @Column(name = "postal_code")
    private String postalCode;
    private String phone;
}
