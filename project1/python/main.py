n, m, r1, r2 = list(map(int, input().split()))
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))

temp = arr[r1]
arr[r1] = arr[r2]
arr[r2] = temp

for i in range(n):
    for j in range(m):
        print(arr[i][j], end=" ")
    print()


