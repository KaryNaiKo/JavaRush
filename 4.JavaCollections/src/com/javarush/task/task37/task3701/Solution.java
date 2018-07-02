package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        //ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }

//        System.out.println();
//
//        Iterator<Integer> iterator = list.iterator();
//        count = 0;
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
//            if (count == 1) {
//                iterator.remove();
//            }
//            count++;
//            if (count == 10) {
//                break;
//            }
//        }

        //System.out.println(list);
    }

    public class RoundIterator implements Iterator<T>{
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public T next() {
            checkForComodification();

            lastRet = cursor;
            T next = get(cursor);
            cursor++;
            if(cursor >= size()) cursor=0;
            return next;
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                Solution.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }
}
