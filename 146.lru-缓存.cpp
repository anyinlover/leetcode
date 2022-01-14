/*
 * @lc app=leetcode.cn id=146 lang=cpp
 *
 * [146] LRU 缓存
 */
#include <unordered_map>
using namespace std;

// @lc code=start
struct DNode {
    DNode* prev = nullptr;
    DNode* next = nullptr;
    int key;
    int value;
    DNode() {}
    DNode(int _key, int _value): key(_key), value(_value) {}
};

class LRUCache {
public:
    LRUCache(int capacity) {
        max_size = capacity;
        head = new DNode();
        tail = new DNode();
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        auto iter = caches.find(key);
        if (iter == caches.end()) {
            return -1;
        } else {
            move_front(iter->second);
            return iter->second->value;
        }
    }
    
    void put(int key, int value) {
        auto iter = caches.find(key);
        if (iter == caches.end()) {
            if (size == max_size) {
                caches.erase(tail->prev->key);
                drop_last();
            } else {
                size++;
            }
            DNode* dn = new DNode(key, value);
            insert_front(dn);
            caches.insert(make_pair(key, dn));
        } else {
            iter->second->value = value;
            move_front(iter->second);
        }
    }

private:
    void move_front(DNode* dn) {
        dn->prev->next = dn->next;
        dn->next->prev = dn->prev;
        
        insert_front(dn);
    }

    void insert_front(DNode* dn) {
        dn->next = head->next;
        dn->prev = head;
        head->next->prev = dn;
        head->next = dn;
    }

    void drop_last() {
        DNode* dn = tail->prev;
        dn->prev->next = tail;
        tail->prev = dn->prev;
        delete dn;
    }

    unordered_map<int, DNode*> caches;
    DNode* head;
    DNode* tail;
    int max_size;
    int size = 0;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
// @lc code=end

