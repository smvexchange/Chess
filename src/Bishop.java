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
        if (isInsideChessField(chessBoard, toLine, toColumn)) {
            if (isAnotherField(line, column, toLine, toColumn)) {
                if (isDiagonalMove(line, column, toLine, toColumn)) {
                    if (isEmptyLine(chessBoard, line, column, toLine, toColumn)) {
                        return isAttackOrEmptyField(chessBoard, toLine, toColumn);
                    } else return false;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
