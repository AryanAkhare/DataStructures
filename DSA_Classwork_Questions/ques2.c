#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

#define MAX 100
int stack[MAX];
int top=-1;

void push(int value){
    if(top<MAX-1){
        stack[++top]=value;
    } else {
        printf("Stack Overflow\n");
    }
}
int pop(){
    if(top>=0){
        return stack[top--];
    }
    else {
        printf("Stack Underflow\n");
        return -1;
    }
}
int eval(char *value){
    int i=0;

    while(value[i]!='\0'){
        if(isdigit(value[i])){
            push(value[i]-'0'); //push char to stack

        } else if(value[i]=='+'){
            push(pop() + pop()); 

        } else if(value[i]=='-'){
            int temp1=pop();
            int temp2=pop();
            push(temp2 - temp1);

        } else if(value[i]=='*'){
            push(pop() * pop());

        } else if(value[i]=='/'){
            int temp1=pop();
            int temp2=pop();

            push(temp2 / temp1);
        } else {
            printf("Invalid character: %c\n", value[i]);
            exit(1);
        }
        i++;
    }
    return pop();
}
int main(){
    char expression[]="234*-5+";
    int result=eval(expression);
    printf("Result: %d\n", result);
}    