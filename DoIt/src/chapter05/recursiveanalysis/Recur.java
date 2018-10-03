package chapter05.recursiveanalysis;

import java.util.Scanner;

// 재귀 함수 이해하기
// 하향식 분석
public class Recur {
    // 재귀 함수
    static void recur(int n){
        if(n>0){
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int x = stdIn.nextInt();

        recur(x);
    }
}
