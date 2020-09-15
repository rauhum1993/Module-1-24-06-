package java_collection_famework.thuc_hanh.cai_dat_cay_tim_kiem_nhi_phan;

public class PrintTest {
    public static void print100(int i) {
        System.out.println(i);

        if (i == 100)
            return;

        print100(++i);
    }

    public static void main(String[] args) {
        print100(1);
    }
}
