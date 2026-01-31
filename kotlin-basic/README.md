# Kotlin Basic Module

Kotlin의 기초부터 고급 문법까지 테스트 코드를 통해 학습하는 모듈입니다.

## 학습 구성

### 1. 단계별 문법 실습 (`syntax.exercises`)
`src/main/kotlin/syntax/exercises/` 경로에 있는 16개의 주제별 연습 문제를 해결하며 문법을 익힙니다.

- **Ex01-04**: 변수, Null Safety, 함수, 제어문
- **Ex05-08**: 클래스, 데이터 클래스, 오브젝트, 상속
- **Ex09-12**: 컬렉션, 람다, 확장 함수, 스코프 함수
- **Ex13-16**: 제네릭, 위임, 코루틴, 고급 기능

### 2. 정답 및 검증 (`syntax.solutions`)
실습 중 막히는 부분이 있다면 `src/main/kotlin/syntax/solutions/`의 정답 코드를 참고할 수 있습니다.

## 테스트 실행 가이드

각 실습 문제에는 전용 테스트 파일이 존재합니다.

```bash
# 특정 주제 테스트 실행 예시
./gradlew :kotlin-basic:test --tests "syntax.exercises.ex01.Ex01_VariablesTest"
```

## 실무 연습 (Optional)
문법 학습 완료 후, `com.example.basic` 패키지에서 실제 도메인 모델(예: 은행 계좌 시스템)을 설계하고 TDD 방식으로 구현해 보는 것을 권장합니다.