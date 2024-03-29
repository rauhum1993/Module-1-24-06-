package dsa_danh_sach.bai_tap.trien_khai_lop_listed_list_don_gian;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int default_capacity = 10;
    public Object elements[];

    public MyList() {

        elements = new Object[default_capacity];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity:" + capacity);
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public boolean add(E element) {
        if(elements.length==size){
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newsize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newsize);
        } else {
            throw new IllegalArgumentException("minCapacity:" + minCapacity);
        }


    }

    public void add(int index, E element){
        if(index>elements.length){
            throw new IllegalArgumentException("index: "+index);
        } else if(elements.length==size){
            this.ensureCapacity(5);
        }
        if (elements[index]==null){
            elements[index]=element;
            size++;
        } else {
            for (int i=size+1; i>= index; i--){
                elements[i]=elements[i-1];
            }
            elements[index]=element;
            size++;
        }

    }
    public E get(int index){
        return (E) elements[index];
    }

    public int indexof( E element){
        int index= -1;
        for(int i=0;i< size; i++){
            if (this.elements[i].equals(element)){
                return i;
            }
        }
        return index;
    }

    public boolean contains (E elememt){
        return this.indexof(elememt)>=0;
    }

    public  MyList<E> clone(){
        MyList<E> v= new MyList<>();
        v.elements =Arrays.copyOf(this.elements,this.size);
        v.size=this.size;
        return v;
    }

    public E remove (int index){
        if(index<0|| index>elements.length){
            throw new IllegalArgumentException("Error index: "+ index);
        }
        E element= (E) elements[index];
        for (int i=index;i<size-1;i++){
            elements[i]=elements[i+1];
        }
        elements[size-1]=null;
        size--;
        return element;
    }

}
