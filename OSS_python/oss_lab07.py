import matplotlib.pyplot as plt
from numpy.random import rand

a = rand(1000)
b = rand(1000)
plt.scatter(a,b)
plt.show()
plt.cla()