# 安装tomcat

```shell
docker run -it --rm tomcat:9.0

## 一般用来测试，用完就删除

## 下载启动

docker pull tomcat:9.0

docker images
REPOSITORY    TAG       IMAGE ID       CREATED        SIZE
tomcat        9.0       041804b6c268   4 days ago     680MB

docker run -d -p 3355:8080 --name tomcat01 041804b6c268

# 存在问题
# linux 命令少了，没有webapps 保证最小的可运行环境

```



> 以后要部署项目，每次进入容器十分麻烦

> 部署ES、kibana

