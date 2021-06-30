public abstract class Car {
	protected int wheelSize;
	protected int speed;

	public Car(int wheelSize, int speed) {
		this.wheelSize = wheelSize;
		this.speed = speed;
	}

	public int move(){
		return wheelSize * speed;
	}

}
