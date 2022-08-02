#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        stack<int> s1;
        stack<int> s2;
        while(l1) {
            s1.emplace(l1->val);
            l1 = l1->next;
        }
        while(l2) {
            s2.emplace(l2->val);
            l2 = l2->next;
        }

        int carry = 0;          //两数相加产生的进位
        ListNode *dummy = new ListNode(-1);
        ListNode *p = nullptr;

        while(!s1.empty() || !s2.empty() || carry != 0) {
            int x = s1.empty() == true ? 0 : s1.top();
            int y = s2.empty() == true ? 0 : s2.top();
            int z = x + y + carry;
            carry = 0;              //相加后进位置零
            if(z > 9) {
                carry = 1;
                z -= 10;
            }
            p = new ListNode(z);
            /*
             * 头插法将新结点p插入到附加头结点后面
             */
            p->next = dummy->next;
            dummy->next = p;
            if(!s1.empty())
                s1.pop();
            if(!s2.empty())
                s2.pop();
        }
        /*
         * 下面的if代码块其实可以优化到while循环的循环条件里。
         * 即把条件carry != 0加入到循环条件里面
         */
        // if(carry > 0) {
        //     p = new ListNode(carry);
        //     p->next = dummy->next;
        //     dummy->next = p;
        // }

        return dummy->next;    //返回结果链表
    }
    ListNode* buildList(int* arr, int n) {
        ListNode *dummy = new ListNode(-1);
        ListNode *p = dummy;
        for (int i = 0; i < n; i++) {
            ListNode *temp = new ListNode(arr[i]);
            p->next = temp;
            p = p->next;
        }
        return dummy->next;
    }
    void printList(ListNode* head) {
        if(head == nullptr) {
            printf("NULL\n");
        }
        ListNode *p = head;
        printf("%d",p->val);
        p = p->next;
        while(p) {
            printf(" %d", p->val);
            p = p->next;
        }
        printf("\n");
    }
};

int main(int argc, char const *argv[])
{
    int a[] = {7, 2, 4, 3};
    int n = sizeof(a) / sizeof(int);
    int b[] = {5, 6, 4};
    int m = sizeof(b) / sizeof(int);

    Solution sol;
    ListNode *l1 = sol.buildList(a, n);
    sol.printList(l1);
    ListNode *l2 = sol.buildList(b, m);
    sol.printList(l2);
    ListNode *l = sol.addTwoNumbers(l1, l2);
    printf("result is : ");
    sol.printList(l);

    return 0;
}
