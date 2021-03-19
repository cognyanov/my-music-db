package com.examFeb.service;

import com.examFeb.model.entity.ArtistEntity;
import com.examFeb.model.entity.enums.SingerEnum;

public interface ArtistService {
    void initArtists();
    ArtistEntity findByName(SingerEnum name);
}
