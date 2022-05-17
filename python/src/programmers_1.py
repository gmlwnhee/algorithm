#1 완주하지 못한 선수
l1 = ["leo", "kiki", "eden"]
l2 = ["leo", "kiki"]

def solution(participant, completion):
    answer = ''
    dic = {}
    dic2 = {}
    for p in participant:
        if p in dic.keys():
            dic[p] += 1
        else:
            dic[p] = 1
    print(dic)
    for c in completion:
        if c in dic2.keys():
            dic2[c] += 1
        else:
            dic2[c] = 1
    for k,v in dic.items():
        if k not in dic2.keys():
            answer = k
            break
        elif k in dic2.keys() and v != dic2[k]:
            answer = k
            break
        else:
            pass
    return answer

# Other Solution 1
import collections


def solution1(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]

# Other Solution 2
def solution2(participant, completion):
    answer = ''
    temp = 0
    dic = {}
    for part in participant:
        dic[hash(part)] = part
        temp += int(hash(part))
    for com in completion:
        temp -= hash(com)
    answer = dic[temp]

    return answer

# Other Solution 3
def solution3(participant, completion):
    participant.sort()
    completion.sort()
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
    return participant[len(participant)-1]

# Other Solution 4
def solution4(participant, completion):
    participant.sort()
    completion.sort()
    for p, c in zip(participant, completion):
        if p != c:
            return p
    return participant[-1]


a = solution(l1, l2)
print(a)