import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

//    private List<List<Integer>> matrix;
////    Matrix(List<List<Integer>> values) {
////        this.matrix = values;
////
//
//
//    }

//    Set<MatrixCoordinate> getSaddlePoints() {
////        Set<MatrixCoordinate> result = new HashSet<>();
////        for (List<Integer> row: matrix) {
////            int maxInRow = getMax(row);
////            int maxIndex = row.indexOf(maxInRow);
////            int minInColumn = getMinInColumn(matrix, maxIndex, maxInRow);
////
////            if (maxInRow == minInColumn) result.add(new MatrixCoordinate())
////        }
////
////        return null;
//    }

//    private int getMax(List<Integer> row) {
//        Collections.sort(row);
//        return row.get(row.size() - 1);
//    }
//
//    private int getMinInColumn(List<List<Integer>> matrix, int columnIndex, int maxInRow) {
//        int min = maxInRow;
//        for (List<Integer> row: matrix) {
//            if (min > row.get(columnIndex))
//            min = row.get(columnIndex);
//        }
//
//        return min;
//    }

    private List<List<Integer>> matrix;
    private Set<MatrixCoordinate> saddlePoint = new HashSet<>();

    Matrix(List<List<Integer>> values) {
        this.matrix = values;
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix.get(0).size(); column++) {

                if (isSaddlePoint(row, column)) {
                    MatrixCoordinate coordinate = new MatrixCoordinate(row + 1, column + 1);
                    saddlePoint.add(coordinate);
                }
            }
        }
    }
    Set<MatrixCoordinate> getSaddlePoints() {

        return saddlePoint;
    }

    Boolean isSaddlePoint(int row, int column){
        int minInColumn = matrix.get(row).get(column);
        for (List<Integer> columns:matrix){
            if (columns.get(column)<minInColumn){
                minInColumn = columns.get(column);
            }
        }
        return Collections.max(matrix.get(row)) <= minInColumn;
    }
}