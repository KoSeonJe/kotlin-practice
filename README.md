# Kotlin Practice Project

이 프로젝트는 Kotlin 언어의 기초 문법부터 고급 기능까지 단계별로 학습하고, 실무적인 AI 챗봇 구현을 연습하기 위한 멀티 모듈 프로젝트입니다.

## 모듈 구조

- **`kotlin-basic`**: Kotlin의 핵심 문법을 JUnit5 테스트 기반으로 학습하는 모듈입니다.
  - 16개의 단계별 연습 문제 (`Ex01` ~ `Ex16`)
  - 각 문제에 대응하는 정답 및 테스트 코드 제공
- **`kotlin-chatbot`**: Spring AI와 RAG(Retrieval-Augmented Generation)를 활용한 챗봇 구현 연습 모듈입니다.

## 학습 방법 (Test-Driven Learning)

본 프로젝트는 `main` 함수 호출 대신 **JUnit5 테스트 코드**를 통해 학습 내용을 검증합니다.

1. `kotlin-basic/src/main/kotlin/syntax/exercises/` 경로의 연습 문제 파일(`Ex*.kt`)을 엽니다.
2. `TODO`로 표시된 미구현 기능을 완성합니다.
3. 대응하는 테스트 코드를 실행하여 성공 여부를 확인합니다.
   - 테스트 파일: `kotlin-basic/src/test/kotlin/syntax/exercises/Ex*Test.kt`

## 실행 및 테스트 명령어

```bash
# 전체 프로젝트 빌드
./gradlew build

# 특정 모듈의 모든 테스트 실행
./gradlew :kotlin-basic:test
./gradlew :kotlin-chatbot:test

# 특정 연습 문제 테스트만 실행 (예: Ex01 Variables)
./gradlew :kotlin-basic:test --tests "syntax.exercises.ex01.Ex01_VariablesTest"

# 정답 코드 테스트 실행
./gradlew :kotlin-basic:test --tests "syntax.solutions.*"
```

## 학습 커리큘럼

| 단계 | 주제 | 핵심 키워드 |
|:--- |:--- |:--- |
| **Phase 1** | 01~04 | 변수, Null 안전성, 함수, 제어문 |
| **Phase 2** | 05~08 | 클래스, Data Class, Object & Companion, 상속 및 Sealed Class |
| **Phase 3** | 09~12 | 컬렉션 연산, 람다, 확장 함수, 스코프 함수 |
| **Phase 4** | 13~16 | 제네릭, 위임(Delegation), 코루틴, 고급 기능(DSL, 연산자 오버로딩) |

## 개발 규칙
- 모든 코드는 작성 후 테스트 통과 여부를 확인해야 합니다.
- 상세한 지침은 `Agents.md` 및 `CLAUDE.md`를 참고하세요.
