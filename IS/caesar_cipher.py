"""
Name : Pratik Gorade
Year : T.Y. B.Tech
Panel : 2
Batch : B2
Roll No. : PB02
usage : python3 caesar_cipher.py
"""

def encrypt(message):
    # this function encrypts the plain text using caesar cipher and returns cipher text
    char_list = list(message)
    encoded_char_list = []
    for char in char_list:
        if char==" ":
            encoded_char_list.append(" ")
        else:
            n = ord(char)
            for i in range(3):
                if n==122:
                    n = 97
                elif n==90:
                    n = 65
                else:
                    n += 1
            encoded_char_list.append(chr(n))
    return list_to_string(encoded_char_list)

def decrypt(message):
    #this function decrypts the text encrypted by encrypt function and returns decrypted string
    char_list = list(message)
    encoded_char_list = []
    for char in char_list:
        if char==" ":
            encoded_char_list.append(" ")
        else:
            n = ord(char)
            for i in range(3):
                if n==97:
                    n = 122
                elif n==65:
                    n = 90
                else:
                    n -= 1
            encoded_char_list.append(chr(n))
    return list_to_string(encoded_char_list)

def list_to_string(list):
    #converts list to string
    str1 = ""
    for char in list:
        str1 += char
    return str1


def main():
    message = str(input('Write message to send to Brutus : '))
    encrypted_message = encrypt(message)
    print('Encrypted message is : ', encrypted_message)
    decrypted_message = decrypt(encrypted_message)
    print('Decrypted message is : ', decrypted_message)

if __name__=='__main__':
    main()
