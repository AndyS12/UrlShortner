package com.example.urlshortner.repository;

import com.example.urlshortner.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlShortnerRepository extends JpaRepository<Url, Integer> {
    @Override
    <S extends Url> S save(S entity);

    @Query("select u from Url u where u.userId = :userId")
    List<Url> getUrlsByUserId(Integer userId);
}
