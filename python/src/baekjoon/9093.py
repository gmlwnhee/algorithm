t = int(input())

# Solution1
for _ in range(t):
    sentence = input().split()
    for s in sentence:
        for i in reversed(s):
            print(i, end='')
        print(' ',end='')
    print()

# Solution2
for _ in range(t):
    sentence = input().split()
    print(*[i[::-1] for i in sentence])