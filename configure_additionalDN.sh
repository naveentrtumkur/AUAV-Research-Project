#!/bin/sh
# I am currently running hadoop on my local system in pseudo-distributed mode.
# In order to configure multiple data nodes in our system,will make use of this shell script 

#Usage : $configure_additionalDN.sh {start/stop} DataNode_count
# Example usage: $configure_additionalDN.sh start 4 -- This will run 4 datanodes.
# you need to kill them after your work is complete. 


# DN_DIR_PREFIX -- It contains the path to store data and log information

DN_DIR_PREFIX="/Users/naveentr/Documents/hadoop-2.7.5/addition_DN_log/"

if[ -z $DN_DIR_PREFIX];then
echo $0: DN_DIR_PREFIX is noy set. Set the appropriate path.
exit 1
fi

#A function to create and start/stop multiple datanodes
run_datanode(){
DN=$2 #Get the second parameter passed as input -- Start/stop
