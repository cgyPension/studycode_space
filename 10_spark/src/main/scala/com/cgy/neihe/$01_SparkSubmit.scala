package com.cgy.neihe

class $01_SparkSubmit {

  /**
   * SparkSubmit
   *
   *     -- main
   *         -- new SparkSubmit
   *
   *         // 执行提交操作
   *         -- doSubmit
   *
   *             // 解析参数
   *             -- parseArguments
   *
   *                 // --master yarn => master
   *                 // --deploy-mode cluster => deployMode
   *                 // --class SparkPI(WordCount) => 【mainClass】
   *                 -- parse
   *
   *             -- submit
   *
   *                 -- doRunMain
   *
   *                     -- runMain
   *
   *                         // 准备提交环境
   *                         // (childArgs, childClasspath, sparkConf, childMainClass)
   *                         // 【cluster】 : childMainClass = org.apache.spark.deploy.yarn.YarnClusterApplication
   *                         // 【client 】 : childMainClass = mainClass
   *                         -- prepareSubmitEnvironment(args)
   *
   *                         -- Thread.currentThread.setContextClassLoader(loader)
   *
   *                         // 通过类名加载这个类
   *                         // Class.forName("xxxxx")
   *                         -- mainClass = Utils.classForName(childMainClass)
   *
   *                         // 反射创建类的对象并进行类型转换
   *                         -- app = mainClass.newInstance().asInstanceOf[SparkApplication]
   *                         -- app.start
   *
   * YarnClusterApplication
   *
   *     -- start
   *
   *        // 封装参数
   *        // --class
   *        -- new ClientArguments
   *        -- new Client
   *
   *           // 创建Yarn客户端对象
   *           -- yarnClient = YarnClient.createYarnClient
   *                 // ResourceManager
   *                 -- rmClient
   *
   *        -- run
   *
   *             // 提交应用
   *             -- submitApplication
   *
   *                 // 配置JVM的启动参数
   *                 // 封装指令 ：【cluster】 command = bin/java org.apache.spark.deploy.yarn.ApplicationMaster
   *                 // 封装指令 ：【client 】 command = bin/java org.apache.spark.deploy.yarn.ExecutorLauncher
   *                 -- createContainerLaunchContext
   *                 -- createApplicationSubmissionContext
   *
   *                 // 向Yarn提交应用
   *                 -- yarnClient.submitApplication(appContext)
   *
   *
   *
   */
}
