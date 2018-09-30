import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

x = [1, 2, 3]
y = [1, 2, 3]

w = tf.Variable(tf.random_normal([1]), name='weight')
# 랜덤으로 생성되는 값.

hypothesis = w * x
# 우리의 가설함수는 H(x) = w(랜덤) * x

cost = tf.reduce_min(tf.square(y - hypothesis))
# cost 함수는 1/m ∑(H(x) - y)^2

trainer = tf.train.GradientDescentOptimizer(learning_rate=0.01).minimize(cost)
# Gradient Descent 알고리즘을 돌려서 cost 를 최소로 만드는 지점을 찾음.
# 즉, w 값을 계속 조정하면서 cost 함수가 최저가 되는 점으로 이동함.

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(0, 1000):
    sess.run(trainer)
    # 세선 실행

    print(i, "번쨰 : ", sess.run(w), sess.run(cost))
    # 리턴값 출력
