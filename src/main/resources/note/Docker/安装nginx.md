#  安装nginx

```shell
docker search nginx

docker pull nginx

docker images
REPOSITORY    TAG       IMAGE ID       CREATED        SIZE
nginx         latest    f652ca386ed1   5 days ago     141MB

# -d 后台运行
# --name 命名
# 3344 外部端口 80 内部端口 端口暴露
docker run -d --name nginx01 -p 3344:80 nginx

docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED          STATUS         PORTS                                   NAMES
dbd484acf907   nginx     "/docker-entrypoint.…"   10 seconds ago   Up 9 seconds   0.0.0.0:3344->80/tcp, :::3344->80/tcp  nginx01


curl localhost:3344
<!DOCTYPE html>
<html>
<head>
<title>Welcome to nginx!</title>
<style>
html { color-scheme: light dark; }
body { width: 35em; margin: 0 auto;
font-family: Tahoma, Verdana, Arial, sans-serif; }
</style>
</head>
<body>
<h1>Welcome to nginx!</h1>
<p>If you see this page, the nginx web server is successfully installed and
working. Further configuration is required.</p>

<p>For online documentation and support please refer to
<a href="http://nginx.org/">nginx.org</a>.<br/>
Commercial support is available at
<a href="http://nginx.com/">nginx.com</a>.</p>

<p><em>Thank you for using nginx.</em></p>
</body>
</html>


 docker exec -it nginx01 /bin/bash
```



> 每次改动nginx配置文件，都需要进入容器内部，十分麻烦。我们要是可以在容器外部提供一个映射路径，达到在容器外部修改文件，容器内部就可以自动修改。岂不美哉？
>
> 容器数据卷



