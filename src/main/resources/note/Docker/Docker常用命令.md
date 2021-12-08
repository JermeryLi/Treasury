# Docker常用命令

## 帮助命令

```shell
docker version # 版本
docker info # 系统信息，包括镜像和容器的数量
docker --help
```

## 镜像命令

* docker images

```shell
docker images #查看本机镜像

[root@lining63 jdk1.8.0_311]# docker images
REPOSITORY    TAG       IMAGE ID       CREATED       SIZE
hello-world   latest    feb5d9fea6a5   8 weeks ago   13.3kB

REPOSITORY 镜像的仓库源
TAG 镜像的标签 
IMAGES ID 镜像的id
created 创建时间
Size 大小


 docker images --help

Usage:  docker images [OPTIONS] [REPOSITORY[:TAG]]

List images

Options:
  -a, --all             Show all images (default hides intermediate images)
      --digests         Show digests
  -f, --filter filter   Filter output based on conditions provided
      --format string   Pretty-print images using a Go template
      --no-trunc        Don't truncate output
  -q, --quiet           Only show image IDs

```

* docker search

  ```shell
  docker search mysql
  
   docker search --help
  
  Usage:  docker search [OPTIONS] TERM
  
  Search the Docker Hub for images
  
  Options:
    -f, --filter filter   Filter output based on conditions provided
        --format string   Pretty-print search using a Go template
        --limit int       Max number of search results (default 25)
        --no-trunc        Don't truncate output
  
  
  docker search mysql --filter=stars=10000
  NAME      DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
  mysql     MySQL is a widely used, open-source relation…   11707     [OK]
  ```

* docker pull

  ```shell
  docker pull --help
  
  Usage:  docker pull [OPTIONS] NAME[:TAG|@DIGEST]
  
  Pull an image or a repository from a registry
  
  Options:
    -a, --all-tags                Download all tagged images in the repository
        --disable-content-trust   Skip image verification (default true)
        --platform string         Set platform if server is multi-platform capable
    -q, --quiet                   Suppress verbose output
  
  
  docker pull mysql 
  Using default tag: latest # 如果不写tag 默认latest
  latest: Pulling from library/mysql
  a10c77af2613: Pull complete    #分层下载 docker images的核心 联合文件系统
  b76a7eb51ffd: Pull complete
  258223f927e4: Pull complete
  2d2c75386df9: Pull complete
  63e92e4046c9: Pull complete
  f5845c731544: Pull complete
  bd0401123a9b: Pull complete
  3ef07ec35f1a: Pull complete
  c93a31315089: Pull complete
  3349ed800d44: Pull complete
  6d01857ca4c1: Pull complete
  4cc13890eda8: Pull complete
  Digest: sha256:aeecae58035f3868bf4f00e5fc623630d8b438db9d05f4d8c6538deb14d4c31b #签名
  Status: Downloaded newer image for mysql:latest
  docker.io/library/mysql:latest
  
  
  docker pull mysql
  #等价
  docker pull docker.io/library/mysql:latest
  
  
  #指定版本下载
  docker pull mysql:5.7
  5.7: Pulling from library/mysql
  a10c77af2613: Already exists
  b76a7eb51ffd: Already exists
  258223f927e4: Already exists
  2d2c75386df9: Already exists
  63e92e4046c9: Already exists
  f5845c731544: Already exists
  bd0401123a9b: Already exists
  2724b2da64fd: Pull complete
  d10a7e9e325c: Pull complete
  1c5fd9c3683d: Pull complete
  2e35f83a12e9: Pull complete
  Digest: sha256:7a3a7b7a29e6fbff433c339fc52245435fa2c308586481f2f92ab1df239d6a29
  Status: Downloaded newer image for mysql:5.7
  docker.io/library/mysql:5.7
  ```

* docker rmi

  ```shell
  docker rmi --help
  
  Usage:  docker rmi [OPTIONS] IMAGE [IMAGE...]
  
  Remove one or more images
  
  Options:
    -f, --force      Force removal of the image
        --no-prune   Do not delete untagged parents
        
        
  docker rmi -f id
  docker rmi -f id id id
  ```

  



## 容器命令

```shell
docker pull docker
```

```shell
docker run [可选参数] images
#参数说明
--name="Name" 容器名字 tomcat01 tomcat02,用来区分容器
-d  后台方式运行
-it 使用交互方式运行，进入容器查看内容
-p  指定容器的端口 -p 8080:8080
	 -p ip:主机端口:容器端口
	 -p 主机端口:容器端口（常用）
	 -p 容器端口
	 容器端口
-P  随机指定端口
```

```shell
# 启动并进入容器
docker run -it centos /bin/bash
exit
```

* docker ps 

  ```shell
  docker ps # 列出所有正在运行的容器
  docker ps -a #列出所有容器
  
  docker ps
  CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
  
  docker ps -a
  CONTAINER ID   IMAGE         COMMAND       CREATED             STATUS                         PORTS     NAMES
  75fcb5df2607   centos        "/bin/bash"   4 minutes ago       Exited (0) 3 minutes ago                 intelligent_tereshkova
  5541a462624a   hello-world   "/hello"      About an hour ago   Exited (0) About an hour ago             agitated_carver
  ```

* 退出容器

  ```shell
  exit #退出并停止容器
  Ctrl+p+q #退出不停止容器
  ```

* 删除容器

  ```shell
  docker rm id
  docker rm -f id # 强制删除  容器运行时
  ```

* 启动停止容器

  ```shell
  docker stop id
  docker restart id
  docker start id
  docker kill id
  ```

* docker run  -d

  ```shell
  docker run -d centos
  docker ps
  # 发现centos 停止了
  # docker容器后台运行时，就必须有一个前台进程。否则docker就会自动停止它。
  # nginx
  ```

* 查看日志

  ```shell
  docker logs --help
  
  Usage:  docker logs [OPTIONS] CONTAINER
  
  Fetch the logs of a container
  
  Options:
        --details        Show extra details provided to logs
    -f, --follow         Follow log output
        --since string   Show logs since timestamp (e.g.
                         2013-01-02T13:23:37Z) or relative
                         (e.g. 42m for 42 minutes)
    -n, --tail string    Number of lines to show from the end
                         of the logs (default "all")
    -t, --timestamps     Show timestamps
        --until string   Show logs before a timestamp (e.g.
                         2013-01-02T13:23:37Z) or relative
                         (e.g. 42m for 42 minutes)
  
  ```

  ```shell
  -tf
  # n表示要显示的记录条数
  --tail n 
  docker logs -tf --tail 10 id
  ```
  
* 查看容器中的进程信息

  ```shell
  docker top id
  ```

* 查看镜像元数据

  ```shell
  docker inspect --help
  
  docker inspect id
  ```

* 进入正在当前运行的容器

  ```shell
  # 我们使用容器通常都是后台方式运行的 需要进入容器，需要修改一些配置
  
  docker exec -it 容器id bashShell
  
  
  docker run -d centos /bin/sh -c "while true;do echo kuangshen;sleep 1;done"
  
  docker ps
  CONTAINER ID   IMAGE     COMMAND                  CREATED              STATUS              PORTS     NAMES
  f2195f1fbf13   centos    "/bin/sh -c 'while t…"   About a minute ago   Up About a minute             romantic_leakey
  
  docker exec -it f2195f1fbf13 /bin/bash
  
  # 进入容器后，开启一个新的终端。常用
  ```

  ```shell
  docker attach 容器id
  # 进入容器正在执行的代码
  ```

* 从容器拷贝文件到主机

  ```shell
  docker cp 容器id:容器文件路径 主机路径
  
  docker cp 0c5e74720bb9:/home/test.java /
  ```

  













