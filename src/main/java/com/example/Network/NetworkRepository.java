package com.example.Network;


import java.util.List;
import java.util.Optional;

import com.example.Network.Network;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NetworkRepository extends JpaRepository<Network, Long> {

    public Optional<Network> findByName(String name);

    public Optional<Network> findByCategory(String category);


}