public class HW10_4108056027_2 extends SortingArray{
    
    int arrayLength;
    final int[] MarcinCiura = {1750, 701, 301, 132, 57, 23, 10, 4, 1};
    public int[] sorting(int[] A_toSort){
        arrayLength = A_toSort.length;
        
        shellSort(A_toSort);
		
        return A_toSort;
    }
    public void swap(int[] A_toSort,int a,int b){
        int temp = A_toSort[a];
        A_toSort[a] = A_toSort[b];
        A_toSort[b] = temp;
    }
    
    public void shellSort(int[] A_toSort){
        
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
