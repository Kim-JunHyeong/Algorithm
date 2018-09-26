package chapter04.stack;

import java.util.Scanner;

//int형 스택의 사용
public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack stk = new IntStack(64);  // 최대 64개를 푸시할 수 있는 스택 생성

        while (true) {
            System.out.println("현재 데이터 수 : " + stk.size() + " / " + stk.capacity());    // (현재 데이터 수/스택 용량)
            System.out.println("(1)push (2)pop (3)peek (4)dump (0)exit : ");

            int munu = stdIn.nextInt(); // nextInt : 띄어쓰기를 기준으로 정수형으로 읽어오는 메서드
            if (munu == 0) break;

            int x = 0;
            switch (munu) {
                case 1:     // push
                    System.out.println("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        stk.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:     // pop
                    try {
                        x = stk.pop();
                        System.out.println("pop한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:     // peek
                    try {
                        x = stk.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:     // dump
                    stk.dump();
                    break;
            }
        }
    }
}