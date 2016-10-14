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

    static int MAX = 10;

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
            System.out.println("lo : " + lo + ", list[" + lo + "]=" + list[lo]);
            System.out.println("hi : " + hi + ", list[" + hi + "]=" + list[hi]);

            // probe the mid point 
            mid = lo + (((hi - lo) / (list[hi] - list[lo])) * (data - list[lo]));
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

}//end of search class

class hashTable {

    static int SIZE = 20;
    int data;

    class DataItem {

        int data;
        int key;
    }

    DataItem hashArray[];
    DataItem dummyItem;
    DataItem item;

    int hashCode(int key) {
        return key % SIZE;
    }

    DataItem search(int key) {
        //get the hash 
        int hashIndex = hashCode(key);

        //move in array until an empty 
        while (hashArray[hashIndex] != null) {

            if (hashArray[hashIndex].key == key) {
                return hashArray[hashIndex];
            }

            //go to next cell
            ++hashIndex;

            //wrap around the table
            hashIndex %= SIZE;
        }

        return null;
    }

    void insert(int key, int data) {

        DataItem item = null;

        item.data = data;
        item.key = key;

        //get the hash 
        int hashIndex = hashCode(key);

        //move in array until an empty or deleted cell
        while (hashArray[hashIndex] != null && hashArray[hashIndex].key != -1) {
            //go to next cell
            ++hashIndex;

            //wrap around the table
            hashIndex %= SIZE;
        }

        hashArray[hashIndex] = item;
    }

    DataItem delete(DataItem item) {
        int key = item.key;

        //get the hash 
        int hashIndex = hashCode(key);

        //move in array until an empty 
        while (hashArray[hashIndex] != null) {

            if (hashArray[hashIndex].key == key) {
                DataItem temp = hashArray[hashIndex];

                //assign a dummy item at deleted position
                hashArray[hashIndex] = dummyItem;
                return temp;
            }

            //go to next cell
            ++hashIndex;

            //wrap around the table
            hashIndex %= SIZE;
        }

        return null;
    }

    void display() {
        int i = 0;

        for (i = 0; i < SIZE; i++) {

            if (hashArray[i] != null) {
                System.out.println("(" + hashArray[i].key + ", " + hashArray[i].data + ")");
            } else {
                System.out.println(" ~~ ");
            }
        }

    }

}//end of hashTable class

class Sort {

    static int MAX = 10;

    static class bubblesort {

        int[] list = {1, 8, 4, 6, 0, 3, 5, 2, 7, 9};

        void display() {
            int i;
            System.out.print("[");

            // navigate through all items 
            for (i = 0; i < MAX; i++) {
                System.out.println(list[i]);
            }

            System.out.println("]");
        }

        void bubbleSort() {
            int temp;
            int i, j;

            boolean swapped = false;

            // loop through all numbers 
            for (i = 0; i < MAX - 1; i++) {
                swapped = false;

                // loop through numbers falling ahead 
                for (j = 0; j < MAX - 1 - i; j++) {
                    System.out.println("Items compared: [" + list[j] + "], [" + list[j + 1] + "]");

                    // check if next number is lesser than current no
                    //   swap the numbers. 
                    //  (Bubble up the highest number) 
                    if (list[j] > list[j + 1]) {
                        temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;

                        swapped = true;
                        System.out.println(" => swapped [" + list[j] + ", " + list[j + 1] + "]");
                    } else {
                        System.out.println(" => not swapped");
                    }

                }

                // if no number was swapped that means 
                //   array is sorted now, break the loop. 
                if (!swapped) {
                    break;
                }
                   
                System.out.println("Iteration " + (i + 1) + "#: ");
                
                display();
            }

        }

    }// end of class bubblesort
}//end of sort class.

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

            //index = way.binarySearch(num, sorted_array);
            //index = way.interpolationSearch(num, sorted_array);
            //test hashTable
            //hashTable myHash = new hashTable();
            //myHash.dummyItem.data = -1;
            //myHash.dummyItem.key = -1;

                     
            Sort mySort = new Sort();
            
            Sort.bubblesort myBubble = new Sort.bubblesort();
            
            myBubble.bubbleSort();
            
        }

    }
