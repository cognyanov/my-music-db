package com.examFeb.repository;

import com.examFeb.model.entity.ArtistEntity;
import com.examFeb.model.entity.enums.SingerEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
    Optional<ArtistEntity> findByName(SingerEnum name);

}
