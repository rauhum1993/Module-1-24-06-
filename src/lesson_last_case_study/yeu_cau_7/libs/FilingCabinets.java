package lesson_last_case_study.yeu_cau_7.libs;

import lesson_last_case_study.yeu_cau_7.commons.ReadWriteFile;
import lesson_last_case_study.yeu_cau_7.controllers.MainController;
import lesson_last_case_study.yeu_cau_7.models.Employee;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public  class FilingCabinets {
    Scanner scanner=new Scanner(System.in);
    public static Stack<Employee> employeeStack= new Stack<>();
    public static void findEmployeeRecords(){
        Scanner scanner=new Scanner(System.in);
        ReadWriteFile.readerFile(MainController.FILE_EMPLOYEE);
        for (Map.Entry<String, Employee> employeeEntry : MainController.employeeMap.entrySet()) {
            employeeStack.push(employeeEntry.getValue());
            System.out.println(employeeEntry.getKey() + ". " + employeeEntry.getValue().toString());
        }
            System.out.println("input name employee");
            String name=scanner.nextLine();
            String name1=name.toLowerCase();
            while ( !employeeStack.isEmpty() ){
                if(name1.equals(employeeStack.peek().getNameEmployee())){
                    System.out.println((employeeStack.peek()).toString());
                    System.out.println("------------");
                    break;
                }else {
                    employeeStack.pop();
                }
            }
        }

}
