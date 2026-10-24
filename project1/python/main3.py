n = int(input())
arr = list(map(int, input().split()))

maxLen = 0
boolean = False
for i in range(n):
    for j in range(i, n):
        boolean = False
        for k in range(i, j):
            if arr[k] == arr[j]:
                boolean = True
                if(j-i > maxLen):maxLen = j-i
                break
        if boolean:
            break
if(j-i > maxLen):maxLen = j-i
print(maxLen)