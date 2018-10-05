import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
x_data = [1, 2, 3, 4, 5, 6]
y_data = [2, 4, 6, 8, 10, 12]

rate = 0.001

x = tf.placeholder(tf.float32)
y = tf.placeholder(tf.float32)

w = tf.Variable(-3.0)

hypothesis = w * x
cost = tf.reduce_min(tf.square(hypothesis - y))

gradient = tf.reduce_mean((hypothesis - y) * x)
# cost 를 미분한 함수

descent = w - rate * gradient
# w-기울기

update = w.assign(descent)
# w = w - 기울기 (assign 시키는 노드를 생성)

# gradient descent algorithm
# w = w - (rate * d/dw cost(w))
# rate 가 너무 크면 값이 발산함.

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(0, 201):
    sess.run(update, feed_dict={x: x_data, y: y_data})
    # 포문을 여러번 돌면서 지속적으로 w값을 조정해 나감.

    print(i, "번쨰 : ", sess.run(cost, feed_dict={x: x_data, y: y_data}), sess.run(w, feed_dict={x: x_data, y: y_data}))
    # 출력
