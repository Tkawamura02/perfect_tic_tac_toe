package perfect_tic_tac_toe;

import java.util.Arrays;

//generate game tree of all possible moves 986409 positions
//human 'X'
//computer 'O'

public class GenTree {
	public static ArrayTree<TicTacToePosition> gameTree = new ArrayTree<TicTacToePosition>(9, 500000000);
	private static int index;
	
	public static void main(String[] args) {
		TicTacToePosition root = new TicTacToePosition();
		
		index = gameTree.addRoot(root);

		populate(root, 1, 0);
		
		for (int i = 0; i<100; i++) {
			TicTacToePosition t = gameTree.get(i);
			if (t != null)
				System.out.printf("%2d) %s\n", i, gameTree.get(i).board);
			else
				System.out.printf("%2d) Empty\n", i);
		}
		
	}

	public static void populate (TicTacToePosition node, int c, int depth) {
		//method fills gameTree with all possible solutions
		//get game at node
		//for each blank in game replace with char
		//add new child to node
		//populate(child, other c)
		while (depth<=8){
			for (int moves = 0; moves <=8; moves++) {
				//check if spots are empty
				int childnum = 0;
				if (node.board[moves] == 0) {
					//fill board with 1 or 2	
					if (depth%2 != 0) {
						//ODD X or human's turn
						TicTacToePosition temp = new TicTacToePosition();
						temp.board=Arrays.copyOf(node.board, node.board.length);
						temp.board[moves] = 1;
						index = gameTree.addChild(index, childnum, temp);
						childnum++;
						populate(temp, 2, depth+1);
					} else {
						//EVEN computer player
						TicTacToePosition temp = new TicTacToePosition();
						temp.board=Arrays.copyOf(node.board, node.board.length);
						temp.board[moves] = 2;
						index = gameTree.addChild(index, childnum, temp);
						childnum++;
						populate(temp, 1, depth+1);
					}
				}
			}
			//depth++;
		}
	}
}
