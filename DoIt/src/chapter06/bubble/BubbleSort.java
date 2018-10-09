package chapter06.bubble;

import java.util.Scanner;

// 버블 정렬 (ver.1)
public class BubbleSort {
    //a[idx1] 과 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2){  // 좌측의 값을 우측의 값과 교환
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    // 버블 정렬 (뒤에서 부터)
    static void bubbleSort(int[] a, int n){
        for(int i = 0 ; i < n - 1 ; i++){       // n-1번 반복
            for(int j = n - 1 ; j > i ; j--)    // n-1번째 요소부터 0번째 요소까지 뒤에서 부터 비교(패스)
                if(a[j-1] > a[j])               // 좌측의 값이 더 크면 교환
                    swap(a, j - 1, j);
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(ver.1)");
        System.out.print("요소의 개수 :");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0 ; i < nx ; i++){
            System.out.print("x[" + i + "] :");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);      // 버블 정렬

        System.out.println("오름차순으로 정렬");
        for(int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] =" + x[i]);
    }
}
