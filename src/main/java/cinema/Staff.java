package cinema;

import javax.persistence.*;

@Entity
public class Staff extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "staff_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private boolean active;
    private String username;
    private String password;
    @Lob
    private byte[] picture;

}

