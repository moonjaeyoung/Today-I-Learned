import numpy as np

arr = np.array([1, 2, 3, 4, 5], dtype=int)
print(arr[arr > 2])
# boolean 을 인덱스에 넣으면 True 인 값만으로 배열을 만들어 반환함.

condition = arr > 3
print(arr[condition])
# 이런식으로 사용 가능

 