package main.java.ChinaHadoop_AI_Offer.Sort;

public class Sort {
    public void mergeSort(int[] arr){
        int[] helper=new int[arr.length];
        mergeSort(arr,helper, 0,arr.length-1);
    }

    private void mergeSort(int[] arr,int[] helper,int left,int right){
        if(left>=right)
            return;
        int mid=left+(right-left)/2;
        mergeSort(arr,helper,left,mid);
        mergeSort(arr,helper,mid+1,right);
        merge(arr,helper,left,mid,right);
    }

    private void merge(int[] arr,int[] helper,int left,int mid,int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }
        int helperLeft = left;
        int helperRight = mid + 1;
        int cur = left;
        while (helperLeft<=mid && helperRight<=right) {
            if(helper[helperLeft]<=helper[helperRight]){
                arr[cur]=helper[helperLeft];
                helperLeft++;
            }else{
                arr[cur]=helper[helperRight];
                helperRight++;
            }
            cur++;
        }
        while(helperLeft<=mid){
            arr[cur]=helper[helperLeft];
            helperLeft++;
            cur++;
        }
        while(helperRight<=right){
            arr[cur]=helper[helperRight];
            helperRight++;
            cur++;
        }
    }

    //快速排序算法
    public void quickSort(int[] arr){
        if(arr==null || arr.length==0)
            return;
        quickImpl(arr,0,arr.length-1);
    }

    private void quickImpl(int[] arr,int low,int high){
        if(low>=high)
            return;
        int temp;
        int left=low;
        int right=high;
        while(left<right){
            while(left<right && arr[right]>arr[low]){
                right--;
            }
            while(left<right && arr[left]<=arr[low]){
                left++;
            }
            if(left<right){
                temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        temp=arr[low];
        arr[low]=arr[left];
        arr[left]=temp;
        quickImpl(arr,low,left-1);
        quickImpl(arr,left+1,high);
    }


    public static void print ( int[] arr){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]).append(" ");
        }
        System.out.println(str.toString());
    }

    public static void main (String[]args){
        Sort sort = new Sort();
        int[] arr = {5, 2, 4, 6, 1, 3, 2, 6};
        int[] arr2={6,2,3,1,4};
        int[] arr3={3,7,8,5,6};
//        sort.mergeSort(arr);
        sort.quickSort(arr3);
        print(arr3);
    }

}
