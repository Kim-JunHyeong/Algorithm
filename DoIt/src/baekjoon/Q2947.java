package baekjoon;

import java.util.Scanner;

// 나무조각 문제(버블 정렬)
public class Q2947 {
    public static void main(String[] args) throws Exception {
        Scanner stdIn = new Scanner(System.in);

        int[] arr = new int[5];

        for(int n = 0; n < 5; n++)
            arr[n] = stdIn.nextInt();

        bubbleSort(arr);
    }

    static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void bubbleSort(int[] arr){              // 값 버블 정렬
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1; j++)
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    printarr(arr);                  // 교환이 일어날 때만 배열 출력
                }
        }
    }

    static void printarr(int[] arr){         // 배열 출력
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}


