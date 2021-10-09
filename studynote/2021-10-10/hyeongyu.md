# 7

- ch6 에서는 polymorphically하게 코드를 수정함. 그러나 아직 conditional logic은 존재하고 있음
- 이번 단원에서는 factory를 개선함

# 7.1

- factory 함수(for함수)는 아직 conditional이 존재하고, shameless green과 유사함.
- 그러나 이전 shameless green과는 다른 점이 존재함. factory함수는 무엇을 할 지는 모르지만, 누가 나머지 일을 할 것인지는 알고 있음. -> break them apart햇음

# 7.2

- 팩토리는 새로운 변종에 대해 열려있을 수 도 있고 닫힐 수도 있다.
- 변종의 로직은 팩토리가 가질 수 도 있고, 변종 클래스가 가질 수도 있다.
- 팩토리의 역할은 어떤 클래스가 elgible한지 알아야 한다.

# 7.3

- 팩토리를 open시키기(하드코딩된 conditional 삭제)
- Dynamic 하게 클래스 이름은 계산하기 -> 지원하지 않는 언어는?
- 단점이 많음.. 항상 convention을 따라야 하고(이걸 프로그래머가 외워야 함) exceptional control flow를 필요로 하게 됨

# 7.4

- key-value를 등록하여 클래스를 생성
- 말장난 아닌가..? 이게 conditional과 머가 다른것이지?

# 7.5

- 클래스를 선택하는 로직을 분리하기
- factory내부에서 어떤 클래스를 생성할 지 선택하지 않음. 생성의 대상이 되는 클래스들에 canHandle함수를 추가하기
- 아직 factory에서 생성 대상이 되는 클래스들을 들고 있어야함(그 클래스의 canHandle함수를 호출해야하니까..)

# 7.6

- Base class에 registry를 만들고 거기에 자식 클래스들을 "등록"하기
- 팩토리에서는 등록된 클래스들 중 가장 적절한 클래스를 선택하는 것이므로 새로운 클래스가 추가될 때 수정할 필요가 없게 됨
