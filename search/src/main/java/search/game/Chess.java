package search.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


/**
 * Chess game
 *
 * <p/>
 * Copyright 2002-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */

public class Chess extends GameSearch {

    // note: set the following to false if running in IntelliJ IDE: console does not display
    // unicode characters. Usually, you want to set to true (at least try it).
    static public boolean USE_UNICODE_CHARS = true; // set to true for graphics characters

    /**
     *  Notes:  PROGRAM false -1,  HUMAN true 1
     */

    /**
     *                PUBLIC API (mostly from GameSearch)
     */

    public boolean drawnPosition(Position p) {
        /**
         * We want to keep searching:
         */
        return false;
    }

    public boolean wonPosition(Position p, boolean player) {
        // eventually, we should check for checkmates here...
        return false;
    }
  
    final public float positionEvaluation(Position p, boolean player) {
        ChessPosition pos = (ChessPosition)p;
        int [] b = pos.board;
        float ret = 0.0f;
        // adjust for material:
        for (int i=22; i<100; i++) {
            if (b[i] != 0 && b[i] != 7)  ret += 1.75f * b[i];
        }
    
        // adjust for positional advantages:
        setControlData(pos);
        int control = 0;
        for (int i=22; i<100; i++) {
            control += humanControl[i];
            control -= computerControl[i];
        }
        // Count center squares extra:
        control += humanControl[55] - computerControl[55];
        control += humanControl[56] - computerControl[56];
        control += humanControl[65] - computerControl[65];
        control += humanControl[66] - computerControl[66];

        control /= 10.0f;
        ret += control;

        // credit for attacked pieces:
        for (int i=22; i<100; i++) {
            if (b[i] == 0 || b[i] == 7) continue;
            if (b[i] < 0) {
                if (humanControl[i] > computerControl[i]) {
                    ret += 0.9f * value[-b[i]];
                }
                if (b[i] == -ChessPosition.QUEEN && humanControl[i]>0) ret += 2;
                if (b[i] == -ChessPosition.KING && humanControl[i]>0)  ret += 4;
            } 
            if (b[i] > 0) {
                if (humanControl[i] < computerControl[i]) {
                    ret -= 0.9f * value[b[i]];
                }
                if (b[i] == ChessPosition.QUEEN && humanControl[i]>0) ret -= 2;
                if (b[i] == ChessPosition.KING && humanControl[i]>0)  ret -= 4;
            }
        }
        // adjust if computer side to move:
        if (!player) ret = -ret;
        return ret;
    }

    public void printPosition(Position p) {
        System.out.println("Board position:");
        ChessPosition pos = (ChessPosition)p;
        int [] b = pos.board;
        for (int col=92; col>=22; col-=10) {
            System.out.println();
            for (int ii=0; ii<8; ii++) {
                int i = ii + col;
                if (b[i] != 0) {
                    System.out.print(pp(b[i], i));
                } else {
                    boolean white_sq = true;
                    for (int k=0; k<blackSquares.length; k++) {
                        if (i == blackSquares[k]) {
                            white_sq = false;
                            break;
                        }
                    }
                    if (white_sq) System.out.print("   ");
                    else          System.out.print(" . ");
                }
            }
        }
        System.out.println();
    }

    private String pp(int piece, int square_index) {
        if (piece == 0) return "   ";
        if (USE_UNICODE_CHARS) {
            switch (piece) {
                case 1:
                    return " \u2659 ";
                case 2:
                    return " \u2658 ";
                case 3:
                    return " \u2657 ";
                case 4:
                    return " \u2656 ";
                case 5:
                    return " \u2655 ";
                case 9:
                    return " \u2654 ";
                case -1:
                    return " \u265F ";
                case -2:
                    return " \u265E ";
                case -3:
                    return " \u265D ";
                case -4:
                    return " \u265C ";
                case -5:
                    return " \u265B ";
                case -9:
                    return " \u265A ";
            }
            return "error";


        } else {
            String color;
            if (piece < 0) color = "B";
            else color = "W";
            int p = piece;
            if (p < 0) p = -p;
            switch (p) {
                case 1:
                    return " " + color + "P";
                case 2:
                    return " " + color + "N";
                case 3:
                    return " " + color + "B";
                case 4:
                    return " " + color + "R";
                case 5:
                    return " " + color + "Q";
                case 9:
                    return " " + color + "K";
            }
            return "error";
        }
    }

    final public Position [] possibleMoves(Position p, boolean player) {
        if (GameSearch.DEBUG) System.out.println("posibleMoves("+p+","+player+")");
        ChessPosition pos = (ChessPosition)p;
        //System.out.println("Chess.possibleMoves(): pos=" + pos);
        //for (int i=22; i<40; i++) System.out.println(pos.board[i]);
        int num = calcPossibleMoves(pos, player);
        if (num == 0) {
            System.out.println("Stalemate");
            System.exit(0);
        }
        ChessPosition [] chessPos = new ChessPosition[num];
        for (int i=0; i<num; i++) {
            chessPos[i] = new ChessPosition();
            for (int j=22; j<100; j++) chessPos[i].board[j] = pos.board[j];
            chessPos[i].board[possibleMoveList[i].to] = chessPos[i].board[possibleMoveList[i].from];
            chessPos[i].board[possibleMoveList[i].from] = 0;
        }
        return chessPos;
    }
    public Position makeMove(Position p, boolean player, Move move) {
        if (GameSearch.DEBUG) System.out.println("Entered Chess.makeMove");
        ChessMove m = (ChessMove)move;
        ChessPosition pos = (ChessPosition)p;
        ChessPosition pos2 = new  ChessPosition();
        for (int i=0; i<120; i++) pos2.board[i] = pos.board[i];
        int pp;
        if (player) pp =  1;
        else        pp = -1;
        if (GameSearch.DEBUG) System.out.println("makeMove: m.from = " + m.from +
                                                 ", m.to = " + m.to);
        pos2.board[m.to] = pos2.board[m.from];
        pos2.board[m.from] = 0;
        return pos2;
    }
    final public boolean reachedMaxDepth(Position p, int depth) {
        if (depth < 5) return false;
        return true;
    }

    private BufferedReader in = null;

    public Move createMove() {
        if (GameSearch.DEBUG) System.out.println("Enter blank square index [0,8]:");
        ChessMove mm = new ChessMove();
        System.out.println("enter a move like 'd2d4' or 'oo'");
        try {
            if (in == null) {
                in = new BufferedReader(new InputStreamReader(System.in));
            }
            String s = in.readLine().toLowerCase();
            System.out.println("s="+s);
            
            // TBD: check for oo and ooo:
            
            char c0 = (char)(s.charAt(0) - 'a' + 2);
            char r0 = (char)(s.charAt(1) - '1' + 2);
            char c1 = (char)(s.charAt(2) - 'a' + 2);
            char r1 = (char)(s.charAt(3) - '1' + 2);
            mm.from = r0*10+c0;
            mm.to   = r1*10+c1;
            System.out.println("From " + mm.from + ", to " + mm.to);
        } catch (Exception e) { System.out.println(e); }
        return mm;
    }

    static public void main(String [] args) throws UnsupportedEncodingException {
        System.out.println("\u2654");
            String unicodeMessage =
                "\u2654 " + // white king
                    "\u2655 " + // white queen
                    "\u2656 " + // white rook
                    "\u2657 " + // white bishop
                    "\u2658 " + // white knight
                    "\u2659 " + // white pawn
                    "\n" +
                    "\u265A " + // black queen
                    "\u265B " + // black queen
                    "\u265C " + // black rook
                    "\u265D " + // black bishop
                    "\u265E " + // black knight
                    "\u265F " + // black pawn
                    "\n" +
                    "\u2610 " + "\u2612 " + "\u25A0 " + "\u25FC";  // trying for white and black squares
        System.out.println(unicodeMessage);
            PrintStream out = new PrintStream (System.out, true , "UTF8" );
            out.println(unicodeMessage);

        ChessPosition p = new ChessPosition();
        for (int i=0; i<120; i++) p.board[i] = initialBoard[i];
        Chess ttt = new Chess();
        /* DEBUG*/ //  ttt.setControlData(p);
        ttt.playGame(p, true);
    }

    /**
     *             PRIVATE API, mostly chess move and evaluation utilities
     */

    // static data that can be re-used (assume single threading!)
    static private float [] computerControl = new float[120];
    static private float [] humanControl    = new float[120];
    

    private void setControlData(ChessPosition pos) {
        for (int i=0; i<120; i++) {
            computerControl[i] = 0;
            humanControl[i] = 0;
        }
        int [] b = pos.board;
        float [] control; // set to computerControl or humanControl, as appropriate
        for (int square_index=22; square_index<100; square_index++) {
            int piece = b[square_index];
            if (piece == 7 || piece == 0) continue;
            int piece_type = piece;
            if (piece_type < 0) {
                piece_type = -piece_type;
                control = computerControl;
            } else {
                control = humanControl;
            }
            int count = 0, side_index, move_offset, temp, next_square;
            int piece_index = index[piece_type];
            int move_index = pieceMovementTable[piece_index];
            if (piece < 0) side_index = -1;
            else           side_index = 1;
            switch (piece_type) {
            case ChessPosition.PAWN:
                {
                    // first check for possible pawn captures:
                    for (int delta=-1; delta<= 1; delta += 2) {
                        move_offset = square_index + side_index * 10 + delta;
                        control[move_offset] += 1.1f;
                        int target = b[move_offset];
                        if ((target <= -1 && target != 7 && piece > 0) ||
                            (target >= 1 && target != 7 && piece < 0)) {
                            // kluge: count pawn control more:
                            control[square_index + side_index * delta] += 1.25f;
                        }
                    }
                }
                // Note: no break here: we want pawns to use move table also:
                break; // ??


            case ChessPosition.KNIGHT:
            case ChessPosition.BISHOP:
            case ChessPosition.ROOK:
            case ChessPosition.KING:
            case ChessPosition.QUEEN:
                {
                    move_index = piece; if (move_index < 0) move_index = -move_index;
                    move_index = index[move_index];
                    //System.out.println("move_index="+move_index);
                    next_square = square_index + pieceMovementTable[move_index];
                outer:
                    while (true) {
                    inner:
                        while (true) {
                            if (next_square > 99) break inner;
                            if (next_square < 22) break inner;
                            if (b[next_square] == 7) break inner;
                            control[next_square] += 1;
                            // the next statement should be augmented for x-ray analysis:
                            if (side_index < 0 && b[next_square] < 0) break inner;
                            if (side_index > 0 && b[next_square] > 0 && b[next_square] != 7) break inner;
                            // NOTE: prevents calculating guarding:
                            //if (b[next_square] != 0) break inner;

                            if (piece_type == ChessPosition.PAWN &&
                                (square_index / 10 == 3))  break inner;
                            if (piece_type == ChessPosition.KNIGHT) break inner;
                            if (piece_type == ChessPosition.KING) break inner;
                            next_square += pieceMovementTable[move_index];
                        }
                        move_index += 1;
                        if (pieceMovementTable[move_index] == 0) break outer;
                        next_square = square_index + pieceMovementTable[move_index];
                    }
                }
            }
        }
        if (false) {
            printPosition(pos);
            System.out.println("Human control:");
            for (int col = 92; col >= 22; col -= 10) {
                System.out.println();
                for (int ii = 0; ii < 8; ii++) {
                    int i = ii + col;

                    //for (int i=99; i>=22; i--) {
                    //if (b[i] == 7 && b[i + 1] == 7) {
                    //    System.out.println();
                    // }
                    if (b[i] != 7) {
                        System.out.print(humanControl[i] + " ");
                    }
                }
            }
            System.out.println();
            System.out.println("Computer control:");
            for (int col = 92; col >= 22; col -= 10) {
                System.out.println();
                for (int ii = 0; ii < 8; ii++) {
                    int i = ii + col;
                    //if (b[i] == 7 && b[i + 1] == 7) {
                    //    System.out.println();
                    //}
                    if (b[i] != 7) {
                        System.out.print(computerControl[i] + " ");
                    }
                }
            }
            System.out.println();
            System.exit(1);
        }
    }

    static class aMove {
        int from;
        int to;
    }
    private static aMove [] possibleMoveList = new aMove[255];
    static {
        for (int i=0; i<255; i++) possibleMoveList[i] = new aMove();
    }

    private int calcPossibleMoves(ChessPosition pos, boolean player) {
        //System.out.println("calcPossibleMoves()");
        int [] b = pos.board;
        int count = 0;
        for (int i=22; i<100; i++) {
            int board_val = b[i];
            //System.out.println(board_val);
            if (board_val == 7) continue;
            // computer pieces will be negative:
            if ((board_val < 0 && !player) || (board_val > 0 && player)) {
                int num = calcPieceMoves(pos, i);
                for (int j=0; j<num; j++) {
                    if (b[piece_moves[j]] != 7) {
                        //System.out.println("count="+count+", i="+i);
                        possibleMoveList[count].from = i;
                        possibleMoveList[count].to = piece_moves[j];
                        //                      System.out.println("possible move: player="+player+
                        //                                         ", from="+i+", to="+piece_moves[j]);
                        count++;
                    }
                }
                // TBD: castle logic, etc. (page 159)
            }
        }
        return count;
    }

    private int calcPieceMoves(ChessPosition pos, int square_index) {
        int [] b = pos.board;
        int piece = b[square_index];
        int piece_type = piece;
        if (piece_type < 0) piece_type = -piece_type;
        int count = 0, side_index, move_offset, temp, next_square;
        int piece_index = index[piece_type];
        int move_index = pieceMovementTable[piece_index];
        if (piece < 0) side_index = -1;
        else           side_index = 1;
        switch (piece_type) {
        case ChessPosition.PAWN:
            {
                // first check for possible pawn captures:
                for (int delta=-1; delta<= 1; delta += 2) {
                    move_offset = square_index + side_index * 10 + delta;
                    int target = b[move_offset];
                    if ((target <= -1 && target != 7 && piece > 0) ||
                        (target >= 1 && target != 7 && piece < 0)) {
                        piece_moves[count++] = square_index + side_index * 10 + delta;
                    }
                }
                // check for initial pawn move of 2 squares forward:
                move_offset = square_index + side_index * 20;
                if (piece > 0) temp = 3; else temp = 8;
                if (b[move_offset] == 0 &&
                    (square_index / 10) == temp &&
                    ((piece < 0 && b[square_index - 10]==0) ||
                     (piece > 0 && b[square_index + 10]==0))) {
                    piece_moves[count++] = square_index + side_index * 20;
                }
                // try to move forward 1 square:
                move_offset = square_index + side_index * 10;
                if (b[move_offset] == 0) {
                    piece_moves[count++] = move_offset;
                }
            }
            break;
        case ChessPosition.KNIGHT:
        case ChessPosition.BISHOP:
        case ChessPosition.ROOK:
        case ChessPosition.KING:
        case ChessPosition.QUEEN:
            {
		move_index = piece; if (move_index < 0) move_index = -move_index;
		move_index = index[move_index];
		//System.out.println("move_index="+move_index);
		next_square = square_index + pieceMovementTable[move_index];
    outer:
		while (true) {
		inner:
		    while (true) {
			if (next_square > 99) break inner;
			if (next_square < 22) break inner;
                        if (b[next_square] == 7) break inner;
			
                        // check for piece on the same side:
                        if (side_index < 0 && b[next_square] < 0) break inner;
                        if (side_index >0 && b[next_square]  > 0) break inner;
			
                        piece_moves[count++] = next_square;
                        if (b[next_square] != 0) break inner;
                        if (piece_type == ChessPosition.KNIGHT) break inner;
                        if (piece_type == ChessPosition.KING) break inner;
                        next_square += pieceMovementTable[move_index];
		    }
		    move_index += 1;
		    if (pieceMovementTable[move_index] == 0) break outer;
		    next_square = square_index + pieceMovementTable[move_index];
		}
	    }
        }
        return count;
    }

    private static int [] piece_moves = new int[255];

    private static int [] initialBoard = {
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
        4, 2, 3, 5, 9, 3, 2, 4, 7, 7,   // white pieces
        1, 1, 1, 1, 1, 1, 1, 1, 7, 7,   // white pawns
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7,   // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7,   // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7,   // 8 blank squares, 2 off board
        0, 0, 0, 0, 0, 0, 0, 0, 7, 7,   // 8 blank squares, 2 off board
        -1,-1,-1,-1,-1,-1,-1,-1, 7, 7,  // black pawns
        -4,-2,-3,-5,-9,-3,-2,-4, 7, 7,  // black pieces
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
        7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7
    };

    private static int [] index = {
        0, 12, 15, 10, 1, 6, 0, 0, 0, 6
    };

    private static int [] pieceMovementTable = {
        0, -1, 1, 10, -10, 0, -1, 1, 10, -10, -9, -11, 9,
        11, 0, 8, -8, 12, -12, 19, -19, 21, -21, 0, 10, 20,
        0, 0, 0, 0, 0, 0, 0, 0
    };
    private static int [] value = {
        0, 1, 3, 3, 5, 9, 0, 0, 0, 20
    };
    private static int [] blackSquares = {
        22, 24, 26, 28, 33, 35, 37, 39,
        42, 44, 46, 48, 53, 55, 57, 59,
        62, 64, 66, 68, 73, 75, 77, 79,
        82, 84, 86, 88, 93, 95, 97, 99
    };
}
