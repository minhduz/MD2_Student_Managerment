import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StudentClass> listStudentClass = new ArrayList<>();
        List<Student> listStudent = new ArrayList<>();

        do {
            System.out.println("**********************QUẢN LÝ HỌC VIỆN******************* ");
            System.out.println("1. Quản lý lớp ");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    boolean check = true;
                    do {
                        System.out.println("**********************QUẢN LÝ LỚP HỌC******************* ");
                        System.out.println("1. Thêm mới lớp học ");
                        System.out.println("2. Cập nhật thông tin lớp học");
                        System.out.println("3. Hiển thị thông tin lớp học");
                        System.out.println("4. Thống kê các lớp học đang hoạt động (ClassStatus = 1)");
                        System.out.println("5. Tìm kiếm lớp học theo tên lớp học");
                        System.out.println("6. Thoát");
                        System.out.print("Lựa chọn của bạn: ");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        switch (choice1){
                            case 1:
                                System.out.print("Nhập số lớp học muốn nhập: ");
                                int n = Integer.parseInt(scanner.nextLine());
                                for (int i = 0; i < n; i++) {
                                    System.out.println("Lớp thứ "+(i+1));
                                    StudentClass studentClass = new StudentClass();
                                    studentClass.inputData(scanner);
                                    listStudentClass.add(studentClass);
                                }
                                break;
                            case 2:
                                boolean check1 = true;
                                System.out.println("");
                                System.out.print("Nhập mã lớp muốn cập nhật: ");
                                String key = scanner.nextLine();
                                for (StudentClass studentClass : listStudentClass) {
                                    if(studentClass.getClassID().contains(key)) {
                                        check1 = true;
                                        System.out.print("Nhập lại tên lớp: ");
                                        String name = scanner.nextLine();
                                        if (!Objects.equals(name, "") && name.length() != 0) {
                                            studentClass.setClassName(name);
                                        }
                                        System.out.print("Nhập lại mô tả lớp: ");
                                        String des = scanner.nextLine();
                                        if (!Objects.equals(des, "") && des.length() != 0) {
                                            studentClass.setClassDescription(des);
                                        }
                                        System.out.print("Nhập lại trạng thái lớp: ");
                                        String status = scanner.nextLine();
                                        if (!Objects.equals(status, "") && status.length() != 0) {
                                            studentClass.setClassStatus(Integer.parseInt(status));
                                        }
                                        break;
                                    } else check1 = false;
                                }
                                if (check1) System.out.println("Đã cập nhật thông tin cho lớp có mã "+key);
                                    else  System.out.println("Không tìm thấy lớp có mã là "+key);
                                System.out.println("");
                                break;
                            case 3:
                                System.out.println("");
                                System.out.printf("%-10s%-12s%-30s%-12s\n","Mã lớp","Tên lớp","Mô tả lớp học","Trạng thái");
                                for (StudentClass studentClass : listStudentClass) {
                                    studentClass.displayData();
                                }
                                System.out.println("");
                                break;
                            case 4:
                                System.out.println("");
                                System.out.printf("%-10s%-12s%-30s%-12s\n","Mã lớp","Tên lớp","Mô tả lớp học","Trạng thái");
                                for (StudentClass studentClass : listStudentClass) {
                                    if(studentClass.getClassStatus() == 1){
                                        studentClass.displayData();
                                    }
                                }
                                System.out.println("");
                                break;
                            case 5:
                                boolean check2 = true;
                                System.out.println("");
                                System.out.println("Nhập tên lớp học muốn tìm: ");
                                String name = scanner.nextLine();
                                System.out.println("");

                                for (StudentClass studentClass : listStudentClass) {
                                    check2 = true;
                                    if(studentClass.getClassName().contains(name)){
                                        System.out.printf("%-10s%-12s%-30s%-12s\n","Mã lớp","Tên lớp","Mô tả lớp học","Trạng thái");
                                        studentClass.displayData();
                                        break;
                                    } else check2 = false;
                                }
                                if (!check2){
                                    System.out.println("không tìm thấy lớp có tên là");
                                }
                                System.out.println("");
                                break;
                            case 6:
                                check = false;
                            default:
                                System.out.println("Mời nhập lại (1-6): ");
                        }
                    } while (check);
                    break;
                case 2:
                    boolean check1 = true;
                    do {
                        System.out.println("**********************QUẢN LÝ SINH VIÊN******************* ");
                        System.out.println("1. Thêm mới sinh viên  ");
                        System.out.println("2. Cập nhật thông tin sinh viên ");
                        System.out.println("3. Hiển thị thông tin sinh viên");
                        System.out.println("4. Tính điểm trung bình");
                        System.out.println("5. Xếp loại sinh viên");
                        System.out.println("6. Sắp xếp sinh viên theo điểm trung bình tăng dần ");
                        System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
                        System.out.println("8. Thống kê số sinh viên đạt loại giỏi, khá, trung bình và yếu");
                        System.out.println("9. Thống kê các sinh viên Pass qua các môn học");
                        System.out.println("10.Thoát");
                        System.out.print("Lựa chọn của bạn: ");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        switch (choice1){
                            case 1:
                                System.out.print("Nhập số học sinh muốn nhập: ");
                                int n = Integer.parseInt(scanner.nextLine());
                                for (int i = 0; i < n; i++) {
                                    System.out.println("Học sinh thứ "+(i+1));
                                    Student student = new Student();
                                    student.inputData(scanner);
                                    System.out.println("Chọn lớp học cho sinh viên:");
                                    int index=1;
                                    for (StudentClass studentClass: listStudentClass) {
                                        System.out.printf("%d. %s\n",index,studentClass.getClassName());
                                        index++;
                                    }
                                    System.out.print("Lựa chọn của bạn: ");
                                    int choice2 = Integer.parseInt(scanner.nextLine());
                                    student.setStudentClass(listStudentClass.get(choice2-1));
                                    listStudent.add(student);
                                }
                                break;
                            case 2:
                                System.out.print("Nhập vào mã sinh viên cần cập nhật: ");
                                String Id = scanner.nextLine();

                                boolean check4 = true;
                                for (Student student: listStudent) {
                                    if(student.getStudentID().contains(Id)) {
                                        boolean check2 = true;
                                        //Câp nhật tên
                                        System.out.print("Nhập lại tên sinh viên: ");
                                        String name = scanner.nextLine().trim();
                                        if (!Objects.equals(name, "") && name.length() != 0) {
                                            do {
                                                if (name.trim().length() < 10 || name.trim().length() > 50) {
                                                    System.out.println("Tên học sinh phải từ 10 - 50 ký tự");
                                                    check2 = true;
                                                } else {
                                                    student.setStudentName(name);
                                                    check2 = false;
                                                }
                                            } while (check2);
                                        }
                                        //Cập nhật tuổi
                                        System.out.print("Nhập lại tuổi sinh viên: ");
                                        String age = scanner.nextLine().trim();
                                        if (!Objects.equals(age, "") && age.length() != 0) {
                                            do {
                                                if (Integer.parseInt(age) < 18) {
                                                    System.out.println("Tuổi học sinh phải lớn hơn hoặc bằng 18");
                                                    check2 = true;
                                                } else {
                                                    student.setStudentAge(Integer.parseInt(age));
                                                    check2 = false;
                                                }
                                            } while (check2) ;
                                        }
                                        //Cập nhật giới tính
                                        System.out.print("Nhập lại giới tính sinh viên: ");
                                        String gender = scanner.nextLine();
                                        if (!Objects.equals(gender, "") && gender.length() != 0) {
                                            student.setStudentSex(Boolean.parseBoolean(gender));
                                        }
                                        //Cập nhật lớp học
                                        System.out.println("Chọn lại lớp học cho sinh viên:");
                                        int index=1;
                                        for (StudentClass studentClass: listStudentClass) {
                                            System.out.printf("%d. %s\n",index,studentClass.getClassName());
                                            index++;
                                        }
                                        System.out.print("Lựa chọn của bạn: ");
                                        String choice2 = scanner.nextLine();
                                        if(!Objects.equals(choice2, "") && choice2.length() != 0){
                                            student.setStudentClass(listStudentClass.get(Integer.parseInt(choice2)-1));
                                        }

                                        //Cập nhật điểm của sinh viên
                                        updateStudentMark(student.getListMarkJavascript(),student,scanner,"Javascript");
                                        updateStudentMark(student.getListMarkJavaCore(),student,scanner,"JavaCore");
                                        updateStudentMark(student.getListMarkJavaWeb(),student,scanner,"JavaWeb");

                                        student.calAvgMark();
                                        student.getStudentGPA();

                                        System.out.print("Nhập lại trạng thái sinh viên: ");
                                        String status = scanner.nextLine();
                                        if(!Objects.equals(status, "") && status.length() != 0){
                                            student.setStudentStatus(Boolean.parseBoolean(status));
                                        }
                                        break;
                                    } else check4 = false;
                                }
                                if(!check4){
                                    System.out.println("Không tồn tại sinh viên có mà là "+Id);
                                }
                                break;
                            case 3:
                                System.out.printf("│%-10s│%-30s│%-5s│%-8s│%-12s│%-24s│%-24s│%-24s│%-8s│%-12s│%-8s│\n","ID","Name","Age","Sex","Class","Javascript","JavaCore","JavaWeb","Avg","GPA","Status");
                                for (Student student: listStudent) {
                                    student.displayData();
                                }
                                System.out.println("");
                                break;
                            case 4:
                                for (Student student: listStudent) {
                                    student.calAvgMark();
                                }
                                break;
                            case 5:
                                for (Student student: listStudent) {
                                    student.getStudentGPA();
                                }
                                break;
                            case 6:
                                listStudent.sort(new Comparator<Student>() {
                                    @Override
                                    public int compare(Student o1, Student o2) {
                                        return Float.compare(o1.getAvgMark(), o2.getAvgMark());
                                    }
                                });
                                break;
                            case 7:
                                boolean ck = true;
                                System.out.print("Nhập tên học sinh muốn tìm: ");
                                String name = scanner.nextLine();
                                for (Student student: listStudent) {
                                    if(student.getStudentName().contains(name)){
                                        ck = true;
                                        student.displayData();
                                    } else ck = false;
                                }
                                if(!ck){
                                    System.out.println("Không có sinh viên có tên là "+name);
                                }
                                break;
                            case 8:
                                int cntExellent = 0, cntGood = 0, cntAvegage = 0, cntWeek = 0;
                                for (Student student : listStudent) {
                                    if (student.getAvgMark() < 5) {
                                        cntWeek++;
                                    } else if (student.getAvgMark() < 7) {
                                        cntAvegage++;
                                    } else if (student.getAvgMark() < 9) {
                                        cntGood++;
                                    } else {
                                        cntExellent++;
                                    }
                                }
                                System.out.printf("So sinh vien gioi: %d - Kha: %d - Trung binh: %d - Yeu: %d\n", cntExellent, cntGood, cntAvegage, cntWeek);
                                break;
                            case 9:
                                int cntPass = 0;
                                for (Student student : listStudent) {
                                    int jsSize = student.getListMarkJavascript().size();
                                    int jvSize = student.getListMarkJavaCore().size();
                                    int jwSize = student.getListMarkJavaWeb().size();
                                    if(student.getAvgMark() >= 5
                                            && student.getListMarkJavascript().get(jsSize-1)>=5
                                            && student.getListMarkJavaCore().get(jvSize-1)>=5
                                            && student.getListMarkJavaWeb().get(jwSize-1)>=5){
                                        cntPass++;
                                    }
                                }
                                System.out.println("Số sinh viên Pass là: "+cntPass);
                                break;
                            case 10:
                                check1 = false;
                                break;
                            default:
                                System.out.println("Mời nhập lại (1-10): ");
                        }
                    }while (check1);
                    break;
                case 3:
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Mời nhập lại (1-4): ");
            }

        }while (true);

    }

    public static void updateStudentMark(List<Float> listMark, Student student,Scanner scanner,String subject){
        System.out.printf("Cập nhật điểm cho môn %s :\n",subject);
        System.out.println("1. Cập nhật lại toàn bộ điểm ");
        System.out.println("2. Cập nhật thêm điểm ");
        System.out.println("3. Cập nhật từng điểm ");
        System.out.println("4. Thoát");
        System.out.print("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                List<Float> listMarkUpdate = new ArrayList<>();
                Student.inputStudentMark(listMarkUpdate,scanner);
                switch (subject){
                    case "Javascript":
                        student.setListMarkJavascript(listMarkUpdate);
                        break;
                    case "JavaCore":
                        student.setListMarkJavaCore(listMarkUpdate);
                        break;
                    case "JavaWeb":
                        student.setListMarkJavaWeb(listMarkUpdate);
                        break;
                }
                break;
            case 2:
                switch (subject){
                    case "Javascript":
                        Student.inputStudentMark(student.getListMarkJavascript(),scanner);
                        break;
                    case "JavaCore":
                        Student.inputStudentMark(student.getListMarkJavaCore(),scanner);
                        break;
                    case "JavaWeb":
                        Student.inputStudentMark(student.getListMarkJavaWeb(),scanner);
                        break;
                }
                break;
            case 3:
                int examTimes;
                float mark;
                boolean check;
                do {
                    System.out.print("Nhập vào lần thi muốn cập nhật: ");
                    examTimes = Integer.parseInt(scanner.nextLine());
                    if(examTimes > listMark.size()){
                        check = true;
                        System.out.println("Sinh viên chưa thi lần thi thứ "+examTimes);
                    } else check = false;
                } while (check);
                System.out.print("Nhập vào điểm thi cập nhật: ");
                mark = Float.parseFloat(scanner.nextLine());
                switch (subject){
                    case "Javascript":
                        student.getListMarkJavascript().set(examTimes-1,mark);
                        break;
                    case "JavaCore":
                        student.getListMarkJavaCore().set(examTimes-1,mark);
                        break;
                    case "JavaWeb":
                        student.getListMarkJavaWeb().set(examTimes-1,mark);
                        break;
                }
                break;
        }
    }
}

