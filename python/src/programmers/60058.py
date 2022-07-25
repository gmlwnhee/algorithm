# 괄호 변환
stack = [] # 스택이 먼저 떠오름

def checkBalance(brace):
    # check balanced string
    for _ in brace:
        if _ == '(':
            stack.append(_)
        else :
            if len(stack) != 0:
                stack.pop()
            else:
                return False
    if len(stack) == 0:
        return True
    else:
        stack.clear()
        return False

def solution(p):
    if p =='':
        return ''
    elif checkBalance(p):
        return p
    else:
        for i in range(0,len(p),2):
            arr = str(p[:i+2])
            print(arr)
            # print(p[:i+1])
            # divide u and v
            if arr.count('(') == arr.count(')'):
                if checkBalance(p[:i+2]):
                    return p[:i+2] + solution(p[i+2:])
                else:
                    return '(' + solution(p[i+2:]) + ')' + p[1:i+1].replace(')', '_').replace('(', ')').replace('_', '(')


p = ["(()())()", ")(", "()))((()"]
result = ["(()())()", "()", "()(())()"]
k = 2

ans = solution(p[k])

if ans == result[k]:
    print('success - ', ans)
else:
    print('fail - ', ans)

# Other Solution 1
def solution1(p):
    if p=='': return p
    r=True; c=0
    for i in range(len(p)):
        if p[i]=='(': c-=1
        else: c+=1
        if c>0: r=False
        if c==0:
            if r:
                return p[:i+1]+solution(p[i+1:])
            else:
                return '('+solution(p[i+1:])+')'+''.join(list(map(lambda x:'(' if x==')' else ')',p[1:i]) ))