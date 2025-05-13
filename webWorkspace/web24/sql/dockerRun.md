## mysql docker container 

### create container
```
docker run -it -d ^
--network net01 ^
--name mysql8 ^
-p 33306:3306 ^
-v D:\webWorkspace\web24\data:/var/lib/mysql ^
-v D:\webWorkspace\web24\sql:/sql ^
-e MYSQL_ROOT_PASSWORD=mysql ^
-e MYSQL_DATABASE=xe ^
-e MYSQL_USER=scott ^
-e MYSQL_PASSWORD=tiger ^
mysql:lts
```

### Restoring data (window ¾ÈµÊ)
```
docker exec -i mysql8 ^
sh -c 'exec mysql -u scott -ptiger' < D:\webWorkspace\web24\sql\dept.sql
```

### Restoring data (window)
```
docker exec -it mysql8 bash
bash-5.1# mysql -u scott -ptiger < /sql/dept.sql
```








