import os
import tensorflow as tf

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

X_data = [
    [73., 80., 75.],
    [93., 88., 93.],
    [89., 91., 90.],
    [96., 98., 100.],
    [73., 66., 70.]
]  # 5 x 3

Y_data = [
    [152.],
    [185.],
    [180.],
    [196.],
    [142.]
]  # 5 x 1

X = tf.placeholder(tf.float32, shape=[None, 3])
Y = tf.placeholder(tf.float32, shape=[None, 1])

W = tf.Variable(tf.random_normal([3, 1]), name='weight')

hypothesis = tf.matmul(X, W)

cost = tf.reduce_mean(tf.square(hypothesis - Y))
optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.00001)
train = optimizer.minimize(cost)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(0, 3001):
    hypothesis_, cost_, _ = sess.run([hypothesis, cost, train], feed_dict={X: X_data, Y: Y_data})

    print(i, "번째 코스트 : ", cost_)
