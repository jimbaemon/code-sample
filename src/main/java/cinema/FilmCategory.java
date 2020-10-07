package cinema;

import javax.persistence.*;

@Entity
@IdClass(FilmCategoryId.class)
@Table(name = "film_category")
public class FilmCategory extends BaseEntity{
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
