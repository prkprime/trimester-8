"""
Name : Pratik Gorade
Year : T.Y. B.Tech
Panel : 2
Batch : B2
Roll No. : PB02
"""
from math import sqrt
from itertools import count, islice

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)

def isPrime(n):
    if n < 2:
        return False

    for number in islice(count(2), int(sqrt(n) - 1)):
        if n % number == 0:
            return False

    return True

def main():
    p = int(input("Enter any prime number : "))
    while isPrime(p) == False:
        p = int(input("{} is not prime number, Enter again : ".format(p)))
    q = int(input("Enter one more prime number : "))
    while isPrime(q) == False:
        q = int(input("{} is not prime number, Enter again : ".format(q)))
    n = p*q
    print(" Value of \'n\' is :", n)
    phi = (p-1)*(q-1)
    print(" Value of \'phi\' is :", phi)
    for e in range(2, phi):
        if gcd(e, phi)==1:
            break
    print(" Value of \'e\' is :", e)
    for d in range(2, phi):
        if (d*e)%phi==1:
            break
    print(" Value of \'d\' is :", d)

    m = int(input("Enter any numerical message to encrypt : "))
    encrypted_message = pow(m, e)%n
    print("Encrypted message is :", encrypted_message)
    decrypted_message = pow(encrypted_message, d)%n
    print("Decrypted message is : ", decrypted_message)
#calculate d using (d*e) mod z = 1
if __name__ == '__main__':
    main()
