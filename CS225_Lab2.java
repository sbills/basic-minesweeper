import java.util.Scanner;
/* CS 225 - Intro to Computer Science II
 * File Name: CS225_Lab2.java
 * Java Programming
 * Lab 2 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: Sean Billideau
 * Name 2: FirstName2 LastName2
 * Description: This file contains the source code for Lab 2.
 */

///////////////////////////////////////////////////////////////////////////////
// INSTRUCTIONS: Update the header above EACH LAB with the correct due date,
// first/last names (remove the "Name 2" line if working alone) and description
// for this specific lab. You should also update the first/last names and problem
// number (if relevant) below in the "System.out.println" statement at the beginning
// of the "main()" method. Failure to do so will result in lost points. DO NOT change
// the name of the class or the autograder will give you 0 points.
//
// PHILOSOPHY: Lab is a chance to "get your feet wet" in a safe environment as it
// will be the first time you'll be trying to program new concepts. Thus, as you'll
// see below, the collaboration rules for LABS are very generous since the main idea
// is for you to learn programming with a lot of resources. To foster this 
// environment, you'll have access to a programming partner of your choice, your peers,
// experienced lab technicians and your instructor.
//
// COLLABORATION: Students may officially work with ONE (1) partner. Both names should
// be listed in the header and in the initial "System.out.println()" statement. When
// you submit your lab, only one partner should submit it (again, make sure both names
// are on all files). Students MAY seek advice and look at other students' code DURING
// lab for tips (including students who are not your direct partner), but may NOT
// copy/paste code from students other than your official partner.
//
// FINISHING & GRADING: Lab assignments must be performed in the Computer Science
// Laboratory each week. You are required to attend every lab session. Labs usually
// consist of several book problems (sometimes there are none) and 1-2 code problems.
// The book problems and code should both be turned in when fully completed. 
//
// When you finish a code problem during lab, you will demonstrate your working program
// to the instructor or to a lab-tech/TA on duty and you and the instructor will both
// sign off on that problem. At that point, you will receive full credit for that problem.
// If you did not finish one or more code problems by the end of lab, you may sign off with
// an instructor/lab-tech/TA during the last 15 minutes of lab; in this event, you will not
// be deducted points for not finishing , but will be graded based on your final
// submission. Book problems will always be graded via the submission and will not be checked
// off during lab.
//
// If you do not finish your lab assignment during the lab period, you and your partner may
// only seek help with your code from lab technicians (available whenever the lab is open)
// and the instructor to aid with any confusion; please refer to posted lab times at the
// entrance of the Main Computer Lab to see when lab techs and computers are available.
// You may also complete the labs on your own machine if yo like (this is preferable).
///////////////////////////////////////////////////////////////////////////////

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
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Sean Billideau");
		System.out.println("Lab 2");
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
		//	testBoardPrinting(mineBoard); // TODO 3: Comment out when print methods tested

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
			// TODO 4: Write code here to ask the user for a row and column to guess...
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
				// TODO 5: Write code here to respond to the user
				// guessing a cell that has hidden mine...
			}
			else if (mineBoard[row][col] == MineCell.HE)
			{
				mineBoard[row][col] = MineCell.RE;
				currScore += 1;
				numEmptySpotsFound+=1;
				// TODO 6: Write code here to respond to the user
				// guessing a cell that has hidden empty cell...
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







		//////////////////////////////////////////////////////
		// TODO 7: Deliver final results. If we've reached this point,
		// the game is over. Write code to let the user know if they won 
		// or lost and print the final board (remember, you have a function
		// to print the game-over board)


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


		// TODO 1: Write code to print the current game state as specified
		// in the comment above
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

		// TODO 2: Write code to print the final (game-over) game state
		// as specified in the comment above
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