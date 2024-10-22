import java.util.*;

public class DutchFlag {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        DutchFlag df = new DutchFlag();
        df.twoSum(arr,8);
        // df.partition(arr, 2);
        // System.out.println(Arrays.toString(arr));
    }

    void partition(int[] arr, int x){
        int less = 0; int great = 0; 
        int pivot = x;
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == pivot){
                swap(arr, i, great);
                great ++;
            }
            else if (arr[i] < pivot){
                swap(arr, less, i);
                swap(arr, great, i);
                less ++;
                great ++;
            }
        }
    }

    void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    ArrayList<Integer> twoSum(int[] arr, int target){
        ArrayList<Integer> a = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            hs.add(arr[i]);
        }
        for (int value : hs){
            System.out.println(value);
        }
        return a;
    }
}
