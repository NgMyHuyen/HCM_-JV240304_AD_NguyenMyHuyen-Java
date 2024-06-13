package ra.controller;

import ra.model.Singer;
import ra.service.SingerService;

import java.util.Scanner;

public class SingerController {
    private SingerService singerService = new SingerService();
    private Scanner scanner = new Scanner(System.in);

    public void manageSingers() {
        while (true) {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Thêm tên ca sĩ mới");
            System.out.println("2. Hiện danh sách tất cả ca sĩ đã có");
            System.out.println("3. Chỉnh sửa thông tin ca sĩ bằng ID");
            System.out.println("4. Xóa thông tin ca sĩ bằng ID");
            System.out.println("5. Exit");
            System.out.print("Hãy chọn 1 số trong menu: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng ca sĩ muốn thêm: ");
                    int count = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < count; i++) {
                        Singer singer = new Singer();
                        singer.inputData();
                        singerService.addSinger(singer);
                    }
                    break;
                case 2:
                    singerService.displayAllSingers();
                    break;
                case 3:
                    System.out.print("Nhập ID của ca sĩ muốn tìm: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Singer singerToUpdate = singerService.findSingerById(id);
                    if (singerToUpdate != null) {
                        singerToUpdate.inputData();
                        singerService.updateSinger(id, singerToUpdate);
                    } else {
                        System.out.println("Không có ca sĩ này.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID ca sĩ bạn muốn xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    singerService.deleteSinger(deleteId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

