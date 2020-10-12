package createAndDestroyObjects.classRelated;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ClassLoaderExample 
{
	/**
	 * Resource: https://www.baeldung.com/java-classloaders
	 * 
	 * - Bootstrap class loader serves as a parent of all the other ClassLoader instances.
	 *   This bootstrap class loader is part of the core JVM and is written in native code.
	 * - Extension class loader is a child of the bootstrap class loader and takes care of loading
	 *   the extensions of the standard core Java classes.
	 * - System class loader loads files found in the classpath environment variable, -classpath or
	 *   -cp command line option.
	 *   
	 * Three Important features of class loaders
	 * - On request to find a class or resource, a ClassLoader instance will delegate the search of 
	 *   the class or resource to the parent classloader.
	 * - Unique classes as we always try to delegate upwards.
	 * - Children class loaders are visible to classes loaded by its parent class loaders.
	 * @throws ClassNotFoundException
	 */
	public void printClassLoaders() throws ClassNotFoundException
	{
		System.out.println("Classloader of this class:" + ClassLoaderExample.class.getClassLoader());
		System.out.println("Classloader of Logging:" + Logger.class.getClassLoader());
		System.out.println("Classloader of ArrayList" + ArrayList.class.getClassLoader());
	}
	
	public static void main(String[] args)
	{
		ClassLoaderExample c = new ClassLoaderExample();
		try 
		{
			c.printClassLoaders();
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
