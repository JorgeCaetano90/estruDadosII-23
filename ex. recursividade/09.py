l = [2, 9, 6, 8, 3, 12, 22, 35, 18, 1]

def media(l):
    if len(l) == 1:
        return l[0]
    else:
        return (l[0] + media(l[1:])) / len(l)

print(media(l))