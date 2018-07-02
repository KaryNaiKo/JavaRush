package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class c : classes){

            if(Modifier.isPrivate(c.getModifiers()))
                if(Modifier.isStatic(c.getModifiers()))
                {
                    if(List.class.isAssignableFrom(c))
                    {
                        try{
                            Constructor constructor = c.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            List list = (List) constructor.newInstance();
                            list.get(0);
                        }catch (IndexOutOfBoundsException e){
                            // вернуть класс
                            return c;
                        } catch (NoSuchMethodException e) {
                            //e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            //e.printStackTrace();
                        }
                    }

                }
        }
        return null;
    }
}

/*
class java.util.Collections$AsLIFOQueue
class java.util.Collections$CheckedCollection
class java.util.Collections$CheckedList
class java.util.Collections$CheckedMap
class java.util.Collections$CheckedNavigableMap
class java.util.Collections$CheckedNavigableSet
class java.util.Collections$CheckedQueue
class java.util.Collections$CheckedRandomAccessList
class java.util.Collections$CheckedSet
class java.util.Collections$CheckedSortedMap
class java.util.Collections$CheckedSortedSet
class java.util.Collections$CopiesList
class java.util.Collections$EmptyEnumeration
class java.util.Collections$EmptyIterator
class java.util.Collections$EmptyList
class java.util.Collections$EmptyListIterator
class java.util.Collections$EmptyMap
class java.util.Collections$EmptySet
class java.util.Collections$ReverseComparator
class java.util.Collections$ReverseComparator2
class java.util.Collections$SetFromMap
class java.util.Collections$SingletonList
class java.util.Collections$SingletonMap
class java.util.Collections$SingletonSet
class java.util.Collections$SynchronizedCollection
class java.util.Collections$SynchronizedList
class java.util.Collections$SynchronizedMap
class java.util.Collections$SynchronizedNavigableMap
class java.util.Collections$SynchronizedNavigableSet
class java.util.Collections$SynchronizedRandomAccessList
class java.util.Collections$SynchronizedSet
class java.util.Collections$SynchronizedSortedMap
class java.util.Collections$SynchronizedSortedSet
class java.util.Collections$UnmodifiableCollection
class java.util.Collections$UnmodifiableList
class java.util.Collections$UnmodifiableMap
class java.util.Collections$UnmodifiableNavigableMap
class java.util.Collections$UnmodifiableNavigableSet
class java.util.Collections$UnmodifiableRandomAccessList
class java.util.Collections$UnmodifiableSet
class java.util.Collections$UnmodifiableSortedMap
class java.util.Collections$UnmodifiableSortedSet
 */


/*
            Class[] interfaces = classes[i].getInterfaces();
            for (int j = 0; j < interfaces.length; j++) {
                //System.out.println(interfaces[j]);

                if(interfaces[j].getSimpleName().equals("List")){
                    Method[] methods = classes[i].getMethods();
                    for (int k = 0; k < methods.length; k++) {
                        methods[k].setAccessible(true);
                        Class[] c = methods[k].getExceptionTypes();
                        for (int l = 0; l < c.length; l++) {
                            System.out.println(c[l]);
                        }
                    }
                }
            }
 */