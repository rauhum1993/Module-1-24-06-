package java_collection_famework.thuc_hanh.cai_dat_cay_tim_kiem_nhi_phan;

public class MyBST<E extends Comparable<E>> {
    MyTreeNode<E> root;
    int size = 0;

    public void insert(E e) {
        if (this.root == null) {
            this.root = new MyTreeNode<>(e);
        } else {
            MyTreeNode rootTmp = this.root;
            MyTreeNode parent = null;

            while (rootTmp != null) {
                if (e.compareTo((E) rootTmp.e) < 0) {
                    parent = rootTmp;
                    rootTmp = rootTmp.left;
                } else if (e.compareTo((E) rootTmp.e) > 0) {
                    parent = rootTmp;
                    rootTmp = rootTmp.right;
                } else {
                    return;
                }

            }
            if (e.compareTo((E) parent.e) > 0) {
                parent.right = new MyTreeNode<>(e);
            } else {
                parent.left = new MyTreeNode<>(e);
            }


        }
        size++;
    }

    public void print(MyTreeNode root) {
        if (root != null) {
            System.out.println(root.e);
            print(root.right);
            print(root.left);
        }
    }

}
