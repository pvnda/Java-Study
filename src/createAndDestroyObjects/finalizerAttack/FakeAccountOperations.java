package createAndDestroyObjects.finalizerAttack;

/**
 * Resource: https://self-learning-java-tutorial.blogspot.com/2020/03/finalizer-attack-in-java.html
 */
public class FakeAccountOperations extends AccountOperations
{
	public FakeAccountOperations()
	{
		
	}
	
	@Override
	protected void finalize()
	{
		System.out.println("Still I can transfer money");
		this.transferMoney(100);
		System.exit(0);
	}
}
