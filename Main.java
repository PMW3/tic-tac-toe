import java.util.Scanner;

public class Main {
    static GameState game = new GameState();

    public static void main(String[] args) {

        while (true) {

            while (!game.isOver()) {

                game.board.displayBoard();

                System.out.println("It's " + game.currentPlayer.symbol + "'s turn");

                Move move = (game.currentPlayer.getTurn());

                while (!game.board.isEmptyPosition(move.pos)) {
                    System.out.println("Give a valid move.");
                    move = (game.currentPlayer.getTurn());
                }

                game.board.applyMove(move);

                game.nextPlayer();

            }

            game.board.displayBoard();
            String outcome = game.board.winner();
            if(outcome.equals("draw")) {
                System.out.println("Its a " + outcome);
            } else {
                System.out.println("Player " + game.board.winner() + " Wins!");
            }

            game.addPointToWinningPlayer();
            System.out.println(game.players[0].points + " Is " + game.players[0].symbol + "'s points!");
            System.out.println(game.players[1].points + " Is " + game.players[1].symbol + "'s points!");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to play again? Press Y for Yes. N for No");
            String ans = scanner.next().toUpperCase();

            while(!(ans.equals("Y") || ans.equals("N"))) {
                System.out.println("Do you want to play again? Press Y for Yes. N for No");
                ans = scanner.next().toUpperCase();
            }

            if(ans.equals("Y")) {
                game.newGame();
            } else {
                break;
            }

        }
    }
}
