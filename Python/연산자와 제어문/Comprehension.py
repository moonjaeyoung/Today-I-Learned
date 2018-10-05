# 복잡한 연산, 제어문을 리스트 안에 넣어 코드의 수를 줄임
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]


# 보통 홀수를 구하기 위해서 하는 방법
myList1 = []
for number in numbers:
    if number % 2 == 1:
        myList1.append(number)
print("기존방식 사용 : " + str(myList1))
# 이런식으로 for 문과 if 문을 결합하여 연산을 실행하여 조건을 비교해 리스트에 추가해야함


# 컴프리헨션을 사용하면 훨씬 간결해짐
myList2 = [number for number in numbers if number % 2 == 1]
print("컴프리헨션 사용 : " + str(myList2))
# 단 한줄의 코드로 위의 반복, 조건검사가 가능함

