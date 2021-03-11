/*package com.example.Network.Services;

import java.util.*;
import java.util.concurrent.CompletableFuture;

import com.example.Network.Repository.NetworkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.Network.Models.Network;

@Service
public class AsyncService implements IPAsyncService {
    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);



    private final static List<Network> networks = new ArrayList<>();



    @Async("threadPoolTaskExecutor")
    public  CompletableFuture<Network> Display() throws InterruptedException{
        /*Network net = new Network();
        net.setTechnology(technology);
        net.setService(service);
        net.setProvider(provider);
        net.setPenetrationLevel(penetrationLevel);
        net.setOwner(owner);
        net.setOtherFeatures(otherFeatures);
        net.setLocation(location);
        networkRepository.save(net);
        System.out.println("Network Saved");
         */
/*
        log.info("getEmployeeName starts");

        Network networkData = restTemplate.getForObject("http://localhost:8080/createTest", Network.class);

        log.info("networkData, {}", networkData);
        Thread.sleep(1000L);    //Intentional delay
        log.info("networkData completed");
        return CompletableFuture.completedFuture(networkData);
    }

    @Override
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Network> getNetworkId(Long Id) throws InterruptedException{
        List<Network> networks = new ArrayList<>();

        List<String> technologyList = new ArrayList<String>();
        technologyList.add("5g");
        technologyList.add("4g");
        technologyList.add("3g");

        List<String> serviceList = new ArrayList<String>();
        serviceList.add("Telephone");
        serviceList.add("Internet");

        List<String> ownerList = new ArrayList<String>();
        ownerList.add("Government");

        List<String> providerList = new ArrayList<String>();
        providerList.add("Cosmote");
        providerList.add("Vodafone");
        providerList.add("Wind");

        List<String> locationList = new ArrayList<String>();
        locationList.add("16777");
        locationList.add("15238");

        List<String> penetrationLevelList = new ArrayList<String>();
        penetrationLevelList.add("89");
        penetrationLevelList.add("45");
        penetrationLevelList.add("98");

        Random rand = new Random();

        String technology;
        String service;
        String owner;
        String provider;
        String location;
        String penetrationLevel;
        for(int i = 0; i < 10;i++){
            technology = technologyList.get(rand.nextInt(technologyList.size()));
            service = serviceList.get(rand.nextInt(serviceList.size()));
            owner = ownerList.get(rand.nextInt(ownerList.size()));
            provider = providerList.get(rand.nextInt(providerList.size()));
            location = locationList.get(rand.nextInt(locationList.size()));
            penetrationLevel = penetrationLevelList.get(rand.nextInt(penetrationLevelList.size()));
            Network n = new Network();
            n.setTechnology(technology);
            n.setService(service);
            n.setProvider(provider);
            n.setPenetrationLevel(penetrationLevel);
            n.setOwner(owner);
            n.setLocation(location);
            networks.add(n);
        }
    }
    Network network = networks.get()
}*/
