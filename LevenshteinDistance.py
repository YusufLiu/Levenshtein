from __future__ import print_function
import argparse
import math
import random

class Levenshtein:
    def minimun(i1, i2 ,i3):
        return min(min(i1,i2),i3)

    def distance(s1, s2):
        if s1 == s2:
        return 0


        # Prepare a matrix
        s1len, s2len = len(s1), len(s2)
        dist = [[0 for i in range(s2len+1)] for x in range(s1len+1)]
        for i in range(s1len+1):
            dist[i][0] = i
        for j in range(s2len+1):
            dist[0][j] = j

        # Counting distance
        for i in range(s1len):
            for j in range(s2len):
                cost = 0 if s1[i] == s2[j] else 1
                dist[i+1][j+1] = min(
                                dist[i][j+1] + 1,   # deletion
                                dist[i+1][j] + 1,   # insertion
                                dist[i][j] + cost   # substitution
                            )
        return dist[-1][-1]


    def closestWord(s1, l1):
        minValue = distance(s1,l1(0))
        minLoc = 0
        for i in range(l1.length-1):
            if(distance(s1.lower(),l1(i).lower()) < minValue):
                minValue = distance(s1.lower(),l1(i).lower())
                minLoc = i

        return l1(minLoc)

