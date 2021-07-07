import java.util.Random;

public class quickSelect {
    public static void main(String[] args) {
        int[] array = {0,2,1,7,4,3,2,5,6,3,-1,-2,0,4,4,4,7,1,5,2,-6,9};
        quickSelect select = new quickSelect();
        int value = select.Median(array);
        System.out.println("Median of array is "+ value);
    }

    public int Median(int[] array){
        int[] ArrayBuf = new int[array.length];
        System.arraycopy(array, 0, ArrayBuf, 0, array.length);
        if(array.length >= CUTOFF * 12){
            if(linear(array)){
                shuffle(ArrayBuf);
            }
        }
        return select(ArrayBuf, (ArrayBuf.length-1)/2);
    }

    final int CUTOFF = 36;
    private int select(int[] array,int indexToFind){
        int head = 0,tail = array.length-1;
        
        for(int indexBuf = 0;indexBuf != indexToFind;){
            if(tail-head > CUTOFF){
                swap(array,head,merelyMedianOf(array,head,tail));
                indexBuf = partition(array,head,tail);
            }
            else{
                shellSort(array,head,tail);
                indexBuf = indexToFind;
            }

            if(indexBuf > indexToFind){
                tail = indexBuf-1;
            }
            else if(indexBuf < indexToFind){
                head = indexBuf+1;
            }
        }
        return array[indexToFind];
    }

    private int partition(int[] array, int head, int tail)
    {
        int i = head+1, j = tail;
        while(i <= j){

            while(array[i] < array[head]){
                if(++i > j) break;
            }
            
            while(array[j] > array[head]){
                if(i > --j) break;
            }

            if(i > j) break;

            swap(array, i++, j--);
        }
        swap(array,head,i-1);

        return i-1;
    }
     
    private int merelyMedianOf(int[] array, int head, int tail){
        int Length = tail - head;
        int[] indexs = {head, head + Length/10, head + Length*2/10, head + Length*3/10, head + Length*4/10,
                        head + Length*5/10, head + Length*6/10, head + Length*7/10, head + Length*8/10, head + Length*9/10, tail};
        for(int i = 1;i < indexs.length;i++){
            for(int j = i; j > 0 && array[indexs[j]] < array[indexs[j-1]]; j--)
                swap(indexs, j, j-1);
        }
        int mid = indexs[indexs.length/2];
        
        return mid;
    }

    final int[] step = {23,8,1}; //Sedgewick, 1982
    private void shellSort(int[] A_toSort,int head,int tail){

        int gap,point;
        for(int i = 0;i < step.length;i++){
            gap = step[i];
            for(int j = head + gap;j <= tail;j++){
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
    
    private void swap(int[] array,int indexA,int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    private void shuffle(int[] array){
        Random rand = new Random();
        for(int range = array.length,indexBuf; range > 0;){
            indexBuf = rand.nextInt(range--);
            swap(array, range, indexBuf);
        }
    }

    boolean linear(int[] array){
        int units = (array.length/CUTOFF) - 1;
        int increase = 0, decrease = 0;
        for(int i = 2 + CUTOFF; i < array.length; i += CUTOFF){
            if(array[i-2] >= array[i-1] && array[i-1] >= array[i] && array[i-CUTOFF] >= array[i-2]){
                decrease++;
            }
            if(array[i-2] <= array[i-1] && array[i-1] <= array[i] && array[i-CUTOFF] <= array[i-2]){
                increase++;
            }
        }

        if(increase >= units*9/10 || decrease >= units*9/10){
            return true;
        }
        else{
            return false;
        }

    }
}