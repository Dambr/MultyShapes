import numpy as np
import math

N = 3

def get_sum(array):
    result = 0
    for i in range(len(array)):
        result += array[i] * math.pow(-1, i + 1 if N % 2 == 0 else i)
    return int(result)

def dec_to_n(dec):
    result = []
    while dec > 0:
        dec, a = divmod(dec, N)
        result = [a] + result
    while len(result) < N:
        result = [0] + result
    return get_sum(result)

shape = [0] * N
for _ in range(N - 1):
    shape = [shape for i in range(N)]
shape = np.array(shape).shape

array = np.array([dec_to_n(j) for j in range(int(math.pow(N, N)))])
array.shape = shape
print(array)