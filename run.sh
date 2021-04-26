docker run -it --name mysql --rm -p 3306:3306  -e MYSQL_ROOT_PASSWORD=SeaBiscuit~!@ -d mysql:latest
docker exec -i mysql mysql -uroot springcloud_sell < springcloud_sell.sql.sql;