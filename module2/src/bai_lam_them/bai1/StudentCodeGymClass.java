package bai_lam_them.bai1;
import java.util.Scanner;
class StudentCodeGymClass {
    private static StudentCodegym[] listStudent;
    private static int count = 0;
    static {
        listStudent = new StudentCodegym[20];
    }
    public int getSize() {
        return count;
    }
    public int getIdStudent(int n) {
        return listStudent[n].getId();
    }
    public String getNameStudent(int n) {
        return listStudent[n].getName();
    }
    public String getDateOfBirthStudent(int n) {
        return listStudent[n].getDateOfBirth();
    }
    // them hoc vien
    public void register(StudentCodegym student) {
        if (count >= 20) {
            System.out.println("Lop da du hoc vien!!! Thang sau quay lai ban nhe");
        } else {
            System.out.println("Chao don " + student.getName() + " gia nhap CdeGym !!!");
            listStudent[count] = student;
            count++;
        }
    }
    //Xoa hoc vien tot nghiep
    public void graduate(int id) {
        for (int i = 0; i < listStudent.length - 1; i++) {
            if (listStudent[i].getId() == id) {
                System.out.println("Chuc mung " + listStudent[i].getName() + " Ban da tot nghiep!!!");
                int j = i;
                while (j < listStudent.length - 1) {
                    listStudent[j] = listStudent[j + 1];
                    j++;
                }
                break;
            }
        }
        listStudent[listStudent.length - 1] = null;
        count--;
    }
    //Hien thi danh sach hoc vien
    public void displayListStudent() {
        System.out.printf("%-5s%-10s%-15s%s", "", "Id", "Name", "Date of Birth");
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.printf("%-5s%-10s%-15s%s", i+1, listStudent[i].getId(), listStudent[i].getName(), listStudent[i].getDateOfBirth());
            System.out.println();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentCodegym student1 = new StudentCodegym(1,"nguyen thi tung","20/11/1995");
        StudentCodegym student2 = new StudentCodegym(2, "bui thi dat", "20/10/1990");
        StudentCodegym student3 = new StudentCodegym(3, "mai thi hai", "10/03/2001");
        StudentCodegym student4 = new StudentCodegym(4, "tran thi hien", "03/04/1996");
        StudentCodeGymClass listStudent = new StudentCodeGymClass();
        listStudent.register(student1);
        listStudent.register(student2);
        listStudent.register(student3);
        listStudent.register(student4);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Them hoc vien");
            System.out.println("2. Xoa hoc vien da tot nghiep");
            System.out.println("3. Hien thi danh sach hoc vien");
            System.out.println("0. Thoát");
            System.out.println("Nhap su lua chon cua ban: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int addId;
                    System.out.print("Nhap vao id cua hoc vien: ");
                    addId = scanner.nextInt();
                    System.out.print("Nhap vao ten hoc vien: ");
                    String addName  = scanner.nextLine();
                    addName = scanner.nextLine();
                    System.out.print("Nhap vao ngay sinh cua  hoc vien: ");
                    String addDate = scanner.nextLine();
                    StudentCodegym student = new StudentCodegym(addId,addName,addDate);
                    listStudent.register(student);
                    break;
                case 2:
                    System.out.println("Nhap id hoc vien bạn muon xoa: ");
                    int deleteId = scanner.nextInt();
                    int confirm;
                    int index = 0;
                    System.out.println("Ban thuc su muon xoa hoc vien nay!!!");
                    System.out.println(listStudent.getIdStudent(index) + " " + listStudent.getNameStudent(index) + " " + listStudent.getDateOfBirthStudent(index));
                    System.out.print("1.Yes or 2.No: ");
                    confirm = scanner.nextInt();
                    if (confirm == 1) {
                        listStudent.graduate(deleteId);
                        break;
                    } else {
                        System.out.println("Ban khong muon xoa hoc vien");
                    }
                    break;
                case 3:
                    listStudent.displayListStudent();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lua chon cua ban khong ton tai!");
            }
        }
    }
}
