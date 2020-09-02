FROM openjdk

COPY target/gobarber*.jar /gobarber/app.jar
COPY scripts/entrypoint.sh /gobarber

ENTRYPOINT /gobarber/entrypoint.sh
