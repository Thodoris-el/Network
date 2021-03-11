package com.example.Network.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import com.example.Network.Models.Network;
@Service
public class DefaultNetworkervice implements NetworkService {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultNetworkervice.class);

    @Override
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Network> getNetworkById(final Long id) throws InterruptedException{
        LOG.info("Filling the network details for id {} ", id);
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
        Network n = new Network();
        for(int i = 0; i <= 0;i++){
            technology = technologyList.get(rand.nextInt(technologyList.size()));
            service = serviceList.get(rand.nextInt(serviceList.size()));
            owner = ownerList.get(rand.nextInt(ownerList.size()));
            provider = providerList.get(rand.nextInt(providerList.size()));
            location = locationList.get(rand.nextInt(locationList.size()));
            penetrationLevel = penetrationLevelList.get(rand.nextInt(penetrationLevelList.size()));

            n.setTechnology(technology);
            n.setService(service);
            n.setProvider(provider);
            n.setPenetrationLevel(penetrationLevel);
            n.setOwner(owner);
            n.setLocation(location);
            networks.add(n);
        }
        Thread.sleep(20000);
        return CompletableFuture.completedFuture(n);
    }

    @Override
    @Async("threadPoolTaskExecutor")
    public void createNetwork() throws Exception{
        LOG.warn("Running method with thread {} :", Thread.currentThread().getName());
        throw new Exception("Throw exception to check the custom exception handling");
    }

    @Override
    public Network getNetworkByTechnology(final String technology) throws InterruptedException{
        LOG.info("Filling the network details for technology {} ", technology);
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

        String technology2;
        String service;
        String owner;
        String provider;
        String location;
        String penetrationLevel;
        Network n = new Network();
        for(int i = 0; i <= 0;i++){
            technology2 = technologyList.get(rand.nextInt(technologyList.size()));
            service = serviceList.get(rand.nextInt(serviceList.size()));
            owner = ownerList.get(rand.nextInt(ownerList.size()));
            provider = providerList.get(rand.nextInt(providerList.size()));
            location = locationList.get(rand.nextInt(locationList.size()));
            penetrationLevel = penetrationLevelList.get(rand.nextInt(penetrationLevelList.size()));

            n.setTechnology(technology2);
            n.setService(service);
            n.setProvider(provider);
            n.setPenetrationLevel(penetrationLevel);
            n.setOwner(owner);
            n.setLocation(location);
            networks.add(n);
        }
        Thread.sleep(20000);
        return n;
    }

}
