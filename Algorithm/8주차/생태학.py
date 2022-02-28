import sys
input = sys.stdin.readline

trees = dict()
count = 0
while True :
    tree = input().rstrip()
    if tree == '' :
        break
    elif tree in trees :
        trees[tree]+=1
    else :
        trees[tree] = 1
    count+=1


sorted_trees = sorted(trees.items())

for key, value in sorted_trees :
    print(f'{key} {trees[key]/count*100:.4f}')