package kz.iitu.mymusic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B+\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lkz/iitu/mymusic/VideosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lkz/iitu/mymusic/VideosAdapter$VideosViewHolder;", "video", "", "Lkz/iitu/mymusic/networking/Videos;", "onMusicClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VideosViewHolder", "app_debug"})
public final class VideosAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<kz.iitu.mymusic.VideosAdapter.VideosViewHolder> {
    private final java.util.List<kz.iitu.mymusic.networking.Videos> video = null;
    private final kotlin.jvm.functions.Function1<kz.iitu.mymusic.networking.Videos, kotlin.Unit> onMusicClick = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kz.iitu.mymusic.VideosAdapter.VideosViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    kz.iitu.mymusic.VideosAdapter.VideosViewHolder holder, int position) {
    }
    
    public VideosAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<kz.iitu.mymusic.networking.Videos> video, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kz.iitu.mymusic.networking.Videos, kotlin.Unit> onMusicClick) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lkz/iitu/mymusic/VideosAdapter$VideosViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lkz/iitu/mymusic/VideosAdapter;Landroid/view/View;)V", "bindMessage", "", "video", "Lkz/iitu/mymusic/networking/Videos;", "app_debug"})
    public final class VideosViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        
        public final void bindMessage(@org.jetbrains.annotations.Nullable()
        kz.iitu.mymusic.networking.Videos video) {
        }
        
        public VideosViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}