package cinema;

import javax.persistence.*;

@Entity
public class Inventory extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "inventory_id")
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
