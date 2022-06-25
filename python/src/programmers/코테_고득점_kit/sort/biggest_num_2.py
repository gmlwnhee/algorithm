from itertools import permutations
from functools import cmp_to_key

# Other Solution1
def solution1(numbers):
    if sum(numbers) == 0 :
        return "0"
    answer = sorted([str(n) for n in numbers], key=lambda x: x * 3, reverse=True)
    return "".join(answer)

# Other Solution2
def comparator(a,b):
    t1 = a+b
    t2 = b+a
    return (int(t1) > int(t2)) - (int(t1) < int(t2)) #  t1이 크다면 1  // t2가 크다면 -1  //  같으면 0

def solution2(numbers):
    n = [str(x) for x in numbers]
    n = sorted(n, key=cmp_to_key(comparator),reverse=True)
    answer = str(int(''.join(n)))
    return answer

# My Solution (time out)
def solution_(numbers):
    perm = list(permutations(numbers, len(numbers)))
    # print(perm)
    max = 0
    for p in perm:
        answer = ''        
        for _ in p:
            answer += str(_)
        if max < int(answer):
            max = int(answer)      
    return str(max)

# numbers = [6, 10, 2]
numbers = [3, 30, 34, 5, 9]

a = solution2(numbers)
print(a)