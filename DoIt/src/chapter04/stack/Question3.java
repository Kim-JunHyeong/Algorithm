package chapter04.stack;

// 하나의 배열을 공유하여 2개의 스택을 구현하는 int형 데이터용 스택 클래스 작성
public class Question3 {
    private int max;
    private int maxA;
    private int maxB;
    private int ptrA;
    private int ptrB;
    private int[] stk;

    // 실행 시 예외 : 스택이 비어 있음.
    public class EmptyQuestion3Exception extends RuntimeException {
        public EmptyQuestion3Exception() {
        }
    }

    // 실행 시 예외 : 스택이 가득 참.
    public class OverflowQuestion3Exception extends RuntimeException {
        public OverflowQuestion3Exception() {
        }
    }

    // 생성자
    public Question3(int capacity) {
        ptrA = 0;
        ptrB = capacity - 1;
        max = capacity;
        maxA = max;
        maxB = 0;

        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
            maxA = 0;
            maxB = 0;
        }
    }

    // A 스택에 데이터를 푸시
    public int pushA(int x) throws OverflowQuestion3Exception {
        if (ptrA == maxA)
            throw new OverflowQuestion3Exception();
        maxB += 1;      // B 스택 데이터 저장 공간이 줄어듬
        return stk[ptrA++] = x;
    }

    // B 스택에 데이터를 푸시
    public int pushB(int x) throws OverflowQuestion3Exception {
        if (ptrB == (maxB-1))
            throw new OverflowQuestion3Exception();
        maxA -= 1;      // A 스택 데이터 저장 공간이 줄어듬
        return stk[ptrB--] = x;
    }

    // A 스택에 있는 데이터 팝
    public int popA() throws EmptyQuestion3Exception {
        if (ptrA <= 0)
            throw new EmptyQuestion3Exception();
        maxB -= 1;      // B 스택 데이터 저장 공간이 늘어남
        return stk[--ptrA];
    }

    // B 스택에 있는 데이터 팝
    public int popB() throws EmptyQuestion3Exception {
        if (ptrB >= (max-1))
            throw new EmptyQuestion3Exception();
        maxA += 1;      // A 스택 데이터 저장 공간이 늘어남
        return stk[++ptrB];
    }

    // A 스택에 있는 데이터 피크
    public int peekA() throws EmptyQuestion3Exception {
        if (ptrA <= 0)
            throw new EmptyQuestion3Exception();
        return stk[ptrA - 1];
    }

    // B 스택에 있는 데이터 피크
    public int peekB() throws EmptyQuestion3Exception {
        if (ptrB >= (max-1))
            throw new EmptyQuestion3Exception();
        return stk[ptrB + 1];
    }

    // A 스택 검색 메서드
    public int indexOfA(int x) {
        for (int i = ptrA - 1; i >= 0; i--)
            if (stk[i] == x)
                return i;
        return -1;
    }

    // B 스택 검색 메서드
    public int indexOfB(int x) {
        for (int i = ptrB + 1; i <= max; i++)
            if (stk[i] == x)
                return i;
        return -1;
    }

    // A 스택의 데이터 수를 확인하는 메서드
    public int sizeA(){
        return ptrA;
    }
    // B 스택의 데이터 수를 확인하는 메서드
    public int sizeB(){
        return max - 1 - ptrB;
    }

    // A 스택의 용량 확인 메서드
    public int capacityA(){
        return maxA;
    }
    // B 스택의 용량 확인 메서드
    public int capacityB(){
        return max - maxB;
    }

    // 모든 스택의 내용을 비움
    public void clear(){
        ptrA = 0;
        ptrB = max - 1;
        maxA = max;
        maxB = 0;
    }

    // 스택 안의 모든 데이터를 bottom부터 출력
    public void dump(){
        if(ptrA <= 0)
            System.out.println("A 스택이 비어 있습니다.");
        else{
            System.out.print("A 스택 : ");
            for(int i = 0 ; i < ptrA ; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
        if(ptrB >= max)
            System.out.println("B 스택이 비어 있습니다.");
        else{
            System.out.print("B 스택 : ");
            for(int i = max - 1; i > ptrB ; i--)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
