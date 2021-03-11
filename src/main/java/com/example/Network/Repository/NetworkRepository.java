package com.example.Network.Repository;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import com.example.Network.Models.Network;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;


public interface NetworkRepository extends JpaRepository<Network, Long> {

    public List<Network> findByTechnology(final String technology);


    public List<Network> findByLocation(final String location);


    public List<Network> findByOwner(final String owner);


    public List<Network> findByService(final String service);


    public List<Network> findByProvider(final String provider);

    public List<Network> findByPenetrationLevel(final String penetrationLevel);



}