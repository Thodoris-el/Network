/*package com.example.Network.Exceptions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Network.Models.Network;
import com.example.Network.Services.AsyncService;
public class Test {
    private static Logger log = LoggerFactory.getLogger(Test.class);

    @Autowired
    private AsyncService service;

    @RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
    public void testAsynch() throws InterruptedException, ExecutionException
    {
        log.info("testAsynch Start");

        CompletableFuture<Network> network = service.Display();


        // Wait until they are all done
        CompletableFuture.allOf(network).join();

        log.info("Network--> " + network.get());
    }
}
*/