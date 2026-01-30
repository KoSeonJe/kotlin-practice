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
// JUnit5 스타일
@Test
fun `계좌 생성 시 기본 잔액은 0이다`() {
    val account = Account("123-456", "홍길동")
    account.balance shouldBe 0L  // Kotest assertion
}

// 또는 assertEquals(0L, account.balance) - 기본 JUnit
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
// 입금 성공
@Test
fun `1000원 입금하면 잔액이 1000원이 된다`() {
    // given
    val account = Account("123-456", "홍길동")

    // when
    account.deposit(1000L)

    // then
    account.balance shouldBe 1000L
}

// 예외 검증 (Kotest 스타일)
@Test
fun `0원 이하 입금 시 예외 발생`() {
    val account = Account("123-456", "홍길동")
    shouldThrow<IllegalArgumentException> {
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

**테스트 예시**:
```kotlin
@Test
fun `잔액이 부족하면 출금할 수 없다`() {
    val account = Account("123-456", "홍길동")
    account.deposit(500L)

    shouldThrow<IllegalStateException> {
        account.withdraw(1000L)
    }
}
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

    deposits shouldHaveSize 2  // Kotest: 리스트 크기 검증
    deposits shouldBe listOf(
        Transaction.Deposit(1000L),
        Transaction.Deposit(2000L)
    )  // Kotest: 리스트 내용 검증
}

@Test
fun `총 입금액을 계산한다`() {
    val account = Account("123-456", "홍길동")
    account.deposit(1000L)
    account.deposit(2000L)

    val totalDeposit = account.transactions
        .filterIsInstance<Transaction.Deposit>()
        .sumOf { it.amount }

    totalDeposit shouldBe 3000L  // Kotlin 컬렉션 + Kotest assertion
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

### 1. JUnit5 + Kotlin (기본)

```kotlin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.DisplayName

class AccountTest {
    @Test
    @DisplayName("계좌 생성 시 기본 잔액은 0이다")
    fun `계좌 생성 시 기본 잔액은 0이다`() {
        val account = Account("123-456", "홍길동")
        assertEquals(0L, account.balance)
    }

    @Test
    fun `입금 후 잔액이 증가한다`() {
        // given
        val account = Account("123-456", "홍길동")

        // when
        account.deposit(1000L)

        // then
        assertEquals(1000L, account.balance)
    }

    @Test
    fun `0원 이하 입금 시 예외 발생`() {
        val account = Account("123-456", "홍길동")
        assertThrows<IllegalArgumentException> {
            account.deposit(0L)
        }
    }
}
```

### 2. Kotest (Kotlin 전용 - 추천)

```kotlin
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.shouldThrow

class AccountBehaviorTest : BehaviorSpec({
    given("새로운 계좌가") {
        val account = Account("123-456", "홍길동")

        `when`("계좌를 생성하면") {
            then("기본 잔액은 0이다") {
                account.balance shouldBe 0L
            }
        }

        `when`("입금을 하면") {
            account.deposit(1000L)
            then("잔액이 증가한다") {
                account.balance shouldBe 1000L
            }
        }
    }
})
```

### 3. kotest-assertions (Kotlin DSL)

```kotlin
// 단순 비교
account.balance shouldBe 1000L

// 예외 검증
shouldThrow<IllegalArgumentException> {
    account.deposit(-100L)
}

// null 검증
account.owner shouldNotBe null

// 리스트 검증
transactions shouldHaveSize 3
transactions shouldContain deposit
```

### 경계값 테스트
- 0원 입금/출금
- 정확히 잔액만큼 출금
- 최대값 테스트

---

## 테스트 의존성 설정

### build.gradle.kts
```kotlin
dependencies {
    // 기본 JUnit5
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")

    // Kotest (선택)
    testImplementation("io.kotest:kotest-runner-junit5:5.8.0")
    testImplementation("io.kotest:kotest-assertions-core:5.8.0")
}
```

## 테스트 스타일 선택 가이드

| 상황 | 추천 방식 |
|------|----------|
| 빠른 시작 | JUnit5 + 한글 함수명 |
| BDD 스타일 | Kotest BehaviorSpec |
| 복잡한 시나리오 | Kotest FunSpec |
| 풍부한 assertion | kotest-assertions |

## 실행 방법

```bash
# 모든 테스트 실행
./gradlew :kotlin-basic:test

# 특정 테스트만 실행
./gradlew :kotlin-basic:test --tests "AccountTest"

# Kotest로 실행
./gradlew :kotlin-basic:test --tests "AccountBehaviorTest"

# 테스트 리포트 보기
open kotlin-basic/build/reports/tests/test/index.html
```

---

## 학습 순서 권장

1. Step 1-3: 기본 문법 (1일)
2. Step 4-5: 중급 문법 (1일)
3. Step 6-7: 고급 패턴 (1일)

각 단계마다 **테스트 먼저 작성** → **구현** → **리팩토링** 순서로 진행하세요.
