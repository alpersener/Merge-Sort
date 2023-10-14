package Sorting.MergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        arr=mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    //array döndürüldüğü için int[] array şeklinde verilir.
    static int[] mergeSort(int[] arr){
        //1 tane kalınca array'i döndür.
        if(arr.length==1)
            return arr;
        int mid=arr.length/2;
        //0 dan mide kadar left array olarak alıp yeni bir arrayi copy işlemi yaparız aynı değerler ancak farklı bir obje oluşturmuş olduk
        int[] left=mergeSort(Arrays.copyOfRange(arr,0,mid));

        int[] right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length ));

        return merge(left,right);



    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix=new int[first.length+second.length];
        int i=0; //ilk array için pointer
        int j=0; //ikinci array için pointer
        int k=0; //ikisinin birleşmiş hali olan yeni array için

        while(i<first.length && j<second.length){ //array'i sonuna kadar gezmesi için(array size aynı olursa ama ?)
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        /*
        array'lerden bir tanesini daha tamamlanmadıysa(örneğin ilk array[1,2,3] ikinci array[5,7,4,9,11]
        yukarıda ikinci array'de 9 ve 11 açıkta kaldı bunların direkt olarak mixlenmiş array'e eklenmesi gerekiyor.ya da
        aynısı 1.array için olsa gibi iki ihtimali de aşağıdaki gibi ekliyoruz
        */
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;


    }

}
