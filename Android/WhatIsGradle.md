## Gradle이란
- 유연성과 성능에 중점을 둔 오픈 소스 빌드 자동화 도구
- 안드로이드 스튜디오와 빌드 시스템은 서로 독립적이다.
- 안드로이드 스튜디오는 코드의 편집만을 담당할 뿐, 빌드는 Gradle을 통해 모두 수행된다.

## Gradle과 같은 빌드 시스템을 사용하는 이유
- 안드로이드 개발을 하다보면 여러 라이브러리를 사용하게 된다.
- 빌드 시스템이 없다면 일일이 .jar 파일을 다운로드 받아 따로 설정
- 라이브러리를 자동으로 관리해줄 수 있는 도구인 Gradle, Maven, Ant 등이 등장
- 라이브러리만이 아닌 빌드, 테스트, 배포, 개발 등을 자동화할 수 있음


## 장점
- Android용 공식 빌드 도구로 많은 언어에서 지원된다.
- 이전 실행의 출력을 재사용하고 변경된 입력만 처리하며 작업을 병렬로 실행하기 때문에 빠르다.
- 사용자 정의 측면에서 높다.
- Ant, Maven이 갖는 XML에 대한 이슈를 Groovy 언어를 이용해서 해결했다. 이로 인해 이전보다 유옇나고 다양한 구현이 가능해졌으며 동적 빌드까지 가능해졌다.

## Android Studio에서의 Gradle
### 설정 파일 : setting.gradle
- gradle에 모듈을 포함하여 gradle들이 모듈을 관리하고 빌드하게 설정하는 파일
- 거의 수정 x

### 최상위 빌드 파일 : build.gradle(Project: MyApplication)
- 모든 모듈을 위한 최상위 설정

### 모듈 레벨 파일 : build.gradle(Module: app)
- 개발자가 자주 수정하는 부분
- 설정 목록
	- complieSdkVersion : 사용하려는 컴파일러 버전
	- application "com.example.myApplication" : 앱의 식별자
	- minSdkVersion : 최소 지원 범위
	- targetSdkVersion : 사용하고 있는 SDK 버전
	- versionCode : 앱의 버전

