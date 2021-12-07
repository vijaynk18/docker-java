package com.mkyong.service;

import java.io.BufferedReader;
import java.util.ArrayList;
import com.mkyong.model.Collection;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.net.URL;

@Service
public class CollectionService {

    Logger logger = LoggerFactory.getLogger(CollectionService.class);

    public List<Collection> getAllCollections() throws IOException {
        URL url = new URL("https://api.getpostman.com/collections");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Api-Key", "PMAK-61ab89802e59640035c075b6-92d3019147c02bf91980eb0fd5cc09618c");

        int status = con.getResponseCode();


        logger.info("Status: "+status);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        logger.info(content.toString());
        in.close();
        con.disconnect();
        return new ArrayList<>();
    }

    public void getCollection(String collectionUid) throws IOException {
        String newURL = "https://api.getpostman.com/collections" + "/" + collectionUid;
        URL url = new URL(newURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Api-Key", "PMAK-61ab89802e59640035c075b6-92d3019147c02bf91980eb0fd5cc09618c");

        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        logger.info(content.toString());
        in.close();
        con.disconnect();
    }

}
