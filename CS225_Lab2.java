import java.util.Scanner;

// enum class used to represent each cell of the mine board:
// HM = Hidden Mine, RM = Revealed Mine, HE = Hidden Empty, RE = Revealed Empty
enum MineCell { HM, RM, HE, RE }

public class CS225_Lab2
{
	// Your code should go below this line
	// Constants used to make defining the mine board easier
	final static MineCell he = MineCell.HE;
	final static MineCell hm = MineCell.HM;

	public static void main(String[] args)
	{
		
		System.out.println("Sean Billideau");
		
		System.out.println("");

		// Definition of mine board. *** DO NOT CHANGE ***
		// The hidden mines are represented by  and the hidden empty
		// cells with  in a 5—5 array.
		MineCell [][] mineBoard = { {he, he, he, he, he},
									{he, hm, he, hm, he},
									{he, he, he, he, he},
									{he, he, hm, he, he},
									{he, he, hm, hm, he} };

		// Test your board printing functions before continuing
		//	testBoardPrinting(mineBoard); 

		// Definition of some variables and constants
		int currScore = 5; // Starting score is 5
		int numEmptySpotsFound = 0; // When we reach 20 empty spots, we win!
		final int minePenalty = 4; // Each time we hit a mine, subtract this value
		final int emptySpaceBonus = 1; // Each time we land on an empty space, add this value

		//////////////////////////////////////////////////////
		// Continue the game while the score is greater AND
		// the number of empty spots revealed is less than 20
		while (currScore > 0 && numEmptySpotsFound < 20)
		{
			
			System.out.println("-----------------------Next Turn-----------------------");
			Scanner sc=new Scanner(System.in);
			System.out.println("Please enter a column and row to guess");
			System.out.println("current score = " + currScore);
			System.out.println("current empty Spots = " + numEmptySpotsFound);

			printCurrBoard(mineBoard);

			String r = sc.next();
			String c = sc.next();
			int row = 0;
			int col = 0; 
			row = Integer.parseInt(r);
			col = Integer.parseInt(c);

			// Respond to each guess the user could make
			if (mineBoard[row][col] == MineCell.HM)
			{
				mineBoard[row][col]=MineCell.RM;
				currScore-=4;
				
			}
			else if (mineBoard[row][col] == MineCell.HE)
			{
				mineBoard[row][col] = MineCell.RE;
				currScore += 1;
				numEmptySpotsFound+=1;
			
			}
			else
			{
				System.out.println("You've already guessed this spot, please try again!");
			}
			printCurrBoard(mineBoard);

		}
		 if (currScore <= 0)
		{
			System.out.println("You lost the game");
			printGameOverBoard(mineBoard);
		}
		else if (numEmptySpotsFound == 20)
		{System.out.println("You won the game");
			printGameOverBoard(mineBoard);
		}
		 byte defualt;

	}

	/////////////////////////////////////////////////////////////////////
	// Prints the state of the board while game is still being played:
	// '?' for unexplored, 'M' for revealed mines, 'E' for revealed empty cells
	/////////////////////////////////////////////////////////////////////
	static void printCurrBoard(MineCell[][] board)
	{
		for (int row =0; row<board.length; row++)
		{
			for (int col =0; col<board[row].length; col++)
			{	
				if( board[row][col] == MineCell.HE|| ( board[row][col]== MineCell.HM)){
					System.out.print(" ? ");
				}

				else if (board[row][col]== MineCell.RM)
					System.out.print(" M ");
				else if (board[row][col]== MineCell.RE)	
					System.out.print(" E ");


			}
			System.out.println();
		}
	}

	/////////////////////////////////////////////////////////////////////
	// Prints the state of the board after the game is over (thus, we can
	// reveal everything to the user):
	// 'm' for unrevealed mines, 'e' for unrevealed empty cells,
	// 'M' for revealed mines, 'E' for revealed empty cells
	/////////////////////////////////////////////////////////////////////
	static void printGameOverBoard(MineCell[][] board)
	{

		for (int row =0; row<board.length; row++)
		{
			for (int col =0; col<board[row].length; col++)
			{	
				if( board[row][col] == MineCell.HE ){
					System.out.print(" e ");
				}
				else if ( board[row][col]== MineCell.HM)
					System.out.print(" m ");

				else if (board[row][col]== MineCell.RM)
					System.out.print(" M ");
				else if (board[row][col]== MineCell.RE)	
					System.out.print(" E ");

			}
			System.out.println();
		}

		
	}

	/////////////////////////////////////////////////////////////////////
	// This function simply calls your two board printing methods to help
	// you test that your print methods are working properly before moving
	// on with this lab.
	/////////////////////////////////////////////////////////////////////
	static void testBoardPrinting(MineCell[][] board)
	{
		printCurrBoard(board);
		System.out.println();
		printGameOverBoard(board);
		System.out.println("\n\n*****Exiting program after test. Comment out testBoardPrinting() method in main() to move on.");
		System.exit(0);
	}
}
