# -*- coding: utf-8 -*-
"""
Created on Thu Feb 24 11:41:57 2022

@author: Bibidi
"""

import sys
input = sys.stdin.readline

N, M = map(int, input().split(' '))
S = set([input().strip() for _ in range(N)])
count = 0
for _ in range(M) :
    m = input().strip()
    if m in S :
        count+=1
    
print(count)