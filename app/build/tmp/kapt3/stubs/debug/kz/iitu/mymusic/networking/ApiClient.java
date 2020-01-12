package kz.iitu.mymusic.networking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH\'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H\'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH\'\u00a8\u0006\u0013"}, d2 = {"Lkz/iitu/mymusic/networking/ApiClient;", "", "getAlbum", "Lretrofit2/Call;", "Lkz/iitu/mymusic/networking/Album;", "album", "", "getAlbumByName", "getAllArtists", "Lkz/iitu/mymusic/networking/Artist;", "name", "getAllTracks", "Lkz/iitu/mymusic/networking/Track;", "track", "", "getTopTen", "getVideo", "Lkz/iitu/mymusic/networking/Videos;", "id", "app_debug"})
public abstract interface ApiClient {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "search.php")
    public abstract retrofit2.Call<kz.iitu.mymusic.networking.Artist> getAllArtists(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "s")
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "track-top10.php")
    public abstract retrofit2.Call<kz.iitu.mymusic.networking.Track> getTopTen(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "s")
    java.lang.String track);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "track.php")
    public abstract retrofit2.Call<kz.iitu.mymusic.networking.Track> getAllTracks(@retrofit2.http.Query(value = "m")
    int track);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "searchalbum.php")
    public abstract retrofit2.Call<kz.iitu.mymusic.networking.Album> getAlbum(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "s")
    java.lang.String album);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "searchalbum.php")
    public abstract retrofit2.Call<kz.iitu.mymusic.networking.Album> getAlbumByName(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "a")
    java.lang.String album);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "mvid.php")
    public abstract retrofit2.Call<kz.iitu.mymusic.networking.Videos> getVideo(@retrofit2.http.Query(value = "i")
    int id);
}