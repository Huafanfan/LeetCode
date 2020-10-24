package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/24 09:40
 */
public class VideoStitching1024 {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] clip : clips) {
            if (clip[0]<left||clip[1]>right){
                if (!map.containsKey(clip[0])) {
                    map.put(clip[0], clip[1]);
                    left = Math.min(left, clip[0]);
                    right = Math.max(right, clip[1]);
                } else {
                    int key = map.get(clip[0]);
                    if (key < clip[1]) {
                        map.put(clip[0], clip[1]);
                        left = Math.min(left, clip[0]);
                        right = Math.max(right, clip[1]);
                    }
                }
            }
        }
        int start = 0;
        int end = 0;
        if (!map.containsKey(start)){
            return -1;
        }
        else {
            end = map.get(start);
        }

        int result = 1;
        int hasVisit = 0;
        while (end < T){
            if (hasVisit == end){
                return -1;
            }
            if (map.containsKey(end)){
                hasVisit = end;
                end = map.get(end);
                result++;
            }
            else {
                end--;
            }
        }
        return result;
    }

    public int videoStitchingDP(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    public int videoStitchingGreedy(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        System.out.println(Arrays.toString(maxn));
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        //int[][] clips = {{16,18},{16,20},{3,13},{1,18},{0,8},{5,6},{13,17},{3,17},{5,6}};
        //int[][] clips = {{0,1},{1,2}};
        int[][] clips = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        VideoStitching1024 videoStitching1024 = new VideoStitching1024();
        System.out.println(videoStitching1024.videoStitchingGreedy(clips,9));
    }
}
