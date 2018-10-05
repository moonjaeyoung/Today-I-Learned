# 튜플의 packing 과 unpacking

my_tuple = 1, 2, 3, 4
# 1, 2, 3, 4 까지 4가지 숫자를 튜플에 packing 함

num1, num2, num3, num4 = my_tuple
# 튜플에 packing 되어있던 데이터를 unpacking 함

print(num1)
print(num2)

num1, num2 = num2, num1
print(num1)
print(num2)

# 이런식으로도 가능함

