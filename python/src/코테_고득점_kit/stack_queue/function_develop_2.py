import collections

def solution(progresses, speeds):
    answer = []
    q = collections.deque()
    for p, s in list(zip(progresses,speeds)):
        # print(p,s)
        cnt = 0
        while p < 100:
            p += s
            cnt += 1
        q.append(cnt)
    # print(q)
    n = 0
    before = q.popleft()
    answer.append(1)
    while q:
        x = q.popleft()
        if before >= x:
            answer[n] += 1
        elif before < x:
            before = x
            answer.append(1)
            n += 1

    return answer

# Other solution 1
# math.ceil 없이 올림 (p-100) => 음수, (p-100) // s => 내림한 음수(음수에서 내림은 절대값은 커짐), -((p-100)//s) => 올림한 양수
def solution1(progresses, speeds):
    Q=[]
    for p, s in zip(progresses, speeds):
        if len(Q)==0 or Q[-1][0]<-((p-100)//s):
            Q.append([-((p-100)//s),1])
        else:
            Q[-1][1]+=1
        # print(Q)
    return [q[1] for q in Q]

# Other solution 2
def solution2(progresses, speeds):
    print(progresses)
    print(speeds)
    answer = []
    time = 0
    count = 0
    while len(progresses)> 0:
        if (progresses[0] + time*speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
        else:
            if count > 0:
                answer.append(count)
                count = 0
            time += 1
    answer.append(count)
    return answer

progresses = [95, 90, 99, 99, 80, 99]
# progresses = [93, 30, 55]
speeds = [1, 1, 1, 1, 1, 1]
# speeds = [1, 30, 5]
a = solution(progresses, speeds)
print(*a)

