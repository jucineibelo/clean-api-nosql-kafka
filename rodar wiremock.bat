@echo off
REM Caminho do JDK 21 (AJUSTE SE NECESSÁRIO)
set JAVA_HOME=C:\Program Files\Java\jdk-21
set PATH=%JAVA_HOME%\bin;%PATH%

REM Caminho do JAR do WireMock
cd "C:\Users\User\Desktop\Projetos\Descomplicando Clean Arc\wiremock"
java -jar wiremock-standalone-4.0.0-beta.2.jar --port 8082

pause
