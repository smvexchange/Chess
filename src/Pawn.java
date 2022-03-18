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
        int dir = 0;
        int startPos = 0;
        if (getColor().equals("White")) {
            dir = 1;
            startPos = 1;
        } else if (getColor().equals("Black")) {
            dir = -1;
            startPos = 6;
        } else return false;

        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (column == toColumn) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    if (line + 2 * dir == toLine
                            && chessBoard.board[line + dir][column] == null
                            && line == startPos) {
                        return true;
                    } else return line + dir == toLine;
                } else return false;
            } else if (Math.abs(column - toColumn) == 1) {
                if (chessBoard.board[toLine][toColumn] != null
                        && !(chessBoard.board[toLine][toColumn].getColor().equals(getColor()))) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
