import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from practice.perceptron.perceptron import Perceptron

if __name__ == '__main__':
    df = pd.read_csv('test.csv', header=None)
    y = df.iloc[0:100, 4]
    y = np.where(y == 'Iris-setosa', -1, 1)
    x = df.iloc[0:100, [0, 2]].values

    plt.scatter(x[:50, 0], x[:50, 1], color='r', marker='o', label='setosa')
    plt.scatter(x[50:100, 0], x[50:100, 1], color='b', marker='x', label='vericolor')
    plt.ylabel('RO! 210(cm)')
    plt.legend(loc=4)
    plt.show()

    # pt = Perceptron(eta=0.1)
    # pt.fit(x, y)
    # print(pt.error)
