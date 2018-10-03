package chapter05.hanoitop;

import java.util.Scanner;

// 하노이 탑
public class Hanoi {
    // n개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int n, int x, int y){
        if(n>1)
            move(n-1, x, 6-x-y);

        System.out.println("원반[" + n + "] 을 " + x + "기둥에서 " + y +"기둥으로 옮김");

        if(n>1)
            move(n-1, 6-x-y, y);
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);      // 1번 기둥의 n개의 원반을 3번 기둥으로 옮김
    }
}
