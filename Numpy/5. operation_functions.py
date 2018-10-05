import numpy as np

arr = np.arange(1, 11).reshape(2, 5)
# 1 2 3 4 5
# 6 7 8 9 10
print("sum : ", arr.sum())
print("sum axis=0 : ", arr.sum(axis=0))
print("sum axis=1 : ", arr.sum(axis=1))
# 축의 개념 이해하기!

print("평균 ", arr.mean())
print("표준편차 ", arr.std())

print("익스포넨셜 : ", np.exp(arr))
print("루트 : ", np.sqrt(arr))

arr_v1 = np.arange(5).reshape(1, 5)
arr_v2 = np.arange(5, 10).reshape(1, 5)
print("arr_v1 : ", arr_v1)
print("arr_v2 : ", arr_v2)
print("vstack : \n", np.vstack((arr_v1, arr_v2)))
# 가로 행렬 두개 합치기

arr_v1 = np.arange(5).reshape(5, 1)
arr_v2 = np.arange(5, 10).reshape(5, 1)
print("arr_h1 : ", arr_v1)
print("arr_h2 : ", arr_v2)
print("hstack : \n", np.hstack((arr_v1, arr_v2)))
# 세로 행렬 두개 합치기

arr_conc1 = np.arange(1, 5).reshape(1, 4)
arr_conc2 = np.arange(4, 8).reshape(1, 4)
print("arr_conc1 : \n", arr_conc1)
print("arr_conc2 : \n", arr_conc2)
print("concatenate axis=0 : \n", np.concatenate((arr_conc1, arr_conc2), axis=0))
# axis = 0 을 기준으로 합치기

arr_conc3 = np.arange(1, 5).reshape(2, 2)
arr_conc4 = np.arange(5, 7).reshape(1, 2)
print("arr_conc3 : \n", arr_conc3)
print("arr_conc4 : \n", arr_conc4.T)
print("concatenate axis=1 : \n", np.concatenate((arr_conc3, arr_conc4.T), axis=1))
# axis = 1 을 기준으로 합치기
# .T를 붙여주면 트랜스포즈함.


