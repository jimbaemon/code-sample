package cinema;

import javax.persistence.*;

@Entity
public class Store extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "store_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "staff_id")
    @Column(name = "manager_staff_id")
    private Staff managerStaff;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Staff getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(Staff managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
