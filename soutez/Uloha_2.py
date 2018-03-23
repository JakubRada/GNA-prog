class Road:
    def __init__(self):
        with open("mapa.txt", "r") as f:
            lines = f.read().split("\n")
        lines.pop()
        self.map = []
        for i in range(20):
            self.map.append(list(lines[i]))
        self.was_there = []
        self.count = 0
        self.last_cross = []
        self.last_choice = []
        self.choice = 0

    def print_map(self):
        for y in range(20):
            for x in range(20):
                print(self.map[y][x], end="", flush=True)
            print("\n")

    def find_place(self, symbol):
        for y in range(20):
            for x in range(20):
                if self.map[y][x] == symbol:
                    return [x, y]

    def look_around(self, loc):
        possible = [[loc[0], loc[1] + 1], [loc[0] - 1, loc[1]], [loc[0], loc[1] - 1], [loc[0] + 1, loc[1]]]
        for i in range(0, 3):
            if (possible[i][0] > 19) or (possible[i][1] > 19):
                del possible[i]
        to_remove = []
        for i in range(len(possible) - 1):
            if (self.map[possible[i][1]][possible[i][0]] == "X") or (self.map[possible[i][1]][possible[i][0]] == "0"):
                to_remove.append(possible[i])
            elif self.map[possible[i][1]][possible[i][0]] == "*":
                return "end"
        for i in range(len(to_remove)):
            possible.remove(to_remove[i])
        to_remove = []
        for i in range(0, len(possible) - 1):
            if possible[i] in self.was_there:
                to_remove.append(possible[i])
        for i in range(len(to_remove)):
            possible.remove(to_remove[i])

        if len(possible) > 1:
            self.last_cross = list(loc)
            self.choice = 0
            self.move(possible[self.choice])

        elif len(possible) == 1:
            self.move(possible[0])

        else:
            self.was_there = self.was_there[0:(self.was_there.index(self.last_cross))]


    def move(self, dest):
        self.was_there.append(dest)
        self.count += 1


Path = Road()


Path.print_map()
print(Path.find_place("0"))
Path.was_there.append(Path.find_place("0"))
while True:
    a = Path.look_around(Path.was_there[len(Path.was_there) - 1])
    if a == "end":
        break
coordinates = []
for i in range(len(Path.was_there)):
    coordinates = list(Path.was_there[i])
    Path.map[coordinates[1]][coordinates[0]] = "o"

print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
Path.print_map()