package createAndDestroyObjects.supplierExample;

import java.util.EnumSet;
import java.util.Set;

public abstract class Book 
{
	public enum Tag {tags1, tags2, tags3, tags4}
	
	@SuppressWarnings("unused")
	private final String attr1;
	@SuppressWarnings("unused")
	private final Set<Tag> tags;
	
	abstract static class Builder<T extends Builder<T>>
	{
		/**
		 * EnumSet contain only Enum values.
		 * It doesn't allow to add null values.
		 * It's not thread-safe (need to be synchronized).
		 * The elements are stored following the order in which they are declared in the enum.
		 * It uses a fail-safe iterator that works on a copy, so it won't throw a ConcurrentModification-
		 * Exception if the collection is modified when iterating over it.
		 * 
		 * Benefits of using EnumSet:
		 * All the methods in an EnumSet are implemented using arithmetic bitwise operations.
		 * It saves memory and unlike HashSet, it does not need to calculate the hashcode of each element.
		 */
		EnumSet<Tag> tags = EnumSet.noneOf(Tag.class);
		private String attribute;
		
		public T addTag(Tag tag) 
		{
			tags.add(tag);
			return self();
		}
		
		public T attr(String attr1)
		{
			this.attribute = attr1;
			return self();
		}
		
		
		abstract Book build();
		
		protected abstract T self();
	}
	
	Book(Builder<?> builder)
	{
		tags = builder.tags.clone();
		attr1 = builder.attribute == null? "" : builder.attribute;
	}
}
