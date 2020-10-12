package createAndDestroyObjects.supplierExample;

import java.util.function.Supplier;

public class BookFactory 
{
	public static void main(String[] args)
	{
		SubBook1 subBook1 = (SubBook1) create(() -> new SubBook1.Builder()
																.attr("haha")
																.addTag(Book.Tag.tags1)
																.attribute2("sdsds")
																.build());
		System.out.println(subBook1.getAttr2());
	}
	
	public static Book create(Supplier<? extends Book> b)
	{
		return b.get();
	}
}
