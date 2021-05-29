public class HW10_4108056027_1 extends SortingArray{
    
    int arrayLength;
    final int[] step = {23,8,1}; //Sedgewick, 1982

    public int[] sorting(int[] A_toSort){
        arrayLength = A_toSort.length;
        quickSort(A_toSort, 0, arrayLength-1);
        
        return A_toSort;
    }

    public void swap(int[] A_toSort,int a,int b){
        int temp = A_toSort[a];
        A_toSort[a] = A_toSort[b];
        A_toSort[b] = temp;
    }
    
    final int CUTOFF = 36;
    public void quickSort(int[] array , int left , int right){
        if(right <= left + CUTOFF){
            shellSort(array,left,right);
            return;
        }
            
        int median = medianOf_3(array,left,(left+right)>>1,right);
        swap(array,left,median);
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot-1);
        quickSort(array, pivot+1, right);
    }

    public int partition(int[] array , int left , int right){
        int pivot = array[left];
        int i = left + 1;
        for(int j = right;i <= j;){
            if(array[i] <= pivot){
                i++;
            }
            if(array[j] >= pivot){
                j--;
            }
            if(i < j){
                if(array[i] > pivot && array[j] < pivot){
                    swap(array, i, j);
                    i++;
                    j--;
                }
            }
        }
        swap(array, left, i-1);
        return i-1;
    }
    
    public int medianOf_3(int[] array,int A,int B,int C){
        if(array[A] >= array[B] && array[B] >= array[C]){
            return B;
        }
        else if(array[B] >= array[C] && array[C] >= array[A]){
            return C;
        }
        else{
            return A;
        }
    }
    
	public void shellSort(int[] A_toSort,int left,int right){

        int gap,point;
        for(int i = 0;i < 3;i++){
            gap = step[i];
            for(int j = left + gap;j <= right;j++){
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
