package cinema;

import javax.persistence.*;

@Entity
@IdClass(FilmCategoryId.class)
@Table(name = "film_category")
public class FilmCategory extends BaseEntity{
    @Id
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Id
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
