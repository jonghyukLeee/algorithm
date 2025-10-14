s = input().strip()
idx = 0
num = 0

while idx < len(s):
    num += 1
    for ch in str(num):
        if idx < len(s) and s[idx] == ch:
            idx += 1
print(num)
