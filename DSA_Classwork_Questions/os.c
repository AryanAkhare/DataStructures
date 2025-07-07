// Online C compiler to run C program online
#include <stdio.h>

int main() {
    int allocation[5][3]={
       {0, 1, 0},
        {2, 0, 0},
        {3, 0, 2},
        {2, 1, 1},
        {0, 0, 2}
    };
    int max[5][3]={
        {7, 5, 3},
        {3, 2, 2},
        {9, 0, 2},
        {2, 2, 2},
        {4, 3, 3}
    };
    
    int available[]={3,3,2};
    int need[5][3];
    int result[5];
    int flag[5]={0,0,0,0,0};
    
    for(int i=0 ; i<5 ; i++){
        for(int j=0; j<3 ; j++){
            need[i][j]=max[i][j]-allocation[i][j];
        }
        
    }
    printf("Need Matrix = [");
    for(int i=0 ; i<5 ; i++){
        for(int j=0; j<3 ; j++){
            printf("%d ",need[i][j]);
        }
        printf("\n");
        
    }
    printf("]");
    
    
    int count=0;
    int process=5;
    
    while(count < process){
        int found=0;
        for(int i=0 ; i<5 ; i++){
            if(flag[i]==0){
                int canAllocate=1;
                for(int j=0 ; j<3 ; j++){
                    if(need[i][j]>available[j]){
                    canAllocate=0; //doesnt run code
                    break;
                    }
                }
                
                if(canAllocate==1){
                    for(int j=0 ; j<3 ; j++){
                        available[j]+=allocation[i][j];
                    }
                    result[count++]=i+1;
                    flag[i]=1;
                    found=1;
                }
            }
        }
        
        if(found == 0){
            printf("\nUnsafe State");
            return -1;
        }
    }
    
    printf("\nSafe Sequence\n");
    for(int i=0 ; i<5 ; i++){
        printf("P%d ",result[i]);
    }
    
    return 0;
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
