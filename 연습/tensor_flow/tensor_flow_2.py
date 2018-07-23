import tensorflow as flow
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

node_1 = flow.placeholder(flow.float32)
node_2 = flow.placeholder(flow.float32)

node_add = flow.add(node_1, node_2)

sess = flow.Session()

print(sess.run(node_add , feed_dict={node_1: 5.0, node_2: 4.0}))
