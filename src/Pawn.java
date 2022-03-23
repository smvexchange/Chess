public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int dir;
        int startPos;
        if (getColor().equals("White")) {
            dir = 1;
            startPos = 1;
        } else if (getColor().equals("Black")) {
            dir = -1;
            startPos = 6;
        } else return false;

        if (isInsideChessField(chessBoard, toLine, toColumn)) {
            if (isAnotherField(line, column, toLine, toColumn)) {
                if (column == toColumn) {
                    if (chessBoard.board[toLine][toColumn] == null) {
                        if (line + 2 * dir == toLine
                                && chessBoard.board[line + dir][column] == null
                                && line == startPos) {
                            chessBoard.setPassingPawn(true);  // set passing pawn flag
                            return true;
                        } else {
                            chessBoard.setPassingPawn(false);  // unset passing pawn flag
                            return line + dir == toLine;
                        }
                    } else return false;
                } else if (Math.abs(column - toColumn) == 1) {
                    if (chessBoard.board[toLine][toColumn] != null) {
                        return !(chessBoard.board[toLine][toColumn].getColor().equals(getColor()));
                    } else return chessBoard.isPassingPawn();
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
