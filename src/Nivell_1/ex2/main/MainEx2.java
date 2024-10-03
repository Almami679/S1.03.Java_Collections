package Nivell_1.ex2.main;


import java.util.*;

public class MainEx2 {

    static List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) {

        List<Integer> nums2 = new LinkedList<>();

        ListIterator<Integer> numsIterator = nums.listIterator(nums.getLast());

        while (numsIterator.hasPrevious()) {
            nums2.add(numsIterator.previous());
        }

        System.out.print("Lista 1: ");
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.print("\nLista 2: ");
        for(int num : nums2) {
            System.out.print(num + " ");
        }
    }

}
