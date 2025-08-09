package lec10_inheritance3;

import java.util.Iterator;

public class ArraySet2<T> implements Iterable<T> {
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
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }
    private class ArraySetIterator implements Iterator<T>{
        private int wizPos;
        public ArraySetIterator(){
            wizPos = 0;
        }
        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos +=1;
            return returnItem;
        }
    }
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder("{");
        for (int i = 0; i < size -1; i++){
            returnString.append(items[i]);
            returnString.append(", ");
        }
        returnString.append(items[size - 1]);
        returnString.append("}");
        return returnString.toString();
    }

    @Override
    public boolean equals(Object o){
        if(this == o){return true;}

        if (o instanceof ArraySet2 oas){
            if(this.size != oas.size){
                return false;
            }
            for (T x : this){
                if(!oas.contains(x)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        ArraySet2<Integer> aset = new ArraySet2<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        ArraySet2<Integer> aset2 = new ArraySet2<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

//        Iterator<Integer> aseer = aset.iterator();
//        while (aseer.hasNext()){
//            int i = aseer.next();
//            System.out.println(i);
//        }

        for (int i : aset){
            System.out.println(i);
        }
        System.out.println(aset);

        System.out.println(aset.equals(aset2));
    }
}
