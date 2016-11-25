#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define MAXWORD 100

struct tnode {
	char *word;
	int count;
	struct tnode *left;
	struct tnode *right;
};

struct tnode *addtree(struct tnode *, char *);
struct tnode *addnumtree(struct tnode *, struct tnode *);
void treeprint(struct tnode *);
void treeprintnum(struct tnode *, struct tnode *);
int getword(char *, int);

/* word frequency count */
int main() {
	struct tnode *root;
	struct tnode *rootnum;
	char word[MAXWORD];

	root = NULL;
	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			root = addtree(root, word);
			root = addtreenum(root, rootnum);
	treeprint(root);
	treeprintnum(root, rootnum);
	return 0;
}

struct tnode *talloc(void);
char *mystrdup(char *);

/* addtree: add a node with w, at or below p */
struct tnode *addtree(struct tnode *p, char *w) {
	int cond;

	if (p == NULL) {
		p = talloc();
		p->word = mystrdup(w);
		p->count = 1;
		p->left = p->right = NULL;
	}
	else if ((cond = strcmp(w, p->word)) == 0)
		p->count++;
	else if (cond <0)
		p->left = addtree(p->left, w);
	else
		p->right = addtree(p->right, w);
	return p;
}

struct tnode *addnumtree(struct tnode *p, struct tnode *old_p){
	if(p == NULL){
		p == talloc();
		p->word = mystrdup(old_p->word);
		p->count = old_p->count;
		p->left = p->right = NULL;
	}else if(old_p->count > p->count){
		p->left = addnumtree(p->left, old_p);
	}else{
		p -> right = addnumtree(p->right, old_p);
	}
}

/* treeprint: in-order print of tree p */
void treeprint(struct tnode *p) {
	if (p != NULL) {
		treeprint(p->left);
		printf("%4d %s\n", p->count, p->word);
		treeprint(p->right);
	}
}

void treeprintnum(struct tnode *p, struct tnode *root) {
	if (p != NULL) {
		treeprintnum(p->left, root);
		root = addnumtree(root, p);
		treeprintnum(p->right, root);
	}
}

#include <stdlib.h>

/* talloc: make a tnode */
struct tnode *talloc(void) {
	return (struct tnode *) malloc(sizeof(struct tnode));
}

/* strdup: make a duplicate of s */
char *mystrdup(char *s) {
	char *p;

	p = (char *) malloc(strlen(s)+1); /* +1 for '\0' */
	if (p != NULL)
		strcpy(p, s);
	return p;
}










