# Docker安装

* 镜像（image）

* 容器（container）

* 仓库（repository）

  存放镜像的地方 Docker hub、阿里云



> 环境

```shell
# 系统内核3.10以上
uname -r
# centos8
```

> 安装

​	[Install Docker Engine on CentOS | Docker Documentation](https://docs.docker.com/engine/install/centos/)

* 卸载旧的Docker

  ```shell
  yum remove docker \
  		   docker-client \
             docker-client-latest \
             docker-common \
             docker-latest \
             docker-latest-logrotate \
             docker-logrotate \
             docker-engine
  ```

* 安装基本组件

  ```shell
  yum install -y yum-utils
  ```

* 设置镜像仓库地址（不要设置国外的）

  ```shell
  yum-config-manager \
      --add-repo \
     https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
  ```

* 更新yum软件包索引

  ```shell
  yum makecache
  ```

* 安装docker相关

  ```shell
  yum install docker-ce docker-ce-cli containerd.io
  #如果报错 运行一下命令
  yum erase podman buildah
  ```

* 启动Docker 

  ```shell
  systemctl start docker
  # 查看是否安装成功
  docker version
  ```

* 测试

  ```shell
  docker run hello-world
  ```

* 查看下载的镜像

  ```shell
  docker images
  ```

* 卸载docker

  ```shell
  # 卸载依赖
  yum remove docker-ce docker-ce-cli containerd.io
  # 删除资源
  # docker的默认工作路径
  rm -rf /var/lib/docker
  rm -rf /var/lib/containerd
  ```

  

## 阿里云镜像加速

```shell
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://9uo29bge.mirror.aliyuncs.com"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker
```



## 底层原理

##### Docker是怎么工作的？

Docker是一个Client-Server结构的系统，Docker的守护进程运行在主机上。通过socket客户端访问。

DockerServer接收到Docker-Client的指令，就会执行这个命令。

##### Docker为什么比VM块

* Docker有着比虚拟机更少的抽象层
* 利用宿主的内核，vm需要时Guest OS