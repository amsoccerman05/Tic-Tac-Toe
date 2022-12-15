import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // ask for names
        System.out.println("Player One, what is your name?");
        String p1 = scan.nextLine();
        System.out.println("Player One, what is your name?");
        String p2 = scan.nextLine();


        // making board

        char[] [] board = new char[3] [3];

        // fill board with dashes

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // draw board   
        drawBoard(board);

        // record data for who is supposed to input
        boolean isPlayer1 = true;

        //has game ended
        boolean gameEnded = false;
        while(!gameEnded) {
            drawBoard(board);
        }

        // record what symbols are being used
        char symbol = ' ';
        if(isPlayer1) {
            symbol = 'x';
        } else {
            symbol = 'o';
        }

        // print players turns

        if(isPlayer1) {
            System.out.println(p1 + " s turn:");
        } else {
            System.out.println(p2 + " s turn:");
        }

        // get rows from user
        System.out.print("Enter a row - it must be 0, 1, or 2: ");
        int row = scan.nextInt();
        System.out.print("Enter a column - it must be 0, 1, or 2: ");
        int col = scan.nextInt();

        // make sure inputs are true
        if (row < 0 || col < 0 || row > 2 || col > 2) {
            System.out.println("Row and Coluum is invalid.");
        } else if(board[row][col] !='-') {
            System.out.println("A move has been made there already.");
        } else {
            break;
        }

        // setting position to players symbol 
        board[row][col] = symbol;

        //check if a player won
        if(hasWon(board) == 'x') {
            System.out.println(p1 + " has won");
            gameEnded = true;
        } else if (hasWon(board) == 'o') {
            System.out.println(p2 + " has won");
            gameEnded = true;
        } else {
            if(hasTied(board)) {
                System.out.println("tie");
                gameEnded = true;
            } else {
                isPlayer1 = !isPlayer1;
            }
        }

        //display final result of board
        drawBoard(board);
    }

    //print board
    public static void drawBoard(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.println(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char hasWon(char[][] board) {
        //check row
        for(int i = 0; i < 3; i++) {
            if(board[i] [0] == board[i][1] && board [i][1] == board [i][2] && board [i][0] !='-') {
                return board[i][0];
            }
        }
        // check columm
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] !='-') {
                return board[0][j];
            }
        }

        // check diagnol
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] !='-') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] !='-') {
            return board[2][0];
        }

        // if nobody won
        return '-';
    } 

    // check for ties (aka if board is full)
    public static boolean hasTied(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}