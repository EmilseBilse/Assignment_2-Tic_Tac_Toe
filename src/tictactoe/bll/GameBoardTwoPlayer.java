package tictactoe.bll;
import tictactoe.gui.TicTacToe;
import tictactoe.gui.controller.TicTacViewController;

/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {
    private boolean isPlayerOne = true;
    private int playCounter = 0;
    String[] plays = {"","","","","","","","",""};

    protected GameBoardTwoPlayer() {

    }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer() {
        //TODO Implement this method
        if(isPlayerOne){
            return 0;
        }else {
            return 1;
        }
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is successful the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */
    @Override
    public boolean play(int col, int row) {
        //TODO Implement this method
        String colRowName = col + " " + row;
        System.out.println(colRowName);
        for (String playName : plays) {

            System.out.println(playName);
            if (playName == colRowName) {
                System.out.println("false");

                return false;
            }
        }
        if(plays[playCounter] == "") {
            plays[playCounter] = col + " " + row;
            playCounter++;
    //        System.out.println("thing in array[playcounter]: " + plays[playCounter - 1]);
      //      System.out.println("playcounter: " + (playCounter - 1));
            System.out.println("true");
            return true;
        }else
            System.out.println("should not happen");
            return true;

        /**if(plays[playCounter] == null){

            plays[playCounter] = col + " " + row;
            playCounter++;
            System.out.println(plays[playCounter - 1]);
            System.out.println(playCounter);

            return true;

        }else{
            System.out.println("fuck you");
            return false;
        }*/


    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */
    @Override
    public boolean isGameOver() {
        //TODO Implement this method
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    @Override
    public int getWinner() {
        //TODO Implement this method
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {
        //TODO Implement this method
    }

}