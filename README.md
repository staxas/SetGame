# nl.edwinrietmeijer.setgame.SetGame

An implementation of the popular pattern finding game Set.

## Generating a Linux Java executable

Run mvn package

$ mvn package

Create a file with the java jar hashbang.

$ echo '#!/usr/bin/java -jar' > setgame

We have written the hashbang as a string to the new file setgame.

Write the jar to the file.

$ cat target/setgame-1.jar >> setgame

The >> appends the jar to the receiving file.

This will create a file that has the bash hashbang and the jar appended to it. Next set setgame to executable and try to run the program.

$ chmod +x setgame  
$ ./setgame
