package com.examFeb.service.impl;

import com.examFeb.model.entity.AlbumEntity;
import com.examFeb.model.service.AlbumServiceModel;
import com.examFeb.model.view.AlbumViewModel;
import com.examFeb.repository.AlbumRepository;
import com.examFeb.service.AlbumService;
import com.examFeb.service.ArtistService;
import com.examFeb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(ModelMapper modelMapper, ArtistService artistService, AlbumRepository albumRepository) {
        this.modelMapper = modelMapper;
        this.artistService = artistService;

        this.albumRepository = albumRepository;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {
        AlbumEntity album = modelMapper.map(albumServiceModel, AlbumEntity.class);

        albumRepository.save(album);
    }

    @Override
    public List<AlbumViewModel> findAllAlbums() {
        return albumRepository.findAll().stream().map(x -> modelMapper.map(x, AlbumViewModel.class)).
                collect(Collectors.toList());

    }

    @Override
    public Long getTotalCopies() {
        return albumRepository.getTotalCopiesSum();
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }

}
