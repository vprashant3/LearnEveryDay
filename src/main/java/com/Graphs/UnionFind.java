package com.Graphs;

import java.util.Arrays;

public class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];
        if(rootX != rootY) {
            for (int i = 0; i < root.length ; i++) {
                if(root[i] == rootY) root[i] = rootX;
            }
        }
    }

    public boolean connected(int x, int y) {
        return  root[x] == root[y];
    }

}






