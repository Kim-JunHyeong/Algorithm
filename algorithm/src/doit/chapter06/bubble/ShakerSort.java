package doit.chapter06.bubble;

import java.util.Scanner;

class ShakerSort_06_05 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 양방향 버블정렬(셰이커정렬)
    static void shakerSort(int[] a, int n) {
        int left = 0;
        int right = n - 1;
        int last = right;

        while (left < right) {
            for (int j = right; j > left; j--) {    // 우측->좌측으로 비교, 오름차순
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;                       // 마지막 교환이 수행된 위치를 저장
                }
            }
            left = last;

            for (int j = left; j < right; j++) {    // 마지막 교환이 수행된 좌측의 위치부터 초기 우측값으로 값을 비교해 나
                if (a[j] > a[j + 1]) {
                   swap(a, j, j + 1);
                    last = j;                      // 역시 마지막 교환이 수행된 위치를 저장
                }
            }
            right = last;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("양방향 버블정렬(셰이커정렬)");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        shakerSort(x, nx); // 배열 x를 양방향 버블정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}