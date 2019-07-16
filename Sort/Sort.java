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
            sort.mergeSort(arr);
            print(arr);
        }

}
