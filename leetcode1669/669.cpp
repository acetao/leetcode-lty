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
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode *p1 = list1;
        ListNode *p2 = list1;
        int num = 0;
        while(p1 && num < a - 1) {
            num++;
            p1 = p1->next;
        }
        num = 0;
        while(p2 && num < b) {
            num++;
            p2 = p2->next;
        }
        printf("%d, %d\n", p1->val, p2->val);
        ListNode *p3 = list2;
        while(p3->next) {
            p3 = p3->next;
        }
        p1->next = list2;
        p3->next = p2->next;
        return list1;
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
    // int arr[] = {0, 1, 2, 3, 4, 5};
    int arr[] = {0, 1, 2, 3, 4, 5, 6};
    int n = sizeof(arr) / sizeof(int);
    // int a = 3, b = 4;
    int a = 2, b = 5;

    // int brr[] = {1000000, 1000001, 1000002};
    int brr[] = {1000000, 1000001, 1000002, 1000003, 1000004};
    int m = sizeof(brr) / sizeof(int);

    Solution sol;
    ListNode *list1 = sol.buildList(arr, n);
    ListNode *list2 = sol.buildList(brr, m);
    list1 = sol.mergeInBetween(list1, a, b, list2);

    sol.printList(list1);

    system("pause");

    return 0;
}
