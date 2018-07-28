import numpy as np
import tensorflow as flow
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

"""
파일을 읽는 방법
"""

xy = np.loadtxt('data-01-test-score.csv', delimiter=',', dtype= np.float32)
# 해당 문서, 나누는 단위, 데이터 형식

x_data = xy[:, 0:-1]
y_data = xy[:, [-1]]
# 리스트 슬라이싱 사용
# list[:]  ->  리스트의 전체요소
# list[1:]  ->  1 ~ 끝 까지 요소
# list[:2]  ->  처음 ~ 2 까지 요소
# list[:-1]  ->  처음 ~ 끝-1 까지 요소

# 2차원 numpy 어레이
# list[: , 1]  ->  x축은 전체, y축은 1번 인덱스만
# list[0:2 , :]  ->  x축은 0~1번 인덱스 , y축은 전체
# list[:, [-1]]  ->  x축은 전체, y축은 마지막 요소만
# ...

print(x_data)
print(y_data)

x = flow.placeholder(flow.float32, shape=[None, 3])
y = flow.placeholder(flow.float32, shape=[None, 1])
w = flow.Variable(flow.random_normal([6, 1]), name='w')

hypothesis = x * w

cost_func = flow.reduce_mean(flow.square(hypothesis - y))

training = flow.train.GradientDescentOptimizer(learning_rate=0.0001).minimize(cost_func)

sess = flow.Session()
sess.run(flow.global_variables_initializer())

for i in range(20001):
    sess.run([training, cost_func, hypothesis], feed_dict={x: x_data, y: y_data})
    print(sess.run([x, y, w, cost_func, hypothesis], feed_dict={x: x_data, y: y_data}))


print("your score is ", sess.run(hypothesis, feed_dict={x: [[100, 70, 101]]}))