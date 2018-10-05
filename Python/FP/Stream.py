my_list = [1, 2, 3, 4, 5, 6]


def power(num):
    return num * num


def under_3(num):
    return num < 3


my_square_list = list(map(power, my_list))
my_under_list = list(filter(under_3, my_list))

print(my_square_list)
print(my_under_list)