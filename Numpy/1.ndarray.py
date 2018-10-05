import numpy as np

array_1 = np.array([1, 4, 5, 8], float)
# np.array(value, type)
# ndarray는 List와 다르게 한가지 타입만 넣을수 있음.

print(array_1)  # 어레이 출력
print(type(array_1[3]))  # numpy float64

array_2 = np.array([1, 2, '3', '4'], float)
print(array_2)
print(type(array_2[3]))
# string -> float

array_3 = np.array([5, 2, 4, 6], str)
print(array_3)
print(type(array_3[3]))
# string -> float

print(array_3.dtype)
print(array_3.shape)
print(array_3.size)

vec = np.array([1, 2, 3], float)
print(vec.shape)
print(vec.ndim)

mat = np.array([[1, 2, 3], [4, 5, 6]], float)
print(mat.shape)
print(mat.ndim)

ten = np.array([[[1, 2, 3], [2, 3, 4]], [[1, 2, 3], [2, 3, 4]]])
print(ten.shape)
print(ten.ndim)
print(ten.size)
