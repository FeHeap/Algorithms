public class insertionSort_binary extends SortingArray{

    public int[] sorting(int[] A_toSort){
        int[] ArrayBuf = new int[A_toSort.length];
        System.arraycopy(A_toSort, 0, ArrayBuf, 0, A_toSort.length);
        insertionSorting(ArrayBuf);
        return ArrayBuf;
    }

    private void swap(int[] A_toSort,int a,int b){
        int temp = A_toSort[a];
        A_toSort[a] = A_toSort[b];
        A_toSort[b] = temp;
    }

    private void insertionSorting(int[] array){
        for(int i = 1; i < array.length; i++){
            if(array[i] < array[i-1]){
                int mid = 0;
                int left = 0, right = i;
                while(true){
                    if(mid != (left + right) / 2){
                        mid = (left + right) / 2;
                    }
                    else{
                        break;
                    }

                    if(array[mid] > array[i] && array[i] < array[mid+1]){
                        right = mid;
                    }
                    else if(array[mid] < array[i] && array[i] > array[mid+1]){
                        left = mid + 1;
                    }
                    else if(array[mid] < array[i] && array[i] < array[mid+1]){
                        mid = mid + 1;
                        break;
                    }
                }

                for(int j = i;j > mid;j--){
                    swap(array, j, j-1);
                }
            }
        }
    }

}
