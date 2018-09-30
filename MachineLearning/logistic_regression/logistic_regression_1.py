import tensorflow as tf
import numpy as np
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

file = np.loadtxt('data.csv')
X_data = np.array(file[:, :5], dtype=np.float32)  # 5 x N
Y_data = np.array(file[:, 5], dtype=np.float32).reshape(-1, 1)  # N x 1

X = tf.placeholder(tf.float32, shape=[None, 5])
Y = tf.placeholder(tf.float32, shape=[None, 1])
W = tf.Variable(tf.random_normal([5, 1]), dtype=tf.float32)

# Hypothesis using sigmoid: tf.div(1., 1. + tf.exp(tf.matmul(X, W)))
hypothesis = tf.sigmoid(tf.matmul(X, W))

# cost/loss function
cost = -tf.reduce_mean(Y * tf.log(hypothesis) + (1 - Y) *
                       tf.log(1 - hypothesis))

train = tf.train.GradientDescentOptimizer(learning_rate=0.05).minimize(cost)


sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(0, 5001):
    h_, c_, w_, _ = sess.run([hypothesis, cost, W, train], feed_dict={X: X_data, Y: Y_data})
    print(i, "번째 학습 hypothesis : \n", h_)
    print(i, "번째 학습 cost : \n", c_)
    print(i, "번째 학습 W : \n", w_)
    print("\n")
