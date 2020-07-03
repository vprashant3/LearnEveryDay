package com.codeforces.DesignPatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(T);

    }

    public int maxSubArrayDP(int[] nums) {
        int[] dp =  new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-1],0);
            max =  Math.max(max, dp[i]);
        }


        return max;
    }


    public int maxSubArrayKadane(int[] nums) {
        int curr_max = nums[0]; // local maxima
        int max_so_far = nums[0]; //global maxima

        for(int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], nums[i] + curr_max);
            max_so_far = Math.max(curr_max, max_so_far);
        }
        return max_so_far;
    }

    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        int j = 0;
        for(int i : T) {
            while(!stack.isEmpty() && i > stack.peek()) {
                res[j] = stack.size();
                stack.pop();
                j++;
            }
            stack.add(i);
        }
        return res;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i : nums2) {
            while(!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] =  map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void easy2 () {
        int[] input = {4,5,2,25};
        Stack<Integer> stack =  new Stack<>();
        for( int i : input) {
            while(!stack.isEmpty() && stack.peek() < i)
                System.out.println(stack.pop()+"  "+i);
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()+"  "+"-1");
        }
    }
    // soln 1
    public void easy1 () {
        int[] input = {4,5,2,25};
        Stack<Integer> stack =  new Stack<>();

        stack.push(input[0]);
        int next;
        int element;

        for(int i = 1; i < input.length; i++) {
            next = input[i];
            if(!stack.isEmpty()) {
                element = stack.pop();
                while( element < next) {
                    System.out.println(element +"--->"+ next);
                    if(stack.isEmpty()) break;
                    element = stack.pop();
                }
                if(element > next) {
                    stack.push(element);
                }
            }
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() +"--->"+"-1");
        }

    }


}
