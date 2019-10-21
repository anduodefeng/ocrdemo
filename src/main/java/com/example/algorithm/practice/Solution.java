package com.example.algorithm.practice;

public class Solution {

    public static void main(String[] args){

        int[][] ii = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};

        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(ii, 3));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        for (int[] in : matrix) {
            if (target == in[in.length - 1]) {
                return true;
            } else if (target < in[in.length - 1]) {
                for (int j : in) {
                    if (target == j) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
