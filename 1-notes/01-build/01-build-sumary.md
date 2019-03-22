
# spark-2.1.0编译

## 环境变量配置
```shell
  export MAVEN_HOME=/home/gaoyc/work/soft/dev/maven/apache-maven-3.3.9
  export PATH=$PATH:$MAVEN_HOME
```

## 编译命令


- 编译指定模块spark-hive-thriftserver
  `mvn package -DskipTests -U  -am -pl sql/hive-thriftserver`

- 编译所有模块
  `mvn package -DskipTests -U`
  说明: -U 强制更新本地仓库缓存

- 编译指定spark-core模块,同时编译其依赖的模块
  `mvn package -DskipTests -am -pl sql/core`

  说明:编译spark-core,主要必须在spark源码根目录，不然在core子工程目录下编译会报找不到scalastyle-config.xml的异常

- 安装到本地仓库
  `mvn install -pl core -DskipTests`

- 发布到私服
  `mvn deploy -pl core -DskipTests`



## 发布到私服

1. 根pom.xml增加如下配置:
```xml
  <!-- add for teligen private nexus repo -->
  <distributionManagement>
    <repository>
      <id>repo-teligen</id>
      <url>http://192.192.189.49:8081/nexus/content/repositories/releases</url>
    </repository>
    <snapshotRepository>
      <id>repo-teligen</id>
      <url>http://192.192.189.49:8081/nexus/content/repositories/snapshots</url>
    </snapshotRepository>
  </distributionManagement>
```

2. sql/hive-thriftserver/pom.xml增加jline依赖
```xml
    <dependency>
      <groupId>${jline.groupid}</groupId>
      <artifactId>jline</artifactId>
    </dependency>
```

## 待验证的操作


  mvn package -DskipTests -am -pl sql/core
  mvn deploy -pl core -DskipTests -Pnexus-teligen-profile
  mvn deploy -pl core -DskipTests -DrepositoryId=Releases -Durl=http://192.192.189.49:8081/nexus/content/repositories/releases/


