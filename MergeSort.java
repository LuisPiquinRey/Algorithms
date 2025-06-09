public class MergeSort{
    public static void main(String[] args){

    }
    /*
     * Today I will show you one of the most recognized algorithms in the industry for sorting data structures: Merge Sort.
       This algorithm stands out for its efficiency, since it has a time complexity of O(n log n), which makes it an excellent option for sorting large volumes of information.

       The key to these algorithms is to understand the principle of “divide and conquer,” since in Merge Sort we must keep splitting the data collection in half following recursive
       ideas until each branch contains a single unit of data. Once this is achieved, we will start sorting according to the numerical value of each unit, and finally, for the reconstruction,
       we must start combining each section.
     */

    //This method helps us break down the array into smaller partitions.
    public static void splitOriginalArray(int[] arrayToSplit,int[] firstHalf,int[] secondHalf){
        int index=0;
        int secondHalfIndex=firstHalf.length;
        for(int element:arrayToSplit){
            if(index<secondHalfIndex){
                firstHalf[index]=element;
            }else{
                secondHalf[index-secondHalfIndex]=element;
            }
            index++;
        }
    }
    /*
     * The following method is one of the keys of the algorithm; it is responsible for merging the partitioned units resulting from the recursion to reconstruct the original
     * length of our array.
     */
    public static void mergeArray(int[] arrayToBeSorted,int[] firstHalf,int[] secondHalf){
        int firstIndex=0;
        int secondIndex=0;
        int indexAlfa=0;
        while(firstIndex<firstHalf.length && secondIndex<secondHalf.length){
            if(firstHalf[indexAlfa]<secondHalf[indexAlfa]){
                arrayToBeSorted[indexAlfa]=firstHalf[firstIndex];
            }else if(secondIndex<secondHalf.length){
                arrayToBeSorted[indexAlfa]=secondHalf[secondIndex++];
            }
            indexAlfa++;
        }
        if(firstIndex<firstHalf.length){
            while(indexAlfa<arrayToBeSorted.length){
                arrayToBeSorted[indexAlfa++]=firstHalf[firstIndex++];
            }
        }
        if(secondIndex<secondHalf.length){
            while(indexAlfa<arrayToBeSorted.length){
                arrayToBeSorted[indexAlfa++]=secondHalf[secondIndex++];
            }
        }
    }
    /*
     * Finally, we have the most important method, which follows the principles of recursion. The base case is when the length is 1; when this condition is met, we must sort and
     *  merge the collections.
     */
    public static void mergeSort(int[] arr){
        if(arr.length==1)return;
        int midIndex=arr.length/2 + arr.length%2;
        int[] firstHalf=new int[midIndex];
        int[] secondHalf=new int[arr.length-midIndex];
        splitOriginalArray(arr,firstHalf,secondHalf);
        mergeSort(firstHalf);
        mergeSort(secondHalf);
        mergeArray(arr,firstHalf,secondHalf);
    }
}