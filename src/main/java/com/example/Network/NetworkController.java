package com.example.Network;



import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.geotools.data.*;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.feature.FeatureCollection;
import org.geotools.util.URLs;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import com.example.Network.Network;
import com.example.Network.ResourceNotFoundException;
import com.example.Network.NetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.Network.ShapefileToJson;

@RestController
@RequestMapping("/Network")
public class NetworkController {

    @Autowired
    private NetworkRepository networkRepository;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Network add(@RequestBody Network network) {
        networkRepository.save(network);
        return network;
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
        network.setName(updatedNetwork.getName());
        network.setCategory(updatedNetwork.getCategory());
        network.setDateOfConstruction(updatedNetwork.getDateOfConstruction());
        network.setCoordinates(updatedNetwork.getCoordinates());
        network.setImage(updatedNetwork.getImage());
        return networkRepository.save(network);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        Network network = networkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        networkRepository.delete(network);
    }

    @GetMapping("/searchByName")
    public Network searchByName(@RequestParam(name = "name") String Name) {
        return networkRepository.findByName(Name)
                .orElseThrow(() -> new ResourceNotFoundException());

    }

    @GetMapping("/searchByCategory")
    public Network searchByCategory(@RequestParam(name = "category") String Category) {
        return networkRepository.findByCategory(Category)
                .orElseThrow(() -> new ResourceNotFoundException());

    }

    @GetMapping("/convert")
    public String convert() throws Exception {
        URL url = getClass().getResource("/stations.shp");
        File file = new File("C:\\Users\\User\\Desktop\\ΕΜΠ\\9o e3amhno\\plhroforiaka\\maven\\Network\\src\\main\\java\\com\\example\\Network\\stations.shp");
        String dest = "C:\\Users\\User\\Desktop\\ΕΜΠ\\9o e3amhno\\plhroforiaka\\maven\\Network\\src\\main\\java\\com\\example\\Network\\destination";
        ShapefileToJson.openShapeFile(file);
        ShapefileToJson.iterate(file,dest);

        return "file converted";

    }

    @GetMapping("/convert3")
    public String convert3() throws Exception{
        CMD.command("stations.json","C:\\Users\\User\\Desktop\\shp\\stations.shp");

        return "file converted- name: stations.json" ;
    }

    @GetMapping("/convert2")
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


}