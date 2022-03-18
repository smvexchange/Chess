public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {             // chess field check
            if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {               // right move check
                if (isEmptyLine(chessBoard, line, column, toLine, toColumn)) {          // empty line check
                    if (chessBoard.board[toLine][toColumn] == null) {                   // can attack check
                        return true;
                    } else if (chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
                        return false;
                    } else return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    private boolean isEmptyLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isEmpty = true;
        int dirX;
        int dirY;
        if (toLine - line > 0) {
            dirX = 1;
        } else dirX = -1;
        if (toColumn - column > 0) {
            dirY = 1;
        } else dirY = -1;
        for (int i = 1; i < Math.abs(toLine - line); i++) {
            if (chessBoard.board[line + 1 * dirX][column + 1 * dirY] != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }
}
