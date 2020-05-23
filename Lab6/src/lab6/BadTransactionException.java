package lab6;

public class BadTransactionException extends Exception{
	
	public int amount;
	
	public BadTransactionException(int badamount)
	{
		super("Invalid withdraw amount:"+badamount);
		
		amount=badamount;
	}
	

}
