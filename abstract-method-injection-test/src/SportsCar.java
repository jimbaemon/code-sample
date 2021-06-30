public class SportsCar extends Car{

	private int nitrospeed;

	public SportsCar(int wheelSize, int speed, int nitrospeed) {
		super(wheelSize, speed);
		this.nitrospeed = nitrospeed;
	}

	@Override
	public int move() {
		return nitrospeed * wheelSize * speed;
	}
}
