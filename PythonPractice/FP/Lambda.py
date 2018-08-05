# 기존방식의 함수
def add(x, y):
    return x + y


# 람다식 적용
lambda_add = lambda x, y: x + y

print(lambda_add(5, 4))
print(type(lambda_add))
