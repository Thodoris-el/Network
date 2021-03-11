package com.example.Network.Controller;



import java.io.File;
import java.net.URL;
import java.util.*;

import com.example.Network.CMD;
import com.example.Network.Repository.NetworkRepository;
import com.example.Network.Exceptions.ResourceNotFoundException;
//import com.example.Network.Services.AsyncService;
import com.example.Network.Services.IPAsyncService;
import com.example.Network.ShapefileToJson;
import org.geotools.data.*;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.feature.FeatureCollection;
import org.geotools.util.URLs;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import com.example.Network.Models.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import com.example.Network.Services.NetworkService;

@RestController
@RequestMapping("/Network")
public class NetworkController {

    @Autowired
    private NetworkRepository networkRepository;
    @Autowired
   private NetworkService networkService;

    @PostMapping("/create")
    public @ResponseBody
    String addNewNetwork (@Valid @RequestParam String technology , @RequestParam String owner , @RequestParam String service ,
                          @RequestParam String provider , @RequestParam String DateOfOperation , @RequestParam String penetrationLevel,@RequestParam String location, @RequestParam String otherFeatures) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Network n = new Network();
        n.setTechnology(technology);
        n.setService(service);
        n.setProvider(provider);
        n.setPenetrationLevel(penetrationLevel);
        n.setOwner(owner);
        n.setOtherFeatures(otherFeatures);
        n.setLocation(location);
        networkRepository.save(n);
        return "Saved";
    }

    @GetMapping("/createTest")
    public @ResponseBody
    List<Network> addNewNetwork () {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

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

        return networks;
    }

    @GetMapping("/net/{id}")
    public CompletableFuture<Network> getNetworkById(@PathVariable Long id) throws InterruptedException {
        return networkService.getNetworkById(id);
    }

    @PostMapping("/net/update")
    public void createNetwork() throws Exception {
        networkService.createNetwork();
    }

    @GetMapping("/net/id/{email}")
    public Network getNetworkByTechnology(@PathVariable String technology) throws InterruptedException {
        return networkService.getNetworkByTechnology(technology);
    }

    @GetMapping
    public List<Network> getAll() {
        return networkRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Network getOne(@PathVariable Long id) {
        return networkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    @PutMapping(value = "/{id}")
    public Network update(@PathVariable Long id, @RequestBody Network updatedNetwork) {
        Network network = networkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        network.setDateOfOperation(updatedNetwork.getDateOfOperation());
        network.setLocation(updatedNetwork.getLocation());
        network.setOtherFeatures(updatedNetwork.getOtherFeatures());
        network.setOwner(updatedNetwork.getOwner());
        network.setPenetrationLevel(updatedNetwork.getPenetrationLevel());
        network.setProvider(updatedNetwork.getProvider());
        network.setService(updatedNetwork.getService());
        network.setTechnology(updatedNetwork.getTechnology());
        return networkRepository.save(network);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        Network network = networkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        networkRepository.delete(network);
    }

    @GetMapping("/searchByTechnology")
    public List<Network> searchByTechnology(@RequestParam(name = "technology") String Technology) {
        return networkRepository.findByTechnology(Technology);

    }

    @GetMapping("/searchByLocation")
    public List<Network> searchByLocation(@RequestParam(name = "location") String Location) {
        return networkRepository.findByLocation(Location);

    }

    @GetMapping("/searchByOwner")
    public List<Network> searchByOwner(@RequestParam(name = "owner") String Owner) {
        return networkRepository.findByOwner(Owner);

    }

    @GetMapping("/searchByService")
    public List<Network> searchByService(@RequestParam(name = "service") String Service) {
        return networkRepository.findByService(Service);

    }

    @GetMapping("/searchByProvider")
    public List<Network> searchByProvider(@RequestParam(name = "provider") String Provider) {
        return networkRepository.findByProvider(Provider);

    }

    @GetMapping("/searchByPenetrationLevel")
    public List<Network> searchByPenetrationLevel(@RequestParam(name = "penetrationLevel") String PenetrationLevel) {
        return networkRepository.findByPenetrationLevel(PenetrationLevel);

    }


    /*@GetMapping("/convert")
    public String convert() throws Exception {
        URL url = getClass().getResource("/stations.shp");
        File file = new File("C:\\Users\\User\\Desktop\\ΕΜΠ\\9o e3amhno\\plhroforiaka\\maven\\Network\\src\\main\\java\\com\\example\\Network\\stations.shp");
        String dest = "C:\\Users\\User\\Desktop\\ΕΜΠ\\9o e3amhno\\plhroforiaka\\maven\\Network\\src\\main\\java\\com\\example\\Network\\destination";
        ShapefileToJson.openShapeFile(file);
        ShapefileToJson.iterate(file,dest);

        return "file converted";

    }*/

    @GetMapping("/convert")
    public String convert3() throws Exception{
        CMD.command("stations.json","C:\\Users\\User\\Desktop\\shp\\stations.shp");

        return "file converted- name: stations.json" ;
    }

    /*@GetMapping("/convert2")
    public String convert2() throws Exception {
        File inFile = new File("C:\\Users\\User\\Desktop\\ΕΜΠ\\9o e3amhno\\plhroforiaka\\maven\\Network\\src\\main\\java\\com\\example\\Network\\stations.shp");
        File outFile = new File("C:\\Users\\User\\Desktop\\ΕΜΠ\\9o e3amhno\\plhroforiaka\\maven\\Network\\src\\main\\java\\com\\example\\Network\\stations.csv");
        outFile.createNewFile();
// Read
        DataStore inputDataStore = DataStoreFinder.getDataStore(
                Collections.singletonMap("url", URLs.fileToUrl(inFile)));

        String inputTypeName = inputDataStore.getTypeNames()[0];
        SimpleFeatureType inputType = inputDataStore.getSchema(inputTypeName);

        FeatureSource<SimpleFeatureType, SimpleFeature>
                source = inputDataStore.getFeatureSource(inputTypeName);

        FeatureCollection<SimpleFeatureType, SimpleFeature>
                inputFeatureCollection = source.getFeatures();

// Write
        FileDataStore newDataStore = FileDataStoreFinder.getDataStore(outFile);

        newDataStore.createSchema(inputType);
        String typeName = newDataStore.getTypeNames()[0];

        SimpleFeatureStore featureStore =
                (SimpleFeatureStore) newDataStore.getFeatureSource(typeName);

        featureStore.addFeatures(inputFeatureCollection);

        return "file converted";

    }
*/

}