.PHONY: run-all build-all test-api logs logs-api
include .env
export

DOCKER_API_VERSION=1.41

base:
	@export DOCKER_API_VERSION=$(DOCKER_API_VERSION)

run-all:
	@echo "Setting existing containers down, running all"
	@docker compose down -v
	$(MAKE) build-all
	@docker compose up -d
	$(MAKE) notify-complete

build-all:
	@docker compose build

logs:
	@docker compose logs -f --tail=100 $(service)

logs-api:
	@docker compose logs -f api

shell-api:
	@docker compose exec api sh

notify-complete:
	@echo "build finished"
	@echo "Frontend: https://localhost:$(FRONTEND_PORT)"
	@echo "API:      https://localhost:$(API_PORT)"
	@echo "Coordinator:   https://localhost:$(COORD_PORT)"
	@echo "Database:   https://localhost:$(DB_PORT)"

