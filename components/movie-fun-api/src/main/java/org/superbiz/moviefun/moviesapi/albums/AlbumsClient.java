package org.superbiz.moviefun.moviesapi.albums;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Component
public class AlbumsClient {
    @Value("${albums.url}")
    private String albumsUrl;

    private RestOperations restOperations = new RestTemplate();

    private static ParameterizedTypeReference<List<AlbumInfo>> albumsListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public void addAlbum(AlbumInfo album) {
        restOperations.postForEntity(albumsUrl, album, AlbumInfo.class);
    }

    public AlbumInfo find(long id) throws URISyntaxException {
        return restOperations.getForEntity(new URI(albumsUrl+"/"+id), AlbumInfo.class).getBody();

    }

    public List<AlbumInfo> getAlbums() {
        System.out.println(albumsUrl);
        return restOperations.exchange(albumsUrl, GET, null, albumsListType).getBody();
    }

    public void deleteAlbum(AlbumInfo album) {
        restOperations.delete(albumsUrl+"/"+album.getId());
    }

    public void updateAlbum(AlbumInfo album) {
        restOperations.put(albumsUrl, album);
    }
}
