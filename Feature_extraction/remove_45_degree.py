import sys
import os
import re
import fnmatch

numb=1
i =1
k=1
end = numb+144
angle = 0
list = []
for t in range(numb,end):
    if t%12 == 10 or t%12 == 11 or t%12 ==0:
        reg = "SelfieCube"+str(t)
        print(reg)
        for file in os.listdir('.'):
            if fnmatch.fnmatch(file,reg+'*'+'JPG'):
                os.remove(file)
     

   #os.remove($reg\*.JPG)
       # print("reg=",reg)
    #os.remove(SelfieCube+t)
'''    if cnt in range(1,48,12):
        str1+=str(pos[i-1])
        i = i+1
    ofn = "DJI_0"+str(numb)+".JPG"
    fn = "SelfieCube"+str(cnt)+"_"+str1+str(k)+"_"+str(angle)+".JPG"
    os.remove(fn)
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
'''
