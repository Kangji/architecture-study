# 7. Manufacturing Intelligence

## 7.1. Contrasting the Concrete Factory with Shameless Green

- 현재 코드의 문제점 : conditional이 hard-coding 되어 있음
- 그러나 shamless green 코드와 비교하면 behavior의 conditional 과 select object의 conditional의 차이가 있음

## 7.2. Fathoming Factories

- OOP 는 다형성에 의존한다. 다형성은 여러 클래스가 같은 롤을 맡는 것이다.

Factories vary along these dimensions:

1. The factory can be open to new variants or closed.

2. The logic that chooses a variant can be owned by the factory or by the variant.

3. The factory can be responsible for knowing/figuring out which classes are eligible to be
manufactured or the variants can volunteer themselves.

## 7.3. Opening the Factory

현재 팩토리는 확장에 열려있지 않다. 하드코딩된 조건을 갖고 있다.

number에 따라 정해진 클래스를 호출하도록 변경하자. (Meta Programmed Class Lookup Factory)

const_get 메소드가 파이썬에도 있는지 궁금하다.

현 코드의 문제점:

1. 이해하기 어렵다.
2. BottleNumber 클래스를 명시적으로 호출하지 않는다.
3. 익셉션이 발생한다.
4. 컨벤션을 만족하지 않는 클래스는 무시한다.

## 7.4. Supporting Arbitrary Class Names

dictionary로 class를 관리하자.

## 7.5. Dispersing The Choosing Logic

factory에서 클래스와 분기를 매칭하지 말고 클래스에서 핸들가능한지 여부를 판단하자.

## 7.6. Self-registering Candidates

여전히 candidate class 리스트는 하드코딩해야 한다. 새로운 클래스 추가를 쉽게 할 수 있도록 구현해보자.

BottleNumber에 후보 클래스들을 등록할 수 있는 static variable을 만들자. 이 클래스를 상속받는 자식클래스에서는 반드시 이 variable에 자신을 등록해야 한다. 이런 구조가 되면 새로운 클래스 추가가 쉬워진다.

## 7.7.  Auto-registering Candidates

여전히 문제가 남아있다. bottlenumber0에서 bottlenumber를 상속받지만 등록하지 않을 수 있다는 점이다. bottlenumber를 상속받는 모든 클래스가 반드시 등록할 수 있도록 bottlenumber클래스에서 모든 자식클래스를 registry에 등록하도록 하자.