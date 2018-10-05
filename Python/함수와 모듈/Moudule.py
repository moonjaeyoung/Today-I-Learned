import random as rd

lists = [1, 2, 3, 4, 5, 6, 7, 8, 9]

print(rd.choice(lists))

print(rd.sample(lists, 2))


def lotto():
    print(rd.sample(range(1, 46), 6))


lotto()
lotto()
lotto()

print(rd.randint(0, 200))
