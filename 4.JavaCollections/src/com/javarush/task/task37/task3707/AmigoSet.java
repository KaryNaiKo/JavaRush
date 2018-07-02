package com.javarush.task.task37.task3707;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Павлуша on 08.04.2018.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E>{
    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int cap = (int) Math.ceil(collection.size()/.75f);
        map = new HashMap<>(Math.max(16, cap));

        for (E e: collection) {
            map.put(e, PRESENT);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }



    private void writeObject(ObjectOutputStream oos) throws IOException, ClassNotFoundException {
        try {
            oos.defaultWriteObject();
        } catch (IOException e) {

        }
        HashSet<E> set = new HashSet<>(map.keySet());
        oos.writeObject(set);
        float loadFactor = HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor");
        oos.writeFloat(loadFactor);
        int capacity = HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity");
        oos.writeInt(capacity);

        oos.flush();
        oos.close();


    }

    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException{
        stream.defaultReadObject();
        Set<E> set = (Set) stream.readObject();
        float loadFactor = stream.readFloat();
        int capacity = stream.readInt();


        map = new HashMap<>(capacity, loadFactor);
        for (E e: set) {
            map.put(e, PRESENT);
        }

        stream.close();
    }

    public static void main(String[] args) throws Exception{
        AmigoSet<Integer> set = new AmigoSet<>();
        FileOutputStream outputStream = new FileOutputStream("D:\\test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        FileInputStream fileInputStream = new FileInputStream("D:\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        set.writeObject(objectOutputStream);
    }
}
