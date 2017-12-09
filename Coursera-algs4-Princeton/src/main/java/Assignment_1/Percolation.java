package Assignment_1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * api 方法要有防御性编程的意识。
 * 一开始只有PercolationStats的使用场景我就没有考虑异常参数的问题，但其实是这个Percolation会给任何场景进行调用。
 * 该版本的在v1的基础上对如下trick进行修改
 * trick：Percolation已经percolates，有一个cell是打开状态，和底部连接，但是和顶部不连接，这时判断该cell是否full的话，会判断为true
 * ，但是其实是false，因为isFull的状态定义是和top有连接
 *
 */
public class Percolation {

    private final int n;

    private boolean[] isOpen;

    private final int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private final WeightedQuickUnionUF unionUF;

    // 针对full的情况，只有一个虚拟的top，没有虚拟的bottom
    private final WeightedQuickUnionUF fullUnionUF;

    private int openSum = 0;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        isOpen = new boolean[this.n * this.n + 2]; // open = true，not open = false
        isOpen[0] = true;
        isOpen[this.n * this.n + 1] = true;
        //+2 are for additional top and bottom cells
        // 简单的将所有top和bottom cells进行判断是否连通,每次判断Percolation的复杂度是n^2
        // 所以添加两个虚拟的点，一个点和所有top连通，一个和所有bottom连通，这样只要判断两个点的连通性就好了，每次复杂度O(1)
        unionUF = new WeightedQuickUnionUF(this.n * this.n + 2);

        fullUnionUF = new WeightedQuickUnionUF(this.n * this.n + 1);
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        if (isOpen[(row - 1) * n + col]) {
            return;
        }
        isOpen[(row - 1) * n + col] = true;
        openSum++;

        int a, b;
        for (int i = 0; i < 4; i++) {
            a = row + move[i][0];
            b = col + move[i][1];

            if (a == n + 1) {
                unionUF.union(n * n + 1, (row - 1) * n + col);
            }
            else if (a == 0) {
                unionUF.union(0, (row - 1) * n + col);
                fullUnionUF.union(0, (row - 1) * n + col);
            }
            else if (b >= 1 && b <= n && isOpen(a, b)) {
                unionUF.union((row - 1) * n + col, (a - 1) * n + b);
                fullUnionUF.union((row - 1) * n + col, (a - 1) * n + b);
            }

        }
    }

    // is site (row, col) open?
    // 这个方法要抛出IllegalArgumentException的异常我表示疑惑...对于不在范围内的row&col我是直接返回false的...但是课程要求就这么改吧...
    // 不过好像jdk里一些判断也是对参数不合法的情况就直接抛出异常。因为api之间不能有耦合这样的么？还是什么...
    // return !(row > n || row <= 0 || col > n || col <= 0) && isOpen[(row - 1) * n + col];
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return isOpen[(row - 1) * n + col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) {
            return false;
        }

        int index = (row - 1) * n + col;
        return fullUnionUF.connected(0, index);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openSum;
    }

    // does the system percolate?
    public boolean percolates() {
        return unionUF.connected(0, this.n * this.n + 1);
    }

    // validate that p is a valid index
    private void validate(int row, int col) {
        if (row > n || row <= 0 || col > n || col <= 0) {
            throw new IllegalArgumentException();
        }
    }


}
