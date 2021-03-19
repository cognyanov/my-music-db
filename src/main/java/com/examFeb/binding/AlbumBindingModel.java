package com.examFeb.binding;

import com.examFeb.model.entity.ArtistEntity;
import com.examFeb.model.entity.enums.GenreEnum;
import com.examFeb.model.entity.enums.SingerEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumBindingModel {
    @Size(min = 3, max = 20, message = "Album name must be between 3 and 20 characters")
    @NotBlank(message = "Please enter name")
    private String name;

    @Size(min = 5, message = "Image url length must be minimum 5 characters")
    @NotBlank(message = "Please enter image url")
    private String imageUrl;

    @DecimalMin(value = "0", message = "Price must be positive")
    @NotNull
    private BigDecimal price;

    @Min(value = 10)
    @NotNull
    private int copies;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The date cannot be in the future")
    private LocalDate releasedDate;

    private String producer;

    @NotNull
    private SingerEnum artist;

    @NotNull (message = "Please select genre")
    private GenreEnum genre;

    @Size(min = 5, message = "Description must be minimum 5 characters")
    @NotBlank(message = "Please enter description")
    private String description;

    public AlbumBindingModel() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
