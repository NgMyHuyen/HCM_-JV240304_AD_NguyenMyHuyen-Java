package ra.run;

import ra.controller.SingerController;
import ra.controller.SongController;

import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingerController singerController = new SingerController();
        SongController songController = new SongController();

        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lí ca sĩ");
            System.out.println("2. Quản lí bài hát");
            System.out.println("3. Tìm kiếm bài hát/ca sĩ");
            System.out.println("4. Thoát");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    singerController.manageSingers();
                    break;
                case 2:
                    songController.manageSongs();
                    break;
                case 3:
                    // Implement search functionality
                    System.out.println("Đang trong quá trình sửa chữa, vui lòng trở lại sau.");
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời thử lại.");
            }
        }
    }
}
