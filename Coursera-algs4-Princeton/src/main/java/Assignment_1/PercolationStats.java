package Assignment_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] res;

    private final double mean;

    private final double stddev;

    private final double confidenceLo;

    private final double confidenceHi;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        res = new double[trials];

        for (int t = 0; t < trials; t++) {
            Percolation percolation = new Percolation(n);
            for (int i = 0; i < n * n; i++) {
                int row, col;
                do {
                    int pt = (int) (StdRandom.uniform() * n * n);
                    row = pt / n + 1;
                    col = pt % n + 1;

                } while (percolation.isOpen(row, col));
                percolation.open(row, col);
                if (percolation.percolates()) {
                    res[t] = ((double) percolation.numberOfOpenSites()) / (n * n);
                    break;
                }
            }
        }

        mean = StdStats.mean(res);
        stddev = StdStats.stddev(res);
        confidenceLo = mean() - ((1.96 * stddev()) / Math.sqrt(res.length));
        confidenceHi = mean() + ((1.96 * stddev()) / Math.sqrt(res.length));
    }

    // sample mean of percolation threshold
    public double mean() {
        return this.mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return this.stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.confidenceHi;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int trials = StdIn.readInt();
        PercolationStats ps = new PercolationStats(n, trials);
        StdOut.print("mean = " + ps.mean() + "\n");
        StdOut.print("std dev = " + ps.stddev() + "\n");
        StdOut.print("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
    }

}