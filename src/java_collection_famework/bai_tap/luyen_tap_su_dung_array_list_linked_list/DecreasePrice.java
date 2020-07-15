package java_collection_famework.bai_tap.luyen_tap_su_dung_array_list_linked_list;

import java.util.Comparator;

public class DecreasePrice implements Comparator<Product> {
    @Override
    public int compare(Product s1, Product s2) {
        return (int) (s2.getPrice()-s1.getPrice());
    }
}
