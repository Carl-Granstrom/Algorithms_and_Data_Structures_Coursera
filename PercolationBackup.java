//Carl Granström, Algorithms 1, April 2018
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    public int num; //length of percolation grid sides
    public int gridsize; //total size of the n*n precolation grid +2 for the top and bottom extra nodes
    public int totalOpen = 0; //total number of open sites
    public WeightedQuickUnionUF grid = new WeightedQuickUnionUF();
    public boolean sites[] = new boolean[]

    public Percolation(int n) {                // create n-by-n grid, with all sites blocked
        if (n <= 0) throw java.lang.IllegalArgumentException;
        int num = n;  //unused?
        gridsize = (n ^ 2 + 2);
        grid = WeightedQuickUnionUF(gridsize);
        sites = boolean[gridsize];
        sites[0] = true;
        sites[gridsize + 1] = true;
    }

    private int xyTo1D(int row, int col) {   //private method for mapping from col/row to 1 the UF-1D structure
        private int oneDim = (((row - 1) * num) + col);
        return oneDim;
    }

    public void open(int row, int col) {   // open site (row, col) if it is not open already
        int index = xyTo1D(row, col);
        if (validateIndex(index) == false){
            throw java.lang.IllegalArgumentException;
        }

        if (sites[index] == true) {
            return;
        }

        if (sites[index] == false) {
            totalOpen =+ 1;
            sites[index] = true;
        }



        if () //merge with adjecent open sites! (make private method?)
    }

    private void connect(int index){
        if (grid.connected(index, (index - num)) {

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

    }

    public int numberOfOpenSites() {      // number of open sites
        return totalOpen;
    }

    public boolean percolates() {             // does the system percolate?

    }

    public static void main(String[] args) {  // test client (optional)

    }

}

//union–find methods union(), find(), connected(), and count()