import numpy as np

arr1 = np.array([1, 2, 3], dtype=int)
arr2 = np.array([1, 2, 3], dtype=int)

print("사칙연산 덧셈", arr1 + arr2)
print("사칙연산 뺄셈", arr1 - arr2)
print("사칙연산 곱셈", arr1 * arr2)
print("사칙연산 나눗셈", arr1 / arr2)

arr_idn = np.identity(2, dtype=int)
print("행렬곱 연산 .dot() : \n", arr_idn.dot(arr_idn))

arr_T = np.arange(6, dtype=int).reshape(2, 3)
print("기본행렬 : \n", arr_T)
print("전치행렬1 : \n", arr_T.T)
print("전치행렬2 : \n", arr_T.transpose())

# 브로드캐스팅 : shape 이 다른 배열간의 연산
# 1. scalar 와 vector/matrix
arr_broadcast = np.arange(1, 7).reshape(2, 3)
# 1 2 3
# 4 5 6
print("연산 전 : \n", arr_broadcast)
print("위의 행렬 + 3(스칼라)  =  \n", arr_broadcast + 3)
print("위의 행렬 제곱 : \n", arr_broadcast ** 2)

# 2. vector 와 matrix
# 1 2 3    +    0 1 2    =  1 3 5
# 4 5 6                        4 5 6
arr_broadcast_vec = np.arange(3)
print("벡터 + 매트릭스 : \n", arr_broadcast + arr_broadcast_vec)

