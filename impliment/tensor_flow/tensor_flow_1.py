import tensorflow as flow
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

node = flow.constant('hello , TensorFlow !')

session = flow.Session()

print(session.run(node))

