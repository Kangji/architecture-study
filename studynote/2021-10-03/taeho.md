# 6. Achieving Openness

코드가 확장에 열려있는지 궁금하다면 직접 확장을 해보자. 쉽게 할 수 있다면 열려 있는 것이다.

## 6.1. Consolidating Data Clumps

조건문을 최대한 없애자. 그러면 코드가 더 이해하기 쉬워지고 유지보수하기도 쉬워진다.

`bottle_number.quantity` 가 3번 반복된다. data clump code smell이 난다. 이 data clump code smell은 data 관련한 code smell로, 같은 데이터 필드가 3번 이상 반복되는 경우를 의미한다. 이렇게 data clump가 있다는 것은 이 clump를 수신하는 메소드가 쉽게 clump management logic에 오염될 수 있음을 인지하자. 중복을 유지하기 힘들 뿐만 아니라 에러와 혼란을 가져다 온다.

quantity + container 의 형식을 갖고 있으므로 이 2개를 하나로 묶자! 이렇게 묶게 되면 아래와 같이 Data Clump가 사라진다.

to_s (python 에서는 "__str __" 함수) 를 사용하여 이  (quantity, container) 페어를 전부 없앴다. ver method가 훨씬 간단해졌지만 여전히 하나 이상의 responsibility를 갖고 있다. 함수 사이에 blank line이 들어가있는 것이 이거를 의미한다.

## 6.2. Making Sense of Conditionals

BottleNumber에 있는 함수들이 전부 number에 의존적인 함수들이다.

object에 dependency를 주입하고 조건부로 동작을 제공하는 대신, injected object에 메시지를 전달하자.

**Replace Conditional with State/Strategy**

**Replace Conditional with Polymorphism**

2가지 전략이 존재한다.

**Replace Conditional with State/Strategy**

- 분기를 새롭고 작은 개체로 분산시킴으로써 분기를 제거한다

**Replace Conditional with Polymorphism**

- 조건의 기본값을 보유할 하나의 클래스를 만들고 각 특수화에 대한 하위 클래스를 추가하여 조건 제거

디자인을 많이 해봐야 디자인에 대한 직관이 생긴다.

## 6.3. Replacing Conditionals with Polymorphism

다형성을 갖는 코드를 만들자. BottleNumber 의 존재를 Bottle 클래스에서 모르게 하자.

현재는 Flocking Rules 과 Extract Class refactoring이 반영되어있다.

분기를 없애기 위해서 디폴트 부모 클래스를 만들고 분기 조건에 해당하는 자식 클래스를 만들자. one-line change를 유지하자.

자식 클래스와 부모클래스를 만들면 상황에 따라 올바른 클래스를 호출해주는 팩토리 함수가 있어야 한다.

컨디션에 따라 적합한 클래스를 호출하자.

팩토리는 다형성 객체를 호출한다. 여러 객체는 모두 같은 역할을 수행하며 어떻게 수행하는지는 세부적으로 다르다. 팩토리를 호출했을 때 어떤 객체가 반환되는지 알 필요가 없다. 

dependency를 최대한 없애자. 코드끼리 dependency를 최대한 줄여야 향후 협업이 쉽다.

### Recipe's steps:

1. Create a subclass to stand in for the value upon which you switch.
    1. Copy one method that switches on that value into the subclass.
    2. In the subclass, remove everything but the true branch of the conditional.
        1. *At this point, create a factory if it does not yet exist, and*
        2. *Add this subclass to the factory if not yet included.*
    3. In the superclass, remove everything but the false branch of the conditional.
    4. Repeat steps a-c until all methods that switch on the value are dispersed.
2. Iterate until a subclass exists for every different value upon which you switch.

## 6.4. Transitioning Between Types

Liskov Subsititution Principle 을 지키자. successor 함수는 같은 객체를 반환해야 한다. 이 정보를 모두가 알아야 하기 때문에 의존성을 유발한다.

팩토리의 위치를 변경하자.

echo chamber effect를 피할 수 있다. ex. bottleNumber.bottle_number_for 함수

함수 이름이 어떤 것에 종속적이라면 그것과 더 긴밀하게 만들고 함수 이름을 변경하자.

다형성은 그 객체가 무엇인지 확인하지 않고 메소드를 호출할 수 있어야 한다. 반드시 명심하자.

successor 같은 함수는 함수명에 맞게 숫자가 아닌 그 객체를 반환해야 한다.

## 6.5. Making the Easy Change

이제 리팩토링을 다 했으니 six-pack requirement 도입을 해보자. 기존에 만든 test 함수를 사용한다.

한번에 하나씩 바꿔가면서 test 에 통과하도록 변경한다. 리팩토링을 깔끔하게 했으므로 쉽게 변경할 수 있다.