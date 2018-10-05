import tensorflow as tf
import numpy as np
import os


def min_max_scale(data):
    numerator = data - np.min(data, 0)
    denominator = np.max(data, 0) - np.min(data, 0)
    # noise term prevents the zero division
    return numerator / (denominator + 1e-7)


os.environ['TF_CPP_MAIN_LOG_LEVEL'] = '2'

file = np.loadtxt('data_std.csv', delimiter=',')
file = min_max_scale(file)

X_data = np.array(file[:, :4], dtype=np.float32)
Y_data = np.array(file[:, 4], dtype=np.float32).reshape(-1, 1)

X = tf.placeholder(tf.float32, shape=[None, 4])
Y = tf.placeholder(tf.float32, shape=[None, 1])
W = tf.Variable(tf.random_normal([4, 1]))
b = tf.Variable(tf.random_normal([1]))

hypothesis = tf.matmul(X, W) + b
cost = tf.reduce_mean(tf.square(hypothesis - Y))

train = tf.train.GradientDescentOptimizer(learning_rate=0.001).minimize(cost)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(0, 2001):
    C_, H_, _ = sess.run([cost, hypothesis, train], feed_dict={X: X_data, Y: Y_data})
    print(i, "번째 : ", C_)
