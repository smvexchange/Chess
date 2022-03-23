public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isInsideChessField(chessBoard, toLine, toColumn)) {
            if (isAnotherField(line, column, toLine, toColumn)) {
                if (isDiagonalMove(line, column, toLine, toColumn, 1)
                        || isStraightMove(line, column, toLine, toColumn, 1)) {
                    return isAttackOrEmptyField(chessBoard, toLine, toColumn);
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        boolean isUnderAttack = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < i; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(getColor())) {
                        if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            isUnderAttack = true;
                        }
                    }
                }
            }
        }
        return !isUnderAttack;
    }
}
