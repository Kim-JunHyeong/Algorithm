package doit.chapter09.linkedlist;

import java.util.Comparator;
// 연결 리스트 클래스

public class LinkedList<E> {
    // 노드
    class Node<E> {             // 이런 클래스 구조를 자기 참조형(self-referential) 이라 함.
        // 제네릭으로 구현되므로 E는 임의의 클래스형이 허용된다.
        private E data;         // 데이터
        private Node<E> next;   // 뒤쪽 포인터(다음 노드 참조)

        // 생성자
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;       // 머리 노드
    private Node<E> crnt;       // 선택 노드

    // 생성자
    public LinkedList() {        // 비어있는 연결 리스트 생성
        head = crnt = null;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;     // 현재 스캔 중인 노드

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {  // 검색 성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;         // 다음 노드를 선택
        }
        return null;                // 검색 실패
    }

    // 머리에 노드 삽입
    public void addFirst(E obj){
        Node<E> ptr = head;         // 삽입 전의 머리 노드
        head = crnt = new Node<E>(obj, ptr);
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null)           // 리스트가 비어 있으면
            addFirst(obj);          // 머리에 삽입
        else{
            Node<E> ptr = head;
            while(ptr.next != null)
                ptr = ptr.next;     // while문 종료 시, ptr은 꼬리 노드를 가리킨다.
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    // 머리 노드를 삭제
    public void removeFirst(){
        if(head != null)
            head = crnt = head.next;
    }

    // 꼬리 노드를 삭제
    public void removeLast(){
        if (head != null){
            if(head.next == null)       // 노드가 하나만 있으면
                removeFirst();          // 머리 노드를 삭제
            else{
                Node<E> ptr = head;     // 스캔 중인 노드
                Node<E> pre = head;     // 스캔 중인 노드의 앞쪽 노드

                while (ptr.next != null){
                    pre = ptr;
                    ptr = ptr.next;
                }   // while 문 종료 시, ptr은 꼬리 노드를 가리키고 pre는 꼬리로부터 두 번째 노드를 가리킨다.
                pre.next = null;        // pre는 삭제 후의 꼬리 노드
                crnt = pre;
            }
        }
    }

    // 노드 p를 삭제
    public void remove(Node p){
        if(head != null){
            if(p == head)               // p가 머리 노드면
                removeFirst();          // 머리 노드를 삭제
            else{
                Node<E> ptr = head;

                while (ptr.next != p){
                    ptr = ptr.next;
                    if(ptr ==null) return;  // p가 리스트에 없다
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    // 선택 노드 삭제
    public void removeCurrentNode(){
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear(){
        while (head != null)        // 노드에 아무것도 없을 때까지
            removeFirst();          // 머리 노드를 제거
        crnt = null;
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next(){
        if(crnt == null || crnt.next ==null)
            return false;           // 이동할 수 없음
        crnt = crnt.next;
        return true;
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if(crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    // 모든 노드 출력
    public void dump(){
        Node<E> ptr = head;

        while(ptr != null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}

/*
- String 의 문자열 비교
    1. equals() 메소드   : 특정 문자열과 지정된 객체를 비교(인증)
    2.       ==         : 값이 아닌 참조를 비교(참조매핑)
    3.   compareTo      : 문자열의 사전적인 값을 비교(분류)
        만약 s1, s2라는 문자열이 있다면 s1.compareTo(s2)를 했을 시
        s1 == s2 : 0
        s1 > s2 : 긍정값 (1)
        s1 < s2 : 부정값 (-1)

- compare() 와 compareTo()에 대해 알아보기
- Comparator<? super E> 이것은 무엇인가??
- Java 제네릭 복습하기
 */

