import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
x_data = [1, 3, 4, 6, 8]
y_data = [1, 2, 3, 5, 6]

x = tf.placeholder(tf.float32)
y = tf.placeholder(tf.float32)

w = tf.Variable(5.0)

hypothesis = w * x
cost = tf.reduce_min(tf.square(hypothesis - y))

optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.01)

gvs = optimizer.compute_gradients(cost)
train = optimizer.apply_gradients(gvs)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(0, 101):
    sess.run(train, feed_dict={x: x_data, y: y_data})
    print(i, "번쨰 : ", sess.run(gvs, feed_dict={x: x_data, y: y_data}))
