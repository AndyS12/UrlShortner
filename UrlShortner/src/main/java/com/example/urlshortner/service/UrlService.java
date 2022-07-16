package com.example.urlshortner.service;

import com.example.urlshortner.model.Url;
import com.example.urlshortner.repository.UrlShortnerRepository;
import com.example.urlshortner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UrlShortnerRepository urlShortnerRepository;

    public Url saveUrl(Url url){
        return urlShortnerRepository.save(url);
    }

    public List<Url> fetchUrls(Integer userId){
        return urlShortnerRepository.getUrlsByUserId(userId);
    }

}
