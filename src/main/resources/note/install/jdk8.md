# jdk8

* [Java Downloads | Oracle](https://www.oracle.com/java/technologies/downloads/#java8)

## centos

目录： 百度网盘  /install package/jdk-8u311-linux-x64.tar.gz

* 下载jdk文件并上传至一目录

  ```shell
  /software/jdk
  ```

* 解压

  ```shell
  tar -zxvf jdk-8u311-linux-x64.tar.gz
  ```

  解压后的路径：/software/jdk/jdk1.8.0_311

* 配置环境变量

  ```shell
  vi /etc/profile
  
  export JAVA_HOME=/software/jdk/jdk1.8.0_311
  export JRE_HOME=${JAVA_HOME}/jre
  export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
  export PATH=${JAVA_HOME}/bin:$PATH
  
  source /etc/profile
  ```

* 检查版本

  ```shell
  java -version
  ```

  







