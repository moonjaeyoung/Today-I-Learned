import numpy as np

a = np.loadtxt("./data1.txt")
print(a)

np.savetxt('data1.csv', a, delimiter=',')
# 텍스트 형태로 저장 (.csv / .txt 파일)

b = np.loadtxt("./data1.csv")
print(b)

np.save(file='npy_test.npy', arr=a)
# 피클(바이너리파일) 형태로 저장 (.npy 파일)

npy = np.load(file='npy_test.npy')
print(npy)
