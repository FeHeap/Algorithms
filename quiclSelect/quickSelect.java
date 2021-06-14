public class quickSelect {
    public static void main(String[] args) {
        int[] array = {0,2,1,7,4,3,2,5,6,3,-1,-2,0,4,4,4};
        quickSelect select = new quickSelect();
        int value = select.Median(array);
        System.out.println("Median of array is "+ value);
    }

    public int Median(int[] array){
        int[] ArrayBuf = new int[array.length];
        System.arraycopy(array, 0, ArrayBuf, 0, array.length);

        return select(ArrayBuf, (ArrayBuf.length-1)/2);
    }

    private int select(int[] array,int indexToFind){
        int head = 0,tail = array.length-1;
        
        swap(array,head,merelyMedianOf(array));

        for(int indexBuf = 0;indexBuf != indexToFind;){
            indexBuf = partition(array,head,tail);
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
        while(i < j){

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
    
    private int merelyMedianOf(int[] array){
        int Length = array.length;
        int[] indexs = {0, Length/10, Length*2/10, Length*3/10, Length*4/10, Length*5/10, Length*6/10, Length*7/10, Length*8/10, Length*9/10, Length-1};
        for(int i = 1;i < indexs.length;i++){
            for(int j = i; j > 0 && array[indexs[j]] < array[indexs[j-1]]; j--)
                swap(indexs, j, j-1);
        }
        int mid = indexs[indexs.length/2];
        
        return mid;
    }
    private void swap(int[] array,int indexA,int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}