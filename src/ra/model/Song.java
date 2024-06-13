
package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId; 
    private String songName; 
    private String descriptions; 
    private Singer singer; 
    private String songWriter; 
    private Date createdDate; 
    private boolean songStatus; 

    
    private static String[] existingSongIds = new String[100];
    private static int existingSongCount = 0;

    public Song() {
        this.createdDate = new Date();
    }

    // get,set
    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

       
        boolean validId = false;
        do {
            System.out.print("Xác nhận lại ID bài hát: ");
            this.songId = scanner.nextLine();
            if (this.songId.length() >= 4 && this.songId.charAt(0) == 'S') {
                boolean duplicate = false;
                for (int i = 0; i < existingSongCount; i++) {
                    if (existingSongIds[i].equals(this.songId)) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    System.out.println("ID đã tồn tại. Vui lòng nhập lại.");
                } else {
                    existingSongIds[existingSongCount++] = this.songId;
                    validId = true;
                }
            } else {
                System.out.println("ID không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!validId);

       
        do {
            System.out.print("Nhập tên bài hát: ");
            this.songName = scanner.nextLine();
            if (this.songName.isEmpty()) {
                System.out.println("Tên bài hát không được để trống. Vui lòng nhập lại.");
            }
        } while (this.songName.isEmpty());

        // Validate descriptions (first letter must be capitalized)
        do {
            System.out.print("Mô tả bài hát: ");
            this.descriptions = scanner.nextLine();
            if (this.descriptions.isEmpty() || !Character.isUpperCase(this.descriptions.charAt(0))) {
                System.out.println("Mô tả bài hát không được để trống và phải bắt đầu bằng chữ cái in hoa. Vui lòng nhập lại.");
            }
        } while (this.descriptions.isEmpty() || !Character.isUpperCase(this.descriptions.charAt(0)));

       
        do {
            System.out.print("Nhà soạn nhạc: ");
            this.songWriter = scanner.nextLine();
            if (this.songWriter.isEmpty()) {
                System.out.println("Nhà soạn nhạc không được để trống. Vui lòng nhập lại.");
            }
        } while (this.songWriter.isEmpty());

       
        do {
            System.out.print("Nhập thong tin ca sĩ: ");
            if (this.singer == null || this.singer.getSingerName().isEmpty()) {
                System.out.println("_____");
                // For now, we'll just create a new Singer if it's null for simplicity
                this.singer = new Singer();
                this.singer.inputData();
            }
        } while (this.singer == null || this.singer.getSingerName().isEmpty());

       
        this.createdDate = new Date();

       
        System.out.print("Trạng thái bài hát (true for active, false for inactive): ");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("_________________");
    }

    public void displayData() {
        System.out.println("Song ID: " + this.songId);
        System.out.println("Song Name: " + this.songName);
        System.out.println("Descriptions: " + this.descriptions);
        System.out.println("Singer: " + (this.singer != null ? this.singer.getSingerName() : "No singer assigned"));
        System.out.println("Song Writer: " + this.songWriter);
        System.out.println("Created Date: " + this.createdDate);
        System.out.println("Song Status: " + (this.songStatus ? "Active" : "Inactive"));
        System.out.println("_________________");

    }

    // Remaining getters, setters, and other methods
}
