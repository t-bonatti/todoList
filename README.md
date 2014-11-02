Projeto de Todo List utilizado para palestra
========

* Utilizado o JBOSS EAP 6.2
* Deve ser configurado um Datasource com o jndi-name = java:/jdbc/todo

Exemplo:

```xml
<datasource jta="true" jndi-name="java:/jdbc/todo" pool-name="todo" enabled="true" use-java-context="true" use-ccm="true">
<connection-url>jdbc:postgresql://localhost/todo</connection-url>
<driver>postgresql</driver>
<new-connection-sql>select 1</new-connection-sql>
<security>
<user-name>username</user-name>
<password>password</password>
</security>
</datasource>
```
