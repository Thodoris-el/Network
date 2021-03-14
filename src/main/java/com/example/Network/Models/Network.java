package com.example.Network.Models;

import org.checkerframework.common.aliasing.qual.NonLeaked;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Entity
@Table(name = "network1")
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = "Technology must be provided")
    private String technology;

    @NotNull(message = "Owner must be provided")
    private String owner;

    @NotNull(message = "Service must be provided")
    private String service;

    @NotNull(message = "Provider must be provided")
    private String provider;

    private Date DateOfOperation;

    @NotNull(message = "Penetration level must be provided")
    private String penetrationLevel;

    @NotNull(message = "Location must be provided")
    private String location;

    private String otherFeatures;




    public void setId(Long Id){
        this.Id = Id;
    }

    public Long getId() {
        return Id;
    }

    public Date getDateOfOperation() {
        return DateOfOperation;
    }

    public String getLocation() {
        return location;
    }

    public String getOtherFeatures() {
        return otherFeatures;
    }

    public String getOwner() {
        return owner;
    }

    public String getPenetrationLevel() {
        return penetrationLevel;
    }

    public String getProvider() {
        return provider;
    }

    public String getService() {
        return service;
    }

    public String getTechnology() {
        return technology;
    }

    public void setDateOfOperation(Date dateOfOperation) {
        DateOfOperation = dateOfOperation;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOtherFeatures(String otherFeatures) {
        this.otherFeatures = otherFeatures;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPenetrationLevel(String penetrationLevel) {
        this.penetrationLevel = penetrationLevel;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

}
