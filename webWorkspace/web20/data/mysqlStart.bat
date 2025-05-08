@echo off
docker run -it --rm -v d:\webWorkspace\dbData:/var/lib/mysql -p 33306:3306 -e MYSQL_RANDOM_ROOT_PASSWORD=yes -e MYSQL_DATABASE=xe -e MYSQL_USER=scott -e MYSQL_PASSWORD=tiger mysql:lts