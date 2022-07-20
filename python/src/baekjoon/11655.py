# ROT13
string = input()

rotate = 13
chkNum1 = ord('Z')
chkNum2 = ord('z')
for s in string:
    if s.isalpha():
        num = ord(s)
        rNum = num + rotate
        # UpperCase
        if num <= chkNum1:
            if rNum > chkNum1:
                ans = ord('A') + rNum - chkNum1 - 1
            else:
                ans = rNum
        # LowerCase
        else:
            if rNum > chkNum2:
                ans = ord('a') + rNum - chkNum2 - 1
            else:
                ans = rNum
        print(chr(ans), end='')
    else:
        print(s, end='')    

# I changed above code, but It's only shorter than above code.   
# chkNum1 = ord('Z')
# chkNum2 = ord('z')
# for s in string:
#     if s.isalpha():
#         num = ord(s)
#         rNum = num + 13
#         # UpperCase
#         if num <= chkNum1:
#             if rNum > chkNum1:
#                 ans = rNum -26
#             else:
#                 ans = rNum
#         # LowerCase
#         else:
#             if rNum > chkNum2:
#                 ans = rNum - 26
#             else:
#                 ans = rNum
#         print(chr(ans), end='')
#     else:
#         print(s, end='')

# Other solution
for i in input():
    if i.isupper():
        t=ord(i)+13
        # ord('Z') == 90
        if t>90:
            # alphabet count
            t-=26
        print(chr(t),end='')
    elif i.islower():
        t=ord(i)+13
        # ord('z') == 122
        if t>122:
            t-=26
        print(chr(t),end='')
    else:
        print(i,end='')