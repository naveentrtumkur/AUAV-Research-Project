# @author Naveen Tumkur Ramesh Babu
##################################
# Cube Co-ordinates extraction   #
##################################

# Given an image and it's JSON file, extract the 3D co-ordinates of the drone poistion
# when the image was taken (X_Y_Z co-ordinates). 


# Import this to handle file operations.
import sys
from io import open
import json
from pprint import pprint

#function to parse the input file and convert it into list of lists.
# This would be used as input for our program.
def parse_infile(fPath):
    return (i) for i in l.strip(',').split() for l in open(fPath,"r").readlines() 

def main():
 #   filen = '/Users/naveentr/Drone_codebase/feature_extraction/JSONfile22.json'
    constructTriangle = parse_infile("JSONfile22.json")
    print(constructTriangle)
    #with open("JSONfile22.json", "r") as read_file:
 #       data = json.load(read_file)
    
if __name__ == '__main__':
    main()
