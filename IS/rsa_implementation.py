"""
Name : Pratik Gorade
Year : T.Y. B.Tech
Panel : 2
Batch : B2
Roll No. : PB02
"""

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)

def main():
    p = 23
    q = 37
    n = p*q
    z = (p-1)*(q-1)
    print('z : ',z)
    for e in range(2, z-1):
        if gcd(e, z)==1:
            break
    print('e : ', e)
    k = 2

#calculate d using (d*e) mod z = 1
if __name__ == '__main__':
    main()
