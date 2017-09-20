package com.example.android.myvideo;

import android.os.Bundle;

import com.brightcove.player.edge.Catalog;
import com.brightcove.player.edge.PlaylistListener;
import com.brightcove.player.event.EventEmitter;
import com.brightcove.player.model.Playlist;
import com.brightcove.player.model.Video;
import com.brightcove.player.view.BrightcoveExoPlayerVideoView;
import com.brightcove.player.view.BrightcovePlayer;

public class MainActivity extends BrightcovePlayer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);
        brightcoveVideoView = (BrightcoveExoPlayerVideoView) findViewById(R.id.brightcove_video_view);
        super.onCreate(savedInstanceState);

        EventEmitter eventEmitter = brightcoveVideoView.getEventEmitter();
        String policy = "";
        String account = "";
        String playlistId = "";
        Catalog catalog = new Catalog(eventEmitter, account, policy);

        PlaylistListener playListListener = new PlaylistListener() {
            @Override
            public void onPlaylist(Playlist playlist) {
                Video video = playlist.getVideos().get(0);
                brightcoveVideoView.add(video);
                brightcoveVideoView.start();
            }
        };
        catalog.findPlaylistByID(playlistId, playListListener);


    }
}
