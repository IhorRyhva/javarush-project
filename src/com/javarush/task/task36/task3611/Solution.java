package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.Set;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        Set<Integer> set = new HashSet<>();
        if(deep == 0){
            return set;
        } else {
            for (int i = 0; i < humanRelationships.length; i++) {
                if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                    set.add(i);
                    set.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                } else if ((i > index) && humanRelationships[i][index]) {
                    set.add(i);
                    set.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            }
//            Object[] array = set.toArray();
//            for(Object o: array){
//                set.addAll(getAllFriendsAndPotentialFriends((Integer) o, deep - 1));
//            }
        }
        set.remove(index);
        return set;
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
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
                // Expected: [0,1,3]
                //[5]
                //[2]
                //[7]

                ////         0      1      2      3      4      5      6     7
                ///* 0 */ {true}//true,  false, false, true,  true,  false, false   //0
                ///* 1 */ {true,  true}//true,  false, true,  false, false, false   //1
                ///* 2 */ {false, true,  true}//false, false, true,  false, false   //2
                ///* 3 */ {false, false, false, true}//true,  false, false, true    //3
                ///* 4 */ {true,  true,  false, true,  true}//false, false, false   //4
                ///* 5 */ {true,  false, true,  false, false, true}//true,  false   //5
                ///* 6 */ {false, false, false, false, false, true,  true}//false   //6
                ///* 7 */ {false, false, false, true,  false, false, false, true}   //7
                ////         0      1      2      3      4      5      6     7
        };
    }
}