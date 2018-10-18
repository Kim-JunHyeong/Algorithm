package doit.chapter04.stack;

import java.util.Scanner;

public class Question3Test {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Question3 stk = new Question3(3);

        while (true) {
            System.out.println();
            System.out.println("A 스택의 현재 데이터 수 : " + stk.sizeA() + " / " + stk.capacityA());
            System.out.println("B 스택의 현재 데이터 수 : " + stk.sizeB() + " / " + stk.capacityB());
            System.out.println("(1)A push (2)A pop (3)A peek \n" +
                    "(4)B push (5) B pop (6)B peek \n" +
                    "(8)clear (9)dump (0)exit");
            System.out.print("메뉴를 선택하세요 : ");
            int menu = stdIn.nextInt();
            if (menu == 0) break;       // exit

            int x = 0;
            switch (menu) {
                case 1:     // A, push
                    System.out.print("A, 데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        stk.pushA(x);
                    } catch (Question3.OverflowQuestion3Exception e) {
                        System.out.println("A 스택이 가득 찼습니다.");
                    }
                    break;

                case 2:     // A, pop
                    try {
                        x = stk.popA();
                        System.out.println("A, pop한 데이터 : " + x);
                    } catch (Question3.EmptyQuestion3Exception e) {
                        System.out.println("A 스택이 비어 있습니다.");
                    }
                    break;

                case 3:     // A, peek
                    try {
                        x = stk.peekA();
                        System.out.println("A, peek한 데이터 : " + x);
                    } catch (Question3.EmptyQuestion3Exception e) {
                        System.out.println("A 스택이 비어 있습니다.");
                    }
                    break;

                case 4:     // B, push
                    System.out.print("B, 데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        stk.pushB(x);
                    } catch (Question3.OverflowQuestion3Exception e) {
                        System.out.println("B 스택이 가득 찼습니다.");
                    }
                    break;

                case 5:     // B, pop
                    try {
                        x = stk.popB();
                        System.out.println("B, pop한 데이터 : " + x);
                    } catch (Question3.EmptyQuestion3Exception e) {
                        System.out.println("B 스택이 비어 있습니다.");
                    }
                    break;

                case 6:     // B, peek
                    try {
                        x = stk.peekB();
                        System.out.println("B, peek한 데이터 : " + x);
                    } catch (Question3.EmptyQuestion3Exception e) {
                        System.out.println("B 스택이 비어 있습니다.");
                    }
                    break;

                case 8:     // clear
                    stk.clear();
                    break;

                case 9:     // dump
                    stk.dump();
                    break;
            }
        }
    }
}
