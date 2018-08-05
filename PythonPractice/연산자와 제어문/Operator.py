# 기본적인 사칙연산
print("덧셈 8+4 : " + str(8 + 4))
print("뺄셈 8-4 : " + str(8 - 4))
print("곱셈 8*4 : " + str(8 * 4))
print("나눗셈 8/4 : " + str(8 / 4))

# C나 Java 에 없는 연산
print("제곱 3^4 : " + str(3**4))
print("나눗셈 전부 출력 5/2 : " + str(7/3))
print("나눗셈 몫만 출력 5/2 : " + str(7//3))

# 논리 연산자
a = 400
b = 100
myList = 500, 600

if a > 100 and a != 0:
    print("correct number")
# and (논리적 and)

if a not in myList:
    print("a is not in myList !")
# not in (리스트와 비교)

if a != b:
    print("a is not b !")
# != (not equal 연산)

if a or b:
    print("or")
