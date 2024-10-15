from functools import reduce

def fibonacci(n):
    return list(
        map(
            lambda x: x[0], 
            reduce(
                lambda acc, _: acc + [(acc[-1] + acc[-2], acc[-1])], 
                range(n - 2), 
                [(1, 0), (1, 1)]
            )
        )
    )

sequencia = fibonacci(10)
print(sequencia)