package cinema;

import javax.persistence.*;

@Entity
@IdClass(FilmActorId.class)
@Table(name = "film_actor")
public class FilmActor extends BaseEntity{
    @Id
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Id
    @OneToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;


}
