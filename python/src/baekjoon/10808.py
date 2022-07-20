# 알파벳 개수
string = input()

length = len(string)
alphaList = [0] * 26
# ord() turns the alphabet into a number (ordinal)
for s in string:
    index = ord(s) - 97
    alphaList[index] += 1
# print(*alphaList)
