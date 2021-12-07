package com.mkyong.controller;

import com.mkyong.service.CollectionService;
import com.mkyong.model.Collection;
import com.mkyong.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/all")
    public List<Collection> getAllCollections() throws IOException {
        return collectionService.getAllCollections();
    }

    /*@GetMapping("/{collection_id}")
    public void getCollection(@PathVariable("collection_id") String collectionId) throws IOException {
        collectionService.getCollection(collectionId);
    }*/

}
