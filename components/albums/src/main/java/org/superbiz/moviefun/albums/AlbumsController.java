package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {
    private AlbumsRepository albumsRepository;

    public AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumsRepository.getAlbums();
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);
    }

    @PutMapping
    public void updateAlbum(@RequestBody Album album) {
        albumsRepository.updateAlbum(album);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieId(@PathVariable Long id) {
        albumsRepository.deleteAlbum(albumsRepository.find(id));
    }

    @GetMapping("/{id}")
    public Album getAlbum(@PathVariable Long id) {
        return albumsRepository.find(id);
    }
}
