package com.example.basic

import com.example.Account
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * README의 모든 테스트 예시를 코틀린 스타일로 작성
 * Kotest assertion 스타일 적용 (shouldBe, shouldThrow 등)
 *
 * Account, Transaction 클래스가 구현되면 주석을 해제하여 사용
 */
class AccountTest {



    // ==================== Step 1: 기본 클래스와 프로퍼티 ====================
    @Test
    fun `계좌 생성 시 기본 잔액은 0이다`() {
        // given
        val account = Account("123-456", "홍길동")

        // then
        account.balance shouldBe 0L
    }

    /*
    // ==================== Step 2: 입금 기능 ====================
    @Test
    fun `1000원 입금하면 잔액이 1000원이 된다`() {
        // given
        val account = Account("123-456", "홍길동")

        // when
        account.deposit(1000L)

        // then
        account.balance shouldBe 1000L
    }

    @Test
    fun `0원 이하 입금 시 예외 발생`() {
        // given
        val account = Account("123-456", "홍길동")

        // then
        shouldThrow<IllegalArgumentException> {
            account.deposit(0L)
        }
    }
    */

    /*
    // ==================== Step 3: 출금 기능 ====================
    @Test
    fun `정상 출금 시 잔액이 감소한다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(5000L)
        }

        // when
        account.withdraw(2000L)

        // then
        account.balance shouldBe 3000L
    }

    @Test
    fun `잔액이 부족하면 출금할 수 없다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(500L)
        }

        // then
        shouldThrow<IllegalStateException> {
            account.withdraw(1000L)
        }
    }

    @Test
    fun `0원 이하 출금 시 예외 발생`() {
        // given
        val account = Account("123-456", "홍길동")

        // then
        shouldThrow<IllegalArgumentException> {
            account.withdraw(-100L)
        }
    }
    */

    /*
    // ==================== Step 4: 계좌 이체 ====================
    @Test
    fun `계좌 이체 시 송신자 잔액이 감소하고 수신자 잔액이 증가한다`() {
        // given
        val sender = Account("123-456", "홍길동").apply {
            deposit(10000L)
        }
        val receiver = Account("789-012", "김철수")

        // when
        sender.transfer(receiver, 3000L)

        // then
        sender.balance shouldBe 7000L
        receiver.balance shouldBe 3000L
    }

    @Test
    fun `잔액 부족으로 이체 실패 시 롤백되어야 한다`() {
        // given
        val sender = Account("123-456", "홍길동").apply {
            deposit(1000L)
        }
        val receiver = Account("789-012", "김철수")
        val senderInitialBalance = sender.balance
        val receiverInitialBalance = receiver.balance

        // when & then
        shouldThrow<IllegalStateException> {
            sender.transfer(receiver, 2000L)
        }

        // 롤백 검증
        sender.balance shouldBe senderInitialBalance
        receiver.balance shouldBe receiverInitialBalance
    }
    */

    /*
    // ==================== Step 5: 거래 내역 ====================
    @Test
    fun `입금 거래 내역만 조회한다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(1000L)
            deposit(2000L)
            withdraw(500L)
        }

        // when
        val deposits = account.getTransactionsByType<Transaction.Deposit>()

        // then
        deposits shouldHaveSize 2
        deposits.map { it.amount } shouldBe listOf(1000L, 2000L)
    }

    @Test
    fun `출금 거래 내역만 조회한다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(5000L)
            withdraw(1000L)
            withdraw(500L)
        }

        // when
        val withdrawals = account.getTransactionsByType<Transaction.Withdrawal>()

        // then
        withdrawals shouldHaveSize 2
        withdrawals.sumOf { it.amount } shouldBe 1500L
    }

    @Test
    fun `총 입금액을 계산한다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(1000L)
            deposit(2000L)
            withdraw(500L)
        }

        // when
        val totalDeposit = account.transactions
            .filterIsInstance<Transaction.Deposit>()
            .sumOf { it.amount }

        // then
        totalDeposit shouldBe 3000L
    }

    @Test
    fun `거래 내역이 시간순으로 저장된다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(1000L)
            withdraw(500L)
            deposit(2000L)
        }

        // when
        val transactions = account.transactions

        // then
        transactions shouldHaveSize 3
        transactions[0] shouldBeInstanceOf<Transaction.Deposit>()
        transactions[1] shouldBeInstanceOf<Transaction.Withdrawal>()
        transactions[2] shouldBeInstanceOf<Transaction.Deposit>()
    }
    */

    /*
    // ==================== Step 6: 계좌 상태 관리 ====================
    @Test
    fun `계좌를 동결하면 입금할 수 없다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            freeze()
        }

        // then
        shouldThrow<IllegalStateException> {
            account.deposit(1000L)
        }
    }

    @Test
    fun `동결된 계좌는 출금할 수 없다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(5000L)
            freeze()
        }

        // then
        shouldThrow<IllegalStateException> {
            account.withdraw(1000L)
        }
    }

    @Test
    fun `동결된 계좌를 해제하면 정상 작동한다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            freeze()
            unfreeze()
        }

        // when
        account.deposit(1000L)

        // then
        account.balance shouldBe 1000L
    }

    @Test
    fun `해지된 계좌는 입금할 수 없다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            close()
        }

        // then
        shouldThrow<IllegalStateException> {
            account.deposit(1000L)
        }
    }

    @Test
    fun `해지된 계좌는 출금할 수 없다`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(5000L)
            close()
        }

        // then
        shouldThrow<IllegalStateException> {
            account.withdraw(1000L)
        }
    }

    @Test
    fun `해지된 계좌는 이체할 수 없다`() {
        // given
        val sender = Account("123-456", "홍길동").apply {
            deposit(5000L)
            close()
        }
        val receiver = Account("789-012", "김철수")

        // then
        shouldThrow<IllegalStateException> {
            sender.transfer(receiver, 1000L)
        }
    }

    @Test
    fun `계좌 상태 조회`() {
        // given
        val account = Account("123-456", "홍길동")

        // then
        account.status shouldBe AccountStatus.ACTIVE

        // when
        account.freeze()

        // then
        account.status shouldBe AccountStatus.FROZEN

        // when
        account.close()

        // then
        account.status shouldBe AccountStatus.CLOSED
    }
    */

    /*
    // ==================== Step 7: 이자 계산 ====================
    @Test
    fun `단리 이자를 계산한다`() {
        // given
        val calculator = SimpleInterestCalculator(rate = 0.05)
        val account = Account(
            accountNumber = "123-456",
            owner = "홍길동",
            interestCalculator = calculator,
        ).apply {
            deposit(10000L)
        }

        // when
        val interest = account.calculateInterest(periods = 1)

        // then
        interest shouldBe 500L // 10000 * 0.05 * 1
    }

    @Test
    fun `복리 이자를 계산한다`() {
        // given
        val calculator = CompoundInterestCalculator(rate = 0.05)
        val account = Account(
            accountNumber = "123-456",
            owner = "홍길동",
            interestCalculator = calculator,
        ).apply {
            deposit(10000L)
        }

        // when
        val interest = account.calculateInterest(periods = 2)

        // then
        // 10000 * (1.05)^2 - 10000 = 1025
        interest shouldBe 1025L
    }

    @Test
    fun `이자를 계좌에 입금한다`() {
        // given
        val calculator = SimpleInterestCalculator(rate = 0.05)
        val account = Account(
            accountNumber = "123-456",
            owner = "홍길동",
            interestCalculator = calculator,
        ).apply {
            deposit(10000L)
        }

        // when
        account.applyInterest(periods = 1)

        // then
        account.balance shouldBe 10500L // 원금 + 이자
    }

    @Test
    fun `이자 계산기 없이 이자 계산 시 예외 발생`() {
        // given
        val account = Account("123-456", "홍길동").apply {
            deposit(10000L)
        }

        // then
        shouldThrow<IllegalStateException> {
            account.calculateInterest(periods = 1)
        }
    }
    */

    // ==================== 임시 테스트 (컴파일용) ====================
    @Test
    fun `프로젝트 설정 확인용 임시 테스트`() {
        // given
        val expected = 4

        // when
        val actual = 2 + 2

        // then
        assert(actual == expected) { "2 + 2는 4여야 합니다" }
    }
}
