package com.example.Network.Repository;


import java.util.List;
import java.util.Optional;

import com.example.Network.Models.Network;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NetworkRepository extends JpaRepository<Network, Long> {

    public List<Network> findByTechnology(String technology);

    public List<Network> findByLocation(String location);

    public List<Network> findByOwner(String owner);

    public List<Network> findByService(String service);

    public List<Network> findByProvider(String provider);

    public List<Network> findByPenetrationLevel(String penetrationLevel);



}