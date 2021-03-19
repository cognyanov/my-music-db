package com.examFeb.model.entity;

import com.examFeb.model.entity.enums.GenreEnum;
import com.examFeb.model.entity.enums.SingerEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity{
    @Column(unique = true, nullable = false, length = 20)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @Column(nullable = false)
    private int copies;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, name = "released_date")
    private LocalDate releasedDate;

    @Column
    private String producer;

    @Enumerated(value = EnumType.STRING)
    private GenreEnum genre;

    @Enumerated(value = EnumType.STRING)
    private SingerEnum artist;

    @ManyToOne
    private UserEntity addedFrom;

    public AlbumEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public UserEntity getAddedFrom() {
        return addedFrom;
    }

    public void setAddedFrom(UserEntity addedFrom) {
        this.addedFrom = addedFrom;
    }

    public SingerEnum getArtist() {
        return artist;
    }

    public void setArtist(SingerEnum artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", Description='" + description + '\'' +
                ", copies=" + copies +
                ", price=" + price +
                ", releasedDate=" + releasedDate +
                ", producer='" + producer + '\'' +
                ", genre=" + genre +
                ", addedFrom=" + addedFrom +
                '}';
    }
}
