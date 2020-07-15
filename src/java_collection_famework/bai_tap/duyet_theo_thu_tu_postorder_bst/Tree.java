package java_collection_famework.bai_tap.duyet_theo_thu_tu_postorder_bst;

public interface Tree<E> {
    boolean insert(E e);
    void postOrder();
    int getSize();
}