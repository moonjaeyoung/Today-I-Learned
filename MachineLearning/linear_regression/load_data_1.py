import tensorflow as tf
import numpy as np
import os

tf.set_random_seed(777)

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

file = np.loadtxt('data.csv', delimiter=',', dtype=np.float32)

X_data = file[:, :3]
Y_data = np.array(file[:, 3]).reshape(-1, 1)
# N x 1 의 행렬로 만들어줘야함.

X = tf.placeholder(tf.float32, shape=[None, 3])
Y = tf.placeholder(tf.float32, shape=[None, 1])

W = tf.Variable(tf.random_normal([3, 1]))
b = tf.Variable(tf.random_normal([1]))

hypothesis = tf.matmul(X, W) + b
cost = tf.reduce_mean(tf.square(hypothesis - Y))

train = tf.train.GradientDescentOptimizer(learning_rate=1e-6).minimize(cost)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

# TRAINING SESSION !!
# for i in range(0, 3001):
#     c, h, w, t = sess.run([cost, hypothesis, W, train], feed_dict={X: X_data, Y: Y_data})
#
#     print("cost : \n", c)
#     print("weight : \n", w)
#     print("hypothesis : \n", h)
#     print("\n")

# weight = 1.387192 , 1.2015423 , -0.6114366

W_trained = [1.387192, 1.2015423, -0.6114366]
W_trained_reshape = np.array(W_trained, dtype=float).reshape(1, 3)

X_prediction = np.array([68, 78, 72])
result = W_trained_reshape.dot(X_prediction)
print(result)
