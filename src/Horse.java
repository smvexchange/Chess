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
        if (isInsideChessField(chessBoard, toLine, toColumn)) {
            if (isAnotherField(line, column, toLine, toColumn)) {
                // this statement checks "L-shape" move and max 2 field move limit
                if (!isDiagonalMove(line, column, toLine, toColumn) && !isStraightMove(line, column, toLine, toColumn)) {
                    if ((Math.abs(toLine - line) <= 2) && Math.abs(toColumn - column) <= 2) {
                        return isAttackOrEmptyField(chessBoard, toLine, toColumn);
                    } else return false;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";

    }
}
