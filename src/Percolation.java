//Carl Granström, Algorithms 1, April 2018
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.*;

public class Percolation {
    public int num; //length of percolation grid sides
    public int gridsize; //total size of the n*n precolation grid +2 for the top and bottom extra nodes
    public int totalOpen = 0; //total number of open sites
    public WeightedQuickUnionUF grid;
    public boolean[] sites;

    public Percolation(int n) {                // create n-by-n grid, with all sites blocked
        if (n <= 0) throw new java.lang.IllegalArgumentException();
        this.num = n;
        this.gridsize = (n ^ 2 + 2);
        this.grid = new WeightedQuickUnionUF(gridsize);
        sites = new boolean[gridsize];
        sites[0] = true;
        sites[gridsize + 1] = true;
    }

    private int xyTo1D(int row, int col) {   //private method for mapping from col/row to 1 the UF-1D structure
        int oneDim = (((row - 1) * num) + col);
        return oneDim;
    }

    public void open(int row, int col) {   // open site (row, col) if it is not open already
        int index = xyTo1D(row, col);
        if (validateIndex(index) == false){
            throw new java.lang.IllegalArgumentException();
        }

        if (sites[index] == true) {
            return;
        }

        if (sites[index] == false) {
            totalOpen =+ 1;
            sites[index] = true;
            connectSite(index);
        }

    }

    private void connectSite(int index){
        if (sites[index - num] == true) {
            grid.union(index, (index - num));  //top union
        }
        if (sites[index - 1] == true) {
            grid.union(index, (index - 1));  //left union
        }
        if (sites[index + 1] == true) {
            grid.union(index, (index + 1));  //right union
        }
        if (sites[index + num] == true) {
            grid.union(index, (index + num));  //bottom union
        }
    }

    private boolean validateIndex(int index){
        if (index <= (gridsize - 2)) {
            return true;
        };
        return false;
    }

    public boolean isOpen(int row, int col) { // is site (row, col) open?
        int index = xyTo1D(row, col);
        return sites[index];
    }

    public boolean isFull(int row, int col) { // is site (row, col) full?
        int index = xyTo1D(row, col);
        return grid.connected(0, index);
    }

    public int numberOfOpenSites() {      // number of open sites
        return totalOpen;
    }

    public boolean percolates() {             // does the system percolate?
        if (grid.connected(0, gridsize -1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {  // test client (optional)

    }
}