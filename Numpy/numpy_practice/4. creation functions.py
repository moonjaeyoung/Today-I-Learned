import numpy as np

arr1 = np.arange(30)
print("arr1 : \n", arr1)
# np.arrange(n) 하면 0~n 까지의 배열을 만들어냄.

arr2 = np.arange(4, 13, 2)
# np.arrange(n,m,l)
# 마찬가지로 시작, 끝, 스텝임
# 4 ~ 12까지 2칸씩 띄어서
print("arr2 : \n ", arr2)

arr3 = np.arange(2, 20, 0.5)
print("arr3 : \n", arr3)
# 원래 Python List 는 float(소숫점) 단위로 step을 설정할 수 없지만
# numpy array 에서는 가능함.

arr4 = np.arange(30).reshape(5, 6)
# 바로 reshape 하여 shape 핸들링
print("arr4 : \n", arr4)
print("flatten arr4 : \n", arr4.flatten())
print("list4 : \n", arr4.tolist())
# tolist 함수를 사용하면 Python List 형태로 바꿔줌

arr5 = np.zeros(shape=(5,), dtype=int)
print("arr5 : \n", arr5)
# np.zeros() 함수는 쉐입과 타입을 정해주면 0으로 가득찬 어레이를 만들어줌

arr6 = np.ones(shape=(2, 3), dtype=np.float32)
print("arr6 : \n", arr6)
# np.ones() 함수는 zeros 와 동일하지만 1로 가득찬 배열을 만들어줌

arr7 = np.empty(shape=(2, 2), dtype=int)
print("arr7 : \n", arr7)
# 초기화되지 않은 배열을 반환해줌

arr8 = np.arange(0, 30, 2).reshape(3, 5)
print("arr8 : \n", arr8)
print("arr8 ones_like: \n", np.ones_like(arr8))
# 모양과 사이즈가 같지만, 모든 element 가 1인 배열을 반환
print("arr8 zeros_like: \n", np.zeros_like(arr8))
# 모양과 사이즈가 같지만, 모든 element 가 0인 배열을 반환
print("arr8 empty_like: \n", np.empty_like(arr8))
# 모양과 사이즈가 같지만, 모든 element 가 초기화 되지 않은 배열을 반환

arr9 = np.identity(n=3, dtype=int)
print("arr9 : \n", arr9)
# 단위행렬을 만들어주는 함수

arr10 = np.eye(3, dtype=int)
print("arr10 : \n", arr10)
# eye(n) -> n x n 단위행렬을 만들어줌

arr10 = np.eye(3, 5, k=2, dtype=int)
print("arr10 setK : \n", arr10)
# eye(n, m, k=?) -> n x n 단위 행렬을 만들고 k 부터 대각선 시작

arr11 = np.array([
    [0, 1, 2],
    [3, 4, 5],
    [7, 8, 9]
], dtype=int)

print("arr11 diag : \n", np.diag(arr11))
# 대각행렬만 반환
print("arr11 diag setK", np.diag(arr11, k=2))
# k로 스타팅 포인트 지정

arr12 = np.random.uniform(0, 1, 10).reshape(2, 5)
print("arr12 균등분포 : \n", arr12)
