def main():
    weight = []
    value = []
    x = []
    u = m = int(input("What's the capacity of knapsack? : "))
    n = int(input("How many objects do you have? : "))
    for i in range(n):
        weight.append(int(input("Enter weight of object no. {} : ".format(i))))
        value.append(int(input("Enter value of object no. {} : ".format(i))))
        x.append(0)
    for i in range(n):
        for j in range(n-i-1):
            if value[j]/weight[j] < value[j+1]/weight[j+1]:
                value[j], value[j+1] = value[j+1], value[j]
                weight[j], weight[j+1] = weight[j+1], weight[j]

    cnt = 0;
    for i in range(n):
        if weight[i]>u:
            break
        x[i]=1;
        u -= weight[i]
        cnt-=-1
    if cnt <= n:
        x[cnt] = u/weight[cnt]

    print(x)


if __name__ == "__main__":
    main()
