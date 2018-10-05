import tensorflow as tf
import numpy as np
import os

tf.set_random_seed(777)  # for reproducibility

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
file = np.loadtxt('data.csv')

X_data = np.array(file[:, :4])
Y_data = np.array(file[:, 4:])

X = tf.placeholder(tf.float32, shape=[None, 4])
Y = tf.placeholder(tf.float32, shape=[None, 3])
W = tf.Variable(tf.random_normal([4, 3]))
b = tf.Variable(tf.random_normal([3]))

hypothesis = tf.nn.softmax(tf.matmul(X, W) + b)
cost = tf.reduce_mean(-tf.reduce_sum(Y * tf.log(hypothesis), axis=1))
# 여러 개체의 크로스 엔트로피 평균
# reduce_min = 평균

train = tf.train.GradientDescentOptimizer(learning_rate=0.1).minimize(cost)

with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())

    for i in range(0, 4001):
        sess.run(train, feed_dict={X: X_data, Y: Y_data})
        if i % 400 is 0:
            print(i, "번째 Cost : \n", sess.run(cost, feed_dict={X: X_data, Y: Y_data}))
            print(i, "번째 W : \n", sess.run(W, feed_dict={X: X_data, Y: Y_data}))
            print('--------------')

    a = sess.run(hypothesis, feed_dict={X: [[1, 11, 7, 9]]})
    print("a", sess.run(tf.argmax(a, 1)))
    print('--------------')

    b = sess.run(hypothesis, feed_dict={X: [[1, 3, 4, 3]]})
    print("b", sess.run(tf.argmax(b, 1)))
    print('--------------')

    c = sess.run(hypothesis, feed_dict={X: [[1, 1, 0, 1]]})
    print("c", sess.run(tf.argmax(c, 1)))
    print('--------------')
