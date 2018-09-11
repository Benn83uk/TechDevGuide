package net.benshouse.techdevguide;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {
    private Random random;
    private boolean[][] cells;
    public Minesweeper(int width, int height, int numMines) {
        this(width, height, numMines, new Random());
    }

    public Minesweeper(int width, int height, int numMines, Random random){
        this.random = random;
        int numCells = width * height;
        if (numMines > numCells || numCells == 0) throw new IllegalArgumentException("Number of mines exceeds number of spaces available");
        this.cells = new boolean[width][height];
        int i = 0;
        for (int w = 0; w < width; w++){
            for (int h = 0; h < height; h++) {
                float mineChance = (float)numMines / (float)numCells;
                if (mineChance > this.random.nextFloat()) {
                    this.cells[w][h] = true;
                    numMines--;
                } else {
                    this.cells[w][h] = false;
                }
                i++;
                numCells--;
            }
        }
    }

    /**
     * Returns a copy of the cells (to prevent modification of original data)
     * @return
     */
    public boolean[][] getCells(){
        boolean [][] copyCells = new boolean[this.cells.length][this.cells[0].length];
        for (int x = 0; x < copyCells.length; x++){
            boolean[] row = this.cells[x];
            copyCells[x] = Arrays.copyOf(row, row.length);
        }
        return copyCells;
    }

    /**
     * Returns a map of the cells showing the number of bombs each cell is next to
     * @return
     */
    public int[][] getMap(){
        int [][] map = new int[this.cells.length][this.cells[0].length];
        for (int x = 0; x < map.length; x++){
            for (int y = 0; y < map[x].length; y++){
                if (this.cells[x][y]){
                    //This cell is a bomb
                    map[x][y] = 9;
                    //if there is a cell above
                    if (x > 0){
                        //if that cell is not a bomb, increase it's value.
                        if (map[x-1][y] != 9) map[x-1][y]++;
                    }
                    //if there is a cell below
                    if (x < map.length -1){
                        //if that cell is not a bomb, increase it's value.
                        if (map[x+1][y] != 9) map[x+1][y]++;
                    }
                    //if there is a cell to the left
                    if (y > 0){
                        //if that cell is not a bomb, increase it's value.
                        if (map[x][y-1] != 9) map[x][y-1]++;
                    }
                    //if there is a cell to the right, increase its value
                    if (y < map[x].length-1){
                        //if that cell is not a bomb, increase it's value.
                        if (map[x][y+1] != 9) map[x][y+1]++;
                    }
                }
            }
        }
        return map;
    }

    public void printCells(){
        StringBuilder output = new StringBuilder();
        for (int x = 0; x < this.cells.length; x++){
            for (int y = 0; y < this.cells[x].length; y++){
                output.append(this.cells[x][y] ? "X" : "O");
                output.append(",");
            }
            output.append(System.lineSeparator());
        }
        System.out.println(output.toString());
    }

    public void printMap(){
        StringBuilder output = new StringBuilder();
        int[][] map = this.getMap();
        for (int x = 0; x < map.length; x++){
            for (int y = 0; y < map[x].length; y++){
                output.append(map[x][y]);
                output.append(",");
            }
            output.append(System.lineSeparator());
        }
        System.out.println(output.toString());
    }
}
