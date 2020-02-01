#include<omp.h>
#include<stdio.h>
#define SIZE 100000
int main()
{
  long long int arr[SIZE];
  #pragma omp for
  for (long long int i=0; i<SIZE; i++)
  {
    arr[i]=SIZE-i-1;
  }
  long long int temp;
  double starttime = omp_get_wtime();
  for (long long int i=0; i<SIZE - 1; i++)
  {
    #pragma omp parallel for private(temp)
    for (long long int j=0; j<SIZE - 1; j+=2)
    {
      if (arr[j]>arr[j+1])
      {
        temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
      }
    }

    #pragma omp parallel for private(temp)
    for (long long int k=1; k<SIZE-1; k+=2)
    {
      if (arr[k]>arr[k+1])
      {
        temp = arr[k];
        arr[k] = arr[k+1];
        arr[k+1] = temp;
      }
    }
  }
  double totaltime = omp_get_wtime() - starttime;
  printf("\nParallel execution time : %f\n", totaltime);
  long long int errors = 0;
  for(int i=0; i<SIZE; i++)
    if(arr[i] != i) errors++;
  printf("\n total errors are %lld \n", errors);
  return 0;
}
