package createAndDestroyObjects.finalizerAndCleaners;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class Finalizable 
{
	private BufferedReader reader;
	
	public Finalizable()
	{
		/**
		 * Resource: https://stackoverflow.com/questions/16570523/getresourceasstream-returns-null
		 * 
		 * Finalizable.class.getClass().getResourceAsStream(...) loads resources using system class loader, 
		 * it obviously fails because it does not see your JARs.
		 * 
		 * Finalizable.class.getResourceAsStream(...) loads resources using the same class loader that loaded 
		 * Finalizable class and it should have access to resources in your JARs.
		 */
		InputStream input = Finalizable.class.getResourceAsStream("file.txt");
		reader = new BufferedReader(new InputStreamReader(input));
	}
	
	public String readFirstLine() throws IOException
	{
		String firstLine = reader.readLine();
		return firstLine;
	}
	
	@Override
	public void finalize()
	{
		try
		{
			reader.close();
			System.out.println("Clased BufferedReader in ths finalizer");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void whenGC_thenFinalizerExecuted() throws IOException
	{
		/**
		 * try(Finalizable resource = new Finalizable())
		 * This cannot use try-with-resources block because it doesn't implement AutoCloseable.
		 */
		String firstLine = new Finalizable().readFirstLine();
		System.out.println(firstLine);
		assertEquals("Test File.", firstLine);
		System.gc();
	}
}
