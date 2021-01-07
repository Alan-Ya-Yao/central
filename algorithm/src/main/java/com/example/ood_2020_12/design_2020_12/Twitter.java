package com.example.ood_2020_12.design_2020_12;

import java.util.*;

public class Twitter {

    private HashMap<Integer, List<Tweets>> userTweets;

    private HashMap<Integer, Set<Integer>> userFollowerId;


    static class Tweets{
        int tweetId;
        int userId;
        Date timeStampe;
        Tweets(int tweetId, int userId){
            this.tweetId = tweetId;
            this.userId = userId;
            timeStampe = new Date();
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

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

    }
}
