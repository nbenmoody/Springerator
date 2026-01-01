# Springerator
This is an example/playground project, where various Java/Spring-related things can be trialed and stored as examples.

## Redis
[This is a good Medium post on spring-boot-starter-data-redis](https://medium.com/@tharindudulshanfdo/optimizing-spring-boot-applications-with-redis-caching-35eabadae012)

## Example Commands
```
http POST localhost:9001/domainmodels \
  Content-Type:application/json \
  isbn="9781234567890" \
  title="Spring Boot in Action" \
  author="Craig Walls" \
  price:=49.99
```

```
http GET localhost:9001/domainmodels/9781234567890
````