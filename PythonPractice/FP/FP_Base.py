def call_10_times(func):
    for i in range(10):
        func()


def hello():
    print("안녕하세요")


call_10_times(hello)


# 매개변수로 함수를 넘격준다.


def add(num1, num2):
    return num1 + num2


def add_square():
    return add


print(add_square())
