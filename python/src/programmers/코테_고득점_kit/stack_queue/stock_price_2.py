# import collections
# import itertools

def solution(prices):
    answer = [0]* len(prices)
    for index in range(len(prices)):
        cnt = 0
        # print(index, i)
        for ind in range(index + 1,len(prices)):
            cnt += 1
            # print(j,cnt)
            if prices[index] > prices[ind]: break
        answer[index] = cnt   
    return answer

# Other Solution 1
from collections import deque
def solution1(prices):
    answer = []
    prices = deque(prices)
    while prices:
        c = prices.popleft()

        count = 0
        for i in prices:
            if c > i:
                count += 1
                break
            count += 1

        answer.append(count)

    return answer
    
# Time out
# def solution(prices):
#     answer = [0]* len(prices)
#     q = collections.deque(prices)
#     for index, i in enumerate(q):
#         cnt = 0
#         # print(index, i)
#         for j in itertools.islice(q, index+1,len(q)):
#             cnt += 1
#             # print(j,cnt)
#             if i > j: break
#         answer[index] = cnt    
#     return answer



# speed : queue < list
#       : range > enumerate
prices = [1, 2, 3, 2, 3]
a = solution(prices)
print(a)