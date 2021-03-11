package com.example.Network.Services;

import  java.util.concurrent.CompletableFuture;
import com.example.Network.Models.Network;
public interface IPAsyncService {
    CompletableFuture<Network> getNetworkId(Long Id) throws InterruptedException;
}
