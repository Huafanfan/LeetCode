package com.huafanfan.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/27 13:27
 */
public class GenerateParentheses0022 {
    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list,0,0,n,new StringBuilder());
        return list;
    }
    void backtrack(List<String> list, int left, int right, int max, StringBuilder cur){
        if (cur.length()==max*2){
            list.add(cur.toString());
            return;
        }
        if (left<max){
            cur.append("(");
            backtrack(list,left+1,right,max,cur);
            cur.deleteCharAt(cur.length()-1);
        }
        if (left>right){
            cur.append(")");
            backtrack(list,left,right+1,max,cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }


    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
