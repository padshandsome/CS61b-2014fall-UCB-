package lab5;

public class Lowerclass extends Part1 {
	
	public void print()
	{
		System.out.println("sub");
	}
	
   public void superprint()
   {
	   super.print();
   }
	
	public static void main(String[] args)
	{
		Lowerclass erzi=new Lowerclass();
		erzi.print();
		erzi.superprint();
	}
}
