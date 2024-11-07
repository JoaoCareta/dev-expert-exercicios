import kotlin.math.max
import kotlin.math.min

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxConsecutiveOnes = 0
    var currentMax = 0
    for (num in nums) {
        if (num == 0) {
            maxConsecutiveOnes = max(currentMax, maxConsecutiveOnes)
            currentMax = 0
        } else {
            currentMax ++
        }
    }
    maxConsecutiveOnes = max(currentMax, maxConsecutiveOnes)
    return maxConsecutiveOnes
}

fun findMaxConsecutiveOnesII(nums: IntArray): Int {
    val arrayNumsInString = nums.joinToString("").split("0")
    return arrayNumsInString.maxOf { it.length }
}

fun dotProduct(nums1: IntArray, nums2: IntArray): Int {
    val maxLength = min(nums1.size, nums2.size)
    var currentSum = 0
    for (index in 0 until maxLength) {
        val vectorsProduct = nums1[index] * nums2[index]
        currentSum += vectorsProduct
    }
    return currentSum
}

fun findNumbers(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    return nums.map { it.toString() }.count { (it.length % 2 == 0) }
}

fun sortedSquares(nums: IntArray): IntArray {
    return nums.map { it*it }.sorted().toIntArray()
}

fun duplicateZeros(arr: IntArray): Unit {
    val last = arr.lastIndex
    var zeros = arr.count { it == 0 }

    for (i in last downTo 0) {
        if (i + zeros <= last) {
            arr[i + zeros] = arr[i]
        }

        if (arr[i] == 0) {
            zeros--
            if (i + zeros <= last) {
                arr[i + zeros] = 0
            }
        }
    }
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    for (i in 0 until n) {
        nums1[m+i] = nums2[i]
    }
    nums1.sort()
}

fun containsDuplicate(nums: IntArray): Boolean {
    val allValues = mutableSetOf<Int>()
    for (number in nums) {
        if (!allValues.add(number)) return true
    }
    return false
}
