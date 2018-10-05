import tensorflow as tf
import numpy as np
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

file = np.loadtxt('data_xor_1.csv', delimiter=',', dtype=np.float32)

X_data = np.array(file[:, :2], dtype=np.float32)
Y_data = np.array(file[:, 2:], dtype=np.float32).reshape(-1, 1)

X = tf.placeholder(tf.float32, shape=[None, 2])
Y = tf.placeholder(tf.float32, shape=[None, 1])

W1 = tf.Variable(tf.random_normal([2, 2]))
# 레이어2의 입력이 2개이므로 레이어1의 출력은 2개여야함
# 2,2 의 쉐입을 가짐.
b1 = tf.Variable(tf.random_normal([2]))
layer1 = tf.sigmoid(tf.matmul(X, W1) + b1)

W2 = tf.Variable(tf.random_normal([2, 1]))
b2 = tf.Variable(tf.random_normal([1]))
hypothesis = tf.sigmoid(tf.matmul(layer1, W2) + b1)

cost = -Y * tf.log(hypothesis) - (1 - Y) * tf.log(1 - hypothesis)
train = tf.train.GradientDescentOptimizer(learning_rate=0.01).minimize(cost)

prediction = tf.cast(hypothesis > 0.5, dtype=tf.float32)
accuracy = tf.reduce_mean(tf.cast(tf.equal(prediction, Y), dtype=tf.float32))

with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())

    for i in range(0, 20001):
        cost_, hypothesis_, _, layer1_ = sess.run([cost, hypothesis, train, layer1], feed_dict={X: X_data, Y: Y_data})

        if i % 2000 is 0:
            print(i, "번째 cost : \n", cost_)
            print(i, "번째 hyp : \n", hypothesis_)
            print(i, "번째 layer1_ : \n", layer1_)
            print("\n")

    print("PREDICTION : \n", sess.run(prediction, feed_dict={X: X_data, Y: Y_data}))
    print("ACCURACY : \n", sess.run(accuracy, feed_dict={X: X_data, Y: Y_data}))
