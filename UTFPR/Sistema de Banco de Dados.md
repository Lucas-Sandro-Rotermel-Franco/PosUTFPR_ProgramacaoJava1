Instalar MARIADB no Linux
sudo apt update
sudo apt install mariadb-server
sudo  mysql_secure_installation

Ao pedir current password só dá enter pq tu n tem o root configurado

n para os dois próximos
y para remover anonymous user
y para permitir root somente no localhost
y para dropar banco de teste
y para recarregar privilégios

Configurando os usuários

sudo mariadb
grant para admin
GRANT ALL ON *.* TO 'admin'@'localhost' IDENTIFIED BY '123' WITH GRANT OPTION;

flush privileges;

exit

Para verificar se tá tudo rodando:
sudo systemctl status mariadb
sudo mysqladmin version
mysqladmin -u admin -p version


sudo mariadb
create database UTFPR;
grant all privileges on UTFPR.* TO 'admin'@'localhost' identified by '123';
grant all privileges on UTFPR.* TO 'lucassandro'@'localhost' identified by '123';
flush privileges;

E então conecta no DBEAVER

