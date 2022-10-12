package ra.entity;

import java.util.Scanner;


public class StudentClass implements IStudentManagement {

    private String classID;
    private String className;
    private String classDescription;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classID, String className, String classDescription, int classStatus) {
        this.classID = classID;
        this.className = className;
        this.classDescription = classDescription;
        this.classStatus = classStatus;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        Boolean check;
        do {
            System.out.print("Nhập mã lớp: ");
            this.classID = scanner.nextLine().trim();
            if (this.classID.length() != 5){
                System.out.println("Mời nhập lại (yêu cầu 5 ký tự)");
                check = true;
            } else if(this.classID.codePointAt(0) != 74){
                System.out.println("Mời nhập lại (phải có ký tự J ở đầu)");
                check = true;
            }
            else check = false;
        } while (check);

        do {
            System.out.print("Nhập tên lớp: ");
            this.className = scanner.nextLine().trim();
            if(this.className.length() > 10){
                System.out.println("Tên lớp quá dài (tối đa 10 ký tự)");
                check = true;
            } else check = false;
        } while (check);

        System.out.print("Mô tả lớp học: ");
        this.classDescription = scanner.nextLine().trim();
        System.out.print("Nhập trạng thái lớp: ");
        this.classStatus = Integer.parseInt(scanner.nextLine().trim());
    }

    @Override
    public void displayData() {
        System.out.printf("%-10s%-12s%-30s%-12s\n",this.classID,this.className,this.classDescription,this.classStatus);
    }

}
