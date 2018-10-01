import tensorflow as tf
import numpy as np
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
learning_rate = 0.1

tf.set_random_seed(777)

training_set = np.loadtxt('data_training.csv', delimiter=',', dtype=np.float32)
test_set = np.loadtxt('data_test.csv', delimiter=',', dtype=np.float32)

x_training = np.array(training_set[:, :3], np.int32)
y_training = np.array(training_set[:, 3:], np.int32)

x_test = np.array(test_set[:, :3], np.int32)
y_test = np.array(test_set[:, 3:], np.int32)

X = tf.placeholder(tf.float32, shape=[None, 3])
Y = tf.placeholder(tf.float32, shape=[None, 3])

W = tf.Variable(tf.random_normal([3, 3]))
b = tf.Variable(tf.random_normal([3]))

legits = tf.matmul(X, W) + b
hypothesis = tf.nn.softmax(legits)

# cross_entropy = -∑(L * log(S))
cross_entropy = -tf.reduce_sum(Y * tf.log(hypothesis), axis=1)
cost = tf.reduce_mean(cross_entropy)
train = tf.train.GradientDescentOptimizer(learning_rate=learning_rate).minimize(cost)

with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())

    # # TRAINING SESSION !
    # for i in range(0, 20001):
    #     H_, C_, W_, B_, T_ = sess.run([hypothesis, cost, W, b, train], feed_dict={X: x_training, Y: y_training})
    #     if i % 1000 == 0:
    #         print(i, "번째 Cost : \n", C_)
    #         print(i, "번째 Hyp : \n", sess.run(tf.argmax(H_, 1)))  # one hot encoding
    #         print(i, "번째 Wgt : \n", W_)
    #         print(i, "번째 bias : \n", B_)

    weight_trained = [
        [-14.011348, 1.2000887, 13.075335],
        [0.44196415, 0.3479418, 0.10999186],
        [4.527767, -0.5909298, -5.9883127]]

    bias_trained = [-14.35556, -0.4226232, 12.174633]

    test_legits = tf.matmul(X, weight_trained) + bias_trained
    test_hypothesis = sess.run(tf.nn.softmax(test_legits), feed_dict={X: x_test})
    result = sess.run(tf.argmax(test_hypothesis, 1))
    print(result)
    # 결과 : 2 2 2 - 테스트 데이터도 잘 맞췄음.
