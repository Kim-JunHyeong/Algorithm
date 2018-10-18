package doit.chapter05.recursive;

import java.util.Scanner;

public class Question03 {
    static int gcdArray(int[] a, int start, int n){
        /* 정답 확인 시 있던 코드, 하지만 n 값은 이미 2 이상만 받을 수 있도록 반복문을 구현해둠
        if (n == 1)
			return a[start];
         */
        if (n == 2)
            return EuclidGCD.gcd(a[start], a[start + 1]);
        else
            return EuclidGCD.gcd(a[start], gcdArray(a, start + 1, n - 1));
    }

    public static void main(String[] args){
        int n = 0;                  // 입력받을 정수의 값
        Scanner stdIn = new Scanner(System.in);
        System.out.print("입력할 정수의 개수 n(2 이상만 가능)\nn : ");
        while(n <= 1){
            n = stdIn.nextInt();
        }

        int[] x = new int[n];       // 크기가 n인 배열

        for(int i = 0; i < n ; i++){
            System.out.print("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        System.out.println("최대 공약수는 " + gcdArray(x, 0, n) + "입니다.");
    }
}
