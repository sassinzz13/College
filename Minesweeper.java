package source;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
 import javax.swing.*;;
public class Minesweeper {
	
	//a short cut for not typing so many shits
	private class MineTile extends JButton{
		int r;
		int c;
		
		public MineTile(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
//-------------------------------------------------------------------------------//
	//gui
	int tileSize = 70;
	int numRows = 8;
	int numCols = numRows;
	int boardHeight = numRows * tileSize;
	int boardWidth = numRows * tileSize;
	JFrame frame = new JFrame("Minesweeper");
	JLabel textLabel = new JLabel();
	JPanel textPanel = new JPanel();
	JPanel boardPanel = new JPanel();
	
	//MineTile 2d array
	MineTile[][] board = new MineTile[numRows][numCols];
	//array list of mines
	ArrayList<MineTile> mineList;
	
	int tilesClicked = 0;
	boolean gameOver = false;
	
	//count of the random mines
	int mineCount = 10;
	Random random = new Random();
	
		Minesweeper(){
//-------------------------------------------------------------------------------//
			//8buttons by 8 buttons
			//Gui implementations		
			  frame.setSize(boardWidth, boardHeight);
			  frame.setLocationRelativeTo(null);
			  frame.setResizable(false);
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  frame.setLayout(new BorderLayout());
			  
			  textLabel.setFont(new Font("Arial", Font.BOLD, 25));
			  textLabel.setHorizontalAlignment(JLabel.CENTER);
			  textLabel.setText("Minesweeper: " + Integer.toString(mineCount));
			  textLabel.setOpaque(true);
			  textPanel.setLayout(new BorderLayout());
			  textPanel.add(textLabel);
			  frame.add(textPanel, BorderLayout.NORTH);
			  boardPanel.setLayout(new GridLayout(numRows,numCols));
			  frame.add(boardPanel);
			  
//-------------------------------------------------------------------------------//			  		
			//check for rows
			for (int r = 0; r<numRows; r++) {
				//check for columns
				for(int c = 0; c< numCols; c++) {
				
					MineTile tile = new MineTile(r,c);
					board[r][c] = tile;			
					tile.setFocusable(false);
					tile.setMargin(new Insets(0,0,0,0));
					tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
					tile.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent e) {
							//if game over return
							if(gameOver) {
								//will not respond to the click
								return;
							}
							//pass in MineTile
							MineTile Tile =  (MineTile) e.getSource();
							
							//left click check
							if(e.getButton() == MouseEvent.BUTTON1) {
								if(tile.getText()=="") {
										//if empty 
									//check if its in the minelist
									if(mineList.contains(tile)) {
										//gameover
										revealMines();
									}else {
										//check for mines
										checkMine(tile.r, tile.c);
									}
								}
								//adds a flag and does not make the button clickable
								//right click
							}else if(e.getButton()==MouseEvent.BUTTON3) {
								//check if the tile is an empty string
								if(tile.getText()=="" && tile.isEnabled()) {
									tile.setText("🚩");
								}//undo flags
								else if(tile.getText()=="🚩") {
									tile.setText("");
								}
							}
						}
					});
					boardPanel.add(tile);
				}
			}	
			  frame.setVisible(true);
			  setMines();		
		}
		
//-------------------------------------------------------------------------------//
		//mines implementations
		void setMines() {
			//idk why theres an error
		mineList = new ArrayList<MineTile>();
			int mineLeft = mineCount;
			while(mineLeft > 0) {				
				int r = random.nextInt(numRows);//random number from 0-7
				int c = random.nextInt(numCols);//random number from 0-7
				MineTile tile = board[r][c];
				//check if minelist already has this tile
				if(!mineList.contains(tile)) {
					mineList.add(tile);
					//if we get the same 2 numbers twice
					mineLeft -= 1;
				}
			}
		}
		
//-------------------------------------------------------------------------------//	
		void revealMines() {
			//iterate through the array list with mines in them
			for(int i = 0; i<mineList.size(); i++) {
				MineTile tile = mineList.get(i);
				tile.setText("💣");
			}
			gameOver = true;
			textLabel.setText("GAME OVER");
		}
		
//-------------------------------------------------------------------------------//	
		void checkMine(int r, int c){
			//base case check if the rows and columns are in the bounderies
			if(r<0 || r>= numRows || c<0 || c>= numCols) {
				//if out of bounds exit immediately
				//so we dont go to check mine recursive
				return;
			}
			MineTile tile = board[r][c];
			//if within the bounderies get the tile add another base case
			if(!tile.isEnabled()) {
				//click on
				return;
			}
			//if not clicked on disable button
			tile.setEnabled(false);
			//increments score
			tilesClicked +=1;
			int minesFound = 0;
			
			//check mine recursives to find the neighboring
			
			minesFound += countMine(r-1, c-1);//top left
			minesFound += countMine(r-1, c);//top
			minesFound += countMine(r-1, c+1);//topright
			
			//left and right
			minesFound += countMine(r, c-1);
			minesFound += countMine(r, c+1);
			//bottom three
			minesFound += countMine(r+1, c-1);//bottom left
			minesFound += countMine(r+1, c);//bottom
			minesFound += countMine(r+1, c+1);//bottom right
			if(minesFound > 0) {
				tile.setText(Integer.toString(minesFound));
			}else {
				//if no mines found
				tile.setText("");
				//top 3 
				checkMine(r-1,c-1);//top left
				checkMine(r-1,c);//top 
				checkMine(r-1,c+1);//top 
				
				//left and right
				checkMine(r,c-1);//left
				checkMine(r,c+1);//right 
				
				//bottom three
				minesFound += countMine(r+1, c-1);//bottom left
				minesFound += countMine(r+1, c);//bottom
				minesFound += countMine(r+1, c+1);//bottom right
			}
			//checks the tiles and the mines
			if(tilesClicked == numRows * numCols - mineList.size()) {
				//we dont want the player clicking on the tiles with mines
				gameOver = true;
				//message that they won
				textLabel.setText("Mines cleared");
			}
		}
		
//-------------------------------------------------------------------------------//	
		//coutns mines
		int countMine(int r, int c) {
			//out bounds, you contain a mine or you dont 
			if(r<0 || r>= numRows || c<0 || c>= numCols) {
				//return 0 para di na umarangkada
				return 0;
			}
			if(mineList.contains(board[r][c])) {
				//if tile inside minelist return 1
				return 1;
			}else {
				return 0;
			}
		}
//-------------------------------------------------------------------------------//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minesweeper minesweeper = new Minesweeper();
	}

}
