package Graph.testingClasses;

public class Test4 {

    static void dfs(char[][] matrix, int currentRow, int currentColumn, boolean[][] visited, StringBuilder path, StringBuilder onlyLetters) {

        visited[currentRow][currentColumn] = true;

        if (Character.isAlphabetic(matrix[currentRow][currentColumn])) {
            onlyLetters.append(matrix[currentRow][currentColumn]);
            path.append(matrix[currentRow][currentColumn]);
        } else {
            path.append(matrix[currentRow][currentColumn]);
        }

        // Nagore
        if (currentRow - 1 >= 0 && !visited[currentRow - 1][currentColumn] && matrix[currentRow - 1][currentColumn] != '0') {
            dfs(matrix, currentRow - 1, currentColumn, visited, path, onlyLetters);
        }
        // Nadole
        if (currentRow + 1 < matrix.length && !visited[currentRow + 1][currentColumn] && matrix[currentRow + 1][currentColumn] != '0') {
            dfs(matrix, currentRow + 1, currentColumn, visited, path, onlyLetters);
        }
        // Levo
        if (currentColumn - 1 >= 0 && !visited[currentRow][currentColumn - 1] && matrix[currentRow][currentColumn - 1] != '0') {
            dfs(matrix, currentRow, currentColumn - 1, visited, path, onlyLetters);
        }
        // Desno
        if (currentColumn + 1 < matrix[0].length && !visited[currentRow][currentColumn + 1] && matrix[currentRow][currentColumn + 1] != '0') {
            dfs(matrix, currentRow, currentColumn + 1, visited, path, onlyLetters);
        }

        /*
        najprvo provere da ne mine granicata, posle toa !visited[currentRow][currentColumn - 1] dali e veke bil tamoka
        i nakraj matrix[currentRow][currentColumn + 1] != '0' ovoa gleda da ne e nula samo da sobira drugite znaci
         */

    }

    public static void main(String[] args) {
        // Tuka gi ispuniv tie so nuli za polesna navigacija
        // test primer 2 e ovoa samo smeni dole kaj povikko na funkicjata
        char[][] matrix = new char[][]{
                {'>', '-', '-', '-', 'A', '-', '@', '-', '+'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '|'},
                {'+', '-', 'U', '-', '+', '0', '0', '0', 'C'},
                {'|', '0', '0', '0', '|', '0', '0', '0', '|'},
                {'S', '0', '0', '0', 'C', '-', '-', '-', '+'},
        };

        // test primer 1 e ovoa samo smeni dole kaj povikko na funkicjata
        char[][] matrix2 = new char[][]{
                {'>', '-', '-', '-', 'A', '-', '-', '-', '+'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '|'},
                {'S', '-', 'B', '-', '+', '0', '0', '0', 'C'},
                {'0', '0', '0', '0', '|', '0', '0', '0', '|'},
                {'0', '0', '0', '0', '+', '-', '-', '-', '+'},
        };

        // Ovoa cisto da vidam dali e dobro
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];


        // ovaj kod ti e ako ne pocnes od gore nevo najpocetko da najde deka e strelkata
        boolean flag = false;
        int startRow = -1, startColumn = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '>') {
                    startRow = i;
                    startColumn = j;
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }

        StringBuilder path = new StringBuilder();
        StringBuilder onlyLetters = new StringBuilder();
        //Rekurzivno
        dfs(matrix, startRow, startColumn, visited, path, onlyLetters);

        System.out.println(path);
        // Ovoa tuka go pravam za da ja trgne S na krajo da ti sprored test primero
        System.out.println(onlyLetters.substring(0, onlyLetters.length() - 1));
    }

}
