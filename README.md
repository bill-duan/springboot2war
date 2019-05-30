# springboot2war
springboot for package war

        <distributionManagement>
        <repository>
            <id>maven-releases</id><!--这个ID需要与你的release仓库的Repository ID一致-->
            <url>http://106.13.65.213:9991/repository/maven-releases/</url>
        </repository>
        <snapshotRepository>
            <id>maven-snapshots</id><!--这个ID需要与你的snapshots仓库的Repository ID一致-->
            <url>http://106.13.65.213:9991/repository/maven-snapshots/</url>
        </snapshotRepository>
    </distributionManagement>
    
    <server>
        <id>maven-releases</id>
        <username>admin</username>
        <password>123456</password>
    </server>
    <server>
        <id>maven-snapshots</id>
        <username>admin</username>
        <password>123456</password>
     </server>
  </servers>
    
    
