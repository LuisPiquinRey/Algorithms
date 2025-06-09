import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchandSearchingExercises {
    public static void main(String[] args){
        System.out.println(findPair(new int[]{1,2,-3,4,-1}, 3));
    }
    /*
     * Welcome user! Today we will talk about one of the easiest yet most important algorithms to learn.
     *
     * Alright, the Binary Search algorithm follows a simple rule: the array must be sorted. Once this is done, it follows
     * very basic principles — subdividing the data collection into two partitions (dividing it in half). What we do is find
     * out which half contains the target. If the element is greater than arr[mid], that means the target we are looking for must
     * be in the upper half. Once this is understood, we simply repeat the same process.
     */
    public static boolean binarySearch(int target,int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)return true;
            if(arr[mid]>target)end=mid-1;
            else start=mid+1;
        }
        return false;
    }
    //Given an array arr. The task is to find the largest element in the given array.
    /*
     * What I came up with for this problem is simply to sort the array so that the last element is the largest within the collection.
     */
    public static int largest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
    //Given an array of positive integers arr[] of size n, the task is to find second largest distinct element in the array.
    /*
     * What I came up with for this exercise is to sort the array. Once that’s done, we’ll iterate in reverse starting from index n-2.
     * Remember that there can be duplicates, so we check if the current number is different from the last one (at index n-1). If it
     * is, then we’ve found the second largest number.
     */
    public int getSecondLargest(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]!=arr[n-1])return arr[i];
        }
        return -1;
    }
    /*
     * Given an array arr[] of size n-1 with distinct integers in the range of [1, n]. This array represents a permutation of the integers from
     * 1 to n with one element missing. Find the missing element in the array.
     *
     * For this exercise, I’m using the XOR operator. The XOR operator (^), short for exclusive OR, is a bitwise operator that compares two binary
     *  values bit by bit and returns 1 if the bits are different and 0 if they are the same.
     */
    public static int missingNum(int arr[]) {
        int n = arr.length;
        int xorAll = 0;
        int xorArr = 0;
        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }
        for (int i = 0; i < n; i++) {
            xorArr ^= arr[i];
        }
        return xorAll ^ xorArr;
    }
    //Given a binary array arr[] of size n, which is sorted in non-increasing order, count the number of 1's in it.

    /*
     * What I came up with to solve this exercise is to use the Stream class to filter out the numbers that are different
     * from one, and then perform a count.
     */
    public int countOne(int arr[]){
        return (int)Arrays.stream(arr).filter(p->p==1).count();
    }
    /*
     * Given an unsorted array and an integer x, the task is to find if there exists a pair of elements in the array whose
     * absolute difference is x.
     * 
     * For solving this exercise, I thought of using the two-pointer technique; depending on the sum, I either move the left
     * pointer forward or the right pointer backward.
     */
    public static boolean findPair(int[] arr, int x) {
        Arrays.sort(arr);
        int i = 0, j = 1;
        while (i < arr.length && j < arr.length) {
            if (i != j && Math.abs(arr[j] - arr[i]) == x) {
                return true;
            } else if (Math.abs(arr[j] - arr[i]) < x) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
    /*
     * Given three sorted arrays in non-decreasing order, print all common elements in non-decreasing order across these arrays.
     * If there are no such elements return an empty array. In this case, the output will be -1. Note: In case of duplicate common
     * elements, print only once.
     *
     */
    public static List<Integer> commonElements(int[] arr1, int[] arr2, int[] arr3)
    {
        int i = 0, j = 0, k = 0;
        List<Integer> common = new ArrayList<>();

        while (i < arr1.length && j < arr2.length
            && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                common.add(arr1[i]);
                i++;
                j++;
                k++;

                while (i < arr1.length
                    && arr1[i] == arr1[i - 1])
                    i++;
                while (j < arr2.length
                    && arr2[j] == arr2[j - 1])
                    j++;
                while (k < arr3.length
                    && arr3[k] == arr3[k - 1])
                    k++;
            }
            else if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr3[k])
                j++;
            else
                k++;
        }
        return common;
    }
}
