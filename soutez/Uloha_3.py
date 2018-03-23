# listy hodnot ciselnych soustav
roman = ["I", "V", "X", "L", "C", "D", "M"]
arabian = [1, 5, 10, 50, 100, 500, 1000]


def to_arabian(number): # funkce resici prevod do arabskych cisel
    # rozklad retezce na jednotliva pismnka
    input_number = list(number)
    result_number = 0
    # pricitani hodnot
    for i in range(len(input_number)):
        item = input_number[i]
        if item in roman:
            # pro pripad IV a IX
            if i < (len(input_number) - 1):
                if (item == "I") and (input_number[i + 1] == ("V" or "X")):
                    result_number -= 1
                else:
                    result_number += arabian[roman.index(item)]
            # ostatni pripady
            else:
                result_number += arabian[roman.index(item)]
        # neexistujici rimske cislo
        else:
            return "Spatny vstup!"
    return result_number

def to_roman(number):
    # zjisteni, zda je input cislo
    try:
        input_number = int(number)
    except:
        return "Špatný vstup!"
    result_number = ""
    # pricitani hodnot rimskych cisel
    for i in range(7):
        if input_number == 4:
            result_number += "IV"
            break
        elif input_number == 9:
            result_number += "IX"
            break
        # pripady jine nez 4 a 9
        else:
            x = input_number // arabian[6 - i]
            result_number += x * roman[6 - i]
            input_number -= (x * arabian[6 - i])
    return result_number

# Urcovani, ktera funkce se spusti
while True:
    command = str(input("Zadej směr převodu |římské -> arabské(1)| | arabské -> římské (2)|: "))
    if command == "1":
        while True:
            num = str(input("Zadej převáděné římské číslo: "))
            if num == "KONEC":
                break
            else:
                result = to_arabian(num)
                print(result)
        break
    elif command == "2":
        while True:
            num = input("Zadej převáděné arabské číslo: ")
            if num == "KONEC":
                break
            else:
                result = to_roman(num)
                print(result)
        break
    else:
        print("Špatný vstup")
print("Program ukončen.")
