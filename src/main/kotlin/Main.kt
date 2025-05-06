fun main() {

}

private fun linkedListTests() {
    val newLinkedList = LinkedList(100)
    println(newLinkedList.toString())
    newLinkedList.linkedListAppendNode(200)
    println(newLinkedList.toString())
    newLinkedList.linkedListAppendNode(300)
    println(newLinkedList.toString())
    newLinkedList.linkedListAppendNode(400)
    println(newLinkedList.toString())
    newLinkedList.linkedListAppendNode(500)
    println(newLinkedList.toString())

    println("Adding")
    newLinkedList.addElementAtIndex(3, 999)
    println(newLinkedList)

    println("Removing 100")
    newLinkedList.removeElement(100)
    println(newLinkedList.toString())

    println("Removing 500")
    newLinkedList.removeElement(500)
    println(newLinkedList.toString())

    println("Removing 999")
    newLinkedList.removeElement(999)
    println(newLinkedList.toString())

    println("Removing 200")
    newLinkedList.removeElement(200)
    println(newLinkedList.toString())

    println("Removing 400")
    newLinkedList.removeElement(400)
    println(newLinkedList.toString())
}

// Region Strings
private fun resultExerciseCPF() {
    println(removeDigitsFromUserCPF("87409217293"))
    println(removeDigitsFromUserCPF("874092172-93"))
    println(removeDigitsFromUserCPF("874.092.172-93"))
}

private fun resultExerciseEmail() {
    println(extractEmailInformation("joao.otavio@syngenta.com.br"))
    println(extractEmailInformation("joao.silva23@yahoo.com.br"))
    println(extractEmailInformation("maria123@gmail.com"))
}

fun resultExerciseExtractDateData() {
    println(extractDateData("01/07/2010"))
    println(extractDateData("4/10/2010"))
    println(extractDateData("15/11/2010"))
}

private fun resultExerciseFormatDate() {
    println(formatDate(5, 4, 2024))
    println(formatDate(10, 7, 2024))
    println(formatDate(5, 10, 2024))
    println(formatDate(15, 10, 1993))
}

private fun resultExerciseValidatePassword() {
    println(validatePassword("Amerca1@"))
    println(validatePassword("amrca154682"))
}

private fun resultExerciseAnagram() {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "car"))
}

private fun resultLongestPrefix() {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}

private fun resultInvalidTransactions() {
    println(invalidTransactions(arrayOf("alice,20,800,mtv", "alice,50,100,beijing")))
}

// End region

// Region Arrays
private fun resultMaxConsecutiveOnes() {
    println(findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))
    println(findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0, 1)))
}

private fun resultDotProduct() {
    println(dotProduct(intArrayOf(1, 0, 0, 2, 3), intArrayOf(0, 3, 0, 4, 0, 99, 99, 99999, 99999)))
    println(dotProduct(intArrayOf(0, 1, 0, 0, 0), intArrayOf(0, 0, 0, 0, 2)))
    println(dotProduct(intArrayOf(0, 1, 0, 0, 2, 0, 0), intArrayOf(1, 0, 0, 0, 3, 0, 4)))
}

private fun resultFindNumbersEven() {
    println(findNumbers(intArrayOf(12, 345, 2, 6, 7896)))
    println(findNumbers(intArrayOf(555, 901, 482, 1771)))
}

private fun resultSortedSquares() {
    println(sortedSquares(intArrayOf(-4, -1, 0, 3, 10)))
    println(sortedSquares(intArrayOf(-7, -3, 2, 3, 11)))
}

private fun resultContainsDuplicate() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
}
// End Region

// Region Recursion
private fun resultSumOfAllNumbers() {
    println(sumOfAllNumbers(0))
    println(sumOfAllNumbers(1))
    println(sumOfAllNumbers(2))
    println(sumOfAllNumbers(3))
    println(sumOfAllNumbers(4))
    println(sumOfAllNumbers(5))
    println(sumOfAllNumbers(6))
    println(sumOfAllNumbers(7))
    println(sumOfAllNumbers(8))
    println(sumOfAllNumbers(9))
    println(sumOfAllNumbers(10))
}

private fun resultOfCalculateFactorial() {
    println(calculateFactorial(1))
    println(calculateFactorial(2))
    println(calculateFactorial(3))
    println(calculateFactorial(4))
    println(calculateFactorial(5))
    println(calculateFactorial(6))
    println(calculateFactorial(7))
    println(calculateFactorial(8))
    println(calculateFactorial(8))
    println(calculateFactorial(10))
}

private fun resultOfCalculateFactorialTailRecursive() {
    println(calculateFactorialTailRecursive(1))
    println(calculateFactorialTailRecursive(2))
    println(calculateFactorialTailRecursive(3))
    println(calculateFactorialTailRecursive(4))
    println(calculateFactorialTailRecursive(5))
    println(calculateFactorialTailRecursive(6))
    println(calculateFactorialTailRecursive(7))
    println(calculateFactorialTailRecursive(8))
    println(calculateFactorialTailRecursive(8))
    println(calculateFactorialTailRecursive(10))
}

private fun resultCalculateFibonacciNumber() {
    println(calculateFibonacciNumber(0))
    println(calculateFibonacciNumber(1))
    println(calculateFibonacciNumber(2))
    println(calculateFibonacciNumber(3))
    println(calculateFibonacciNumber(4))
    println(calculateFibonacciNumber(5))
    println(calculateFibonacciNumber(6))
    println(calculateFibonacciNumber(7))
    println(calculateFibonacciNumber(8))
    println(calculateFibonacciNumber(9))
    println(calculateFibonacciNumber(10))
}

private fun resultCalculateFibonacciNumberTailRecursive() {
    println(calculateFibonacciNumberTailRecursive(0))
    println(calculateFibonacciNumberTailRecursive(1))
    println(calculateFibonacciNumberTailRecursive(2))
    println(calculateFibonacciNumberTailRecursive(3))
    println(calculateFibonacciNumberTailRecursive(4))
    println(calculateFibonacciNumberTailRecursive(5))
    println(calculateFibonacciNumberTailRecursive(6))
    println(calculateFibonacciNumberTailRecursive(7))
    println(calculateFibonacciNumberTailRecursive(8))
    println(calculateFibonacciNumberTailRecursive(9))
    println(calculateFibonacciNumberTailRecursive(10))
}

private fun resultReverseList() {
    println(reverseList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
    println(reverseList(listOf()))
}

private fun resultChallengeSalesDepartment() {
    println(
        totalSales(
            listOf(
                "8349,14/09/2024,899.9,ESPORTE",
                "4837,17/09/2024,530.0,VESTUARIO",
                "15281,21/09/2024,1253.99,ESPORTE",
                "15344,27/09/2024,1000.9,VESTUARIO",
                "18317,04/10/2024,250.4,VESTUARIO",
                "18972,11/10/2024,385.5,JARDINAGEM"
            ),
            "VESTUARIO"
        )
    )
}
// End Region

// Region Selection & Sort
private fun resultBubbleSort() {
    println(bubbleSort(mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)))
}

private fun resultSelectionSort() {
    println(selectionSort(mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)))
}

private fun resultInsertionSort() {
    println(insertionSort(mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)))
    println(insertionSortMedium(mutableListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)))
    println(insertionSort(mutableListOf(15, -5, 88, 2, 1, 0, 324, -45, 77, -100, 345)))
    println(insertionSortMedium(mutableListOf(15, -5, 88, 2, 1, 0, 324, -45, 77, -100, 345)))
}

// End Region

private fun resultMinimumRooms() {
    println(minimumRooms(listOf(900, 940, 950, 1100, 1500, 1800), listOf(910, 1200, 1120, 1130, 1900, 1300)))
    println(minimumRooms(listOf(900, 1100, 1235), listOf(1000, 1200, 1240)))
}

private fun resultNumRescueBoats() {
    println(numRescueBoats(intArrayOf(1, 2), 3)) // 1
    println(numRescueBoats(intArrayOf(3, 2, 2, 1), 3)) // 3
    println(numRescueBoats(intArrayOf(3, 5, 3, 4), 5)) // 4
}

private fun resultNumberOfBottles() {
    println(numWaterBottles(9, 3))
    println(numWaterBottles(15, 4))
}

private fun resultTwoSumsIILeetCode() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9))
    println(twoSum(intArrayOf(2, 3, 4), 6))
    println(twoSum(intArrayOf(-1, 0), -1))
}

private fun resultMaxAreaLeetoCode() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(intArrayOf(1, 1)))
}

private fun resultFindMaxAverageLeetCode() {
    println(findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
    println(findMaxAverage(intArrayOf(5), 1))
}

private fun resultFindKthLargestLeetCode() {
    println(findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}

private fun resultMergeSort() {
    val array = intArrayOf(9, 15, -2, -99, -678, 12, 34, 89, 67, 15, 32, 22, 1, 2, 0, 5, 69)
    mergeSort(array)
    println(array.toList())
}
