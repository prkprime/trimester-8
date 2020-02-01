#include<stdio.h>
#include<stdlib.h>
#define MAX 100000
int main() {
  FILE *file1 = fopen("array1.txt", "r");
  FILE *file2 = fopen("array2.txt", "r");
  long long int arr1[MAX][MAX], arr2[MAX][MAX], n1, n2;
  for(int i=0; i<MAX; i++) {
    for(int j=0; j<MAX; j++) {
      fscanf(file1,"%lld",&n1);
      printf("%lld \n", n1);
      arr1[i][j] =n1;
      fscanf(file2,"%lld",&n1);
      printf("%lld \n", n1);
      arr2[i][j] = n1;
    }
  }
}
