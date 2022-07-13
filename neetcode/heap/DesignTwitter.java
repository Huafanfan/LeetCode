package neetcode.heap;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/13 16:59
 */
public class DesignTwitter {
    int time;
    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> userMap;
    public DesignTwitter() {
        time = 0;
        tweetMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet();
        t.id = tweetId;
        t.time = time++;
        List<Tweet> tweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        tweets.add(t);
        tweetMap.put(userId, tweets);
        follow(userId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> followeeIds = userMap.get(userId);
        Queue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.time - o1.time;
            }
        });
        int circle = 0;
        while (followeeIds != null){
            circle++;
            for (int followeeId : followeeIds){
                List<Tweet> tweets = tweetMap.get(followeeId);
                if (tweets != null && tweets.size() - circle >=0){
                    pq.add(tweets.get(tweets.size() - circle));
                }
            }
            if (!pq.isEmpty() && ans.size() != 10){
                ans.add(pq.poll().id);
            } else {
                return ans;
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> users = userMap.getOrDefault(followerId, new HashSet<>());
        users.add(followeeId);
        userMap.put(followerId, users);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> users = userMap.getOrDefault(followerId, new HashSet<>());
        users.remove(followeeId);
        userMap.put(followerId, users);
    }

    public static class Tweet {
        int time;
        int id;
    }
}
