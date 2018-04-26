timestring = '00:15:00.000Z'
time_list = timestring.split(":")
time_list[2] = time_list[2][:6]
hours = round(int(time_list[0]) + (int(time_list[1]) / 60) + (float(time_list[2]) / 3600), 3)
print(hours)