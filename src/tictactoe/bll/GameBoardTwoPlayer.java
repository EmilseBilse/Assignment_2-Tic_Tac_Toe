package tictactoe.bll;
import tictactoe.gui.TicTacToe;
import tictactoe.gui.controller.TicTacViewController;

/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {
    private boolean isPlayerOne;
    private String[] plays;

    private final int COLS = 3;
    private final int ROWS = 3;
    private int availableSlots;

    protected GameBoardTwoPlayer() {
        newGame();
    }


    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer() {
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
        if(plays[col + row * COLS] == null && isGameOver() == false){
            plays[col + row * COLS] = (getNextPlayer() == 0) ? "X" : "O";
            isPlayerOne = !isPlayerOne;
            availableSlots -= 1;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */
    @Override
    public boolean isGameOver() {
        if(availableSlots <= 0 || getWinner() == 0 || getWinner() == 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    @Override
    public int getWinner() {
        //vandret
        if(plays[0] == plays[1] && plays[1] == plays[2] && plays[0] == plays[2] && plays[0] != null){
            if(plays[0] == "X"){
                return 0;
            }else{
                return 1;
            }
        }
        if(plays[3] == plays[4] && plays[4] == plays[5] && plays[3] == plays[5] && plays[3] != null){
            if(plays[3] == "X"){
                return 0;
            }else{
                return 1;
            }
        }
        if(plays[6] == plays[7] && plays[7] == plays[8] && plays[6] == plays[8] && plays[6] != null){
            if(plays[6] == "X"){
                return 0;
            }else{
                return 1;
            }
        }

        //lodret
        if(plays[0] == plays[3] && plays[3] == plays[6] && plays[6] == plays[0] && plays[0] != null){
            if(plays[0] == "X"){
                return 0;
            }else{
                return 1;
            }
        }

        if(plays[1] == plays[4] && plays[4] == plays[7] && plays[7] == plays[1] && plays[1] != null){
            if(plays[1] == "X"){
                return 0;
            }else{
                return 1;
            }
        }
        if(plays[2] == plays[5] && plays[5] == plays[8] && plays[8] == plays[2] && plays[2] != null){
            if(plays[2] == "X"){
                return 0;
            }else{
                return 1;
            }
        }

        //diagonalt
        if(plays[0] == plays[4] && plays[4] == plays[8] && plays[8] == plays[0] && plays[0] != null){
            if(plays[0] == "X"){
                return 0;
            }else{
                return 1;
            }
        }
        if(plays[2] == plays[4] && plays[4] == plays[6] && plays[6] == plays[2] && plays[2] != null){
            if(plays[2] == "X"){
                return 0;
            }else{
                return 1;
            }
        }
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {
        availableSlots = ROWS * COLS;
        plays = new String[9];
        isPlayerOne = true;
    }

}