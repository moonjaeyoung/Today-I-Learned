import tensorflow as flow
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

x_data = [
    [73., 80., 75.],
    [93., 88., 93.],
    [89., 91., 90.],
    [96., 98., 100.],
    [73., 66., 70.]
]

y_data = [
    [152.],
    [185.],
    [100.],
    [196.],
    [142.]
]

x = flow.placeholder(flow.float32, shape=[None, 3])
y = flow.placeholder(flow.float32, shape=[None, 1])
w = flow.Variable(flow.random_normal([5, 1]), name='w')

hypothesis = x * w

cost_func = flow.reduce_mean(flow.square(hypothesis - y))

training = flow.train.GradientDescentOptimizer(learning_rate=0.000001).minimize(cost_func)

sess = flow.Session()
sess.run(flow.global_variables_initializer())

for i in range(2001):
    sess.run(training, feed_dict={x: x_data, y: y_data})
    print(sess.run(w), '\n',  sess.run(y, feed_dict={x: x_data, y: y_data}))


