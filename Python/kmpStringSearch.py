# -*- coding: utf-8 -*-
"""
Created on Tue Jan  7 11:53:07 2020

@author: Jaspreetsingh_Tuli
"""

def findPrefix(pattern, prefixList):
    patternLength = len(pattern)
    prefixLength = 0
    prefixList[0] = 0
    
    for i in range(1, patternLength):
        if(pattern[i] == pattern[prefixLength]):
            prefixLength +=1
            prefixList[i] = prefixLength
        else:
            if prefixLength != 0:
                prefixLength = prefixList[prefixLength-1]
                i -=1
            else:
                prefixList[i] = 0
    return prefixList

def kmp(text, pattern):
    textLength = len(text)
    patternLength = len(pattern)
    prefixList = [0]*patternLength
    findPrefix(pattern, prefixList)
    i = 0
    j = 0
    indexList = []
    while(i<textLength):
        if(text[i] == pattern[j]):
            i+=1
            j+=1
        if j == patternLength:
            indexList.append(i-j)
            j = prefixList[j-1]
        elif i < textLength and pattern[j] != text[i]:
            if j!=0:
                j = prefixList[j-1]
            else:
                i+=1
    return indexList
      
print(kmp("ashishahgdsjgajdgidhgikadhgaid  hshivam kahdkahd shiuahsodna","shi"))
print(kmp("gajsdabafgliablzbffaiiiaasweajs","ajs"))