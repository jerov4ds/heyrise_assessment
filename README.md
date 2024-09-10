**Starting the environment**

This docker compose environment contains a local Postgres database (Version 14)

```
docker compose -f "heyrise-development-environment-assessment/docker-compose-local.yml" up -d --build
```


**Running the application**

Use your IDE or command line to start the application.
You can test the availability by calling 

```
curl --request POST \
  --url http://localhost:8085/api/v1/helloWorld \
  --header 'Content-Type: application/json' \
  --data '{
	"helloWorldMessage": "Hello World"
}'
```

and

```
curl --request GET \
  --url http://localhost:8085/api/v1/helloWorld \
```

**Component Structure**

Please follow the helloWorldComponent structure when implementing the calendarComponent Structure.

helloWorldComponent (Microservice)
| core
| | helloWorldManagement (Manager takes care on one specific logical Part/Entity of the component)
| | | data (Internal Objects)
| | | database (Entites and Repository)
| | | dataMapper (MapStruct based Mappers)
| | | exception (Internal Exceptions)
| | | rest (Dto and Resources)
| | | DataService (Convert Rest/Internal Object)
| | | Manager (Implemented Logic)
| restController
| | helloWorldRestController (API Endpoints)

Logical Flow of an incoming API Request
1. RestController
2. DataService
3. Manager
4. Repository
