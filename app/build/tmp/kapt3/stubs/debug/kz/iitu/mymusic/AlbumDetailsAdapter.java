package kz.iitu.mymusic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lkz/iitu/mymusic/AlbumDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lkz/iitu/mymusic/AlbumDetailsAdapter$AlbumDetailsViewHolder;", "albums", "", "Lkz/iitu/mymusic/networking/Album;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AlbumDetailsViewHolder", "app_debug"})
public final class AlbumDetailsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<kz.iitu.mymusic.AlbumDetailsAdapter.AlbumDetailsViewHolder> {
    private final java.util.List<kz.iitu.mymusic.networking.Album> albums = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kz.iitu.mymusic.AlbumDetailsAdapter.AlbumDetailsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    kz.iitu.mymusic.AlbumDetailsAdapter.AlbumDetailsViewHolder holder, int position) {
    }
    
    public AlbumDetailsAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<kz.iitu.mymusic.networking.Album> albums) {
        super();
    }
    
    public AlbumDetailsAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lkz/iitu/mymusic/AlbumDetailsAdapter$AlbumDetailsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bindMessage", "", "album", "Lkz/iitu/mymusic/networking/Album;", "app_debug"})
    public static final class AlbumDetailsViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        
        public final void bindMessage(@org.jetbrains.annotations.Nullable()
        kz.iitu.mymusic.networking.Album album) {
        }
        
        public AlbumDetailsViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}