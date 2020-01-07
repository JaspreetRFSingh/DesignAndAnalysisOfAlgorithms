# -*- coding: utf-8 -*-
"""
Created on Tue Jan  7 13:24:00 2020

@author: Jaspreetsingh_Tuli
"""

def rabin_karp(text, pattern, prime):
    
    text_length = len(text)
    pattern_length = len(pattern)
    pattern_hash = 0
    text_hash = 0
    index_list = []
    
    for i in range(0,pattern_length):
        pattern_hash += ord(pattern[i]) * (prime ** i)
    
    for i in range (0, (text_length - pattern_length)+1):
        text_hash = 0
        for k in range(0, pattern_length):
            text_hash += ord(text[i+k]) * (prime ** k)
        if pattern_hash == text_hash:
            flag = True
            for j in range (0, pattern_length):
                if text[i+j] != pattern[j]:
                    flag=False
            if(flag):
                index_list.append(i)
    return index_list
        

print(rabin_karp("sshisahshi","shi",3))