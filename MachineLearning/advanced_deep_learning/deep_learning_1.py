import numpy as np
import tensorflow as tf
import os
import math


def xavier_init(n_inputs, n_outputs, uniform=True):
    if uniform:
        init_range = math.sqrt(6.0 / (n_inputs + n_outputs))
        return tf.random_uniform_initializer(-init_range, init_range)
    else:
        stddev = math.sqrt(3.0 / (n_inputs + n_outputs))
        return tf.truncated_normal_initializer(stddev=stddev)


os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

file = np.loadtxt('data_advanced.csv', delimiter=',', dtype=np.float32)

X_data = np.array(file[:, :-1], dtype=np.float32)
Y_data = np.array(file[:, -1], dtype=np.float32).reshape(-1, 1)

X = tf.placeholder(tf.float32, shape=[None, 7])
Y = tf.placeholder(tf.float32, shape=[None, 1])

# xavier initializer 사용
W1 = tf.get_variable("W1", shape=[7, 32], initializer=xavier_init(16, 32))
b1 = tf.Variable(tf.random_normal([32]))
L1 = tf.nn.relu(tf.matmul(X, W1) + b1)
_L1 = tf.nn.dropout(L1, 0.7)
# dropout 적용

W2 = tf.get_variable("W2", shape=[32, 32], initializer=xavier_init(32, 32))
b2 = tf.Variable(tf.random_normal([32]))
L2 = tf.nn.relu(tf.matmul(_L1, W2) + b2)
_L2 = tf.nn.dropout(L2, 0.7)

W3 = tf.get_variable("W3", shape=[32, 1], initializer=xavier_init(32, 1))
b3 = tf.Variable(tf.random_normal([1]))

hypothesis = tf.nn.softmax(tf.matmul(_L2, W3) + b3)
_hypothesis = tf.nn.dropout(L2, 1.0)
cost = tf.reduce_mean(-tf.reduce_sum(Y * tf.log(hypothesis), axis=1))
train = tf.train.AdamOptimizer(learning_rate=0.01).minimize(cost)
# AdamOptimizer 적용

with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())

    for i in range(0, 4001):
        T, T_cost, T_hypothesis, T_W = sess.run([train, cost, _hypothesis, W3], feed_dict={X: X_data, Y: Y_data})

        print(i, "번째 코스트 : \n", T_cost)
        print(i, "번째 가설 : \n", T_hypothesis)
        print(i, "번째 Weight : \n", T_W)
