package lab13;

public class AlwaysRock extends Player {
	
	public AlwaysRock() {
		
	}
	public AlwaysRock(String name) {
		super(name);
	}
	
	
	@Override
	public Roshambo generateRoshambo() {
		// TODO Auto-generated method stub
		return Roshambo.ROCK;
	}

	
}