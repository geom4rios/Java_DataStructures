/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import static datastructures.MergerSort.mergeSort;
import java.util.*;
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

    public static void display(int[] list) {
        int i;
        System.out.print("[");

        // navigate through all items 
        for (i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

        System.out.println("]");
    }

    public static void printline(int count) {
        int i;

        for (i = 0; i < count - 1; i++) {
            System.out.print("=");
        }

        System.out.println();
    }

    static class bubblesort {

        int[] list = {1, 8, 4, 6, 0, 3, 5, 2, 7, 9};

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
                Sort.display(this.list);
            }

        }

    }// end of class bubblesort

    static class insertionSort {

        int[] intArray = {4, 6, 3, 2, 1, 9, 7};

        void insertionSort() {

            int valueToInsert;
            int holePosition;
            int i;

            // loop through all numbers 
            for (i = 1; i < intArray.length; i++) {

                // select a value to be inserted. 
                valueToInsert = intArray[i];

                // select the hole position where number is to be inserted 
                holePosition = i;

                // check if previous no. is larger than value to be inserted 
                while (holePosition > 0 && intArray[holePosition - 1] > valueToInsert) {
                    intArray[holePosition] = intArray[holePosition - 1];
                    holePosition--;
                    System.out.println(" item moved: " + intArray[holePosition]);
                }

                if (holePosition != i) {
                    System.out.print(" item inserted : " + valueToInsert);
                    System.out.println(" at position " + holePosition);
                    // insert the number at hole position 
                    intArray[holePosition] = valueToInsert;
                }

                System.out.println("Iteration " + (i + 1) + "#: ");
                Sort.display(intArray);

            }
        }

    }//end of insertion sort class

    static class selectionSort {

        int intArray[] = {4, 6, 3, 2, 1, 9, 7};

        void selectionSort() {

            int indexMin, i, j;

            // loop through all numbers 
            for (i = 0; i < intArray.length - 1; i++) {

                // set current element as minimum 
                indexMin = i;

                // check the element to be minimum 
                for (j = i + 1; j < intArray.length; j++) {
                    if (intArray[j] < intArray[indexMin]) {
                        indexMin = j;
                    }
                }

                if (indexMin != i) {
                    System.out.print("Items swapped [ " + intArray[i]);
                    System.out.println(", " + intArray[indexMin] + "]");

                    // swap the numbers 
                    int temp = intArray[indexMin];
                    intArray[indexMin] = intArray[i];
                    intArray[i] = temp;
                }

                System.out.println("Iteration " + (i + 1) + "#: ");
                Sort.display(intArray);

            }
        }
    }//end of selection sort class

    static class mergeSort {
        int i;
        int a[] = {10, 166, 196, 526, 327, 311, 33, 345, 47, 44};
        int max = a.length;
        int b[] = new int[max];
        
        public void mergeSort() {
            System.out.println("List before sorting");

            for (i = 0; i < max; i++) {
                System.out.print(" " + a[i]);
            }

            sort(0, max);

            System.out.println("List after sorting");

            for (i = 0; i < max; i++) {
                System.out.println(a[i]);
            }
        }

        void merging(int low, int mid, int high) {
            int l1, l2, i;
            System.out.println("GOT INTO merging, low is " + low + " mid is " + mid + " and high is " + high);
            for (l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 < high; i++) {
                if (a[l1] <= a[l2]) {
                    b[i] = a[l1++];
                } else {
                    b[i] = a[l2++];
                }
            }

            while (l1 <= mid) {
                b[i++] = a[l1++];
            }

            while (l2 < high) {
                b[i++] = a[l2++];
            }

            for (i = low; i < high; i++) {
                a[i] = b[i];
            }
        }

        void sort(int low, int high) {
            int mid;

            if (low < high) {
                mid = (low + high) / 2;
                System.out.println("low is " + low + " mid is " + mid + " and high is " + high);
                sort(low, mid);
                sort(mid + 1, high);
                merging(low, mid, high);
            } 
        }
        
    }// end of merge sort class.

}//end of sort class.

class MergerSort 
{
    @SuppressWarnings("rawtypes") 
    public static Comparable[] mergeSort(Comparable[] list) 
    {
        //If list is empty; no need to do anything
        if (list.length <= 1) {
            return list;
        }
         
        //Split the array in half in two parts
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
         
        //Sort each half recursively
        mergeSort(first);
        mergeSort(second);
         
        //Merge both halves together, overwriting to original array
        merge(first, second, list);
        return list;
    }
     
    @SuppressWarnings({ "rawtypes", "unchecked" }) 
    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) 
    {
        //Index Position in first array - starting with first element
        int iFirst = 0;
         
        //Index Position in second array - starting with first element
        int iSecond = 0;
         
        //Index Position in merged array - starting with first position
        int iMerged = 0;
         
        //Compare elements at iFirst and iSecond, 
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) 
        {
            if (first[iFirst].compareTo(second[iSecond]) < 0) 
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            } 
            else
            {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
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

        //index = way.binarySearch(num, sorted_array);
        //index = way.interpolationSearch(num, sorted_array);
        //test hashTable
        //hashTable myHash = new hashTable();
        //myHash.dummyItem.data = -1;
        //myHash.dummyItem.key = -1;
        //Sort mySort = new Sort();
        //Sort.bubblesort myBubble = new Sort.bubblesort();
        //myBubble.bubbleSort();
        //Sort.insertionSort myInsertionSort = new Sort.insertionSort();
        //System.out.print("Input Array: ");
        //myInsertionSort.insertionSort();
        //myInsertionSort.printline(50);
        //Sort.selectionSort mySelectionSort = new Sort.selectionSort();
        //mySelectionSort.selectionSort();
        //Sort.mergeSort myMergeSort = new Sort.mergeSort();
        //myMergeSort.mergeSort();
        
  
        //Unsorted array
        Integer[] a = { 2, 6, 3, 5, 1 };
         
        //Call merge sort
        mergeSort(a);
         
        //Check the output which is sorted array
        System.out.println(Arrays.toString(a));

 

    }

}
