package com.example.urlshortner.controller;

import com.example.urlshortner.model.Url;
import com.example.urlshortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UrlController {
    public static final Integer TIME_TO_LIVE = 5;

    @Autowired
    UrlService urlService;

    @GetMapping("/saveUrl")
    public Url generateAndSaveUrl(@RequestHeader(required = false) Integer userId, @RequestParam String url){
        String shortUrl = generateSHortenedUrl(url);
        Url urlEntity = new Url();
        urlEntity.setActualUrl(url);
        urlEntity.setShortenedUrl(shortUrl);
        urlEntity.setCreatedTime(LocalDateTime.now());
        urlEntity.setUserId(userId);
            urlEntity.setTimeToLive(TIME_TO_LIVE);
        return urlService.saveUrl(urlEntity);
    }

    //fetch all the records for that userId
    //check if shortened url is present -> return corresponding actual Url
    @GetMapping("/fetchActualUrl")
    public List<Url> fetchActualUrl(@RequestHeader(required = false) Integer userId, @RequestParam String shortUrl){

        List<Url> listOfUrls = urlService.fetchUrls(userId);

        return listOfUrls;
    }

    private String generateSHortenedUrl(String url){
        //url + currTime
        return url.substring(0,3) + System.currentTimeMillis();
    }
}
