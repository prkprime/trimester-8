#include<stdio.h>
#include<omp.h>

void serial_bubble(long long int size) {
  long long int arr[size];
  #pragma omp parallel num_threads(8)
  {
    #pragma omp for
    for(long int i = 0; i < size; i++) {
      arr[i] = size - i;
    }
  }

  printf("hello\n");
  double start_time = omp_get_wtime();
  for(int i=0; i<size; i++) {
    for(int j=0; j<size-i-1; j++) {
      if(arr[j]>arr[j+1]) {
        long long int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
      }
    }
  }
  printf("Serial time = %lf \n", omp_get_wtime()-start_time );
}

void parallel_sort() {
  long long int arr[size];
  #pragma omp parallel num_threads(8)
  {
    #pragma omp for
    for(long int i = 0; i < size; i++) {
      arr[i] = size - i;
    }
  }

  printf("hello\n");
  double start_time = omp_get_wtime();
  #pragma omp parallel num_threads(omp_get_max_threads())
  {
    #pragma omp for
    for(int i=0; i<size; i++) {
      for(int j=0; j<size-i-1; j++) {
        if(arr[j]>arr[j+1]) {
          long long int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
  }
  printf("Serial time = %lf \n", omp_get_wtime()-start_time );
}

int main() {
  long long int size;

  int choice = 0;
  do {
    printf("\nEnter size : ");
    scanf("%lld", &size);
    printf("\nEnter\t\n0 : Exit\n\t1 : Serial Bubble Sort\n\t2 : Parallel Bubble Sort\n");
    scanf("%d", &choice);
    if(choice==0) {
      return 0;
    }
    else if(choice==1) {
      serial_bubble(size);
    }
    else if(choice==2) {
      parallel_sort(size);
    }
  } while(choice !=0);
}
