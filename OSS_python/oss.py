import numpy as np
import matplotlib.pyplot as plt
import normal, rand
from numpy.linalg import inv
from numpy.random


print(np.random.randint(10, size = 10))
print(np.random.randint(2, size = 10))

A = np.random.randint(10, size = (2, 4))
B = np.random.randint(2, size = (3, 3))

for row in A :
  print(row)
  
for row in B :
  print(row)

print(np.random.randint(5, 10, size = (2, 4)))

A = np.array([1, 2, 3])
print(A)

A = np.array([[1, 2, 3], [4, 5, 6]])
for row in A :
  print(row)
  
A = np.array([[1, 2, 3], [4, 5, 6]])
B = np.array([[0, 1, 2], [3, 4, 5]])

C = A + B
for row in C :
  print(row)

D = A - B
for row in D :
  print(row)

A = np.matrix("1 2 3;4 5 6")
B = np.matrix("0 1 2;3 4 5")

C = A + B
for row in C :
  print(row)

D = A - B
for row in D :
  print(row)

A = np.matrix("1 2 3;4 5 6")
C = np.matrix("0 1;2 3;4 5")

E = A * C
for row in E :
	print(row)

A = np.matrix("1 2 3;4 5 6;7 8 9")

E = A.transpose()
for row in E :
	print(row)


a = np.matrix('1 2;3 4')
ainv = inv(a)

for row in ainv :
	print(row)

print(np.arange(3))
print(np.arange(3,7,0.1))


plt.plot([1, 2, 3, 4], [4, 5, 6, 7])
plt.axis([0, 5, 0, 10])
plt.show()
plt.cla()

t = np.arange(0.0, 2.0, 0.01)
s = np.sin(2*np.pi*t)
plt.plot(t, s)
plt.show()

x = normal(size = 200)
plt.hist(x, bins = 30)
plt.show()
plt.cla()



import numpy as np
from numpy.linalg import inv

A = np.random.randint(10, size=(2,2))
for row in A :
	print(row)
E = A.transpose()
for row in E :
	print(row)

ainv = inv(A)
for row in ainv :
	print(row)


import matplotlib.pyplot as plt
import numpy as np

t = np.arange(0.0, 10.0, 0.01)
s = np.sin(2*np.pi*t)
c = np.cos(2*np.pi*t)
plt.plot(t, s)
plt.plot(t, c)
plt.show()
plt.cla()


import matplotlib.pyplot as plt
from numpy.random import normal, rand

x = normal(size = 1000)
plt.hist(x, bins = 30)
plt.show()
plt.cla()


import matplotlib.pyplot as plt
from numpy.random import rand

a = rand(1000)
b = rand(1000)
plt.scatter(a,b)
plt.show()
plt.cla()