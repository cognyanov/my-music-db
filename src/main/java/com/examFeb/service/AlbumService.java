package com.examFeb.service;

import com.examFeb.model.entity.AlbumEntity;
import com.examFeb.model.service.AlbumServiceModel;
import com.examFeb.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumServiceModel);

    List<AlbumViewModel> findAllAlbums();

    Long getTotalCopies();

    void deleteById(Long id);
}
