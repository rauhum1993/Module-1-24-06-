package java_collection_famework.thuc_hanh.cai_dat_cay_tim_kiem_nhi_phan;

public class MyBstTest {
    public static void main(String[] args) {
        MyBST  myBstTest=new MyBST();

        myBstTest.insert(45);
        myBstTest.insert(55);
        myBstTest.insert(60);
        myBstTest.insert(59);
        myBstTest.insert(57);
        myBstTest.insert(101);
        myBstTest.insert(100);
        myBstTest.insert(67);
        myBstTest.insert(60);
        myBstTest.insert(107);
        myBstTest.print(myBstTest.root);
        System.out.println("------------------------------");
        System.out.println("size "+ myBstTest.size);


    }
}
