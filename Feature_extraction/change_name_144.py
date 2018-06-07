import sys
import os
numb = int(sys.argv[1])
print(numb)
pos = ["C","L","B","R"]
str1 = ""
cnt = 1
#print(pos[0])
'''for fileName in os.listdir("."):
    for i in range(1,4):
        str1+= str(pos[i-1]) 
        for j in range(1,4):
            for k in range(1,3):
                fn = "SelfieCube"+str(cnt)+"_"+str1+str(k)
                ofn = "DJI_"+str(numb)
                os.rename(fileName, fileName.replace(ofn, fn))
                cnt = cnt+1
                numb= numb+1
                print(numb)
                print(cnt)
        if cnt == 24:
            str1 = "DW"
        elif cnt == 48:
            str1 = "UP_UP"
'''

i =1
k=1
end = numb+144
angle = 0
for t in range(numb,end):
   # for fileName in os.listdir("."):
    if cnt in range(1,48,12):
        str1+=str(pos[i-1])
        i = i+1
    ofn = "DJI_0"+str(numb)+".JPG"
    fn = "SelfieCube"+str(cnt)+"_"+str1+str(k)+"_"+str(angle)+".JPG"
    os.rename(ofn, fn)
    angle+=15
    k+=1
    cnt+=1
    numb+=1
    if angle == 60:
        angle = 0
    if k ==4:
        k = 1
    if cnt == 48:
        str1 = "DW"
        i = 1
    elif cnt == 72:
        str1="UP_UP"
        i = 1
