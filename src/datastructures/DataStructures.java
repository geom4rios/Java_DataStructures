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

        /*myHash.insert(1, 20);
        myHash.insert(2, 70);
        myHash.insert(42, 80);
        myHash.insert(4, 25);
        myHash.insert(12, 44);
        myHash.insert(14, 32);
        myHash.insert(17, 11);
        myHash.insert(13, 78);
        myHash.insert(37, 97);

        myHash.display();

        myHash.item = myHash.search(37);

        if (myHash.item != null) {
            System.out.println("Element found: " + myHash.item.data);
        } else {
            System.out.println("Element not found");
        }

        myHash.delete(myHash.item);

        myHash.item = myHash.search(37);

        if (myHash.item != null) {
            System.out.println("Element found: " + myHash.item.data);
        } else {
            System.out.println("Element not found");
        }*/

    }

}
