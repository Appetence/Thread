package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @program: pay-router
 * @description:
 * @author: xiamu
 * @create: 2021-03-16 16:28
 */
public class MaxLongString {

    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5122 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    public static void main(String[] args) {
/*        long start2 = System.currentTimeMillis();
        String randomString = getRandomString(100000000L);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);*/
        String randomStringByLength = "abcdadd";//getRandomStringByLength(100000000L);
        long start1 = System.currentTimeMillis();
        System.out.println(lengthOfLongestSubstring(randomStringByLength));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
        randomStringByLength = "aab";
        String o = toMaxRepeatLength(randomStringByLength);
    }

    private static String toMaxRepeatLength(String randomStringByLength) {
        HashMap<String, HashMap<Integer, Integer>> result = new HashMap<>();
        char[] chars = randomStringByLength.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String aChar = String.valueOf(chars[i]);
            if (result.containsKey(aChar)) {
                //已含有该字符
                HashMap<Integer, Integer> stringIntegerHashMap = result.get(aChar);
                int key = i - 1;
                if (stringIntegerHashMap.containsKey(key)) {
                    stringIntegerHashMap.put(i, stringIntegerHashMap.get(key) + 1);
                    stringIntegerHashMap.remove(key);
                } else {
                    stringIntegerHashMap.put(i, 1);
                }
            } else {
                //未含有该字符
                HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
                integerIntegerHashMap.put(i, 1);
                result.put(aChar, integerIntegerHashMap);
            }
        }
        HashMap<String, Integer> finalOut = new HashMap<>();
        result.entrySet().forEach((k) -> {
            System.out.println(k);
            finalOut.put(String.valueOf(k), result.get(k).entrySet().stream().sorted((p, q) -> p.getValue().compareTo(q.getValue()))
                    .collect(Collectors.toList())
                    .get(0).getValue());
        });
        Map<String, Integer> stringIntegerMap = sortMapByValues(finalOut);
        Map.Entry entry = stringIntegerMap.entrySet().iterator().next();
        String key = (String) entry.getKey();
        String value = (String) entry.getValue();


        return key + ":" + value;
    }

    public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
        HashMap<K, V> finalOut = new LinkedHashMap<>();
        aMap.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        return finalOut;
    }

    /**
     * 创建辅助数组，长度为128,并将传入的字符串的每个字符作为辅助数组的下标
     * 计算同一个元素重复出现时候下标差值判断最小字符长度，比较每次重复时候字符串长度和上次重复长度大小，返回较大值
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int fa = 0;
        int n = s.length();
        int[] map = new int[128];
        //字符数组
        char[] ch = s.toCharArray();
        for (int j = 0, i = 0; j < n; j++) {
            //指定字符存储的字符串和偏移量直接的大小
            i = Math.max(map[ch[j]], i);
            //字符串的长度等于最后一个字符的下标 - 最前面一个字符的下标
            fa = Math.max(fa, j - i + 1);
            //以字符作为map数组的下标，并给对应的下标赋值
            map[ch[j]] = j + 1;
        }
        return fa;
    }

    public static String getRandomStringByLength(long length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        int baseLength = base.length();
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(baseLength);
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
//leetcode submit region end(Prohibit modification and deletion)

}


