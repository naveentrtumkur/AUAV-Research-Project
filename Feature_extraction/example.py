res=[]
with open('JSONfile22.json','rt') as myfile:
    for line in myfile:
        #print(line)
        res.append(line.strip("{}"))
print(res[0])

list = res[0].split(',')
print(list)
print(list[2])

path_taken = list[2].split(':')[1].strip('\"')
print(path_taken)

pos = []
for char in path_taken:
    pos += char

print(pos)

# check whether our list contains 'UP' or 'DW'
if 'UP' in pos:
    print("UP is present")
elif 'DW' in pos:
    print("DW is present")
else:
    print("Both not present")

    

#for elem in res:
 ##   print(elem)  
