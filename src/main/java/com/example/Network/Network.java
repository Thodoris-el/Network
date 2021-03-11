package com.example.Network;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.*;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "network")
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    private String name;

    private String category;

    //@DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date DateOfConstruction;


    private String[] Coordinates;


    private String Image;

    public void setId(Long Id){
        this.Id = Id;
    }

    public Long getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setDateOfConstruction(Date dateOfConstruction) {
        DateOfConstruction = dateOfConstruction;
    }

    public Date getDateOfConstruction() {
        return DateOfConstruction;
    }

    public void setCoordinates(String[] coordinates) {
        Coordinates = coordinates;
    }

    public String[] getCoordinates() {
        return Coordinates;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getImage() {
        return Image;
    }
}
