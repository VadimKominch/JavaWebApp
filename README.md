to add mysql container to db run

docker run -p 3306:3306 --name mysql-server \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=advertisment_db \
-d mysql:latest