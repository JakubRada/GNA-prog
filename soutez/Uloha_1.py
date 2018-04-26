import time
woman_step_const = 0.413
man_step_const = 0.415

def load_data(filename):
    with open(filename + ".csv", "r") as f:
        return f.read().split("\n")

def time_to_hours(timestring):
    time_list = timestring.split(":")
    time_list[2] = time_list[2][:6]
    return round(int(time_list[0]) + (int(time_list[1]) / 60) + (float(time_list[2]) / 3600), 3)
    
def get_weight():
    while True:
        try:
            return float(input("Your weight [kg]: "))
        except:
            print("!! It has to be a number !!")

def datum_function(): #gets datum in correct format from user
    print("\n")
    while True:
        year = input("Year:" + 5 * " ")
        if year == "#today":
            date = time.strftime("%d_%m_%Y")
            return date
        else:
            try:
                year = int(year)
            except ValueError:
                continue
            if len(str(abs(year))) == 4:
                break
    while True:
        try:
            month = int(input("Month:" + 4 * " "))
        except ValueError:
            continue
        if month in range(1, 13):
            break
    while True:
        try:
            day = int(input("Day:" + 6 * " "))
        except ValueError:
            continue
        if (month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12) and day\
                in range(1, 32):
            break
        elif (month == 4 or month == 6 or month == 9 or month == 11) and day in range(1, 31):
            break
        else:
            if (year % 4) == 0:
                if day in range(1, 30):
                    break
                else:
                    continue
            else:
                if day in range(1, 29):
                    break
                else:
                    continue
    if day < 10 and month < 10:
        date = "0" + str(day) + "_0" + str(month) + "_" + str(year)
    elif day < 10 <= month:
        date = "0" + str(day) + "_" + str(month) + "_" + str(year)
    elif day >= 10 > month:
        date = str(day) + "_0" + str(month) + "_" + str(year)
    else:
        date = str(day) + "_" + str(month) + "_" + str(year)
    return date

class Day:
    def __init__(self, data_list_):
        self.data_list = data_list_[1:len(data_list_)]
        self.get_step_len()
        self.weight = get_weight()
        self.date = datum_function()

    def get_step_len(self):
        help_list = self.data_list[0].split(",")
        if help_list[4] == '0':
            self.step_len = (int(help_list[5]) * man_step_const)
        else:
            self.step_len = (int(help_list[5]) * woman_step_const)
        self.step_len /= 100

    def get_output(self):
        self.results = [0, 0, 0, 0] #steps, deep sleep, shallow sleep, energy burned
        for line in self.data_list:
            if line == '' or line == ' ':
                continue
            temp_res = self.analyze_one_line(line)
            for i in range(4):
                self.results[i] += temp_res[i]
        self.results[0] = round(self.results[0] * (self.step_len / 1000), 1)
        self.results[3] = round(self.results[3] / 1000, 0)
        print("Walked km: {0}; Sleep: {1} hours deep, {2} hours shallow; burned kcal: {3}.\n".format(self.results[0], self.results[1], self.results[2], self.results[3]))

    def analyze_one_line(self, line):
        sublist = line.split(",")
        sublist = sublist[:3]
        t = 0
        if sublist[1] != '00:00:00.000Z':
            t = time_to_hours(sublist[1]) - time_to_hours(sublist[0])
        else:
            t = 24 - time_to_hours(sublist[0])
        step_count = int(sublist[2])
        s = (step_count * self.step_len) / 1000
        v = s / t
        e = (0.0215 * (v * v * v) - 0.1765 * (v * v) + 0.8710 * v + 1.4577) * t * self.weight
        if step_count == 0:
            return [0, t, 0, e]
        elif (step_count > 0) and (step_count < 10):
            return [step_count, 0, t, e]
        else:
            return [step_count, 0, 0, e]
    
    def write_to_file(self):
        try:
            f = open("fitness_prehled.csv", "r")
            f.close()
        except:
            f = open("fitness_prehled.csv", "w")
            f.write("Day,km,deep sleep,shallow sleep, burned kcal,\n")
            f.close()
        f = open("fitness_prehled.csv", "a")
        f.write("{0},{1},{2},{3},{4}\n".format(self.date, self.results[0], self.results[1], self.results[2], self.results[3]))

while True:
    file = input("File: ")
    if file == "END":
        break
    else:
        try:
            data = load_data(file)
        except:
            print("!! Non-existing file !!")
            continue
        the_D = Day(load_data(file))
        the_D.get_output()
        the_D.write_to_file()
        del the_D