spark启动运行相关笔记
========================

# SparkContext启动相关
- 创建scheduler backend and the task scheduler.
  方法: createTaskScheduler

   - yarn-client模式的scheduler与backend:
        scheduler(TaskScheduler): org.apache.spark.scheduler.cluster.YarnScheduler
        backend: org.apache.spark.scheduler.cluster.YarnClientSchedulerBackend

   scheduler.start()启动，内部触发调用相对应的backend.start方法, backend核心逻辑是向yarn提交application，启动applicationMaster。AM启动后向yarn申请任务配置所需的container(executor)

## YarnClientSchedulerBackend的启动流程
    核心步骤
    1.  createContainerLaunchContext
        setupLaunchEnv // 设置启动ApplicationMaster container的环境.
        prepareLocalResources // 根据需要上传资源(conf,jar)到分布式缓存

    2.  createApplicationSubmissionContext
    3.  submitApplication