package TIC_TAC_TOE;
import java.util.Scanner;
public class tictactoe {
	private player player1,player2;
	private Board board;
	
	public static void main(String[] args) {
		tictactoe t=new tictactoe();
		t.startGame();
	}
	
	public void startGame() {
		Scanner s=new Scanner(System.in);
		//players input
		player1=takePlayerInput(1);
		player2=takePlayerInput(2);
		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("Symbol Already Taken !! pick another symbol!!");
			char symbol=s.next().charAt(0);
			player2.setSymbol(symbol);
		}
		//create Board
		board =new Board(player1.getSymbol(),player2.getSymbol());
		//conduct the game
		boolean player1Turn=true;
		int status=Board.INCOMPLETE;
		while(status==board.INCOMPLETE ||status==Board.INVALID) {
			if(player1Turn) {
				System.out.println("Player 1-"+player1.getName()+"s.turn");
				System.out.println("Enter x: ");
				int x=s.nextInt();
				System.out.println("Enter y: ");
				int y=s.nextInt();
				status= board.move(player1.getSymbol(),x,y);
				if(status!=Board.INVALID) {//player 1 ne galat turn chala again told him ki chalo
					player1Turn=false;
					board.print();
				}
				else {
					System.out.println("Invalid Move!! Try Again!!");
				}
			}
			else {
				System.out.println("Player 2-"+player2.getName()+"s.turn");
				System.out.println("Enter x: ");
				int x=s.nextInt();
				System.out.println("Enter y: ");
				int y=s.nextInt();
				status= board.move(player2.getSymbol(),x,y);
				if(status!=Board.INVALID) {
					//player 2 ka turn complete hone pe player 1 ka turn aa jayega so make palyer 1 turn true
					player1Turn=true;
					board.print();
				}
				else {
					System.out.println("Invalid Move!! Try Again!!");
				}
			}
		}
		if(status==Board.PLAYER_1_WINS) {
			System.out.println("Player 1 - "+player1.getName()+" wins !!");
		}
		else if(status==Board.PLAYER_2_WINS) {
			System.out.println("Player 2 - "+player2.getName()+" wins !!");
		}
		else {
			System.out.println("Draw !!");
		}
	}
	 private player takePlayerInput(int num) {
		 Scanner s=new Scanner(System.in);
		 System.out.println("Enter player "+num+"name: ");
		 String name=s.nextLine();
		 System.out.println("Enter plaer "+num+" Symbol: ");
		 char symbol=s.next().charAt(0);
		 player p=new player(name,symbol);
		 return p;
	 }
}
