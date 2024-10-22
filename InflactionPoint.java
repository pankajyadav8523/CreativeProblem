public class InflactionPoint {
    public static void main(String[] args) {
       int[] arr = {56, 50};
       InflactionPoint obj = new InflactionPoint();
       System.out.println(obj.binarySearchIp(arr, 0, arr.length));
       System.out.println(obj.inflactionPoint(arr));
    }

    public int inflactionPoint(int[] arr){
        int max = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        return arr[max];
    }

    public int binarySearchIp(int[] arr, int start, int end){
        int mid = start + (end-start)/2;
        if ()
        if ((arr[mid] > arr[mid-1]) && arr[mid] > arr[mid+1]){
            return arr[mid];
        }
        if (arr[mid] < arr[mid+1]){
            return binarySearchIp(arr, mid+1, end);
        }
        else{
            return binarySearchIp(arr, start, mid);
        }
    }
}
