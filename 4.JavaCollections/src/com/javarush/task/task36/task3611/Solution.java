package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humansRelationships;

    public static void main(String[] args) {


        Solution solution = new Solution();
        solution.humansRelationships = generateRelationships();

//        for (int i = 0; i < 8; i++) {
//            Set set = solution.getFriends(i);
//            System.out.println(set);
//        }
        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              //expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           //expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        Set<Integer> set = null;

        if(deep > 0) {
            set = getFriends(index);
            if(deep > 1) {
                Set<Integer> tempSet = new HashSet<>();
                for (int i : set) {
                    Set cset = getAllFriendsAndPotentialFriends(i, deep-1);
                    if (cset != null) {
                        tempSet.addAll(cset);
                    }
                }
                set.addAll(tempSet);
            }
        }
        set.remove(index);
        return set;
    }

/*
[1, 4, 5]
[0, 2, 4]
[1, 5]
[4, 7]
[0, 1, 3]
[0, 2, 6]
[5]
[3]
*/



    //remove people from set, with which you have already had relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humansRelationships.length; i++) {
            if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humansRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    private Set<Integer> getFriends(int human) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < humansRelationships.length; i++) {
            if(i < human) {
                if(humansRelationships[human][i]) set.add(i);
            } else {
                if(humansRelationships[i][human]) set.add(i);
            }
        }
        set.remove(human);

        return set;
    }

    //return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}