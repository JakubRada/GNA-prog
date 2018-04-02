def fill_dict(filename):
	dict = {}
	with open(filename + ".txt", "r") as f:
		strings = f.read().split("\n")
	for item in strings:
		tmp = item.split(" ")
		dict[tmp[0]] = tmp[1]
	return dict
dict_name = input("Enter dictionary name: ")
text_name = input("Enter text name: ")
dict = fill_dict(dict_name)
with open(text_name + '.txt', 'r') as f:
	text = (" ".join((f.read().split("\n")))).split(" ")
print(text)
result = []
for i in text:
	try:
		result.append(dict[i])
	except:
		result.append("??")
result_string = " ".join(result)
print(result_string)