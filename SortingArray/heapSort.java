public class heapSort extends SortingArray{
    
    private int arrayLength;

    public int[] sorting(int[] A_toSort){
        arrayLength = A_toSort.length;

        int[] ArrayBuf = new int[arrayLength + 1];
        System.arraycopy(A_toSort, 0, ArrayBuf, 1, arrayLength);;

        int[] ArrayBuf_return = new int[arrayLength];
        heapSorting(ArrayBuf, ArrayBuf_return);

        return ArrayBuf_return;
    }

    private void heapSorting(int[] heapArray, int[] array){

        generateHeap(heapArray);
  
        for(int i = 0; i < array.length; i++){
            array[i] = heapArray[1];
            heapArray[1] = heapArray[arrayLength];
            arrayLength--;
            sink(heapArray, 1);
        }
    }

    private void generateHeap(int[] array){
        int floor;
        for(floor = 1; floor < arrayLength; floor *= 2); //arrayLength != array.length;arrayLength == array.length-1
        floor /= 2;
        for(int i = floor; i > 0; i--){
            sink(array, i);
        }
    }

    private void sink(int[] array, int index){
        int point = index;
        while(point * 2 <= arrayLength){
            if(point * 2 + 1 <= arrayLength){
                if(array[point*2+1] <= array[point*2]){
                    if(array[point] > array[point*2+1]){
                        swap(array, point, point*2+1);
                        point = point*2+1;
                    }
                    else{
                        break;
                    }
                }
                else if(array[point*2+1] > array[point*2]){
                    if(array[point] > array[point*2]){
                        swap(array, point, point*2);
                        point = point*2;
                    }
                    else{
                        break;
                    }
                }
            }
            else if(point * 2 <= arrayLength){
                if(array[point] > array[point*2]){
                    swap(array, point, point*2);
                    point = point*2;
                }
                else{
                    break;
                }
            }
        }
    }
    
    private void swap(int[] A_toSort,int a,int b){
        int temp = A_toSort[a];
        A_toSort[a] = A_toSort[b];
        A_toSort[b] = temp;
    }
}
