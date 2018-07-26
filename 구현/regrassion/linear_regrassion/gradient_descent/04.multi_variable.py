import tensorflow as flow
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

x1_data = [73., 93., 89., 96., 73.]
x2_data = [80., 88., 91., 98., 66.]
x3_data = [75., 93., 90., 100., 70.]
y_data = [152., 185., 180., 196., 142.]

x1 = flow.placeholder(flow.float32)
x2 = flow.placeholder(flow.float32)
x3 = flow.placeholder(flow.float32)
y = flow.placeholder(flow.float32)

w1 = flow.Variable(flow.random_normal([1]), name='w1')
w2 = flow.Variable(flow.random_normal([1]), name='w2')
w3 = flow.Variable(flow.random_normal([1]), name='w3')
b = flow.Variable(flow.random_normal([1]), name='bias')

# Hypothesis = H(x1, x2, x3) = x1w1 + x2w2 + x3w3
hypothesis = (x1 * w1) + (x2 * w2) + (x2 * w3) + b

cost_func = flow.reduce_mean(flow.square(hypothesis - y))

training = flow.train.GradientDescentOptimizer(learning_rate=0.00001).minimize(cost_func)

sess = flow.Session()
sess.run(flow.global_variables_initializer())

for i in range(100001):
    sess.run(training,
             feed_dict={x1: x1_data, x2: x2_data, x3: x3_data, y: y_data})

    print(sess.run(w1), sess.run(w2), sess.run(w3),
          sess.run(cost_func, feed_dict={x1: x1_data, x2: x2_data, x3: x3_data, y: y_data}),
          sess.run(y, feed_dict={x1: x1_data, x2: x2_data, x3: x3_data, y: y_data}))
