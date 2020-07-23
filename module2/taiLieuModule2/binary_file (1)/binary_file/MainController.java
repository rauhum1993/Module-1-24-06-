package binary_file;

public class MainController {

    public static void main(String[] args) {
        StudentManage studentManage = new StudentManage();

        // doc file tu student.txt va luu ket qua doc vao List
        studentManage.setStudentList(FileUtils.readFile());

        // hien thi danh sach sau khi doc
        System.out.println("-------------List after read----------------");
        studentManage.showStudentList();

        // Them 3 phan tu vao danh sach
//        studentManage.addNewStudent(new Student("Hai",20));
//        studentManage.addNewStudent(new Student("Hien",20));
//        studentManage.addNewStudent(new Student("Dat",20));

        // hien thi danh sach sau khi them
//        System.out.println("-------------List sau khi add----------------");
//        studentManage.showStudentList();


        System.out.println("-------------update----------------");
        // Cap nhat "Hien" thanh "Chuong, 28 tuoi"
        String name = "Hien";
        Student studentTemp = new Student("Chuong", 28);
        boolean isUpdate = studentManage.updateStudent(name, studentTemp);
        if (isUpdate) {
            System.out.println("update successful..");
        } else {
            System.out.println("Update fail. Name: " + name + " is not exist.");
        }

        System.out.println("-------------List after update----------------");
        studentManage.showStudentList();

        // Ghi list sau chinh sua xuong file
        FileUtils.writeFile(studentManage.getStudentList());

    }
}
