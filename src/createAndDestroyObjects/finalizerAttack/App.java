package createAndDestroyObjects.finalizerAttack;

import java.util.concurrent.TimeUnit;

/**
 * Resource: https://self-learning-java-tutorial.blogspot.com/2020/03/finalizer-attack-in-java.html
 */
public class App 
{
	public static void main(String[] args) throws InterruptedException
	{
		AccountOperations accountOp = null;
		try
		{
			accountOp = new FakeAccountOperations();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		System.gc();
		TimeUnit.MINUTES.sleep(10);
	}
}
