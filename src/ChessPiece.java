public abstract class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public abstract String getColor();

    public boolean isInsideChessField(ChessBoard chessBoard, int toLine, int toColumn) {
        return chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn);
    }

    public boolean isAnotherField(int line, int column, int toLine, int toColumn) {
        return !(line == toLine && column == toColumn);
    }

    public boolean isDiagonalMove(int line, int column, int toLine, int toColumn) {
        return Math.abs(toLine - line) == Math.abs(toColumn - column);
    }

    // Overloading the method isDiagonalMove
    public boolean isDiagonalMove(int line, int column, int toLine, int toColumn, int fieldLimit) {
        return (Math.abs(toLine - line) <= fieldLimit && Math.abs(toColumn - column) <= fieldLimit)
                && (Math.abs(toLine - line) == Math.abs(toColumn - column));
    }

    public boolean isStraightMove(int line, int column, int toLine, int toColumn) {
        return (line == toLine ^ column == toColumn);
    }

    // Overloading the method isStraightMove
    public boolean isStraightMove(int line, int column, int toLine, int toColumn, int fieldLimit) {
        return (Math.abs(toLine - line) <= fieldLimit && Math.abs(toColumn - column) == 0)
                || (Math.abs(toLine - line) == 0 && Math.abs(toColumn - column) <= fieldLimit);
    }

    public boolean isAttackOrEmptyField(ChessBoard chessBoard, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else return !(chessBoard.board[toLine][toColumn].getColor().equals(getColor()));
    }

    public boolean isEmptyLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isEmpty = true;
        int dirX = Integer.compare(toLine, line);
        int dirY = Integer.compare(toColumn, column);
        int lineLength;
        if (dirY == 0) {
            lineLength = Math.abs(toLine - line);
        } else if (dirX == 0) {
            lineLength = Math.abs(toColumn - column);
        } else lineLength = Math.abs(toColumn - column);
        for (int i = 1; i < lineLength; i++) {
            if (chessBoard.board[line + i * dirX][column + i * dirY] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }
}
