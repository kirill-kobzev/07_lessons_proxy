package proxy;

import java.util.Random;

public class GenerateArray {

    private int size;

    public int[] GenerateArray(int size) {

        this.size = size;
        int[] array = new int[size];
        Random random = new Random();
        boolean bool = false;
        int arr;

        for(int i = 0; i <size; i++ ){

            arr = random.nextInt(size*size);

            for (int j = 0; j <i+1; j++ ){
                if(array[j] == arr){
                    bool = true;
                }
            }

            if(bool != true){
                array[i] = arr;
                bool = false;
            }else{
                arr = random.nextInt(size*size);
                bool = false;
                i = i -1;
            }

        }

        return array;

    }

}
