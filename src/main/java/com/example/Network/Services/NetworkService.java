package com.example.Network.Services;

import com.example.Network.Models.Network;
import java.util.concurrent.CompletableFuture;


public interface NetworkService {
    CompletableFuture<Network> getNetworkById(final Long id) throws InterruptedException;
    void createNetwork() throws Exception;
    Network getNetworkByTechnology(final String technology) throws InterruptedException;

}
