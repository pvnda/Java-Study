package createAndDestroyObjects.supplierExample;

public class SubBook1 extends Book
{
	private final String attr2;
	
	public static class Builder extends Book.Builder<Builder>
	{
		private String attribute2;
		Book build() {
			// TODO Auto-generated method stub
			return new SubBook1(this);
		}
		
		public Builder attribute2(String attribute2)
		{
			this.attribute2 = attribute2;
			return this;
		}

		@Override
		protected Builder self() 
		{
			return this;
		}
		
	}
	private SubBook1(Builder builder) 
	{
		super(builder);
		attr2 = builder.attribute2 == null? "" : builder.attribute2;
	}
	
	public String getAttr2() {
		return attr2;
	}
}
