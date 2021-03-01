package cinema;

import java.io.Serializable;
import java.util.Objects;

public class FilmCategoryId implements Serializable {

    private Long film;
    private Long category;

    public FilmCategoryId() {
    }

    public FilmCategoryId(Long film, Long category) {
        this.film = film;
        this.category = category;
    }

    public Long getFilm() {
        return film;
    }

    public Long getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryId that = (FilmCategoryId) o;
        return Objects.equals(film, that.film) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, category);
    }
}
