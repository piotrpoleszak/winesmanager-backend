package com.poleszak.winesmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Wine implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String strain;
    private String color;
    private Integer vintage;
    private String taste;
    private String country;
    private Integer rating;
    private String imageURL;
    @Column(nullable = false, updatable = false)
    private String wineCode;

    public Wine() {}

    public Wine(String name, String strain, String color, Integer vintage, String taste, String country, Integer rating, String imageURL)
    {
        this.name = name;
        this.strain = strain;
        this.color = color;
        this.vintage = vintage;
        this.taste = taste;
        this.country = country;
        this.rating = rating;
        this.imageURL = imageURL;
        this.wineCode = UUID.randomUUID().toString();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStrain()
    {
        return strain;
    }

    public void setStrain(String strain)
    {
        this.strain = strain;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Integer getVintage()
    {
        return vintage;
    }

    public void setVintage(Integer vintage)
    {
        this.vintage = vintage;
    }

    public String getTaste()
    {
        return taste;
    }

    public void setTaste(String taste)
    {
        this.taste = taste;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }

    public String getWineCode()
    {
        return wineCode;
    }

    public void setWineCode(String wineCode)
    {
        this.wineCode = wineCode;
    }

    @Override
    public String toString()
    {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", strain='" + strain + '\'' +
                ", color='" + color + '\'' +
                ", vintage=" + vintage +
                ", taste='" + taste + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", imageURL='" + imageURL + '\'' +
                ", wineCode='" + wineCode + '\'' +
                '}';
    }
}
