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

