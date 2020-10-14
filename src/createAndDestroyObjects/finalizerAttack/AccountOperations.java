package createAndDestroyObjects.finalizerAttack;

/**
 * Resource: https://self-learning-java-tutorial.blogspot.com/2020/03/finalizer-attack-in-java.html
 */
public class AccountOperations 
{
	public AccountOperations()
	{
		if (!isAuthorized())
		{
			throw new SecurityException("You can't access the account");
		}
	}
	
	public boolean isAuthorized()
	{
		return false;
	}
	
	public void transferMoney(double amount)
	{
		System.out.println("Transferring " + amount + " to beneficiary");
	}
}
