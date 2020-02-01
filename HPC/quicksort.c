#include<stdio.h>
#include<omp.h>
#define MAX 1000
void swap(long long int* a, long long int* b)
{
  long long int t = *a;
  *a = *b;
  *b = t;
}

long long int partition(long long int arr[], long long int low, long long int high)
{
  long long int pivot;
  long long int i = low-1;
  pivot = arr[high];
  for (long long int j=low; j<high; j++)
  {
    if(arr[j] < pivot)
    {
      i++;
      swap(&arr[j], &arr[i]);
    }
  }
  swap(&arr[i+1], &arr[high]);
  return i+1;
}


void quicksort(long long int arr[], long long int low, long long int high)
{
  if(low<high)
  {
    long long int j = partition(arr, low, high);
    #pragma omp parallel sections num_threads(2)
    {
      #pragma omp section
      quicksort(arr, low, j-1);
      #pragma omp section
      quicksort(arr, j+1, high);
    }

  }
}



long long int main()
{
  long long int arr[MAX];
  for(long long int i=0; i<MAX; i++)
    arr[i]=MAX-i-1;

  double starttime = omp_get_wtime();
  quicksort(arr, 0, MAX-1);
  double totaltime = omp_get_wtime() - starttime;
  printf("%f\n", totaltime);

  return 0;
}
