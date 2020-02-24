package name.mdemidov.interview.leetcode.task0295;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * 295. Find Median from Data Stream
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFinder {

    private List<Integer> data;

    public MedianFinder() {
        data = new ArrayList<>();
    }

    public void addNum(int num) {
        data.add(num);
    }

    public double findMedian() {
        Collections.sort(data);
        int mid = data.size() / 2;
        if (data.size() % 2 > 0) {
            return data.get(mid);
        } else {
            return (data.get(mid - 1) + data.get(mid)) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf1 = new MedianFinder();
        mf1.addNum(1);
        mf1.addNum(2);
        System.out.println(mf1.findMedian()); // 1.5
        mf1.addNum(3);
        System.out.println(mf1.findMedian()); // 2
    }
}
