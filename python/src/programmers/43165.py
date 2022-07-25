# 타겟 넘버
from itertools import product

numbers = [1,1,1,1,1]
# numbers = [4,1,2,1]
target = 3
# target = 4

def solution(numbers, target):
    answer = 0
    sign = ['+','-']
    signlist = list(product(sign,repeat=len(numbers)))
    for sign in signlist:
      if sum(list(map(lambda x : int(x[1]+str(x[0])),list(zip(numbers,sign))))) == target:
        answer += 1
    return answer

# Other solution 1
def solution1(numbers, target):
    print(numbers, target)
    if not numbers and target == 0 :
        return 1
    elif not numbers:
        return 0
    else:
        return solution(numbers[1:], target-numbers[0]) + solution(numbers[1:], target+numbers[0])

# Other solution 2
from itertools import product
def solution2(numbers, target):
    l = [(x, -x) for x in numbers]
    print(*l)
    print(list(product(*l)))
    s = list(map(sum, product(*l)))
    print("S", s)
    return s.count(target)

# Other solution 3
def dfs(nums, i, n, t):
    ret = 0
    if i==len(nums):
        if n==t: return 1
        else: return 0
    ret += dfs(nums, i+1, n+nums[i], t)
    ret += dfs(nums, i+1, n-nums[i], t)
    return ret

def solution3(numbers, target):
    answer = dfs(numbers, 0, 0, target)
    return answer