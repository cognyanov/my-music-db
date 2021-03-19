package com.examFeb.model.view;

import com.examFeb.model.entity.enums.GenreEnum;
import com.examFeb.model.entity.enums.SingerEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private Long id;
    private String imageUrl;
    private String name;
    private SingerEnum artist;
    private GenreEnum genre;
    private BigDecimal price;
    private LocalDate releasedDate;
    private int copies;

    public AlbumViewModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SingerEnum getArtist() {
        return artist;
    }

    public void setArtist(SingerEnum artist) {
        this.artist = artist;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
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

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
