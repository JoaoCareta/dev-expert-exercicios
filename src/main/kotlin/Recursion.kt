fun sumOfAllNumbers(finalNumber: Int): Int {
    if (finalNumber <= 0) return 0
    return finalNumber + sumOfAllNumbers(finalNumber-1)
}

fun calculateFactorial(factorialNumber: Int): Int {
    if (factorialNumber <= 1) return 1
    return factorialNumber * calculateFactorial(factorialNumber-1)
}

tailrec fun calculateFactorialTailRecursive(factorialNumber: Int, accumulatedValue: Int = 1): Int {
    val currentAccumulatedValue = factorialNumber * accumulatedValue
    if (factorialNumber <= 1) return accumulatedValue
    return calculateFactorialTailRecursive(factorialNumber-1, currentAccumulatedValue)
}

fun calculateFibonacciNumber(fibonacciLimitNumber: Int): Int {
    if (fibonacciLimitNumber == 0 || fibonacciLimitNumber == 1) return 1
    return calculateFibonacciNumber(fibonacciLimitNumber-1) + calculateFibonacciNumber(fibonacciLimitNumber -2)
}

tailrec fun calculateFibonacciNumberTailRecursive(fibonacciLimitNumber: Int, a: Int = 0, b: Int = 1): Int {
    return if (fibonacciLimitNumber == 0) a else calculateFibonacciNumberTailRecursive(fibonacciLimitNumber - 1, b, a + b)
}

tailrec fun reverseList(listToReverse: List<Int>, accumulatedList: List<Int> = emptyList()): List<Int> {
    if (listToReverse.isEmpty()) return accumulatedList
    val currentAccumulatedList = mutableListOf<Int>()
    currentAccumulatedList.addAll(accumulatedList + listToReverse.last())
    return reverseList(listToReverse.subList(0, listToReverse.size-1), currentAccumulatedList)
}

tailrec fun totalSales(sales: List<String>, department: String, departmentSalesValue: Double = 0.0, totalDepartmentSales: Int = 0): String {
    if (sales.isEmpty()) return "$totalDepartmentSales VENDAS. TOTAL = ${String.format("%.2f", departmentSalesValue)}"
    val allSales = sales.map { it.toSales() }
    if (allSales.first().salesDepartment == department) {
        return totalSales(sales.subList(1, sales.size), department, departmentSalesValue + allSales.first().saleValue, totalDepartmentSales+1)
    }
    return totalSales(sales.subList(1, sales.size), department, departmentSalesValue, totalDepartmentSales)
}

data class Sales(val id: String, val date: String, val saleValue: Double, val salesDepartment: String)

fun String.toSales(): Sales {
    val salesInformationArray = this.split(",")
    return Sales(
        id = salesInformationArray[0],
        date = salesInformationArray[1],
        saleValue = salesInformationArray[2].toDouble(),
        salesDepartment = salesInformationArray[3]
    )
}