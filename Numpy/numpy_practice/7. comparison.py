import numpy as np

arr = np.zeros((2, 2), dtype=int)

print(np.any(arr > 5))
# 배열의 element 중 하나라도 성립할 경우 true, 아니면 false

print(np.all(arr == 0))
# 배열의 element 중 모두 성립할 경우 true, 아니면 false
# == 연산자는 값비교, is 연산자는 주소비교 !

print(arr > 0)
# 벡터 - 스칼라 직접 비교
# boolean 배열로 반환됨.

print(arr == np.identity(2, dtype=int))
# 벡터 - 벡터 직접 비교
# 마찬가지로 boolean 배열로 반환됨

FTTF = np.identity(2, dtype=int) == np.zeros((2, 2), dtype=int)
print(FTTF.any())
# boolean 배열.any() -> element중 하나라도 true 가 있으면 true 반환

c = np.array([1, 2, 3], dtype=int)
np.logical_and(c < 4, c > 0)
np.logical_or(c < 4, c > 0)
# logical_?? : 두가지 수식에 대한 논리연산
