package cinema;

import javax.persistence.*;

@Entity
public class Film extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "film_id")
    private Long id;
    private String title;
    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "rental_duration")
    private int rentalDuration;
    @Column(name = "rental_rate")
    private int rentalRate;
    private int length;
    @Column(name = "replacement_cost")
    private int replacementCost;
    @Lob
    @Column(name = "special_features")
    private String specialFeatures;
    @Lob
    private String fulltext;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public int getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(int rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(int replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }
}
