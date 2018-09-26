//Given a 2D matrix of characters and a target word, write a function that returns whether the word can be
//        found in the matrix by going left-to-right, or up-to-down.
//
//        For example, given the following matrix:
//
//        [['F', 'A', 'C', 'I'],
//        ['O', 'B', 'Q', 'P'],
//        ['A', 'N', 'O', 'B'],
//        ['M', 'A', 'S', 'S']]
//
//        and the target word 'FOAM', you should return true, since it's the leftmost column.
//        Similarly, given the target word 'MASS', you should return true, since it's the last row.

public class DailyCodingProblem {

    class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean findInGrid(char[][] grid, String word) {
        int rowSize = grid[0].length;
        int columnSize = grid.length;
        Coordinates coordinates = new Coordinates(0, 0);
        while (coordinates.x < columnSize && coordinates.y < rowSize) {
            coordinates = findTheIndexInGrid(grid, coordinates, word.charAt(0));
            if (coordinates == null) {
                return false;
            } else {
                if (checkHorizontal(grid, coordinates, word) || checkVertical(grid, coordinates, word)) {
                    return true;
                }
            }
            coordinates.y++;
        }
        return false;
    }

    private boolean checkVertical(char[][] grid, Coordinates coordinates, String word) {
        if (Math.abs(coordinates.x - grid.length) < word.length()) {
            return false;
        }
        for (int k = 0, i = coordinates.x; i < grid.length && k < word.length(); i++) {
            if (grid[i][coordinates.y] == word.charAt(k)) {
                k++;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkHorizontal(char[][] grid, Coordinates coordinates, String word) {
        if (Math.abs(coordinates.y - grid[coordinates.x].length) < word.length()) {
            return false;
        }
        for (int k = 0, i = coordinates.y; i < grid[coordinates.x].length && k < word.length(); i++) {
            if (grid[coordinates.x][i] == word.charAt(k)) {
                k++;
            } else {
                return false;
            }
        }
        return true;
    }

    private Coordinates findTheIndexInGrid(char[][] grid, Coordinates c, char w) {
        int i = c.x;
        int j = c.y;
        while (i < grid.length) {
            while (j < grid[i].length) {
                if (grid[i][j] == w) {
                    return new Coordinates(i, j);
                }
                j++;
            }
            j = 0;
            i++;
        }
        return null;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };
        DailyCodingProblem problem = new DailyCodingProblem();
        System.out.println(problem.findInGrid(grid, "MASS"));
    }
}
