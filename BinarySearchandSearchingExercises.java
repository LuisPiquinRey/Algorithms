import java.util.Arrays;

public class BinarySearchandSearchingExercises {
    public static void main(String[] args){

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
}
