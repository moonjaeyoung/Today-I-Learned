import tensorflow as flow
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

x = [1, 2, 3]
y = [1, 2, 3]
# 트레이닝 데이터셋

w = flow.Variable(flow.random_normal([1]), name='weight')
b = flow.Variable(flow.random_normal([1]), name='bias')
# 변수 선언

# H(x) = Wx + b
hypothesis = w * x + b

# CostFunction = {Σ 1->n (W(x) - y)^2} / 2n
cost = flow.reduce_mean(flow.square(hypothesis - y))
# reduce_mean = 평균계산 함수
# = {Σ 1->n (function)} / n ... 전체를 더한다음에 그것의 갯수로 나누는 함수

# Gradient descent Algorithm
optimizer = flow.train.GradientDescentOptimizer(learning_rate=0.01)
training = optimizer.minimize(cost)
# 미리 구현된 알고리즘 사용

sess = flow.Session()
# 세션 오픈
sess.run(flow.global_variables_initializer())
# 전역변수 초기화 필수 !!

for i in range(6000):
    sess.run(training)
    print(i, sess.run(w), sess.run(b) , sess.run(cost))
    # 세션 실행
