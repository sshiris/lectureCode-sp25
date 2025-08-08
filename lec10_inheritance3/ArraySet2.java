package lec10_inheritance3;

public class ArraySet2<T> {
    private T[] items;
    private int size;

    public ArraySet2(){
        items =(T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T x){
        for (int i = 0; i < size; i++){
            if(items[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public void add(T x){
        if(!contains(x)){
            items[size] = x;
            size += 1;
        }
    }
}
