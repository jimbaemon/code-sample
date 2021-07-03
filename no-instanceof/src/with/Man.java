package with;

import java.util.List;

import with.animal.Animal;
import with.animal.Cat;
import with.animal.Fish;

public class Man {

	void interActiveWithAnimal(List<Animal> animalList){
		animalList.forEach(
			animal -> {
				if(animal instanceof Fish){
					eat(animal);
				}
				else if(animal instanceof Cat){
					play(animal);
				}
			}
		);
	}

	void play(Animal animal){
		System.out.println(animal.getKoreanName()+"랑 놀앗당");
	}

	void eat(Animal animal){
		System.out.println(animal.getKoreanName()+"를 먹었당");
	}
}
