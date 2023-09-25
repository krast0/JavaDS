package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private static final int INIT_CAP = 4;
    private int size;
    private int capacity;

    public ArrayList() {
        this.elements = new Object[INIT_CAP];
        this.size = 0;
        this.capacity = INIT_CAP;
    }


    @Override
    public boolean add(E element) {

    if (this.size == this.capacity) {
        resize();
    }


        this.elements[this.size++] = element;
        return true;

    }

    @Override
    public boolean add(int index, E element) {
        if(index < 0 || index > this.size) {
            return false;
        }

        shiftRight(index);
        this.elements[index] = element;
        this.size++;
        return true;
    }

    @Override
    public E get(int index) {
        if(indexIsValid(index)){
            return (E) elements[index];
        }else{
            throw new IndexOutOfBoundsException("error");
        }

    }
    public boolean indexIsValid(int index){
            return index >= 0 && index < elements.length;
    }
    @Override
    public E set(int index, E element) {
        E currentElement = (E) elements[index];
        if(indexIsValid(index)){
            elements[index] = element;
            return currentElement;
        }else{
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public E remove(int index) {
        System.out.println("test");
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    public void resize(){
        this.capacity *=2;
        Object[] tmp = new Object[this.capacity];

        for (int i = 0; i < this.elements.length; i++) {
            tmp[i] = this.elements[i];
        }
        this.elements = tmp;
    }

    private void shiftRight(int index) {
        for (int i = size; i >= index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
    }
}
