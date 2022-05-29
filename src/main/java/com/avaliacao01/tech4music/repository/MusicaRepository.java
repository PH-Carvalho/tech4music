package com.avaliacao01.tech4music.repository;

import com.avaliacao01.tech4music.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica,String> {
    
}
