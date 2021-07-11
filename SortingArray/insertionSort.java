public class insertionSort extends SortingArray{

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
            for(int j = i; j > 0 && array[j] < array[j-1]; j--){
                swap(array, j, j-1);
            }
        }
    }

}
