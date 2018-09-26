package chapter04.stack;

// int형 스택
public class IntStack {
    private int max;    // 스택 용량
    private int ptr;    // 스택 포인터
    private int[] stk;  // 스택 본체

    // 실행 시 예외 : 스택이 비어있음.
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    // 실행 시 예외 : 스택이 가득 참.
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    // 생성자
    public IntStack(int capacity) {      // capacity : 용량, 수용력
        ptr = 0;                        // 처음 스택을 생성하면 스택은 비어있음
        max = capacity;                 // 전달받은 값을 스택의 용량으로 설정
        try {
            stk = new int[max];         // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {    // 생성에 실패하면 max의 값을 0으로
            max = 0;                    // why? 다른 메서드가 존재하지 않는 배열에 잘못 접근하는 것을 막기 위
        }
    }

    // 스택에 데이터를 푸시
    // ptr은 포인터 변수를 의미하는 것이 아니고 삽입할 인덱스를 기억하는 용도로 사용하는 변수임, 스택의 인덱스를 가르킨다는 의미
    public int push(int x) throws OverflowIntStackException {
        if (ptr == max)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    // 스택에서 정상에 있는 데이터를 팝(제거)하고 그 값을 반환하는 메서드
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)        // 스택이 비어 있다면 팝을 할 수 없음
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // 스택에서 정상에 있는 데이터를 피크(엿보다)하는 메서드
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)        // 스택이 비어있음
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // 검색 메서드(값을 찾아 인덱스 반환, 없으면 -1 반환)
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--)  // 위에서 부터 선형 검색
            if (stk[i] == x)
                return i;   // 검색 성공
        return -1;          // 검색 실패
    }

    // 스택의 모든 요소를 삭제하는 메서드
    public void clear() {
        ptr = 0;
    }

    // 용량을 확인하는 메서드
    public int capacity() {
        return max;
    }

    // 데이터 수를 확인하는 메서드
    public int size() {
        return ptr;
    }

    // 스택이 비어 있는지 검사하는 메서드
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는지 검사하는 메서드
    public boolean isFull() {
        return ptr >= max;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
