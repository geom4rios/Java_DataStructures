/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author marios
 */
class search {

    public int binarySearch(int value, int sorted[]) {

        int length = sorted.length;
        System.out.println("length of Array is " + length);
        int count=1;
        int current, midPoint;
        int lowerBound = 0;
        int upperBound = length;
        
        

        while (true) {

            if (upperBound < lowerBound) {
                System.out.println("Number not found");
                return 0;
            }

            midPoint = lowerBound + (upperBound - lowerBound) / 2;
            System.out.println(midPoint);
            if (sorted[midPoint] < value) {
                lowerBound = midPoint + 1;
            }

            if (sorted[midPoint] > value) {
                upperBound = midPoint - 1;
            }

            if (sorted[midPoint] == value) {
                System.out.println("found at position " + midPoint + " after " + count + " Iteraions");
                return midPoint;
            }
            ++count;

        }
    }
}

    public class DataStructures {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
            int sorted_array[] = {2, 3, 5, 13, 22, 33, 24, 222, 223, 555, 859, 950};
            search way = new search();

            int num = 223;
            int index;

            index = way.binarySearch(num, sorted_array);

            System.out.println(index);

        }

    }
