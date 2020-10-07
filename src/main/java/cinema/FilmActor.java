package cinema;

import javax.persistence.*;

@Entity
@IdClass(FilmActorId.class)
@Table(name = "film_actor")
public class FilmActor extends BaseEntity{
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;


}
