/*
 * @lc app=leetcode.cn id=355 lang=cpp
 *
 * [355] 设计推特
 */

#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <queue>
using namespace std;

// @lc code=start

struct Tweet {
    int time;
    int tweetId;
    int userId;
    Tweet() {}
    Tweet(int _time, int _tweetId, int _userId): time(_time), tweetId(_tweetId), userId(_userId) {}
};

inline bool operator < (const struct Tweet& t1, const struct Tweet& t2) {
    return t1.time < t2.time;
}

class Twitter {
public:
    Twitter() {

    }
    
    void postTweet(int userId, int tweetId) {
        auto tweetsIter = tweets.find(userId);
        if (tweetsIter == tweets.end()) {
            Tweet* tweet = new Tweet(time, tweetId, userId);
            vector<Tweet*> a_tweet = {tweet};
            tweets.insert(make_pair(userId, a_tweet));
            if (follows.find(userId) == follows.end()) {
                unordered_set<int> a_follow = {userId};
                follows.insert(make_pair(userId, a_follow));
            }
        } else {
            tweetsIter->second.emplace_back(new Tweet(time, tweetId, userId));
        }
        time++;
    }
    
    vector<int> getNewsFeed(int userId) {
        vector<int> result;
        auto followerIter = follows.find(userId);
        if (followerIter == follows.end()) {
            return {};
        }
        auto& followees = followerIter->second;
        int size = 0;
        unordered_map<int, int> lens;
        for (auto followee : followees) {
            auto tweetsIter = tweets.find(followee);
            if (tweetsIter == tweets.end()) {
                size = 0;
            } else {
                size = tweetsIter->second.size();
            }
            
            lens.insert(make_pair(followee, size));
        }
        priority_queue<Tweet*> pq;
        for (auto& len : lens) {
            if (len.second > 0) {
                pq.push(tweets[len.first][len.second - 1]);
                len.second--;
            }
        }
        int k = 0;
        while (k < 10 && !pq.empty()) {
            auto tweet= pq.top();
            pq.pop();
            result.push_back(tweet->tweetId);
            int& i = lens[tweet->userId];
            if (i > 0) {
                i--;
                pq.push(tweets[tweet->userId][i]);
            }
            k++;
        }
        return result;
    }
    
    void follow(int followerId, int followeeId) {
        auto iter = follows.find(followerId);
        if (iter == follows.end()) {
            unordered_set<int> a_follow = {followerId,followeeId};
            follows.insert(make_pair(followerId, a_follow));
        } else {
            iter->second.insert(followeeId);
        }
    }
    
    void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        auto followerIter = follows.find(followerId);
        if (followerIter != follows.end()) {
            auto followeeIter = followerIter->second.find(followeeId);
            if (followeeIter != followerIter->second.end()) {
                followerIter->second.erase(followeeIter);
            }
        }
    }

private:
    int time = 0;
    unordered_map<int, unordered_set<int>> follows;
    unordered_map<int, vector<Tweet*>> tweets;
};

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter* obj = new Twitter();
 * obj->postTweet(userId,tweetId);
 * vector<int> param_2 = obj->getNewsFeed(userId);
 * obj->follow(followerId,followeeId);
 * obj->unfollow(followerId,followeeId);
 */
// @lc code=end

