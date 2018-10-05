import numpy as np

# shape handling : reshape 함수를 사용
arr = [[1, 2, 3, 4], [5, 6, 7, 8]]
new_arr = np.array(arr).reshape(8, )
# 단, element의 갯수가 동일해야함.

print(new_arr)
print(new_arr.shape)

tensor = new_arr.reshape(2, 2, 2)
print(tensor)

print(tensor.reshape(-1, 4))

print(tensor.flatten())
# 추가로 flatten() 을 사용하면 해당 어레이를 1차원으로 펴줌
