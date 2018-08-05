import tensorflow as flow
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

x = flow.placeholder(flow.float32)
y = flow.placeholder(flow.float32)
w = flow.Variable(flow.random_normal([1]), name='weight')

# H(x) = Wx
hypothesis = w * x

# Cost = {Σ 1->n (W(x) - y)^2} / 2n
cost = flow.reduce_mean(flow.square(hypothesis - y))

# Gradient descent Algorithm 구현
rate = 0.1
desc = w - rate * flow.reduce_mean((w*x-y) * x)
# 미분해서 자동으로 W값이 최소값으로 움직이게 함
# 이 것이 Gradient descent Algorithm

sess = flow.Session()
# 세션 오픈
sess.run(flow.global_variables_initializer())
# 전역변수 초기화 필수 !

for i in range(30):
    sess.run(w.assign(desc), feed_dict={x: [1, 2, 3], y: [1, 2, 3]})
    print(i, sess.run(cost, feed_dict={x: [1, 2, 3], y: [1, 2, 3]}), sess.run(w))
    # 직접 구현한 알고리즘을 assign 하는 세션을 실행.
