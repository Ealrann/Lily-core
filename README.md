# Lily core

This project include some common tools and models, with minimal dependency.

It could also demonstrate how to use EMF generated code in a modular environment (java 9 jigsaw).

I had lot's of trouble making a emf project (so an Eclipse plugin project) working in a modular environment, with gradle. Also, generating xcore code in Gradle is tedious to maintain, and slow down a lot your gradle build.

So, I decided to keep it simple: generating the code in one basic plugin project (not modular, not managed by gradle), and using the generated code in a modular project (managed with gradle).

Downside: you can only update the generated code in Eclipse, and you have to add the generated code to git revision control.
