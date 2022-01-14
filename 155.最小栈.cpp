/*
 * @lc app=leetcode.cn id=155 lang=cpp
 *
 * [155] 最小栈
 */
#include <stack>
#include <climits>

using namespace std;

// @lc code=start
class MinStack {
public:
    MinStack() {
        min_stack.push(INT_MAX);
    }
    
    void push(int val) {
        the_stack.push(val);
        if (val < min_stack.top()) {
            min_stack.push(val);
        } else {
            min_stack.push(min_stack.top());
        }
    }
    
    void pop() {
        the_stack.pop();
        min_stack.pop();
    }
    
    int top() {
        return the_stack.top();
    }
    
    int getMin() {
        return min_stack.top();
    }
private:
    stack<int> the_stack;
    stack<int> min_stack;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
// @lc code=end

