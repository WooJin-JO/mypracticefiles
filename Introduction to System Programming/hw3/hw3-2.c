#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define BUFSIZE 1000
#define MAXWORD 100
#define FKEYS (sizeof filterword / sizeof(struct filter))

struct tnode {
	char *word;
	int count;
	struct tnode *left;
	struct tnode *right;
};

struct tnode *reducetree(struct tnode *, char *);
struct tnode *addfreqtree(struct tnode *p, char *w, int count);
struct tnode *createtreefromtree(struct tnode *oldt, struct tnode *freqt);
void treeprint(struct tnode *);
int getword(char *, int);

/* word frequency count */
int main() {
	struct tnode *root, *freqroot;
	char word[MAXWORD];

	root = NULL;
	freqroot = NULL;
	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			root = reducetree(root, word);
		freqroot = createtreefromtree(root, freqroot);
	// treeprint(root);
		treeprint(freqroot);
		return 0;
	}

	struct tnode *talloc(void);
	char *mystrdup(char *);

	struct tnode *reducetree(struct tnode *p, char *w) {
		int cond;

		if (p == NULL) {
			p = talloc();
			p->word = mystrdup(w);
			p->count = 1;
			p->left = p->right = NULL;
		}
		else if ((cond = strcmp(w, p->word)) == 0){
			p->count++;
		}
		else if (cond <0){
			p->left = reducetree(p->left, w);
		}
		else{
			p->right = reducetree(p->right, w);
		}
		return p;
	}

	struct tnode *addfreqtree(struct tnode *p, char *w, int count) {

		if (p == NULL) {
			p = talloc();
			p->word = mystrdup(w);
			p->count = count;
			p->left = p->right = NULL;
		}
	else if (count > p->count)
		p->left = addfreqtree(p->left, w, count);
	else
		p->right = addfreqtree(p->right, w, count);
	return p;
}

struct tnode *createtreefromtree(struct tnode *oldt, struct tnode *freqt){
	if (oldt != NULL){
		freqt = createtreefromtree(oldt->left, freqt);
		freqt = addfreqtree(freqt, oldt->word, oldt->count);
		freqt = createtreefromtree(oldt->right, freqt);
	}
	return freqt;
}

void treeprint(struct tnode *p) {
	if (p != NULL) {
		treeprint(p->left);
		if((p->count) >= 2){
			p->count -= 1;
		}

		if(p->count > 0){
			printf("%4d %s\n", p->count, p->word);
		}
		treeprint(p->right);
	}
}

#include <stdlib.h>

struct tnode *talloc(void) {
	return (struct tnode *) malloc(sizeof(struct tnode));
}

char *mystrdup(char *s) {
	char *p;

	p = (char *) malloc(strlen(s)+1);
	if (p != NULL)
		strcpy(p, s);
	return p;
}

char buf[BUFSIZE];
int bufp = 0;

int getch();
void ungetch(int c);

int getword(char *word, int lim){
	int c, limorigin=lim;
	char *w = word;

	while(isspace(c = getch()));

	if(c != EOF) *w++ = c;

	if(!isalpha(c)){
		*w = '\0';
		return c;
	}
	for(;--lim > 0; w++){
   		if(!isalnum(*w = getch()) && *w != '\''){
			ungetch(*w);
			break;
		}
	}
	if(*(w-2) == 's' && *(w-1) == '\'') w = w-1;
	else if(*(w-2) == '\'' && *(w-1) == 's') w = w-2;

	*w = '\0';

	if(strlen(word) == 1) getword(word, limorigin);
	return word[0];
}

int getch(void){
	return (bufp > 0)?buf[--bufp]:getchar();
}
void ungetch(int c){
	if(bufp > BUFSIZE)
		printf("ungetch: too many characters\n");
	else
		buf[bufp++] = c;
	return;
}