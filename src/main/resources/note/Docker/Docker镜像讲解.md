# Docker 镜像讲解

## 镜像是什么

镜像是一种轻量级、可执行的独立软件包，用来打包软件运行环境和基于运行环境开发的软件。它包含运行某个软件所需的所有内容，包括代码、运行时库、环境变量和配置文件。

所有应用，直接打包Docker镜像，就可以直接跑起来。

如何得到镜像：

* 从远程仓库镜像
* 拷贝
* 自己制作



## Docker镜像加载原理

> UnionFS联合文件系统

UnionFS联合文件系统是一种分层、轻量级并且高性能的文件系统，它支持对文件系统的修改作为一次提交来一层层的叠加，同时可以将不同目录挂载到同一个虚拟文件系统下。Union文件系统是Dockers镜像的基础。镜像可以通过分层来进行继承，基于基础镜像（没有父镜像），可以制作各种具体的应用镜像。

特性：一次同时加载多个文件系统，但从外面来看，只能看到一个文件系统，联合加载会把各个文件系统叠加起来，这样最终的文件系统会包含所有底层的文件和目录。

> Docker镜像加载原理

Docker的镜像实际上由一层层的文件系统组成，UnionFS。

bootfs boot file system主要包含boot loader和kernel。bootloader主要引导加载kernel。Linux刚启动时会加载bootfs文件系统，在Docker镜像的最底层是bootfs。这一层与我们典型的linux/unix系统是一样的，包含boot加载器和内核。当boot加载完成之后整个内核就在内存了，此时内存的使用权已有bootfs转交给内核，系统会卸载bootfs。

rootfs root file system,在bootfs上。包含的就是典型linux系统中的/dev,/proc,/bin,/etc等标准目录和文件。rootfs就是各种不同操作系统发行版，比如Ubuntun、centos。



对于精简的OS,rootfs可以很小，只需要包含最基本的命令，工具和程序库就行了，因为底层直接用Host的kernal,自己只需要提供rootfs。对于不同的Linux发行版，bootfs基本是一致的。rootfs会有差别，不同的发行版可以公用bootfs。

虚拟机时分钟级别的，容器时秒级的。



## 分层理解

> 分层的镜像



所有的Docker镜像都起始于一个基础镜像层，当进行修改或增加新的内容时，就会在当前镜像层之上，创建新的镜像层。



Docker镜像是只读的，当容器启动时，一个新的可写层被加载到镜像的顶部。这一层就是容器层，容器层之下就是镜像层。



## commit镜像

```shell
docker commit 提交容器成为一个副本

docker commit -m='提交的容器信息' -a='作者' 容器id 目标镜像名:[TAG]
```

```shell
# 启动一个默认的tomcat

# 发现这个默认的tomcat是没有webapps应用的，镜像的原因，官方的镜像默认webapps是没有文件的

docker commit -a="lining" -m="add webapps app" ca0bde5ae8ea tomcat01:1.0

sha256:008b35b76338c69070238c20dae36af654e44dad40773c4246c8bb824a520448

docker images
REPOSITORY            TAG       IMAGE ID       CREATED          SIZE
tomcat01              1.0       008b35b76338   22 seconds ago   685MB
tomcat                9.0       041804b6c268   5 days ago       680MB
nginx                 latest    f652ca386ed1   6 days ago       141MB
hello-world           latest    feb5d9fea6a5   2 months ago     13.3kB
centos                latest    5d0da3dc9764   2 months ago     231MB
portainer/portainer   latest    580c0e4e98b0   8 months ago     79.1MB
elasticsearch         7.6.2     f29a1ee41030   20 months ago    791MB

```

