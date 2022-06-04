package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: pay-router
 * @description:
 * @author: xiamu
 * @create: 2021-03-15 16:54
 */
public class Solution {
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组
// 👍 692 👎 0
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> integers = spiralOrder(matrix);
        System.out.println(integers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        /**
         * 螺旋矩阵问题，每次循环获取最外层的元素
         */
        int top = 0, bottom = matrix.length - 1;
        //前提是已知所有行长度相同
        int left = 0, right = matrix[0].length - 1;
        int y  = 0;
        //前提是x轴和y轴长度相同
        while (top < (matrix.length + 1) / 2 && left < (matrix[y].length + 1) / 2) {
            //上边
            for (int i = left; i <= right; i++) {
                result.add(matrix[left][i]);
            }
            //右边 +1 代表忽略开始那行
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            //下边 -1 代表忽略最右侧的那个  top ！= bottom 避免同一行进行操作
            for (int i = right - 1; i >= left && top != bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            //左边 -1 代表忽略最下边那个  +1 代表忽略最上边的那个  ！=  避免同一列进行操作引
            for (int i = bottom - 1; i >= top+1 && left != right; i--) {
                result.add(matrix[i][left]);
            }
            top++;
            left++;
            bottom--;
            right--;
            y++;
        }
        return result;
    }
//leetcode submit region end(Prohibit modification and deletion)
}
