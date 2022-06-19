import collections
# 우선순위 큐를 써보려고 했으나 같은 수의 경우 앞에꺼가 먼저나올 것으로 생각되어 큐 이용

def solution(priorities, location):
    q = collections.deque()
    length = len(priorities)
    # loc = 0 if location == len(priorities)-1 else location + 1
    for i, p in enumerate(priorities):
        q.append((p, i))
    l = list(zip(*enumerate(priorities)))
    cnt = 0
    while q:
        # max Proiority and index
        maxP, maxI = max(q)
        x = q.popleft()
        # print(x)
        # print(q)
        if x[0] == maxP:
            cnt += 1
            priorities[x[1]] = 0
            if x[1] == location:
                break    
        else:
            q.append(x)
    
    return cnt

# Other Solution 1 (use any)
def solution1(priorities, location):
    queue =  [(i,p) for i,p in enumerate(priorities)]
    answer = 0
    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            answer += 1
            if cur[0] == location:
                return answer

# Other Solution 2
def solution2(priorities, location):
    answer = 0
    search, c = sorted(priorities, reverse=True), 0
    while True:
        for i, priority in enumerate(priorities):
            s = search[c]
            print(s)
            if priority == s:
                c += 1
                answer += 1
                if i == location:
                    break
        else:
            continue
        break
    return answer

priorities = [1, 1, 9, 1, 1, 1]
# priorities = [2, 1, 3, 2]
location = 0
# location = 2
a = solution2(priorities, location)
print(a)