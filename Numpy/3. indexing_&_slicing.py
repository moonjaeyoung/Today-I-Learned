import numpy as np

a = np.array([[1, 2], [3, 4]], int)
'''
INDEXING
'''
print(a[1][1])
# 기존 리스트에서의 인덱싱기법
# 1 x 1 위치에 있는 원소를 반환함

print(a[1, 0])
# numpy 에서는 좀더 직관적으로 1,0 같이 좌표로 입력할 수 있음

a[1][0] = 7
a[0, 1] = 88
# 할당역시 가능
print(a)

'''
SLICING
'''
b = np.array([[1, 2, 3, 4], [5, 6, 7, 8]], int)
# 1 2 3 4
# 5 6 7 8

print("슬라이싱 1: \n", b[:, 2:])
# : 를 쓰면 전체라는 뜻임
# 행전체, 2열~이상 -> 슬라이스

print("슬라이싱 2: \n", b[1, 1:3])
# : 1행, 1열~3열 -> 슬라이스
# 1:3 이렇게 하면 1~2까지 자르는 것임
# x : y -> x부터 y 전까지

print("슬라이싱 3: \n", b[1:3])
# : 콤마를 안쓰고 하나만 적으면 행만 선택해서 모든 열을 긁어옴
# 1~3행, 모든열 -> 슬라이스
# 그러나 지금 0~1행까지밖에 없으므로, 1행의 모든열을 출력함.

print("슬라이싱 4: \n", b[:])
# 콤마를 안적었기 때문에 행만 선택, :행을 선택했기 때문에 모든 행선택
print("슬라이싱 5: \n", b[1:, 2:4])
# 1행~이상 , 2~4열 -> 슬라이스
