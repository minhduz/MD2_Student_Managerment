package ra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studentID;
    private String studentName;
    private int studentAge;
    private boolean studentSex;
    private StudentClass studentClass;
    private List<Float> listMarkJavascript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new ArrayList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String GPA;
    private Boolean studentStatus;

    public Student() {
    }

    public Student(String studentID,
                   String studentName,
                   int studentAge,
                   boolean studentSex,
                   StudentClass studentClass,
                   List<Float> listMarkJavascript,
                   List<Float> listMarkJavaCore,
                   List<Float> listMarkJavaWeb,
                   float avgMark,
                   String GPA,
                   Boolean studentStatus) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentSex = studentSex;
        this.studentClass = studentClass;
        this.listMarkJavascript = listMarkJavascript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.GPA = GPA;
        this.studentStatus = studentStatus;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public boolean isStudentSex() {
        return studentSex;
    }

    public void setStudentSex(boolean studentSex) {
        this.studentSex = studentSex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<Float> getListMarkJavascript() {
        return listMarkJavascript;
    }

    public void setListMarkJavascript(List<Float> listMarkJavascript) {
        this.listMarkJavascript = listMarkJavascript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public Boolean getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        Boolean check;

        do {
            System.out.print("Nh???p m?? sinh vi??n: ");
            this.studentID = scanner.nextLine().trim();
            if (this.studentID.trim().length() != 6){
                System.out.println("M???i nh???p l???i (y??u c???u 6 k?? t???)");
                check = true;
            } else if(this.studentID.trim().charAt(0) != 'S'){
                System.out.println("M???i nh???p l???i (ph???i c?? k?? t??? S ??? ?????u)");
                check = true;
            }
            else check = false;
        } while (check);

        do {
            System.out.print("Nh???p t??n sinh vi??n: ");
            this.studentName = scanner.nextLine().trim();
            if(this.studentName.trim().length() < 10 || this.studentName.trim().length() > 50){
                System.out.println("T??n h???c sinh ph???i t??? 10 - 50 k?? t???");
                check = true;
            } else check = false;
        } while (check);

        do {
            try {
                System.out.print("Nh???p tu???i sinh vi??n: ");
                this.studentAge = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e){
                System.out.println("L???i! M???i nh???p l???i");
            }
            if(this.studentAge < 18){
                System.out.println("Tu???i h???c sinh ph???i l???n h??n ho???c b???ng 18");
                check = true;
            } else check = false;
        } while (check);

        System.out.print("Nh???p gi???i t??nh sinh vi??n (Nam = true, N??? = false): ");
        this.studentSex = Boolean.parseBoolean(scanner.nextLine().trim());
        System.out.println("Nh???p c??c ??i???m thi Javacript: ");
        inputStudentMark(this.listMarkJavascript,scanner);
        System.out.println("Nh???p c??c ??i???m thi JavaCore: ");
        inputStudentMark(this.listMarkJavaCore,scanner);
        System.out.println("Nh???p c??c ??i???m thi JavaWeb: ");
        inputStudentMark(this.listMarkJavaWeb,scanner);
        System.out.print("Nh???p tr???ng th??i sinh vi??n: ");
        this.studentStatus = Boolean.parseBoolean(scanner.nextLine().trim());

    }

    public void calAvgMark() {
        this.avgMark = (listMarkJavascript.get(listMarkJavascript.size() - 1) +
                listMarkJavaCore.get(listMarkJavaCore.size() - 1) +
                listMarkJavaWeb.get(listMarkJavaWeb.size() - 1)) / 3;
    }

    @Override
    public void displayData() {
        System.out.printf("???%-10s???%-30s???%-5d???%-8b???%-12s???%-24s???%-24s???%-24s???%-8.2f???%-12s???%-8s???\n",this.studentID,this.studentName,this.studentAge,this.studentSex,
        this.studentClass.getClassName(),
                displayStudentMark(this.listMarkJavascript),
                displayStudentMark(this.listMarkJavaCore),
                displayStudentMark(this.listMarkJavaWeb),
                this.avgMark,this.GPA,this.studentStatus);
    }

    public static void inputStudentMark(List<Float> listMark ,Scanner scanner){
        int count = listMark.size()+1;
        do {
            System.out.printf("Nh???p ??i???m thi l???n %d: ",count);
            float mark = Float.parseFloat(scanner.nextLine());
            listMark.add(mark);
            count++;
            System.out.printf("B???n c?? mu???n nh???p ??i???m l???n %d kh??ng\n",count);
            System.out.println("1. C??");
            System.out.println("2. Kh??ng");
            System.out.print("L???a ch???n c???a b???n: ");
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if(choice != 1 ){
                break;
            }
        }while (true);
    }

    public String displayStudentMark(List<Float> listMark){
        String displayMarks = "";
        for (Float marks: listMark) {
            displayMarks += marks+", ";
        }
        return displayMarks;
    }

    public void getStudentGPA(){
        if (getAvgMark()>0&&getAvgMark()<5) this.GPA = "Y???u";
        else if(getAvgMark()>=5&&getAvgMark()<7) this.GPA = "Trung b??nh";
        else if(getAvgMark()>=7&&getAvgMark()<9) this.GPA = "Kh??";
        else if(getAvgMark()>=9&&getAvgMark()<=10) this.GPA = "Gi???i";

    }
}
