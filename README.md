# spring-boot-actuator-sample
Simple Spring Boot Actuator Sample

# Metric endpoints

## Fetch all metrics
```bash curl -X "GET" "http://localhost:8080/metrics/"```

## Fetch only free memory metric
```bash curl -X "GET" "http://localhost:8080/metrics/mem.free"```

## Health check
```bash curl -X "GET" "http://localhost:8080/health"```

## Shutdown application
If ```endpoints.shutdown.enabled``` is set to ```true``` you can shutdown your application with the following command.
```bash curl -X "GET" "http://localhost:8080/shutdown"```
Please keep in mind that the application will shutdown immediately.

## Add additional information to ```info``` metric
If you call the ```info``` endpoint, you will not receive any information. 
You can add information by adding ```info.``` to you __application.properties__.
```bash curl -X "GET" "http://localhost:8080/info"```
```bash {"contact":{"fullname":"Simon Michel","phone":"+49 170 - 123456789","email":"simon@itblogging.de"}}```

# Remote Shell
If you add the remote Shell dependency, you will find something like the following at your log file.
```bash Using default password for shell access: 8d6e6b69-7630-463f-9570-d1ae699d9316```

You can login to your application 
```bash ssh user@localhost -p 2000```

```bash ssh user@localhost -p 2000
        key_load_public: invalid format
        Password authentication
        Password:
          .   ____          _            __ _ _
         /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
        ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
         \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
          '  |____| .__|_| |_|_| |_\__, | / / / /
         =========|_|==============|___/=/_/_/_/
         :: Spring Boot ::  (v1.3.3.RELEASE) on smic.local```

You can now run all commands that are also available at the metrics endpoints.
The only advantage that I can see here is, that you have live statistics at the __metrics__ information. 

## Endpoint list
```bash endpoint list```

```bash 
requestMappingEndpoint
   environmentEndpoint
   healthEndpoint
   beansEndpoint
   infoEndpoint
   metricsEndpoint
   traceEndpoint
   dumpEndpoint
   autoConfigurationReportEndpoint
   shutdownEndpoint
   configurationPropertiesReportEndpoint```
   
