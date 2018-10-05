import numpy as np
import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

file = np.loadtxt('data_practice.csv', delimiter=',', dtype=np.float32)

X_data = np.array(file[:, :-1], dtype=np.float32)
Y_data = np.array(file[:, -1], dtype=np.float32).reshape(-1, 1)

X = tf.placeholder(tf.float32, shape=[None, 7])
Y = tf.placeholder(tf.float32, shape=[None, 1])

W1 = tf.Variable(tf.random_normal([7, 1]))
b1 = tf.Variable(tf.random_normal([1]))
hypothesis = tf.matmul(X, W1) + b1

cost = tf.reduce_mean(tf.square(hypothesis - Y))
train = tf.train.GradientDescentOptimizer(learning_rate=0.003).minimize(cost)

with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())

    # for i in range(0, 50001):
    #     cost_, hypothesis_, w_, b_, _, = sess.run([cost, hypothesis, W1, b1, train], feed_dict={X: X_data, Y: Y_data})
    #     if i % 5000 is 0:
    #         print("cost : \n", cost_)
    #         print("hypothesis : \n", hypothesis_)
    #         print("w : \n", w_)
    #         print("b : \n", b_)

    trained_w = [
    [2.4059625],
    [-2.2378142],
    [3.8700228],
    [2.756923],
    [0.891787],
    [0.9617368],
    [2.2648122]]

    trained_b = [-0.3127127]

    X_prediction = [[8., 8., 9., 8., 8., 9., 10.]]

    pred = sess.run(tf.matmul(X_prediction, trained_w) + trained_b)
    print(pred)
