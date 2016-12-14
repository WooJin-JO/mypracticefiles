import tensorflow as tf
# TensorFlow 사용을 위한 import
from tensorflow.examples.tutorials.mnist import input_data

# Dataset loading
mnist = input_data.read_data_sets("./samples/MNIST_data/", one_hot=True)

# Set up model
# 각 이미지들을 784차원의 벡터로 단조화([None, 784]형태로 표현, None은 어떤 길이도 가능)
x = tf.placeholder(tf.float32, [None, 784])
'''
Variable = TensorFlow의 상호작용하는 작업 그래프들 간에 유지되는 변경가능한 텐서
W와 b를 0으로 초기화
784차원 이미지 벡터를 곱해서 10차원 벡터 증거 만들기
출력에 더하기
'''
W = tf.Variable(tf.zeros([784, 10]))
b = tf.Variable(tf.zeros([10]))
'''
모델 구현
tf.matmul(x,W) 표현식으로 x와 W를 곱하고 b를 더한다.
마지막으로 tf.nn.softmax를 적용
'''
y = tf.nn.softmax(tf.matmul(x, W) + b)

# 교차 엔트로피를 구현하기 위해 정답을 입력할 새로운 placeholder추가
y_ = tf.placeholder(tf.float32, [None, 10])
'''
교차 엔트로피 구현
tf.log = y의 각 원소의 로그값 계산
y_의 각 원소들에, 각가에 해당하는 tf.log(y)를 곱하기
tf.reduce_sum = 텐서의 모든 원소 더하기
'''
cross_entropy = -tf.reduce_sum(y_*tf.log(y))
'''
학습도를 0.01로 준 경사 하강법알고리즘을 이용 교차 엔트로피를 최소화
경사 하강법 = 각가의 변수들을 비용을 줄이는 방향으로 약간씩 바꾸는 방법
'''
train_step = tf.train.GradientDescentOptimizer(0.01).minimize(cross_entropy)

# Session
# 실행 전 마지막으로 우리가 만든 변수들을 초기화하는 작업 추가
init = tf.initialize_all_variables()
# 세션에서 모델을 시작하고 변수들을 초기화하는 작업 수행
sess = tf.Session()
sess.run(init)

# Learning
'''
1000번 학습
각 반복 단계마다, 학습 세트로부터 100개의 무작위 데이터들의 일괄 처리(batch)들을 가져와서
placeholders를 대체하기 위한 일괄 처리 데이터에 train_step 피딩을 실행
'''
for i in range(1000):
  batch_xs, batch_ys = mnist.train.next_batch(100)
  sess.run(train_step, feed_dict={x: batch_xs, y_: batch_ys})

# Validation
'''
tf.argmax = 특정한 축을 따라 가장 큰 원소의 색인을 알려주는 함수
Ex)) tf.argmax(y, 1) => 진짜 라벨이 tf.argmax(y_, 1)일때 우리 모델이 각 입력에 대하여
                        가장 정확 하다고 생각하는 라벨
tf.euqal = 예측이 실제와 맞았는지 확인
'''
correct_prediction = tf.equal(tf.argmax(y,1), tf.argmax(y_,1))
# 얼마나 많은 비율로 맞았는지 확인을 위해 부정 소숫점으로 캐스팅 후 평균값 도출
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))

# Result should be approximately 91%.
# 테스트 데이터의 정확도 출력
print(sess.run(accuracy, feed_dict={x: mnist.test.images, y_: mnist.test.labels}))
