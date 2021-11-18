# linux 

##时区
* 查看时区
~~~ssh
ll /etc/localtime 
~~~
* 修改时区
~~~ssh
ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime 
ll /etc/localtime 
date
~~~
* 如有必要重启
~~~ssh
reboot
~~~