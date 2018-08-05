my_int = 1
print(my_int)
# int 자료형

# 파이썬에 primitive 는 없다.
# 모든 것이 call by reference

var_address = id(my_int)
hex_var_address = hex(id(my_int))
# 주소를 출력하는 함수 id
# 16진수로 변환해주는 함수 hex

print(hex_var_address)

a = 10300
b = 10300

print(a == b)
print(a is b)

# == 은 값 비교
# is 는 주소 비교

print(hex(id(a)))
print(hex(id(b)))
