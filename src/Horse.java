public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (line + 2 == toLine || line - 2 == toLine
                    || line + 1 == toLine || line - 1 == toLine
                    || column + 2 == toColumn || column - 2 == toColumn
                    || column + 1 == toColumn || column - 1 == toColumn) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    return true;
                } else if (!(chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor()))) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
