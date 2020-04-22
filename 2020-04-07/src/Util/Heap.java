package Util;

public class Heap {
    final int DefaultCapacity = 10;
    int[] array = new int[DefaultCapacity];
    int size = 0;

    public Heap(int Capacity){
        array = new int[Capacity];
    }

    public Heap(){

    }

    public int size(){
        return size;
    }

    public void clear(){
        size = 0;
    }

    public void add(int element){
        array[size++] = element;
        siftUp(size - 1);

    }
    public int remove(){
        array[0] = array[size - 1];
        size --;
        siftDown(0);
        return 0;
    }

    public int get(){
        return array[0];
    }

    public void replace(int element){
        array[0] = element;
        siftDown(0);
    }

    private void siftUp(int index){
        int temp = 0;
        while(index > 0) {
            temp = (index - 1) / 2;
            if(array[index] <= array[temp]){
                exchange(index, temp);
                index = temp;
            }else{
                break;
            }
        }

    }

    private void siftDown(int index){
        int left_index = 0;
        int right_index = 0;
        int temp = 0;
        while(true) {
            left_index = 2 * index + 1;
            right_index = 2 * index + 2;
            temp = max(left_index, right_index);
            if (temp != -1 && array[index] > array[temp]) {
                exchange(index, temp);
                index = temp;
            }else{
                break;
            }
        }
    }
    private void exchange(int index1, int index2){
        int temp = 0;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private int max(int index1, int index2){
        if(index1 >= size -1){
            if(index2 >= size -1)
                return -1;
            else
                return index2;
        }
        else if (index2 >= size - 1)
            return index1;
        else
            return array[index1] < array[index2] ? index1 : index2;
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }

}
