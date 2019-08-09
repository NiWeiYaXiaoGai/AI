package main.java.ChinaHadoop_AI_Offer.Array.day21;

import java.util.Scanner;

public class DictoryArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oddNumber=0;
        int evenNumber=0;
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(" ");
        int arr[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            arr[i] = Integer.parseInt(stringArray[i]);
            if((arr[i]&1)==1){
                oddNumber++;
            }else{
                evenNumber++;
            }
        }
        if(oddNumber>0 && evenNumber>0){
            quickSort(arr,0,arr.length-1);
        }
        print(arr);
    }
    private static void quickSort(int[] arr,int low,int high){
        if(low>=high)
            return;
        int left=low;
        int right=high;
        int temp;
        while(left<right){
            while(left<right && arr[right]>=arr[low]){
                right--;
            }
            while(left<right && arr[left]<=arr[low]){
                left++;
            }
            if(left<right){
                temp=arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
            }
        }
        temp=arr[right];
        arr[right]=arr[low];
        arr[low]=temp;
        quickSort(arr,low,left-1);
        quickSort(arr,left+1,high);
    }
    public static void print(int[] arr){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<arr.length;i++)
            str.append(arr[i]).append(" ");
        System.out.println(str.toString());
    }
}
