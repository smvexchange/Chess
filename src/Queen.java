public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {                 // chess field check
            if ((line == toLine ^ column == toColumn) || (Math.abs(toLine - line) == Math.abs(toColumn - column))) {
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
        return "Q";
    }

    private boolean isEmptyLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isEmpty = true;
        int dirX;
        int dirY;
        if (line == toLine ^ column == toColumn) {
            dirX = Integer.compare(toLine, line);
            dirY = Integer.compare(toColumn, column);
            isEmpty = isEmptyX(chessBoard, line, column, toLine, toColumn, isEmpty, dirX, dirY);
        }
        if ((Math.abs(toLine - line) == Math.abs(toColumn - column))) {
            if (toLine - line > 0) {
                dirX = 1;
            } else dirX = -1;
            if (toColumn - column > 0) {
                dirY = 1;
            } else dirY = -1;
            for (int i = 1; i <= Math.abs(toLine - line); i++) {
                if (chessBoard.board[line + dirX][column + dirY] != null) {
                    isEmpty = false;
                    break;
                }
            }
        }
        return isEmpty;
    }

    static boolean isEmptyX(ChessBoard chessBoard,
                            int line, int column,
                            int toLine, int toColumn,
                            boolean isEmpty,
                            int dirX, int dirY) {
        int lineLength = 0;
        if (dirY == 0) {
            lineLength = Math.abs(toLine - line);
        }
        if (dirX == 0) lineLength = Math.abs(toColumn - column);
        for (int i = 1; i < lineLength; i++) {
            if (chessBoard.board[line + dirX][column + dirY] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }
}