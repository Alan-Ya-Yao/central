package com.example.company.shopee_202104;

import java.util.*;

/**
 * /**
 *
 * @ClassName: TopKFrequentWords
 * @description:
 * @author: pengyi
 * @create: 2021-04-15 18:01
 **/
public class TopKFrequentWords {

    /**
     * Given a non-empty list of words, return the k most frequent elements.
     *
     * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
     *
     * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * Output: ["the", "is", "sunny", "day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     *     with the number of occurrence being 4, 3, 2 and 1 respectively.
     * */
    public static List<String> topKFrequent(String[] words, int k) {
        // key：字符串，value：出现的次数
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        // 传入 count.keySet() 对列表初始化
        List<String> candidates = new ArrayList<>(count.keySet());
        candidates.sort(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                if (count.get(w1).equals(count.get(w2))) {
                    return w1.compareTo(w2);
                } else {
                    return count.get(w2) - count.get(w1);
                }
            }
        });
        return candidates.subList(0, k);
    }

    public static void main(String[] args) {
        String[] nums = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "tencent", "wechat"};
        topKFrequent(nums, 4);
    }
}
