import sys
from exposure_time import *

path_name = sys.argv[1]
data = get_exif(path_name)

print(data)

