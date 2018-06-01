from gps_lat_long import *

path_name = '/Users/naveentr/Drone_codebase/feature_extraction/DJI_1957.JPG'
meta_data =  ImageMetaData(path_name)
latlng = meta_data.get_lat_lng()
print(latlng)

print(meta_data)
