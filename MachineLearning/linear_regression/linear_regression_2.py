import tensorflow as tf
import os

# placeholder 사용한 버전, 내용은 이전의 파일과 동일함.
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
x_data = [1, 3, 4, 6, 8]
y_data = [1, 2, 3, 5, 6]

x = tf.placeholder(tf.float32)
y = tf.placeholder(tf.float32)

w = tf.Variable(tf.random_normal([1]), name='weight')

hypothesis = w * x
cost = tf.reduce_min(tf.square(hypothesis - y))

trainer = tf.train.GradientDescentOptimizer(learning_rate=0.01).minimize(cost)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(0, 101):
    sess.run(trainer, feed_dict={x: x_data, y: y_data})
    print(i, "번쨰 : ", sess.run(cost, feed_dict={x: x_data, y: y_data}), sess.run(w, feed_dict={x: x_data, y: y_data}))
