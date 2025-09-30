.SILENT: build-skip-tests verify-skip-tests test start-docker stop-docker

build-skip-tests:
	@mvn clean package -DskipTests

verify-skip-tests:
	@mvn clean verify \
		-Dspring.datasource.url=jdbc:postgresql://localhost:5432/consilium-db \
		-Dspring.datasource.username=consilium \
		-Dspring.datasource.password=consilium_password \
		-DskipTests

test:
	@mvn clean test \
		-Dspring.datasource.url=jdbc:postgresql://localhost:5432/consilium-db \
		-Dspring.datasource.username=consilium \
		-Dspring.datasource.password=consilium_password

start-docker:
	@$(MAKE) build-skip-tests; \
	docker compose up --build -d; \
	echo "Docker 🐳 Container Running! 🚀"

stop-docker:
	@docker compose down;
	echo "Docker 🐳 Container Stopped."