package ra.controller;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Scanner;

public class SongController {
    private SongService songService = new SongService();
    private SingerService singerService = new SingerService();
    private Scanner scanner = new Scanner(System.in);

    public void manageSongs() {
        while (true) {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Thêm bài hát mới");
            System.out.println("2. Hiện tất cả bài hát đang có");
            System.out.println("3. Chỉnh sửa thông tin bằng ID bài hát");
            System.out.println("4. Xóa thông tin bằng ID bài hát");
            System.out.println("5. Exit");
            System.out.print("Chọn chức năng bạn muốn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Số lượng bài hát bạn muốn thêm mới: ");
                    int count = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < count; i++) {
                        Song song = new Song();
                        while (true) {
                            System.out.print("Nhập ID bài hát (từ 4 kí tự trở lên và bắt đầu bằng chữ 'S' in hoa): ");
                            String songId = scanner.nextLine();
                            if (songId.length() >= 4 && Character.isUpperCase(songId.charAt(0))) {
                                song.setSongId(songId);
                                break;
                            } else {
                                System.out.println("ID không hợp lệ. Vui lòng nhập lại.");
                            }
                        }
                        song.inputData();
                        songService.addSong(song);
                    }
                    break;
                case 2:
                    songService.displayAllSongs();
                    break;
                case 3:
                    System.out.print("Nhập ID bài hát muốn update: ");
                    String id = scanner.nextLine();
                    Song songToUpdate = songService.findSongById(id);
                    if (songToUpdate != null) {
                        songToUpdate.inputData();
                        songService.updateSong(id, songToUpdate);
                    } else {
                        System.out.println("Đang trong quá trình sửa chữa, vui lòng quay lại sau.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID bài hát để xóa: ");
                    String deleteId = scanner.nextLine();
                    songService.deleteSong(deleteId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Vui lòng thử lại.");
            }
        }
    }
}