# Sheepy common code

This project include common tools and models, with minimal dependency.

It could also demonstrate how to use EMF/XCore generated code in a modular environment (java 9 jigsaw).

I had lot's of trouble making a xcore project (so an Eclipse plugin project) working in a modular environment, with gradle. Aloso, generating xcore code in Gradle is tedious to maintain, and slow a lot your gradle build.

So, I decided to keep it simple: generating the code in one basic plugin project (not modular, not managed by gradle), and using the generated code in a modular project (managed with gradle).

Downside: you can only update the generated code in Eclipse, and you have to add the generated code to git revision control.

# EMF

This project use org.elipse.emf. 

Since it's a modular project, it's better to use a recent version of EMF (at least 2.14), due to the automatic-module name in Manifest.mf. 

At this moment, the most recent version of EMF in Maven Central is 2.12. In order to put a more recent version in your MavenLocal, you have to locate the emf libs in your Eclipse setup, and do something like :


```shell
mvn org.apache.maven.plugins:maven-install-plugin:2.5:install-file -Dfile=org.eclipse.emf.ecore_2.15.0.v20180722-1159.jar -Dversion=2.15.0 -Dpackaging=jar

mvn org.apache.maven.plugins:maven-install-plugin:2.5:install-file -Dfile=org.eclipse.emf.common_2.15.0.v20180723-1316.jar -Dversion=2.15.0 -Dpackaging=jar



mvn org.apache.maven.plugins:maven-install-plugin:2.5:install-file -Dfile=org.eclipse.emf.ecore.source_2.15.0.v20180722-1159.jar -Dversion="2.15.0" -DartifactId=org.eclipse.emf.ecore -DgroupId=org.eclipse.emf -Dpackaging=jar -Dclassifier=sources

mvn org.apache.maven.plugins:maven-install-plugin:2.5:install-file -Dfile=org.eclipse.emf.common.source_2.15.0.v20180723-1316.jar -Dversion="2.15.0" -DartifactId=org.eclipse.emf.common -DgroupId=org.eclipse.emf -Dpackaging=jar -Dclassifier=sources
```

