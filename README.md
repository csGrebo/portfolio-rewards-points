# Reward Points Calculator

---

Application to calculate the rewards balance of a user based on their purchases in the last three months.

---

## Endpoints

- /reward-balance
  - Requires the query parameter `userId`
  - Valid user IDs include the following:
      - coberg
      - ebridg
      - golaak
      - jsmith

---

## To Run

Start the application via `mvn spring-boot:run` and send requests such as `curl localhost:8080/rewards-balance?userId=jsmith`

---

NOTE: This application requires JavaSE 11 or better to run