list1 = [1, 2, 3, 4, 5, 6]

print('슬라이싱 ', list1[0:3])
# 리스트 슬라이싱
# 리스트의 n ~ k 번째 원소를 출력

print('2번 반복 ', list1 + list1)
print('5번 반복 ', list1 * 5)
# 반복 (+ 와 * 연산자를 사용)

del list1[0]
print('0번 인덱스 삭제 ', list1)
# 인덱스 삭제

list1.remove(3)
print('3이라는 값 삭제 ', list1)
# 값 삭제

list1.append(0)
print('마지막 인덱스에 0 추가 ', list1)
# 추가

list1.insert(0, 9)
print('0번 인덱스에 9 삽입 ', list1)
# 삽입

list1.sort()
print('정렬 ', list1)
# 정렬

print('2번째 안댁스 원소 pop ', list1.pop(2))
print('pop 연산후 2번쨰 인덱스의 원소는 삭제됨', list1)
# 스택의 pop 과 동일
# 주의 할 점은 pop 연산후에는 해당 요소가 삭제됨


list1.insert(0,5)
list1.insert(2,5)
list1.insert(4,5)
print(list1)
print("5의 갯수는 : " + str(list1.count(5)))
