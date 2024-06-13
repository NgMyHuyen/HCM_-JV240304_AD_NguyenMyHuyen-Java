package ra.model;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Singer {
    private static int idCounter = 1;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    // Constructors
    public Singer() {
        this.singerId = idCounter++;
    }

    public Singer(String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = idCounter++;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    // Getters and Setters
    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Methods
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tên ca sĩ: ");
        this.singerName = scanner.nextLine();
        System.out.print("Tuổi ca sĩ: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Quê quán: ");
        this.nationality = scanner.nextLine();
        System.out.print("Giới tính (false cho nữ và true cho nam): ");
        this.gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Thể loại bài hát: ");
        this.genre = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("ID ca sĩ: " + this.singerId);
        System.out.println("Tên ca sĩ: " + this.singerName);
        System.out.println("Tuổi: " + this.age);
        System.out.println("Quê quán: " + this.nationality);
        System.out.println("Giới tính: " + (this.gender ? "Male" : "Female"));
        System.out.println("Thể loại bài hát: " + this.genre);
        System.out.println("______________");
    }
}

