public class ShellSort_MarcinCiura extends SortingArray{
    
    private int arrayLength;
    private final int[] MarcinCiura = {1750, 701, 301, 132, 57, 23, 10, 4, 1};

    public int[] sorting(int[] A_toSort){

        arrayLength = A_toSort.length;

        int[] ArrayBuf = new int[arrayLength];

        System.arraycopy(A_toSort, 0, ArrayBuf, 0, arrayLength);
        
        shellSort(ArrayBuf);
		
        return ArrayBuf;
    }
    private void swap(int[] A_toSort,int a,int b){
        int temp = A_toSort[a];
        A_toSort[a] = A_toSort[b];
        A_toSort[b] = temp;
    }
    
    private void shellSort(int[] A_toSort){
        
        int upperBound = 9;
        
        int gap,point;
        for(int i = 0;i < upperBound;i++){
            gap = MarcinCiura[i];
            for(int j = gap;j < arrayLength;j++){
                if(A_toSort[j] < A_toSort[j-gap]){
                    for(point = j;point >= gap;point -= gap){
                        if(A_toSort[point] < A_toSort[point-gap]){
                            swap(A_toSort, point, point - gap);
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
    }
    

}
