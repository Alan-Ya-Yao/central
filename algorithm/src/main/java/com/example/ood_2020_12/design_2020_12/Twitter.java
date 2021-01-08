package com.example.ood_2020_12.design_2020_12;

import java.util.*;

public class Twitter {
    /***
     *     alan 注意限制 list of tweets的大小
     *
     *
     */
    private HashMap<Integer, List<Tweets>> userTweets;

    private HashMap<Integer, Set<Integer>> userFollowerId;

    static class Tweets{
        int tweetId;
        int userId;
        Date timeStampe;
        Tweets(int userId, int tweetId){
            this.tweetId = tweetId;
            this.userId = userId;
            timeStampe = new Date();
        }
        private Date getTimeStampe(){
            return this.timeStampe;
        }
        private int getTweetId(){
            return this.tweetId;
        }

    }
    /** Initialize your data structure here. */
    public Twitter() {
        userTweets = new HashMap<>();
        userFollowerId = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweets tweets = new Tweets(userId, tweetId);
        userTweets.compute(userId, (id, tweetsList)->{
            if(Objects.isNull(tweetsList)){
                List<Tweets> newList = new ArrayList<>();
                newList.add(tweets);
                return newList;
            }else{
                tweetsList.add(tweets);
                if(tweetsList.size() > 10){
                    tweetsList.remove(0);
                }
                return tweetsList;
            }
        });
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList();
        PriorityQueue<Tweets> tweetsMaxHeap = new PriorityQueue<Tweets>(
                (o1, o2)->{ return  o2.getTimeStampe().compareTo(o1.getTimeStampe());}
        );
        if(Objects.nonNull(userTweets.get(userId))){
            tweetsMaxHeap.addAll(userTweets.get(userId));
        }
        Set<Integer> followees = userFollowerId.get(userId);
        if(Objects.nonNull(followees)){
            for(Integer followeeId: followees){
                if(Objects.nonNull(userTweets.get(followeeId))){
                    tweetsMaxHeap.addAll(userTweets.get(followeeId));
                }
            }
        }
        for(int i = 0; i < 10; i++){
            if(tweetsMaxHeap.size() > 0){
                result.add(tweetsMaxHeap.poll().getTweetId());
            }
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
       if(Objects.isNull(followeeId) || Objects.isNull(followerId)){
           return;
       }
        Set<Integer> followees = userFollowerId.get(followerId);
       if(Objects.nonNull(followees)){
           followees.add(followeeId);
       }else{
           followees.add(followeeId);
       }

        return;
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(Objects.isNull(followeeId) || Objects.isNull(followerId)){
            return;
        }
        Set<Integer> followees = userFollowerId.get(followerId);
        if(Objects.nonNull(followees)){
            followees.remove(followeeId);
        }
        return;
    }
    public static void main(String[]args){
        Twitter solution = new Twitter();
        solution.postTweet(1, 5);
        solution.postTweet(1, 3);
        List<Integer> list = solution.getNewsFeed(1);
        list.forEach(System.out::println);
    }
}
