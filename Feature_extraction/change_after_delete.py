import sys
import os
import re

count = 1

for file in os.listdir('.'): 
    if "SelfieCube" in file:
        start = file.split('_')
        #print(start)
        temp = ''.join('_').join(start[1:])
        #print(temp)
        new_name = "SelfieCube"+str(count)+temp
    
        print(new_name)
        count +=1
        os.rename(file,new_name)
