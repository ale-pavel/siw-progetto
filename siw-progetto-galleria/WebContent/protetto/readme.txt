Inserire i file da proteggere con login in questa cartella, assicurarsi di includere dentro web.xml l'url-pattern corretto e di
modificare la navBar per non avere broken links

Estratto da /conf/tomcat-users.xml:
  <role rolename="amministratore" />
  <user username="siw" password="siw" roles="amministratore" />