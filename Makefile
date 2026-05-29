.PHONY: run-all build-all test-api logs logs-api

DOCKER_API_VERSION=1.41

base:
	@export DOCKER_API_VERSION=$(DOCKER_API_VERSION)

run-all: build-all
	@echo "Setting existing containers down, running all"
	@docker compose down -v
	@docker compose up -d

build-all:
	@docker compose build

logs:
	@docker compose logs -f --tail=100 $(service)

logs-api:
	@docker compose logs -f api

shell-api:
	@docker compose exec api sh

