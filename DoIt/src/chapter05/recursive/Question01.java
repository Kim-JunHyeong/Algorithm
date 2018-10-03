package chapter05.recursive;

import java.util.Scanner;

// 재귀호출 미사용 factorial 작성
public class Question01 {
    public static void main(String[] args){
        int fac = 1;

        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수 입력 : "); int num = stdIn.nextInt();
        System.out.print(num + "! = ");
        while(num > 0){
            fac = fac * num;
            num--;
        }
        System.out.print(fac);
    }
}
