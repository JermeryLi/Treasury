# 安装ES kibana

## ES

```shell

# --net 网络配置
docker run -d --name elasticsearch --net somenetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:tag


docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.6.2

docker ps
CONTAINER ID   IMAGE                 COMMAND                  CREATED         STATUS         PORTS                                                                                  NAMES
a37d0a51ddb6   elasticsearch:7.6.2   "/usr/local/bin/dock…"   2 minutes ago   Up 2 minutes   0.0.0.0:9200->9200/tcp, :::9200->9200/tcp, 0.0.0.0:9300->9300/tcp, :::9300->9300/tcp   elasticsearch

# 查看docker运行状态
docker stats

# 如果服务器配置不够 会卡住 可以启动es时分配内存
# -e 环境配置修改
docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e ES_JAVA_OPTS="-Xms64m -Xmx512M" elasticsearch:7.6.2
```

## kibana

> Docker 网络原理



