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
    static int MAX=10;
    
    public int binarySearch(int value, int sorted[]) {

        int length = sorted.length;
        System.out.println("length of Array is " + length);
        int count = 1;
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
                System.out.println("found at position " + midPoint + " after " + count + " Iterations");
                return midPoint;
            }
            ++count;

        }
    }
   

   public int interpolationSearch(int data, int list[]) {
        int lo = 0;
        int hi = MAX - 1;
        int mid = -1;
        int comparisons = 1;
        int index = -1;

        while (lo <= hi) {
            System.out.println("Comparison " + comparisons);
            System.out.println("lo : " + lo + ", list[" + lo +"]=" + list[lo]);
            System.out.println("hi : " + hi + ", list[" + hi +"]=" + list[hi]);            

            // probe the mid point 
            mid = lo + (( (hi - lo) / (list[hi] - list[lo])) * (data - list[lo]));
            System.out.println("mid = " + mid);

            // data found 
            if (list[mid] == data) {
                index = mid;
                break;
            } else if (list[mid] < data) {
                // if data is larger, data is in upper half 
                lo = mid + 1;
            } else {
                // if data is smaller, data is in lower half 
                hi = mid - 1;
            }
            ++comparisons;
        }

        System.out.println("Total comparisons made: " + comparisons);
        
        return index;
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

        index = way.interpolationSearch(num, sorted_array);

    }

}
