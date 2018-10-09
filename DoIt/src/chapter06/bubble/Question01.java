package chapter06.bubble;

import java.util.Scanner;

// 비교 교환 연산을 왼쪽부터 실행하기
public class Question01 {
    // 오름차순 교환 연산
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    // 버블 정렬 (좌측부터)
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {    // n-1번 반복
            for (int j = 0; j < n - 1; j++)  // 요소 비교
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
        }// for
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("버블 정렬, 요소의 개수 :");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++){    // 배열의 요소 값 저장
            System.out.print("x[" + i + "] :");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);      // 버블 정렬, 오름차순

        System.out.println("버블 정렬, 오름차순");
        for(int i = 0; i < nx; i++)    // 정렬 내용 출력
            System.out.println("x[" + i + "] =" + x[i]);

    }
}