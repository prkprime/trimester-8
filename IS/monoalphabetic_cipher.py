"""
Name : Pratik Gorade
Year : T.Y. B.Tech
Panel : 2
Batch : B2
Roll No. : PB02
"""

from string import ascii_letters, digits
from random import shuffle

def monoalpha_cipher():
    pool = ascii_letters + digits
    original_pool = list(pool)
    shuffled_pool = list(pool)
    shuffle(shuffled_pool)
    return dict(zip(original_pool, shuffled_pool))

def reverse_monoalpha_cipher(monoalpha_cipher):
    reverse_monoalpha_cipher = {}
    for key, value in monoalpha_cipher.items():
        reverse_monoalpha_cipher[value] = key
    return reverse_monoalpha_cipher

def encrypt(message, monoalpha_cipher):
    encrypted_message = []
    for letter in message:
        letter1 = monoalpha_cipher.get(letter)
        if letter1 != None:
            encrypted_message.append(letter1)
        else:
            encrypted_message.append(letter)
    return "".join(encrypted_message)

def decrypt(message, reverse_monoalpha_cipher):
    decrypted_message = []
    for letter in message:
        letter1 = reverse_monoalpha_cipher.get(letter)
        if letter1 != None:
            decrypted_message.append(letter1)
        else:
            decrypted_message.append(letter)
    return "".join(decrypted_message)

def main():
    monoalpha_cipher_dict = monoalpha_cipher()
    reverse_monoalpha_cipher_dict = reverse_monoalpha_cipher(monoalpha_cipher_dict)
    message = str(input('Write something : '))
    encrypted_message_string = encrypt(message, monoalpha_cipher_dict)
    print('Encrypted message is : ', encrypted_message_string)
    decrypted_message_string = decrypt(encrypted_message_string, reverse_monoalpha_cipher_dict)
    print('Decrypted message is : ', decrypted_message_string)

if __name__=='__main__':
    main()
