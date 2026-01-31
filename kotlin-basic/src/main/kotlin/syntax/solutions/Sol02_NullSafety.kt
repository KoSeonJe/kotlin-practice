package syntax.solutions.sol02

fun exercise1(input: String?): Int = input?.length ?: 0

fun exercise2(name: String?): String = name ?: "Unknown"

data class Address(val city: String?)
data class Company(val address: Address?)
data class Employee(val company: Company?)

fun exercise3(employee: Employee?): String =
    employee?.company?.address?.city ?: "No City"

fun exercise4(value: String?): String =
    value?.let { it.uppercase() } ?: "EMPTY"

fun exercise5(value: String?): Int = value!!.length

fun exercise6(value: String?): String {
    if (value != null) {
        return value  // 스마트 캐스트
    }
    return "NULL"
}

