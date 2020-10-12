package createAndDestroyObjects.finalizerAndCleaners;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class CloseableResource implements AutoCloseable 
{
	private BufferedReader reader;
	
	public CloseableResource()
	{
		InputStream input = CloseableResource.class.getResourceAsStream("file.txt");
		reader = new BufferedReader(new InputStreamReader(input));
	}
	
	public String readFirstLine() throws IOException
	{
		String firstLine = reader.readLine();
		return firstLine;
	}
	
	@Override
	public void close()
	{
		try
		{
			reader.close();
			System.out.println("Closed BufferedReader in the close method");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void whenTryWResourcesExits_thenResourceClosed() throws IOException
	{
		try (CloseableResource resource = new CloseableResource())
		{
			String firstLine = resource.readFirstLine();
			assertEquals("Test File.", firstLine);
		}
	}
}
