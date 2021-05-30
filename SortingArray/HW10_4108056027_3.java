public class HW10_4108056027_3 extends SortingArray{
    
    int arrayLength;
    final int[] step = {23,8,1}; //Sedgewick, 1982
    final int[] S_step = {16577,4193,1073,281,77,23,8,1};
    public int[] sorting(int[] A_toSort){
        arrayLength = A_toSort.length;
        boolean flag = false;
        int maybe = arrayLength >> 4;
        for(int i = 36;i < maybe;i+=36){
            if(A_toSort[i-36] < A_toSort[i] || A_toSort[arrayLength - i-36] < A_toSort[arrayLength - i]){
                flag = true;
                break;
            }
        }
        if(flag && arrayLength > 37)
            quickSort(A_toSort, 0, arrayLength-1);
        else{
            S_shellSort(A_toSort);
        }
        return A_toSort;
    }
    public void swap(int[] A_toSort,int a,int b){
        int temp = A_toSort[a];
        A_toSort[a] = A_toSort[b];
        A_toSort[b] = temp;
    }
    
    final int CUTOFF = 36;

    public void quickSort(int[] array , int left , int right){
        stack_1a Stack = new stack_1a();
        Stack.push(left);
        Stack.push(right);
        while(Stack.top != -1){
            int Right = Stack.pop();
            int Left = Stack.pop();
            int median = medianOf_3(array,Left,(Left+Right)>>1,Right);
            swap(array,Left,median);
            int pivot = partition(array, Left, Right);
            if((pivot-1) > Left + CUTOFF){
                Stack.push(Left);
                Stack.push(pivot-1);
            }
            else{
                shellSort(array,Left,pivot-1);
            }
            if((pivot+1) + CUTOFF < Right){
                Stack.push(pivot+1);
                Stack.push(Right);
            }
            else{
                shellSort(array,pivot+1,Right);
            }
        }
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


    public class stack_1a {
        int top = -1;
        int[] stack = new int[1000];
        int pop(){
            return stack[top--];
        }
        void push(int value){
            stack[++top] = value;
        }
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

    public void S_shellSort(int[] A_toSort){
        int upperBound = S_step.length;

        int gap,point;
        for(int i = 0;i < upperBound;i++){
            gap = S_step[i];
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