# SeleniumBigAssignment

## Steps
- Start the Docker:
    `docker compose up`
    (If it had the authentication issue then: `docker login`)
- The testing environment is up at localhost:8081
- Enter the image:
    `docker exec -it foldername-ubuntu-1 bash`
- Clean && Test (All the actions will be visible in the testing environment):
    `gradle clean && gradle test`