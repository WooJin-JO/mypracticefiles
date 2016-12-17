#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_key 1000
#define BUF 1000

struct key {
    char *name;
};

struct key *read_key();
void inorder_traversal(struct key array[], struct key *ky);
void print_key(struct key key[]);

char *get_word();

int meetEOF = 0;

int main(void) {
    struct key key[MAX_key] = {{0}};
    struct key *ky;

    while ((ky = read_key()) != NULL) {
        inorder_traversal(key,ky);
    }
    print_key(key);
}

struct key *read_key() {
    struct key *ky;
    char *name = get_word();

    if(name == NULL) return NULL;
    ky = (struct key *)(malloc(sizeof(struct key)));
    ky->name = name;
    return ky;
}

void inorder_traversal(struct key key[], struct key *ky) {
    int inserted = 0;
    struct key tmp, swap;
    int index;

    for (index = 0;
        key[index].name != 0 && index < MAX_key ;
        index++) {
        if (strcmp(key[index].name, (*ky).name) > 0) {
            tmp = key[index];
            key[index] = *ky;
            *ky = tmp;
        }
    }
    key[index] = *ky;
}

void print_key(struct key key[]) {
    for (int index=0; key[index].name != 0 && index < MAX_key; ++index) {
        printf("%10s\n", key[index].name);
    }
}

char *get_word() {
    char *word = (char *) malloc(sizeof(char)*BUF);
    char c;
    int index;

    if (meetEOF) return NULL;

    while (isspace(c = getchar())) ;

    for (index=0; index < BUF; ++index) {
        if (c == EOF) {
            meetEOF = 1;
            break;
        }
        if (isalnum(c))
            word[index] = c;
        else
            break;
        c = getchar();
    }
    word[index] = '\0';
    return word;
}