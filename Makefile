## Environment Variables
LOCAL_DB_URL = jdbc:postgresql://localhost:5432/gobarber

CONTAINER=gobarber-api
IMAGE=$(CONTAINER)

DOCKER_COMPOSE_FILE=docker-compose.local.yml

## Commands
start: ## Start application. Please set variable SERVER_ACC_ROOT with server path
	make build
	java -jar target/gobarber-0.0.1-SNAPSHOT.jar

build: ## Build application
	mvn clean install

clean: ## Clean server deployment directory
	rm -f /target/gobarber*

test: ## Run tests
	mvn test

## Migration
local-migration:
	@read -p "Enter Database password:" password; \
    mvn flyway:migrate -Dflyway.user=postgres -Dflyway.url=${LOCAL_DB_URL} -Dflyway.password=$$password
.PHONY: local-migration

## Docker
start_image:
	docker-compose -f $(DOCKER_COMPOSE_FILE) up

down_image:
	docker-compose -f $(DOCKER_COMPOSE_FILE) down
	make remove_image

remove_image:
	docker rmi $(IMAGE)

.DEFAULT_GOAL := start
