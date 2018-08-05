def my_function():
    print("hello")


# def 키워드로 작성

def add(num1, num2):
    return num1 + num2


# 함수 선언시 리턴값의 형태를 정의해주지 않아도 됨,


def return_tuple(num1, num2):
    return num1, num2, num1 + num2


my_function()

print(add(1, 4))

print(return_tuple(5, 8))
