package doit.chapter05.recursive;

import java.util.Scanner;

// 재귀 호출 미사용 유클리드 호제법 작성
public class Question02 {
    public static void main(String[] args){
        int gcd;
        int x;
        int y;
        int tmp;

        Scanner stdIn = new Scanner(System.in);

        System.out.println("최대 공약수 구하기");
        System.out.print("정수 입력 : ");   x = stdIn.nextInt();
        System.out.print("정수 입력 : ");   y = stdIn.nextInt();

        while(true){
            if(y == 0){
                gcd = x;
                break;
            }else{
                tmp = x;
                x = y;
                y = tmp % y;
            }
        }   // while
        System.out.println("최대 공약수 : "+ gcd);
    }
}
