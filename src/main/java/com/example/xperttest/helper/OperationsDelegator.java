package com.example.xperttest.helper;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class OperationsDelegator {

    private long[][][] tree;
    private long[][][] numbers;
    private int initialSet = 0;

    public void update(int x, int y, int z, int value) {
        long delta = value - numbers[x][y][z];
        numbers[x][y][z] = value;
        for (int i = x + 1; i <= initialSet; i += i & (-i)) {
            for (int j = y + 1; j <= initialSet; j += j & (-j)) {
                for (int k = z + 1; k <= initialSet; k += k & (-k)) {
                    tree[i][j][k] +=  delta;
                }
            }
        }
    }

    public BigInteger query(int x1, int y1, int z1, int x2, int y2, int z2) {
        long result = summation(x2+1,y2+1,z2+1) - summation(x1,y1,z1) - summation(x1,y2+1,z2+1) - summation(x2+1,y1,z2+1) - summation(x2+1,y2+1,z1) + summation(x1,y1,z2+1) + summation(x1,y2+1,z1) + summation(x2+1,y1,z1);
        return BigInteger.valueOf(result);
    }

    private long summation(int x, int y, int z) {
        long sum = 0l;
        for (int i = x; i > 0; i -= i & (-i)) {
            for (int j = y; j > 0; j -= j & (-j)) {
                for (int k = z; k > 0; k -= k & (-k)) {
                    sum += tree[i][j][k];
                }
            }
        }
        return sum;
    }


    public void setMethod(Integer initialSet) {
        if (initialSet == 0) return;
        this.initialSet = initialSet;
        tree = new long[initialSet+1][initialSet+1][initialSet+1];
        numbers = new long[initialSet][initialSet][initialSet];
    }


}
