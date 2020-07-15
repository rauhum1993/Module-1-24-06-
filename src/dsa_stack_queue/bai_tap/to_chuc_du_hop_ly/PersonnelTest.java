package dsa_stack_queue.bai_tap.to_chuc_du_hop_ly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PersonnelTest {
    public static void main(String[] args) {
        Personnel personnel_1=new Personnel("khanh","male","1993");
        Personnel personnel_2=new Personnel("hai","male","2001");
        Personnel personnel_3=new Personnel("tung","male","1999");
        Personnel personnel_4=new Personnel("mai","female","1994");
        Personnel personnel_5=new Personnel("ha","female","1995");
        Personnel personnel_6=new Personnel("hien","female","1995");
        Personnel personnel_7=new Personnel("thu","female","1996");

        List<Personnel> personnel_Manage= new ArrayList<>();
        personnel_Manage.add(personnel_1);
        personnel_Manage.add(personnel_2);
        personnel_Manage.add(personnel_3);
        personnel_Manage.add(personnel_4);
        personnel_Manage.add(personnel_5);
        personnel_Manage.add(personnel_6);
        personnel_Manage.add(personnel_7);

        System.out.println("Before-sort--------------------------------");
        for(int i=0;i<personnel_Manage.size();i++){
            System.out.println(personnel_Manage.get(i)+"\t");
        }

        Queue<Personnel> female = new LinkedList<>();
        Queue<Personnel> male = new LinkedList<>();

        for (int i=0;i<personnel_Manage.size();i++){
            if(female.equals(personnel_Manage.get(i).getSex())){
                female.add(personnel_Manage.get(i));
            } else {
                male.add(personnel_Manage.get(i));
            }
        }
        int count = 0;
        while (!female.isEmpty()) {
            personnel_Manage.set(count, female.poll());
            count++;
        }
        while ((!male.isEmpty())) {
            personnel_Manage.set(count, male.poll());
            count++;
        }
        System.out.println("Sort by sex -----------------------------------------------");
        for (int i = 0; i < personnel_Manage.size(); i++) {
            System.out.println(personnel_Manage.get(i));
        }

    }
}
