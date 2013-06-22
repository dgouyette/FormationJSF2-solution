Pour faire fonctionner les TP, il faut ajouter dans le fichier settings.xml de maven la ligne suivante : 

 <mirrors>
    <mirror>
      <id>all</id>
      <mirrorOf>*</mirrorOf>
      <name>Human Readable Name for this Mirror.</name>
      <url>http://nexus.cestpasdur.com/nexus/content/groups/everything/</url>
    </mirror>
</mirrors>