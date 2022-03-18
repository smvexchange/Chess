public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {                 // chess field check
            if (line == toLine ^ column == toColumn) {                                     // right move check
                if (isEmptyLine(chessBoard, line, column, toLine, toColumn)) {              // empty line check
                    if (chessBoard.board[toLine][toColumn] == null) {                       // can attack check
                        return true;
                    } else return !chessBoard.board[toLine][toColumn].getColor().equals(getColor());
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    private boolean isEmptyLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isEmpty = true;
        int dirX = Integer.compare(toLine, line);
        int dirY = Integer.compare(toColumn, column);
        isEmpty = Queen.isEmptyX(chessBoard, line, column, toLine, toColumn, isEmpty, dirX, dirY);
        return isEmpty;
    }
}
