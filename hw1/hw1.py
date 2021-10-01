f = [ i for i in open("symbols.txt", "r").readlines() ]
dict = {'\n' : '\n'}
tmp = ''

str = input()
for c in str:
    if c != ':' and c != ',':
        if tmp == '':
            tmp = c
        else:
            dict[tmp] = c
            tmp = '' 

for i in f:
    for j in i:
        print(dict[j], end="")