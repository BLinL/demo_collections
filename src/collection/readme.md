
# ThreadPoolExecutor
状态

- RUNNING 初始状态可以执行任务
- SHUTDOWN 不在接受新任务
- STOP 不接收新任务，不处理已添加的任务，并且会中断正在处理的任务
- TIDYING SHUTDOWN状态下 阻塞队列里的任务执行完毕
- TERMINATED 执行完terminated()之后 由TIDYING-》TERMINATED