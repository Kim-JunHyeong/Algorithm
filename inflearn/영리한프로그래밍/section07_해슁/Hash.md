#### 해싱

- 해쉬 테이블
  - 해쉬 테이블은 dynamic set(: 탐색과 삽입과 삭제 3가지 연산을 지원하는 자료구조) 을 구현하는 효과적인 방법 중 하나 
  - 해쉬 테이블은 일반적으로 하나의 배열 
  - 해쉬함수라고 불리는 하나의 함수를 이용해서 저장할 키를 어디에 저장할지 계산하는 방법



- 충돌
  두 개 이상의 키가 동일한 위치로 해싱되는 경우
  즉, 서로 다른 두 키 k1 과 k2에 대해서 h(k1) = h(k2)인 상황
  일반적으로 단사함수가 아니므로 충돌이 발생할 수 밖에 없음
  키의 개수가 테이블 사이즈보다 크다면 당연히 충돌이 발생함
  충돌이 발생할 경우 대처 방법 : chaining 과 open addressing

--------------------------------------------------

- chaining 에 의한 충돌 해결
  동일한 장소로 해싱된 모든 키들을 하나의 연결리스트로 저장
  - 키의 삽입
    키 k를 리스트 T[h(k)]의 맨 앞에 삽입 : 시간 복잡도 O(1)
    중복된 키가 들어올 수 있고 *중복 저장이 허용되지 않는다면* 삽입 시 동일한 키가 있는지 리스트를 먼저 검색해야 함. 따라서 시간 복잡도는 *리스트의 길이에 비례* 
  - 키의 검색
    리스트 T[h(k)]에서 *순차검색*
    시간복잡도는 키가 저장된 리스트의 길이에 비례
  - 키의 삭제
    리스트T[h(k)]로 부터 키를 검색 후 삭제
    일단 키를 검색해서 찾은 후에는 O(1) 시간에 삭제 가능
  - 최악의 경우는 모든 키가 하나의 슬롯으로 해싱되는 경우
    길이가 n인 하나의 연결리스가 만들어짐
    따라서 최악의 경우 탐색 시간은 O(n) + 해쉬 함수 계산 시간
    하지만 최악의 경우는 언제나 존재할 수 밖에 없다!!
  - 평균 시간 복잡도는 키들이 여러 슬롯에 얼마나 잘 분배되느냐에 의해서 결정

------------------



- SUHA(Simple Uniform Hashing Assumption)
  - 각각의 키가 모든 슬롯(해쉬 테이블의 각각의 인덱스)들에 균등한 확률로 독립적으로 해싱된다는 가정 --> 성능분석을 위해서 하는 가정(현실에서는 불가능, 해쉬함수는 랜덤함수가 아니고 고정되어야 함), 다른 방법으로는 universal hashing이 있음.(랜덤 키를 선택하는 방법,) but 역시 충분하지 않음
  - 위의 조건이 충족되면 평균 검색 시간은 O(1) 이 된다.

--------------------------------------------------------------------------

- Open Addressing 에 의한 충돌 해결

  - 모든 키를 해쉬 테이블 자체에 저장(기본 개념)

  - 테이블의 각 칸(slot)에는 1개의 키만 저장(기본 개념)

  - Open Addressing의 충돌 해결 기법

    - Linear probing (가장 기본 형태)
      h(k), h(k)+1, h(k)+2 ... 순서로 검사하여 처음으로 빈 슬롯에 저장, 테이블의 끝에 도달하면 다시 처음으로 돌아감(circular하게 )

      > 단점
      >
      > primary cluster : 키에 의해 채워진 연속된 슬롯들
      > 이런 cluster이 생성되면 이 cluster는 점점 더 커질 확률이 높음
      >
      > 새로운 키가 insert 될 때 cluster 가장 밑으로 들어갈 확률이 높아짐
      >
      > 검색 시간이 clusert의 길이에 비례하게 됨(chaining 의 list 의 길이와 비슷)

    Linear probing의 cluster의 단점을 해결하기 위한 직관적인 방법(원초적인 해결 방법은 아님)

    - Quadratic probing
      충돌 발생 시 h(k), h(k)+1^2, h(k)+2^2, h(k)+3^2, ... 순서로 저장(일반적인 형태, 다른 이차함수로의 변형도 가능)
    - Double hashing
      서로 다른 두 해쉬 함수 h1과 h2를 이용 h(k, i) = (h1(k) + i*h2(k)) mod m
      두 번째 해쉬함수는 0이 되어서는 안된다는 규칙이 있다
      키 값에 따라 offset 이 달라진다.	

  - Open Addressing, 키의 삭제
    - 단순히 키를 삭제 할 경우 문제가 발생
      ex) A2, B2, C2가 순서대로 모두 동일한 해쉬함수값을 가져 linear probing으로 충돌을 해결했다면 B2를 삭제 한 후 C2를 검색했을 때 문제가 발생한다.(중간에 값이 비어있어서 C2를 찾지 못함)
    - 따라서 키를 삭제하면 삭제한 이후의 키들을 원래 해쉬값에 맞게 옮겨주어야 한다.
    - ![image1](https://github.com/Kim-JunHyeong/Algorithm/blob/develop/inflearn/%EC%98%81%EB%A6%AC%ED%95%9C%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/section07_%ED%95%B4%EC%8A%81/Open%20Addressing%20-%20%ED%82%A4%EC%9D%98%20%EC%82%AD%EC%A0%9C.PNG)
    
---

- 좋은 해쉬 함수란?

  - 현실에서는 키들이 랜덤하지 않음( SUHA(Simple Uniform Hashing Assumption) -> 이것은 이상이다... )
  - 만약 키들의 통계적 분포에 대해 알고 있다면 이를 이용해서 해쉬 함수를 고안하는 것이 가능하겠지만 현실적으로는 어렵다.
  - 키들이 어떤 특정한 패턴을 가지더라도 해쉬 함수값이 불규칙적이 되도록 하는 것이 바람직하다.
  - 해쉬 함수값이 키의 특정 부분에 의해서만 결정되지 않아야 한다.

- 해쉬 함수

  - Division 기법

    - h(k) = k mod m : 거의 모든 해시함수들이 일반적으로 가장 마지막으로 사용(가장 쉬움)

    > 장점 : 한 번의 mod 연산으로 계산, 빠름
    >
    > 단점 : 어떤 값 m에 대해서는 해쉬 함수값이 키 값의 특정 부분에 의해서 결정되는 경우가 있음. 가령 m=2^x 이면 키의 하위 x비트가 해쉬 함수값이 됨.

  -  Multiplication 기법

    - 0 ~ 1 사이의 상수 A를 선택 : 0 < A < 1
    - key * A의 정수 부분을 버리고 소수 부분만을 택한다.
    - 소수 부분에 m을 곱한 후 소수점 아래를 버린다.

    > ex) m = 8 , word size = w = 5, k = 21,
    >
    > A = 13/32 선택
    >
    > key * A = 21 * 13/32 = 273/32 = 8 + 17/32
    >
    > m(key * A mod 1) = 8 * 17/32 = 17/4 = 4.xxxx
    >
    > 즉, h(21) = 4
    >
    > > - 장점
    > >
    > > 키들이 불규칙하고 예측 불가능하게 만듦
    > >
    > > 키의 특정 부분에 의해서 결정되지 않음
    >
    > - >



---

- Hash code in java

  - 자바는 언어 차원에서 hash를 체계적으로 지원해줌(chaining으로 충돌을 해결하고 있음) -> Object 클래스가 hashCode() 메서드를 가짐

  - 또는 HashMap, HashSet 등을 자바에서는 제공해주고 있다.

  - 결국 자바에서는 모든 클래스가 hashCode() 메서드를 상속받는다. 이 메서드는 하나의 32비트 정수를 반환한다(32비트이므로 음수일 수도 있다)

  - x.equals(y)이면 x.hashCode() == y.hashCode() 하지만 역은 성립하지 않는다.

  - 필요에 따라 각 클래스마다 이 메서드를 override 하여 사용한다.

    > ex) Integer 클래스는 정수값을 hashCode로 사용
    >
    > ex) String
    >
    > ``` java
    > public final class String{
    >     private final char[] s;
    >     
    >     public int hashCode(){
    >         int hash = 0;
    >         for(int i = 0; i < lenght(); i++)
    >             hash = s[i] + 31 + (31 * hash);
    >         return hash;
    >     }
    > }
    > ```
    >
    > h(s) = 31^(L-1) * s0 + ..... + 
    > String = s0 s1 s2 ... sL-1 -> 31진수
    > ​		길이가 L
    >
    >
    > ex) 사용자 정의 클래스
    >
    > ```java
    > public class Record{
    >     private String name;
    >     private int id;
    >     private double value;
    >     
    >     public int hashCode() {
    >         int hash = 17;
    >         hash = 31*hash + name.hashCode();
    >         hash = 31*hash + Integer.valueOf(id).hashCode();
    >         hash = 31*hash + Double.valueOf(value).hashCode();
    >         return hash;
    >     }
    > }	// 모든 멤버들을 사용하여 hashCode를 생성한다.
    > ```
    >
    > ex) HashSet
    >
    > ```java
    > HashSet<MyKey> set = new Hashset<MyKey>();
    > set.add(MyKey);
    > if(set.contains(theKey)){	// 어떠한 원소가 있는지 검사하는 메서드 contains
    >     ...
    > }
    > int k = set.size();	// 집합 원소의 개수
    > set.remove(theKey);	// 집합 원소 제거
    > Iterator<MyKey> it = set.iterator();
    > while(it.hasNext()){
    >     MyKey key = it.next();
    >     if(key.eequals(aKey))
    >         it.remove();
    > }
    > ```
    >
    >

- hashCode와 hash 함수

  - Hash Code : 임의의 32비트 정수(음수일 수 있다.)
  - Hash 함수 : 배열의 크기가 정해졌을 때 Hash Code를 사용함.
