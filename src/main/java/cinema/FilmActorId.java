package cinema;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FilmActorId implements Serializable {

    private Long filmId;
    private Long actorId;

    public FilmActorId() {
    }

    public FilmActorId(Long filmId, Long actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public Long getActorId() {
        return actorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(filmId, that.filmId) &&
                Objects.equals(actorId, that.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, actorId);
    }
}
