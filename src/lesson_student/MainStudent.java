package lesson_student;

import lesson_last_case_study.yeu_cau_7.commons.ReadWriteFile;
import lesson_last_case_study.yeu_cau_7.models.Room;
import lesson_last_case_study.yeu_cau_7.models.Villa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainStudent {
    public static final String FILE_STUDENT = "src/lesson_student/student.csv";
    public static final String REGEX_NAME = "^(([A-Z][a-z]*((\\s)))+[A-Z][a-z]*)|([A-Z]([a-z]*))$";
    public static List<Stundent> stundentList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choose;

        do {
            System.out.println("-------------Menu------------" + "\n" +
                    "1. Add Student." + "\n" +
                    "2. Show Info Student." + "\n" +
                    "3. Edit student information " + "\n" +
                    "4. Delete student information " + "\n");

            System.out.println("");
            System.out.print("Please select an item : ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addStundent();
                    break;
                case 2:
                    System.out.println(" ------------Student list sorted by name-----------");
                    showInFoStudent();
                    break;
                case 3:
                    showInFoStudent();
                    editInfo();
                    break;
                case 4:
                    showInFoStudent();
                    deleteInfo();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter wrong. Entype: ");
            }

        } while (choose != 0);
    }

    private static void deleteInfo() {
        Scanner scanner= new Scanner(System.in);

        stundentList.clear();
        ReadWriteFileStudent.readerFile(FILE_STUDENT);
        Stundent student = null;
        boolean check;
        System.out.println("Enter the student ID you want to delete: ");
        int id= Integer.parseInt(scanner.nextLine());
        for (int i=0;i<stundentList.size();i++){
            if(id==stundentList.get(i).getId()){
                stundentList.remove(stundentList.get(i));
                check=true;
                break;
            } else check=false;
            if (check=false){
                System.out.println("Enter wrong: ");
            }
        }
        ReadWriteFileStudent.saveFile("",FILE_STUDENT);
        for(int i=0;i<stundentList.size();i++){
            ReadWriteFileStudent.writerFile(stundentList.get(i).getId()+",",FILE_STUDENT);
            ReadWriteFileStudent.writerFile(stundentList.get(i).getName()+",",FILE_STUDENT);
            ReadWriteFileStudent.writerFile(stundentList.get(i).getAge()+",",FILE_STUDENT);
            ReadWriteFileStudent.writerFile(stundentList.get(i).getNameClass()+"\n",FILE_STUDENT);
        }

    }

    private static void showInFoStudent() throws IOException {
        stundentList.clear();
        ReadWriteFileStudent.readerFile(FILE_STUDENT);
        Stundent student = null;
        stundentList.sort(new Sort());
        for (int i = 0; i < stundentList.size(); i++) {
            student = stundentList.get(i);
            System.out.println(student.toString());
        }
    }

    private static void editInfo() {
        Scanner scanner= new Scanner(System.in);


        stundentList.clear();
        ReadWriteFileStudent.readerFile(FILE_STUDENT);
        Stundent student = null;
        boolean check;
        System.out.println("Enter the student ID you want to edit: ");
        int id= Integer.parseInt(scanner.nextLine());
        for(int i=0;i<stundentList.size();i++){
            if (id==stundentList.get(i).getId()){
                System.out.println(stundentList.get(i).toString());
                System.out.println("Begin edit");
                System.out.println("Enter  name: ");
                String newName= scanner.nextLine();
                System.out.println("Enter  age: ");
                int newAge= Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name Class: ");
                String nameClass=scanner.nextLine();
                stundentList.get(i).setName(newName);
                stundentList.get(i).setAge(newAge);
                stundentList.get(i).setNameClass(nameClass);
                check=true;

            } else {
                check=false;

            }


        }
        if (check=true){
            System.out.println("successfully changed");
            ReadWriteFileStudent.saveFile("",FILE_STUDENT);
            for(int i=0;i<stundentList.size();i++){
                ReadWriteFileStudent.writerFile(stundentList.get(i).getId()+",",FILE_STUDENT);
                ReadWriteFileStudent.writerFile(stundentList.get(i).getName()+",",FILE_STUDENT);
                ReadWriteFileStudent.writerFile(stundentList.get(i).getAge()+",",FILE_STUDENT);
                ReadWriteFileStudent.writerFile(stundentList.get(i).getNameClass()+"\n",FILE_STUDENT);
            }
        }else {
            System.out.println();
        }

    }


    private static void addStundent()  {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
       int id = 0;
        do {
            try {
                System.out.println("1. Enter id ");
                id = Integer.parseInt(scanner.nextLine());
                if (id > 0) {

                    System.out.println("Enter successful id");
                    check = true;
                } else {
                    System.out.println("Enter the wrong the id format");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);

        String name;
        do {
            System.out.println("2. Enter Name :");
            name = scanner.nextLine();
            Pattern p = Pattern.compile(REGEX_NAME);
            Matcher m = p.matcher(name);
            if (m.find() == false) {
                System.out.println("Enter the wrong ID format ");
                check = false;
            } else {
                System.out.println(" Enter successful ID");
                check = true;
            }
        } while (!check);

        int age = 0;
        do {
            try {
                System.out.println("3. Enter age (bigger than 18 age) ");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 18) {

                    System.out.println("Enter successful age");
                    check = true;
                } else {
                    System.out.println("Enter the wrong age format");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Enter is not a number ");
                check = false;
            }
        } while (!check);

        System.out.println("4.Enter name class  of Student: ");
        String nameClass = scanner.nextLine();

        stundentList.add(new Stundent(id,name, age, nameClass));
        for (int i = stundentList.size() - 1; i < stundentList.size(); i++) {
            ReadWriteFileStudent.writerFile(stundentList.get(i).getId()+",",FILE_STUDENT);
            ReadWriteFileStudent.writerFile(stundentList.get(i).getName() + ",", FILE_STUDENT);
            ReadWriteFileStudent.writerFile(stundentList.get(i).getAge() + ",", FILE_STUDENT);
            ReadWriteFileStudent.writerFile(stundentList.get(i).getNameClass() + "\n", FILE_STUDENT);
            stundentList.clear();


        }

    }
}
