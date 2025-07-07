#include<stdio.h>
#include<string.h>

#define MAX_SIZE 100

struct Employee{
    char name[50];
    int id;
    double salary;
};
void search(struct Employee employees[], int n, int targetId){
    int low = 0;
    int high = n - 1;

    while(low <= high){
        int mid = (low + high) / 2;
        if(employees[mid].id==targetId){
            printf("Employee Found:\n");
            printf("Name: %s\n", employees[mid].name);
            printf("ID: %d\n", employees[mid].id);
            printf("Salary: %.2lf\n", employees[mid].salary);
            return;
        }
        else if(employees[mid].id<targetId){
            low = mid + 1;
        }
        else{
            high = mid - 1;
        }
        
    }
    printf("not found ");  

}
int main(){
    struct Employee employees[MAX_SIZE];
    int n;
    printf("Enter the number of employees: ");
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        printf("Enter employee %d details:\n", i+1);
        printf("Name: ");
        scanf("%s", employees[i].name);
        printf("ID: ");
        scanf("%d", &employees[i].id);
        printf("Salary: ");
        scanf("%lf", &employees[i].salary);
    }
    int targetId;
    printf("Enter the ID to search: ");
    scanf("%d", &targetId);
    search(employees, n, targetId);
    return 0;
}