Start the PostgreSQL service:
docker run -d --name postgres_container -e POSTGRES_USER={USERNAME} -e POSTGRES_PASSWORD=
{PASSWORD} -e PGDATA=/data/postgres -v postgres:/data/postgres -p 5432:5432 --restart 
unless-stopped postgres

Start the pgAdmin service:
docker run -d --name pgadmin_container -e PGADMIN_DEFAULT_EMAIL={EMAIL} -e 
PGADMIN_DEFAULT_PASSWORD={PASSWORD} -e PGADMIN_CONFIG_SERVER_MODE=False -v 
pgadmin:/var/lib/pgadmin -p 5050:80 --network postgres --restart unless-stopped dpage/pgadmin4