#include <stdio.h>
#include <string.h>

typedef struct dLinkedList dLinkedList;

struct dLinkedList {
    dLinkedList* prev;
    dLinkedList* next;
    char* val;
};

dLinkedList* insert(dLinkedList* parent, char* str) {
    dLinkedList* node = malloc(sizeof(dLinkedList));
    parent->next = node;
    node->prev = parent;
    node->val = str;
    return node;
}

void printDLL(dLinkedList* node) {
    if (node == NULL) {
        return;
    }
    printf("%s", node->val);
    printDLL(node->next);
}

int main() {
    dLinkedList root;
    dLinkedList* curr = &root;
    printf("Hello, World!");
    curr = insert(curr, "stackoverflow");
    curr = insert(curr, "test12");
    printDLL(&root);
    return 0;
}
