package firstProject;

/************************************************
 *this program prints 
 *a rectangle entered by
 *the user
 ************************************************/
import java.util.Scanner;

public class PrintReectangle 
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		int height; 
		int width;
		char character;
		
		System.out.print("enter the height: ");
		height = stdIn.nextInt();
		System.out.print("enter the width: ");
		width = stdIn.nextInt();
		System.out.print("enter your character: ");
		character = stdIn.next().charAt(0);
		
		for (int row=1; row<=height; row++)
		{
			for (int col=1; col>=width; col++)
			{
				System.out.print(character);
			}
			System.out.println();
		}
	}//end main	
}//end class PrintReectangle


