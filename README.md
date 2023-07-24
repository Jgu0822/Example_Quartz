[![Java CI with Maven](https://github.com/fabioformosa/quartz-manager/actions/workflows/maven.yml/badge.svg)](https://github.com/fabioformosa/quartz-manager/actions/workflows/maven.yml)
[![npm CI](https://github.com/fabioformosa/quartz-manager/actions/workflows/npm.yml/badge.svg)](https://github.com/fabioformosa/quartz-manager/actions/workflows/npm.yml)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/it.fabioformosa.quartz-manager/quartz-manager-starter-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/it.fabioformosa.quartz-manager/quartz-manager-starter-api)  
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fabioformosa_quartz-manager&metric=coverage)](https://sonarcloud.io/summary/new_code?id=fabioformosa_quartz-manager) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=fabioformosa_quartz-manager&metric=bugs)](https://sonarcloud.io/summary/new_code?id=fabioformosa_quartz-manager) [![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=fabioformosa_quartz-manager&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=fabioformosa_quartz-manager) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=fabioformosa_quartz-manager&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=fabioformosa_quartz-manager)


[QUARTZ MANAGER](https://github.com/fabioformosa/quartz-manager#quartz-manager)  
    &nbsp;&nbsp;&nbsp;&nbsp;[Quartz Manager UI](https://github.com/fabioformosa/quartz-manager#quartz-manager-ui)  
    &nbsp;&nbsp;&nbsp;&nbsp;[Quartz Manager API](https://github.com/fabioformosa/quartz-manager#quartz-manager-api)    
[HOW IT WORKS](https://github.com/fabioformosa/quartz-managerhttps://github.com/fabioformosa/quartz-manager#get-started)  
    &nbsp;&nbsp;&nbsp;&nbsp;[Quartz Manager Starter API Lib](https://github.com/fabioformosa/quartz-manager#quartz-manager-starter-api-lib)  
    &nbsp;&nbsp;&nbsp;&nbsp;[Quartz Manager Starter UI Lib](https://github.com/fabioformosa/quartz-manager#quartz-manager-starter-ui-lib)   
    &nbsp;&nbsp;&nbsp;&nbsp;[Quartz Manager Starter Security Lib](https://github.com/fabioformosa/quartz-manager#quartz-manager-starter-security-lib)  
    &nbsp;&nbsp;&nbsp;&nbsp;[Quartz Manager Persistence Lib](https://github.com/fabioformosa/quartz-manager#quartz-manager-starter-persistence-lib)  
[EXAMPLES](https://github.com/fabioformosa/quartz-manager#examples)  
[LIMITATIONS](https://github.com/fabioformosa/quartz-manager#limitations)  
[ROADMAP](https://github.com/fabioformosa/quartz-manager#roadmap)  
[REPOSITORY](https://github.com/fabioformosa/quartz-manager#repository)  
[HOW TO CONTRIBUTE](https://github.com/fabioformosa/quartz-manager#how-to-contribute)  
[SUPPORT THE PROJECT](https://github.com/fabioformosa/quartz-manager#%EF%B8%8F-support-the-project-%EF%B8%8F)

# QUARTZ MANAGER 쿼츠 매니저
지난 10년 동안 [Quartz Scheduler](http://www.quartz-scheduler.org/)는 Java 애플리케이션을 위한 가장 많이 사용되는 오픈소스 작업 스케줄링 라이브러리로 자리 잡았습니다.

**Quartz Manager**는 **REST API** 계층과 편리한 **UI 콘솔**을 추가하여 Quartz 스케줄러를 쉽게 제어하고 모니터링할 수 있도록 개선한 것입니다.


Quartz Manager는 Spring 기반 웹 애플리케이션에서 사용할 수 있는 Java 라이브러리로, 예약된 작업을 실행, 시작 및 중지하고 작업 결과를 가져올 수 있습니다. Quartz Manager API를 통해 HTTP 호출을 사용하거나 시각적 방법으로 Quartz Manager UI 대시보드를 통해 이 작업을 수행할 수 있습니다.


## QUARTZ MANAGER UI
**Quartz Manager UI**는 Quartz Manager Java 라이브러리 자체에서 제공되는 대시보드 형태의 단일 페이지 애플리케이션입니다. 
프로젝트에 내장시킬 수 있으며 Swagger UI와 함께 내장시킬 수도 있습니다. 
웹소켓을 활용하여 트리거 업데이트와 작업 실행 결과를 실시간으로 받아볼 수 있습니다.

![](https://github.com/fabioformosa/quartz-manager/blob/master/quartz-manager-parent/quartz-manager-web-showcase/src/main/resources/quartz-manager-4-screenshot.png)

## QUARTZ MANAGER API
Quartz-Manager는 Quartz 스케줄러와 상호작용하기 위해 REST 엔드포인트를 노출합니다. 
이 엔드포인트는 Quartz Manager UI에서도 호출됩니다. 
REST API는 OpenAPI Specification 인터페이스로 문서화되어 있습니다.

![](https://github.com/fabioformosa/quartz-manager/blob/master/quartz-manager-parent/quartz-manager-web-showcase/src/main/resources/quartz-manager-4-swagger.png)


# HOW IT WORKS(작동 방식)  
Quartz Manager는 기존 Quartz 인스턴스와 함께 공존할 수 있거나 자체적으로 Quartz dependency를 가져와서 사용할 수 있습니다.

첫 번째 경우, Quartz Manager는 Quartz v2.3.x와 호환됩니다. 
Quartz Manager는 자체적으로 Quartz 스케줄러 인스턴스를 생성하고 구성하며 해당 인스턴스를 통해 생성된 작업과 트리거만 관리합니다. 
기존의 Quartz 인스턴스에서 실행 중인 다른 작업과 트리거는 Quartz Manager의 범위 밖입니다.

후자의 경우, 기존의 Quartz 인스턴스가 없는 경우 Quartz Manager를 가져와서 Quartz 인스턴스를 빠르게 설정할 수 있습니다. 
필요한 경우 영구 저장소를 통해 지속성을 활성화할 수도 있습니다. 
또한 예약된 작업만 실행하는 빈 프로젝트를 처음부터 시작하려는 경우, Quartz Manager는 [JWT](https://jwt.io) 기반 인증 모델을 사용하여 API와 UI를 보호하는 보안 계층을 활성화할 수 있습니다.

**FEATURES(주요기능)**
* [Quartz Simple Trigger](http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/tutorial-lesson-05.html)를 예약할 수 있으며,
  작업을 지금 또는 특정 일시에 시작하고 일정한 시간 간격으로 반복되도록 설정하거나 실행 횟수를 무제한하거나 특정 종료 일시까지 제한할 수 있습니다.
  
* Quartz 스케줄러를 API를 통해 시작, 일시 중지 및 재개하거나 UI 콘솔의 시작/중지 버튼을 클릭하여 수행할 수 있습니다.
  
* 활성 웹소켓을 활용하여 'Quartz-Manager-UI'에서 프로그레스 바를 실시간으로 업데이트하고 Quartz 작업에서 생성된 최신 로그 목록을 표시합니다.
  
* 프로젝트에 보안 계층이 없는 경우 보안 계층을 활성화하여 API와 UI에 대해 인증된 사용자만 접근할 수 있도록 할 수 있습니다.
  
* PostgreSQL 데이터베이스에 구성 및 트리거 진행 상태를 영속적으로 저장하기 위해 영속성 계층을 활성화할 수 있습니다.

# GET STARTED(시작하기)

**Requirements(요구사항)** 
  Java 9+, Spring Framework 5+ (Spring Boot 2.x)
  
Quart Manager is a modular library(Quartz Manager는 모듈식 라이브러리입니다):
* quartz-manager-starter-api (mandatory-필수)
* quartz-manager-starter-ui (optional-선택)
* quartz-manager-starter-security (optional-선택)
* quartz-manager-starter-persistence (optional-선택)

프로젝트의 전체 구성 시간을 줄이기 위해 라이브러리의 모든 모듈은 Spring Starters 접근 방식을 따릅니다. 따라서 의존성을 가져오기만 하면 시작할 수 있습니다.

다음은 가져올 수 있는 quartz-manager 모듈 목록입니다.

## Quartz Manager Starter API Lib(Quartz Manager Starter API 라이브러리)
이것은 라이브러리의 유일한 필수 모듈입니다.
의존성을 추가하고 job 클래스를 Quartz Manager에서 처리 가능한 상태로 설정하고 application.properties 파일에 속성을 설정합니다.

### Step 1. Dependency(의존성 추가)

#### Maven
```
<dependency>
  <groupId>it.fabioformosa.quartz-manager</groupId>
  <artifactId>quartz-manager-starter-api</artifactId>
  <version>4.0.8</version>
</dependency>
```
#### Gradle
```
implementation group: 'it.fabioformosa.quartz-manager', name: 'quartz-manager-starter-api', version: '4.0.8'
```

### Step 2. Quartz Manager Job Classes
Quartz Manager에서 처리 가능한 트리거를 위해 job 클래스는 'AbstractLoggingJob' 슈퍼 클래스를 확장해야 합니다. 
이렇게 하면 Quartz Manager가 실행 결과를 수집하고 UI 콘솔에서 표시할 수 있습니다.

 ```
 public class SampleJob extends AbstractLoggingJob {

    @Override
    public LogRecord doIt(JobExecutionContext jobExecutionContext) {
        ... do stuff ...
        return new LogRecord(LogType.INFO, "Hello from QuartManagerDemo!");
    }

}
```

### Step 3. Quartz Manager API - App Props(앱 속성)

| Property                           | Values   |Mandatory | Default | Description                                                               |
| :---                               |:---      |:---      |:---     |:--                                                                        |
| quartz-manager.jobClassPackages    | string   | Yes      |         |java base package which contains your job classes<br>(job 클래스를 포함하는 Java 기본 패키지)                          |
| quartz-manager.oas.enabled         | boolean  | No       | false   |whether to create an OpenAPI instance to expose the OAS and the Swagger UI<br>(OpenAPI Specification 및 Swagger UI를 노출할지 여부) |


### REST API & OpenAPI Specification
Quartz Manager API의 OpenAPI Specification을 노출하려면 app prop quartz-manager.oas.enabled=true로 설정하십시오. 
Reach out the swagger-ui at the URL(Swagger-UI는 다음 URL에서 확인할 수 있습니다.):
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

프로젝트에 이미 OpenAPI 인스턴스가 있고 'quartz-manager.oas.enabled=true'로 설정한 경우, 애플리케이션의 API를 그룹화하는 OpenApiGroup을 추가해야 합니다. Quart Manager는 "Quartz Manager"라는 그룹으로 API를 노출합니다. OAS 주석을 사용하는 경우 다음과 같이 설정합니다 :
```
  @Bean
  public GroupedOpenApi simplySpringDemoGroupedOpenApi() {
    return GroupedOpenApi.builder().group("myapp").packagesToScan("com.example.myapp").build();
  }
```

### QUARTZ SETTINGS
Quartz Manager creates its own instance of a [Quartz Scheduler](http://www.quartz-scheduler.org/).<br>
Quartz Manager는 자체적으로 Quartz 스케줄러 인스턴스를 생성합니다.

By default, the managed quartz instance is instantiated with the following props:<br>
기본적으로 관리되는 Quartz 인스턴스는 다음과 같은 속성으로 인스턴스화됩니다 :

```
org.quartz.scheduler.instanceName=quartz-manager-scheduler
org.quartz.threadPool.threadCount=1
```

Quartz Manager가 생성하는 Quartz 인스턴스의 구성을 사용자 정의하려면 classpath( src/main/resources)에 'managed-quartz.properties' 파일을 만들어서 사용합니다.<br>
For further details about the quartz properties, click [here](http://www.quartz-scheduler.org/documentation/quartz-2.3.0/configuration/).

#### Existing Quartz Instance (기존의 Quartz 인스턴스)
Quartz Manager는 [Quartz Scheduler library](https://mvnrepository.com/artifact/org.quartz-scheduler/quartz) 버전 2.3.2를 타사적으로 가져옵니다.<br>

Quartz Manager는 Quartz 스케줄러 라이브러리 버전 2.3.2를 타사적으로 가져옵니다. 
그러나 Quartz Manager는 기존에 가져온 Quartz 스케줄러 라이브러리가 있는 경우에도 가져올 수 있습니다. 
실제로 Quartz Manager는 프로젝트에서 생성한 기존 Quartz 스케줄러 인스턴스와 함께 공존할 수 있습니다. 이 경우 Quartz Manager는 해당 인스턴스에서 생성한 트리거를 관리하며 다른 quartz 인스턴스와 간섭하지 않습니다. 
전제 조건은 Quartz 스케줄러 버전 2.3.x를 가져왔을 경우입니다.

Quartz Manager가 생성한 Quartz 인스턴스와 Quartz Manager가 아닌 기존의 Quartz 인스턴스를 동시에 구성하려면 'managed-quartz.properties' 파일과 'quartz.properties' 파일을 사용합니다.

Quartz 'SchedulerFactoryBean'을 생성한 경우 '@Primary' 태그를 달아서 동일한 타입의 충돌을 피해야 합니다.

```
    @Primary
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean( JobFactory jobFactory, Properties quartzProperties) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        ...
        return factory;
    }
```


## Quartz Manager Starter UI Lib
Quartz Manager API와 상호작용하는 UI 대시보드를 사용하려면 다음 의존성을 선택적으로 가져올 수 있습니다.

### Dependency

#### Maven
```
<dependency>
  <groupId>it.fabioformosa.quartz-manager</groupId>
  <artifactId>quartz-manager-starter-ui</artifactId>
  <version>4.0.8</version>
</dependency>
```
#### Gradle
```
implementation group: 'it.fabioformosa.quartz-manager', name: 'quartz-manager-starter-ui', version: '4.0.8'
``` 

### Reach out the UI Console at URL
로컬에서 실행 중이면 [http://localhost:8080/quartz-manager-ui/index.html](http://localhost:8080/quartz-manager-ui/index.html) 에서 UI 콘솔을 확인할 수 있습니다.



## Quartz Manager Starter Security Lib

인증된 사용자만 REST API 및 UI에 접근할 수 있도록 보안 계층을 활성화하려면 이 선택적인 의존성을 가져올 수 있습니다. Quartz Manager의 인증 모델은 [JWT](https://jwt.io/)를 기반으로 합니다.

기존에 Spring Security 구성이 있는 프로젝트에 Quartz Manager를 가져올 경우 다음과 같은 사항을 고려하십시오:
- 기존 보안이 쿠키 기반인 경우, 실제로 quartz-manager-security-lib 모듈을 가져올 필요가 없습니다. Quartz Manager는 보안 설정 아래에 있을 것입니다. 기타 모든 경우 (HTTP 헤더, 쿼리 매개변수 기반 등)에서 Quartz Manager는 인증 토큰을 인식하지 못하고 자체적으로 인증 모델을 구현할 것입니다.
- Quartz Manager Security는 "/quartz-manager" 기본 경로에 대해 별도의 HTTP Spring Security 체인을 사용하여 Spring Security를 기반으로 합니다. 따라서 기존의 보안 설정과 간섭하지 않습니다.
- Quartz Manager Security는 간단한 인메모리 모델을 채택하여 인증을 수행합니다. Quartz Manager에 접근할 수 있는 사용자를 정의해야 합니다(사용자 이름/자격 증명은 application.properties를 통해 전달됩니다).
- 기본적으로 UI는 JWT 토큰을 인증 헤더에 "Bearer" 형식으로 첨부합니다.

미래 개발 계획으로는 Quart Manager Security OAuth2 클라이언트를 지원할 예정입니다.


### Dependency

#### Maven

```
<dependency>
  <groupId>it.fabioformosa.quartz-manager</groupId>
  <artifactId>quartz-manager-starter-security</artifactId>
  <version>4.0.8</version>
</dependency>
```

#### Gradle

```
compile group: 'it.fabioformosa.quartz-manager', name: 'quartz-manager-starter-security', version: '4.0.8'
```


### Quartz Manager Security Lib - App Props(앱 속성)

| Property                                                    | Values   |Mandatory         | Default | Description     |
| :---                                                        |:---      |:---              |:---     |:--              |
| quartz-manager.security.jwt.secret                          | string   |                  |         | Secret to sign the JWT Token(JWT 토큰 서명에 사용할 비밀) |          
| quartz-manager.security.jwt.expiration-in-sec               | number   | no               | 28800   | JWT 토큰의 만료 시간 (초)                             |
| quartz-manager.security.accounts.in-memory.enabled          | boolean  | no               | true    | 인메모리 모델 활성화 여부                             |
|quartz-manager.security.accounts.in-memory.users[0].username | string   | yes (if enabled) |         | 사용자 이름                             | 
|quartz-manager.security.accounts.in-memory.users[0].password | string   | yes              |         | 패스워드                             |
|quartz-manager.security.accounts.in-memory.users[0].roles[0] | string   | yes              |         | set the value ADMIN (권한 설정 (예: ADMIN으로 설정)         |


## Quart Manager Starter Persistence Lib

기본적으로 Quartz Manager는 메모리에 관리되는 'org.quartz.simpl.RAMJobStore'를 사용하여 작업 스케줄러 데이터를 저장합니다. RAMJobStore는 가장 간단하면서도 가장 성능이 우수한 저장소입니다. 그러나 이로 인해 애플리케이션이 종료되거나 충돌하는 경우 모든 스케줄링 데이터가 손실될 수 있습니다. 애플리케이션을 다시 시작하는 경우 스케줄러를 중단한 지점에서 다시 시작할 수 없습니다.

스케줄러 데이터를 영구적으로 저장하려면 Quartz Manager Persistence 모듈을 가져와야 합니다. 
영구 저장소로 사용할 Postgresql 데이터베이스를 제공해야 합니다. Quartz Manager가 시작할 때 DDL과 DML 쿼리에 대한 권한이 있는 Postgresql 사용자가 제공되어야 합니다. 
DDL에 대해 생각해야 할 점은 Quartz Manager Persistence가 부팅 시 필요한 모든 테이블을 생성한다는 것입니다.

### Dependency

#### Maven

```
<dependency>
  <groupId>it.fabioformosa.quartz-manager</groupId>
  <artifactId>quartz-manager-starter-persistence</artifactId>
  <version>4.0.8</version>
</dependency>
```

#### Gradle

```
compile group: 'it.fabioformosa.quartz-manager', name: 'quartz-manager-starter-persistence', version: '4.0.8'
```

### Quartz Manager Persistence Lib - App Props(앱 속성)

| Property                                                    | Values   |Mandatory         | Default | Description     |
| :---                                                        |:---      |:---              |:---     |:--              |
| quartz-manager.persistence.quartz.datasource.url            | string   | yes              |         |eg. jdbc:postgresql://localhost:5432/quartzmanager |          
| quartz-manager.persistence.quartz.datasource.user           | string   | yes              |         |                              |
| quartz-manager.persistence.quartz.datasource.password       | string   | yes              |         |                              |



## Examples 예제

다양한 시나리오의 프로젝트가 Quartz Manager를 가져온 예제를 "[quartz-manager-use-cases](https://github.com/fabioformosa/quartz-manager-use-cases)" 리포지토리에서 확인할 수 있습니다.

* *simply-spring* - 최소한의 스프링 프로젝트를 처음부터 생성하여 예약된 작업을 실행하는 일반적인 시나리오입니다. 가져온 라이브러리: Quartz Manager API, Quartz Manager UI 및 Quartz Manager Security.
* *simply-spring-no-security* - 보안 없이 간단한 스프링 프로젝트로 Quartz Manager API, Quartz Manager UI를 가져옵니다.
* *existing-security-cookie-based* - 쿠키 기반 인증 모델을 가진 기존 보안이 있는 경우 Quartz Manager가 기존 보안 설정 아래에서 실행되는 방법을 보여줍니다. Quartz Manager API, Quartz Manager UI를 가져옵니다.
* *existing-security-header-based* - 기존의 Spring Security 설정이 있는 프로젝트에서 Quartz Manager Security가 어떻게 공존할 수 있는지 보여줍니다. Quartz Manager API, Quartz Manager UI 및 Quartz Manager Security를 가져옵니다.
* *existing-quartz* - 기존의 Quartz 인스턴스와 Quartz Manager가 공존하는 방법을 보여줍니다. Quartz Manager API, Quartz Manager UI를 가져옵니다.
* *existing-quartz-and-storage* - 기존의 Quartz 인스턴스와 Quartz Manager Persistence가 공존하는 방법을 보여줍니다. Quartz Manager API, Quartz Manager UI 및 Quartz Manager Persistence를 가져옵니다.


## Limitations 제한 사항

> Step by step, day by day

Quartz Manager는 [Quartz Scheduler](http://www.quartz-scheduler.org/)를 관리하기 위한 완전한 라이브러리가 될 수 있도록 로드맵이 진행 중입니다.

At this stage of the roadmap, these are the limitations(현재 로드맵 단계에서 다음과 같은 제한 사항이 있습니다.):
* 현재 여러 트리거 또는 작업을 시작할 수 없습니다. 현재의 해결 방법은 Quartz Manager를 기반으로 여러 프로젝트를 실행하는 것입니다.
* Currently you can only start(현재는 Quartz 간단한 트리거만 지원됩니다.) [Quartz Simple Trigger](http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/tutorial-lesson-05.html). The support to other kind of triggers will come soon(다른 종류의 트리거 지원은 곧 추가될 예정입니다): [Calendar Interval Trigger](https://www.quartz-scheduler.org/api/2.3.0/org/quartz/CalendarIntervalTrigger.html), [Cron Interval Trigger](https://www.quartz-scheduler.org/api/2.3.0/org/quartz/CronTrigger.html), [Daily Interval Trigger](https://www.quartz-scheduler.org/api/2.3.0/org/quartz/DailyTimeIntervalTrigger.html)
* 현재 클러스터 모드는 지원되지 않습니다.
* 현재 Quartz Manager의 지속성은 PostgreSQL만 지원합니다. MySQL, MariaDB, SqlServer, Oracle, H2와 같은 다른 데이터베이스도 지원될 예정입니다.

## ROADMAP

프로젝트 로드맵은 [Project Roadmap](https://github.com/users/fabioformosa/projects/1)에서 확인하실 수 있습니다.
피드백을 주시는 것을 망설이지 마세요. 귀하의 의견은 우선순위를 이해하는 데 중요합니다.

Next steps in the roadmap are:
* Manage multiple triggers and jobs<br>
여러 트리거와 작업 관리
* Cluster mode support<br>
클러스터 모드 지원
* Support to other all types of Quartz Triggers:  [Calendar Interval Trigger](https://www.quartz-scheduler.org/api/2.3.0/org/quartz/CalendarIntervalTrigger.html), [Cron Interval Trigger](https://www.quartz-scheduler.org/api/2.3.0/org/quartz/CronTrigger.html), [Daily Interval Trigger](https://www.quartz-scheduler.org/api/2.3.0/org/quartz/DailyTimeIntervalTrigger.html)<br>
Calendar Interval Trigger, Cron Interval Trigger, Daily Interval Trigger와 같은 다른 모든 유형의 Quartz 트리거 지원
* UI Re-styling<br>
UI 스타일 재조정
* OAuth Client<br>
OAuth 클라이언트
* Support to other DBMS than PostreSQL: MySQL, MariaDB, SqlServer, Oracle, H2.<br>
PostgreSQL 이외의 다른 DBMS 지원: MySQL, MariaDB, SqlServer, Oracle, H2

## Repository

Checkout the **master branch** to get the sourcecode of the latest released versions.<br>
최신 릴리스 버전의 소스 코드를 얻으려면 master 브랜치를 확인하십시오.
Checkout the **develop branch** to take a look at the sourcecode of the incoming release.<br>
다가오는 릴리스의 소스 코드를 확인하려면 develop 브랜치를 확인하십시오.

## HOW-TO CONTRIBUTE  

For tech details, how-to run locally the project and how-to contribute, reach out this other [README.md](https://github.com/fabioformosa/quartz-manager/blob/develop/quartz-manager-parent/README.md)<br>
기술적 세부 정보, 프로젝트를 로컬에서 실행하는 방법 및 기여 방법에 대해서는 다른 README.md 문서를 참조하세요.

## ❤️ SUPPORT THE PROJECT ❤️

Sometimes it's a matter of a kind action. You can support Quartz Manager and its continuous improvement turning on a github star on this project ⭐
