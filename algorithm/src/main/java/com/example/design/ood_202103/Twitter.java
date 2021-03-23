package com.example.design.ood_202103;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.Data;

import java.sql.Timestamp;
import java.util.*;

/**
 * /**
 *
 * @ClassName: twitter
 * @description:
 * @author: pengyi
 * @create: 2021-03-23 16:53
 **/
class Twitter {



     /**
      * alan 注意限制 list of tweets的大小
     */
    private HashMap<Integer, List<Tweet>> userTweets;

    private HashMap<Integer, Set<Integer>> userFollowee;

    private static Long Timestamp = 0l;

    static class Tweet{
        int tweetId;
        int userId;
        Long timeStampe;
        Tweet(int userId, int tweetId){
            this.tweetId = tweetId;
            this.userId = userId;
            timeStampe = Timestamp++;
        }
        private Long getTimeStampe(){
            return this.timeStampe;
        }
        private int getTweetId(){
            return this.tweetId;
        }

    }
    /** Initialize your data structure here. */
    public Twitter() {
        userTweets = new HashMap<>();
        userFollowee = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        userTweets.compute(userId, (usrId, tweetsList)->{
                    if(Objects.nonNull(tweetsList)){
                        tweetsList.add(new Tweet(userId, tweetId));
                        if(tweetsList.size() > 10){
                            tweetsList.remove(0);
                        }
                    }else{
                        tweetsList = new ArrayList<Tweet>();
                        tweetsList.add(new Tweet(userId, tweetId));
                    }
                    return tweetsList;
                }
        );
        return;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> result = new PriorityQueue<Tweet>((t1, t2) ->{
            return t2.timeStampe.compareTo(t1.timeStampe);
        });
        List<Tweet> myTweets = userTweets.get(userId);
        if(Objects.nonNull(myTweets)){
            result.addAll(myTweets);
        }
        Set<Integer> setOfFollowee = userFollowee.get(userId);
        if(Objects.nonNull(setOfFollowee)){
            setOfFollowee.stream().forEach(id ->{
                if(Objects.nonNull(userTweets.get(id))){
                    result.addAll(userTweets.get(id));
                }
            });
        }
        List<Integer> tweetsIdList = new ArrayList<>();
        int size = result.size();
        for(int i = 0; i < Math.min(size, 10); i++){
            tweetsIdList.add(result.poll().getTweetId());
        }
        return tweetsIdList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userFollowee.compute(followerId, (followerId_tmp, setFollowee)->{
            if(Objects.nonNull(setFollowee)){
                setFollowee.add(followeeId);
            }else{
                setFollowee = new HashSet<Integer>();
                setFollowee.add(followeeId);
            }
            return setFollowee;
        });
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        userFollowee.compute(followerId, (id, setFollowee) ->{
            if(Objects.nonNull(setFollowee)){
                setFollowee.remove(followeeId);
            }
            return setFollowee;
        });
    }

    public static void main(String[]args){
        Twitter solution = new Twitter();
        solution.postTweet(1, 5);
        solution.postTweet(1, 3);
//        solution.follow(1, 2);
//        solution.postTweet(2, 7);
        List<Integer> list = solution.getNewsFeed(1);
        list.forEach(System.out::println);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
