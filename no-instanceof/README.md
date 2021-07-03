# instanceof 를 안사용 하고 책임 나누기.
[[참조 : Why not use instanceof operator in OOP design?](https://stackoverflow.com/questions/20589590/why-not-use-instanceof-operator-in-oop-design)]

사람이 동물의 타입별로 **행위**가 나뉘는 경우 [물고기 : 먹는다, 고양이 : 논다]  
우리가 사람이기 때문에 사람에 interactiveWith를 넣어 주게 된다.  
하지만 단일 책임 원칙에 따라 동물의 종류 에 따라 행동이 바뀐다면,  
해당 동물 쪽에 책임을 이관해야 한다.  

전자의 경우 동물의 종류가 늘어날때 마다 if(T instance R) 이 늘어나겠지만,  
후자로 동물쪽에 책임을 주는 경우에는 동물의 종류가 늘어나도 아무런 상관이 없다.