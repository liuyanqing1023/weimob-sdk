

##### API用法
授权:
```java
    @Autowired
    private StringRedisTemplate template;
    @GetMapping("/code")
    public void mssage(String code,String state){
        Bases bases = new Bases(template,
                Config.builder()
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .redirectUri(redirectUri)
                        .build()
        );
        bases.accessToken(code);
    }
```
token续期:
```java

```