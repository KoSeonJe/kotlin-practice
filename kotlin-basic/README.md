# Kotlin 문법 & 테스트 연습 프로젝트

TDD(Test-Driven Development) 방식으로 코틀린 문법을 학습하는 미니 프로젝트입니다.

## 프로젝트: 은행 계좌 시스템 (BankAccount)

간단한 은행 계좌 도메인을 구현하면서 코틀린 핵심 문법을 익힙니다.

---

## 학습 방법: 테스트 먼저 작성 (Red → Green → Refactor)

1. **Red**: 실패하는 테스트 먼저 작성
2. **Green**: 테스트 통과하는 최소 코드 작성
3. **Refactor**: 코드 개선

---

## 단계별 요구사항

### Step 1: 기본 클래스와 프로퍼티
**학습 문법**: `class`, `data class`, `val/var`, 생성자, 프로퍼티

```
요구사항:
- Account 클래스 생성
- 계좌번호(accountNumber: String), 소유자(owner: String), 잔액(balance: Long) 보유
- 잔액 기본값은 0
```

**테스트 예시**:
```kotlin
@Test
fun `계좌 생성 시 기본 잔액은 0이다`() {
    val account = Account("123-456", "홍길동")
    assertEquals(0L, account.balance)
}
```

---

### Step 2: 입금 기능
**학습 문법**: 함수 정의, `require`, 예외 처리

```
요구사항:
- deposit(amount: Long) 함수 구현
- 입금액이 0 이하면 IllegalArgumentException 발생
- 입금 후 잔액 반환
```

**테스트 예시**:
```kotlin
@Test
fun `1000원 입금하면 잔액이 1000원이 된다`() {
    val account = Account("123-456", "홍길동")
    account.deposit(1000L)
    assertEquals(1000L, account.balance)
}

@Test
fun `0원 이하 입금 시 예외 발생`() {
    val account = Account("123-456", "홍길동")
    assertThrows<IllegalArgumentException> {
        account.deposit(0L)
    }
}
```

---

### Step 3: 출금 기능
**학습 문법**: `when`, nullable 타입, `?:` 엘비스 연산자

```
요구사항:
- withdraw(amount: Long) 함수 구현
- 출금액이 0 이하면 IllegalArgumentException
- 잔액 부족하면 IllegalStateException
- 출금 후 남은 잔액 반환
```

---

### Step 4: 계좌 이체
**학습 문법**: 확장 함수, `also`, `apply`, `let`

```
요구사항:
- transfer(to: Account, amount: Long) 함수 구현
- 출금과 입금이 원자적으로 처리되어야 함
- 실패 시 롤백 (출금만 되고 입금 안 되면 안 됨)
```

---

### Step 5: 거래 내역
**학습 문법**: `sealed class`, `enum class`, 컬렉션 함수 (`filter`, `map`, `sumOf`)

```
요구사항:
- Transaction sealed class 정의 (Deposit, Withdrawal, Transfer)
- 계좌에 거래 내역 리스트 추가
- 거래 유형별 조회 기능
- 총 입금액, 총 출금액 계산 기능
```

**테스트 예시**:
```kotlin
@Test
fun `입금 거래 내역만 조회한다`() {
    val account = Account("123-456", "홍길동")
    account.deposit(1000L)
    account.deposit(2000L)
    account.withdraw(500L)

    val deposits = account.getTransactionsByType<Transaction.Deposit>()
    assertEquals(2, deposits.size)
}
```

---

### Step 6: 계좌 상태 관리
**학습 문법**: `enum class`, 상태 패턴, `copy()` (data class)

```
요구사항:
- AccountStatus enum (ACTIVE, FROZEN, CLOSED)
- freeze(), unfreeze(), close() 함수
- FROZEN 상태에서는 입출금 불가
- CLOSED 상태에서는 모든 작업 불가
```

---

### Step 7: 이자 계산 (고급)
**학습 문법**: `interface`, `object`, companion object, 고차 함수

```
요구사항:
- InterestCalculator 인터페이스 정의
- SimpleInterestCalculator: 단리 계산
- CompoundInterestCalculator: 복리 계산
- Account에 이자 계산기 주입 (DI 연습)
```

---

## 프로젝트 구조

```
src/
├── main/kotlin/
│   └── bank/
│       ├── Account.kt
│       ├── Transaction.kt
│       ├── AccountStatus.kt
│       └── InterestCalculator.kt
└── test/kotlin/
    └── bank/
        ├── AccountTest.kt
        ├── TransactionTest.kt
        └── InterestCalculatorTest.kt
```

---

## 테스트 작성 팁

### 테스트 네이밍 (한글 추천)
```kotlin
@Test
fun `잔액이 부족하면 출금할 수 없다`() { }
```

### Given-When-Then 패턴
```kotlin
@Test
fun `1000원 입금 후 500원 출금하면 잔액은 500원`() {
    // Given: 초기 상태
    val account = Account("123-456", "홍길동")

    // When: 행동
    account.deposit(1000L)
    account.withdraw(500L)

    // Then: 검증
    assertEquals(500L, account.balance)
}
```

### 경계값 테스트
- 0원 입금/출금
- 정확히 잔액만큼 출금
- 최대값 테스트

---

## 실행 방법

```bash
# 테스트 실행
./gradlew test

# 특정 테스트만 실행
./gradlew test --tests "bank.AccountTest"
```

---

## 학습 순서 권장

1. Step 1-3: 기본 문법 (1일)
2. Step 4-5: 중급 문법 (1일)
3. Step 6-7: 고급 패턴 (1일)

각 단계마다 **테스트 먼저 작성** → **구현** → **리팩토링** 순서로 진행하세요.
