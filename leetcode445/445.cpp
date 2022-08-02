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
        l1 = rev(l1);
        l2 = rev(l2);

        int carry = 0;          //两数相加产生的进位
        ListNode *dummy = new ListNode(-1);
        ListNode *p = dummy;
        ListNode *p1 = l1;
        ListNode *p2 = l2;
        int tot = 0;
        while(p1 || p2) {
            tot++;
            int x = p1 == nullptr ? 0 : p1->val;
            int y = p2 == nullptr ? 0 : p2->val;
            int z = x + y + carry;
            carry = 0;              //相加后进位置零
            if(z > 9) {
                carry = 1;
                z -= 10;
            }
            p->next = new ListNode(z);
            p = p->next;
            if(p1)
                p1 = p1->next;
            if(p2)
                p2 = p2->next;
        }
        if(carry > 0) {
            p->next = new ListNode(carry);
        }

        return rev(dummy->next);    //反转结果链表
    }

    ListNode* rev(ListNode* head) {
        if(head == nullptr || head->next == nullptr)
            return head;
        ListNode *prev = nullptr;
        while(head) {
            ListNode* next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
    int a[] = {0};
    int n = sizeof(a) / sizeof(int);
    int b[] = {0};
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
