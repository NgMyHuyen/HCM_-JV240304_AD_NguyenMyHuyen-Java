package ra.service;

import ra.model.Singer;
import ra.model.Song;

public class SongService {
    private Song[] songs = new Song[100];
    private int size = 0;

    public void addSong(Song song) {
        songs[size++] = song;
    }

    public void displayAllSongs() {
        for (int i = 0; i < size; i++) {
            songs[i].displayData();
        }
    }

    public Song findSongById(String id) {
        for (int i = 0; i < size; i++) {
            if (songs[i].getSongId().equals(id)) {
                return songs[i];
            }
        }
        return null;
    }

    public void updateSong(String id, Song updatedSong) {
        for (int i = 0; i < size; i++) {
            if (songs[i].getSongId().equals(id)) {
                songs[i] = updatedSong;
                break;
            }
        }
    }

    public boolean deleteSong(String id) {
        for (int i = 0; i < size; i++) {
            if (songs[i].getSongId().equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    songs[j] = songs[j + 1];
                }
                songs[--size] = null; 
                return true;
            }
        }
        return false;
    }
}
