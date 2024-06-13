package ra.service;

import ra.model.Singer;

public class SingerService {
    private Singer[] singers = new Singer[100];
    private int size = 0;

    public void addSinger(Singer singer) {
        singers[size++] = singer;
    }

    public void displayAllSingers() {
        for (int i = 0; i < size; i++) {
            singers[i].displayData();
        }
    }

    public Singer findSingerById(int id) {
        for (int i = 0; i < size; i++) {
            if (singers[i].getSingerId() == id) {
                return singers[i];
            }
        }
        return null;
    }

    public void updateSinger(int id, Singer updatedSinger) {
        for (int i = 0; i < size; i++) {
            if (singers[i].getSingerId() == id) {
                singers[i] = updatedSinger;
                break;
            }
        }
    }

    public void deleteSinger(int id) {
        for (int i = 0; i < size; i++) {
            if (singers[i].getSingerId() == id) {
                for (int j = i; j < size - 1; j++) {
                    singers[j] = singers[j + 1];
                }
                size--;
                break;
            }
        }
    }
}


