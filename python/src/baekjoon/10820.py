# 문자열 분석
import sys

input = sys.stdin.readline
# Wrong input, we can't know input count
# num = int(input())
while True:
    string = input().rstrip("\n")

    if not string:
        break

    list_ = [0 for _ in range(4)]
    for s in string:
        if s.islower():
            list_[0] +=1
        elif s.isupper():
            list_[1] +=1
        elif s.isnumeric():
            list_[2] +=1
        else:
            list_[3] +=1

        # num = ord(s)
        # if num >= 97:
        #     list_[0] +=1
        # elif num >= 65:
        #     list_[1] +=1
        # elif num == 32:
        #     list_[3] +=1
        # else:
        #     list_[2] +=1

        # # It's slower than above codes.
        # num = ord(s)
        # if num >= ord('a'):
        #     list_[0] +=1
        # elif num >= ord('A'):
        #     list_[1] +=1
        # elif num == ord(' '):
        #     list_[3] +=1
        # else:
        #     list_[2] +=1      
    print(*list_)

# Other solution 1
for x in sys.stdin:
    res = [0,0,0,0]
    for c in x:
        if 'a'<=c and c<='z':
            res[0]+=1
        elif 'A'<=c and c<='Z':
            res[1]+=1
        elif '0'<=c and c<='9':
            res[2]+=1
        elif c == ' ':
            res[3]+=1
    print(*res)

# Other solution 2
import re

while True:
    try:
        string = input()
    except:
        break
    if len(string) == 0:
        break
    elif len(string) != 0:
        somunja = re.findall('[a-z]', string)
        daemunja = re.findall('[A-Z]', string)
        sutja = re.findall('[0-9]', string)
        gongback = re.findall(' ', string)

        print(len(somunja), len(daemunja), len(sutja), len(gongback))