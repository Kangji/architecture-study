# 8. Developing a Programming Aesthetic

99 bottle이 아닌 다른 가사에 대해서 얼마나 표현할 수 있는가?  

Bottle, BottleVerse를 분리하고 dependency를 최소화하자.  
Bottle 안에 verse가 있던 것을 extract 하자.  
이렇게 되면 verse에 따라 다르게 구현이 가능해진다.  

### Dependency Inversion Principle  

1. High-level modules should not depend upon low-level modules. Both should depend upon abstractions.  
2. Abstractions should not depend upon details. Details should depend upon abstractions.

### Law of Demeter

For all classes C and for all methods M attached to C, all objects to which M sends a message must be instances of classes associated with the following classes:
1. The argument classes of M (including C). 
2. The instance variable classes of C.


### Summary
Put domain behavior on instances.  
Be averse to allowing instance methods to know the names of constants.  
Seek to depend on injected abstractions rather than hard-coded concretions.  
Push object creation to the edges, expecting objects to be created in one place and used in another.  
Avoid Demeter violations, using the temptation to create them as a spur to search for deeper abstractions.  
