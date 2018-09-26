package chapter04.queue;

// 큐의 대표적인 특징 : 선입선출(First In First Out)
// 배열의 요소를 옮기는 큐의 문제를 해결하기 위해 링 버퍼로 큐를 만든다.
public class IntQueue {
    private int max;    // 큐의 용량
    private int front;  // 첫 번째 요소
    private int rear;   // 마지막 요소
    private int num;    // 현재 데이터 수
    private int[] que;  // 큐 본체

    // 실행 시 예외 : 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){}
    }
    // 실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }

    //생성자
    public IntQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[max];     // 큐 본체용 배열을 생성
        }catch(OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // 큐에 데이터를 인큐
    public int enque(int x) throws OverflowIntQueueException{
        if(num>=max)
            throw new OverflowIntQueueException();  // 큐가 가득 참
        que[rear++] = x;    // 데이터를 인큐하고 rear과 num을 1씩 증가
        num++;
        if(rear == max)     // 만약 rear의 값이 max값과 같다면 종료가 되어버리기 때문에 rear를 0으로 변경해준다.
            rear = 0;
        return x;
    }

    // 큐에서 데이터를 디큐
    public int deque() throws EmptyIntQueueException{
        if(num<=0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if(front == max)    // front의 값이 max와 같아지더라도 배열의 처음 위치인 que[0]의 위치에서 데이터를 꺼낼 수 있어야 함
            front = 0;
        return x;
    }

    // 큐에서 데이터를 피크(프런트 데이터)
    public int peek() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();     // 큐가 비어 있다면..
        return que[front];
    }

    // 큐에서 x를 검색하여 인덱스를 반환(찾지 못하면 -1)
    public int indexOf(int x){
        for(int i = 0; i<num; i++){         // i   = 0->1->2->3 ->4->5->6->7
            int idx = (i + front) % max;    // idx = 7->8->9->10->11->0->1->2
            if(que[idx] == x)       // 검색에 성공했다면..
                return idx;
        }
        return -1;
    }

    // 큐를 비움
    public void clear(){
        num = front = rear = 0;
    }

    // 큐의 용량을 반환
    public int capacity(){
        return max;
    }

    // 큐에 쌓여 있는 데이터 수를 반환
    public int size(){
        return num;
    }

    // 큐가 비어 있는지 확인
    public boolean isEmpty(){
        return num <= 0;
    }

    // 큐가 가득 찼는지 확인
    public boolean isFull(){
        return num >= max;
    }

    // 큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
    public void dump(){
        if(num<=0){
            System.out.println("큐가 비어 있습니다.");
        }
        for(int i = 0; i<num; i++)
            System.out.print(que[(i+front)%max] + " ");
        System.out.println();
    }
}
