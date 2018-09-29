import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

X_data = [
    [90, 95, 90, 99, 98],
    [50, 44, 42, 60, 60],
    [68, 72, 80, 65, 70],
    [0, 10, 22, 0, 25],
    [80, 84, 91, 80, 85],
    [40, 55, 40, 38, 40],
    [70, 78, 77, 69, 73]
]  # 7 x 5

Y_data = [
    [98],
    [52],
    [72],
    [20],
    [87],
    [42],
    [77]
]  # 7 x 1

X = tf.placeholder(tf.float32, shape=[None, 5])  # ? x 5
Y = tf.placeholder(tf.float32, shape=[None, 1])  # ? x 1
W = tf.Variable([[0.23], [0.23], [0.23], [0.23], [0.23]], dtype=tf.float32)  # 5 x 1

hypothesis = tf.matmul(X, W)
cost = tf.reduce_min(tf.square(hypothesis - Y))

train = tf.train.GradientDescentOptimizer(learning_rate=0.00001).minimize(cost)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

# TRAINING SESSION !
# for i in range(0, 8001):
#     cost_, hypothesis_, train_ = sess.run([cost, hypothesis, train], feed_dict={X: X_data, Y: Y_data})

# W = 0.21057633, 0.20996839, 0.21042275, 0.20937954, 0.20866278

W_trained = [
    [0.21057633],
    [0.20996839],
    [0.21042275],
    [0.20937954],
    [0.20866278]
]

X_prediction = [[75.0, 74.0, 78.0, 72.0, 80.0]]

print("예측값 : ", sess.run(tf.matmul(X_prediction, W_trained)))
