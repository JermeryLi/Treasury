# 数据卷 MYSQL



```shell
docker pull mysql:5.7

docker run -d -p 3306:3306 -v /home/mysql/

docker run -d -p 3306:3306 -v /home/mysql/conf:/etc/mysql/conf.d -v /home/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=lining --name mysql01 mysql:5.7

```

