import java.util.*
import kotlin.collections.HashSet
import kotlin.math.ceil
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.min

// Estudar Region
fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
    fun isSubsequence(index: Int): Boolean {
        val skipIndexes = HashSet<Int>()
        for (idx in 0..index) {
            skipIndexes.add(removable[idx])
        }

        var i = 0
        var j = 0
        while (i < s.length && j < p.length) {
            if (!skipIndexes.contains(i) && s[i] == p[j]) {
                j++
            }
            i++
        }
        return j == p.length
    }

    var l = 0
    var r = removable.size
    while (l < r) {
        val m = l + (r - l) / 2
        if (isSubsequence(m)) {
            l = m + 1
        } else {
            r = m
        }
    }

    return l
}

fun shortestSubarray(nums: IntArray, k: Int): Int {
    val N = nums.size
    val prefixes = LongArray(N + 1)
    for (i in 1..N) {
        prefixes[i] = nums[i - 1].toLong() + prefixes[i - 1]
    }

    var res = Int.MAX_VALUE
    val queue = LinkedList<Int>()
    for (i in prefixes.indices) {
        while (queue.isNotEmpty() && prefixes[i] - prefixes[queue.first] >= k) {
            res = minOf(res, i - queue.pollFirst())
        }

        while (queue.isNotEmpty() && prefixes[i] <= prefixes[queue.last]) {
            queue.pollLast()
        }

        queue.add(i)
    }
    return if (res == Int.MAX_VALUE) -1 else res
}

fun maximumLength(s: String): Int {
    for (k in s.length - 2 downTo 1) {
        if (hasThreeOccr(s, k)) return k
    }
    return -1
}

fun hasThreeOccr(s: String, k: Int): Boolean {
    val map = mutableMapOf<String, Int>()

    for (i in 0..s.length - k) {
        val a = s.substring(i, i + k)
        if (a.all { it == a[0] }) {
            map[a] = map.getOrDefault(a, 0) + 1
            if (map.any { it.value == 3 }) return true
        }
    }
    return false
}

fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    potions.sort()  // Sort the potions array
    val answer = IntArray(spells.size)
    val m = potions.size
    val maxPotion = potions[m - 1]

    for (i in spells.indices) {
        val spell = spells[i]
        val minPotion = ceil(success.toDouble() / spell).toLong()

        // No suitable potion found
        if (minPotion > maxPotion) {
            answer[i] = 0
            continue
        }

        // Find index of first potion greater than or equal to minPotion
        val index = lowerBound(potions, minPotion.toInt())
        answer[i] = m - index  // Number of successful pairs
    }

    return answer
}

// Lower bound function using binary search
private fun lowerBound(arr: IntArray, key: Int): Int {
    var low = 0
    var high = arr.size
    while (low < high) {
        val mid = low + (high - low) / 2
        if (arr[mid] < key) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}

fun coinChange(coins: IntArray, amount: Int): Int {
    // Crio um array, que tenha o tamanho do valor + 1, e o valor default será de valor+1
    val dp = IntArray(amount + 1) { amount + 1 }

    // Caso base
    dp[0] = 0

    // Estarei interando dentre cada valor, de 1 até o valor final
    for (a in 1..amount) {
        // então eu vou iterar dentre cada valor da moeda
        for (b in coins) {
            // Então eu verifico se consigo dar a moeda e o valor em dinheiro será >= 0 para não dar troco a mais
            if (a - b >= 0) {
                // Se eu consegui dar a moeda, tiramos o minimo entre o valor daquele valor, ou 1 + o valor anterior
                dp[a] = minOf(dp[a], 1 + dp[a - b])
            }
        }
    }
    return if (dp[amount] != amount + 1) dp[amount] else -1
}

fun change(amount: Int, coins: IntArray): Int {
    val dp = IntArray(amount + 1) // zero initialized
    dp[0] = 1 // there is only one way to add up to nothing with positive coins

    for (c in coins) {
        for (i in c..amount) {
            dp[i] += dp[i - c]
        }
    }

    return dp[amount]
}

// End Region

fun countNegatives(grid: Array<IntArray>): Int {
    /*
     * grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]] ---> 8
     */
    var numberOfNegatives = 0
    for (i in grid) {
        numberOfNegatives += i.count { it < 0 }
    }
    return numberOfNegatives
}


fun findMin(nums: IntArray): Int {
    return nums.min()
}

fun findMinII(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val middlePoint = left + (right - left) / 2
        if (nums[middlePoint] < nums[right]) {
            right = middlePoint
        } else {
            left = middlePoint + 1
        }
    }
    return nums[left]
}

fun checkIfExist(arr: IntArray): Boolean {
    for (i in arr.indices) {
        for (j in arr.indices) {
            if (i != j && arr[i] == 2 * arr[j]) {
                return true
            }
        }
    }
    return false
}

fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val middlePoint = left + (right - left) / 2
        if (nums[middlePoint] == target) return middlePoint
        when {
            nums[middlePoint] > target -> {
                right = middlePoint - 1
            }

            nums[middlePoint] < target -> {
                left = middlePoint + 1
            }
        }
    }
    return -1
}

fun searchII(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        val middleNumber = nums[mid]
        when {
            middleNumber < target -> left = mid + 1
            middleNumber > target -> right = mid - 1
            else -> return mid
        }
    }
    return -1
}

fun isPerfectSquare(num: Int): Boolean {
    var l = 1
    var r = minOf(num, Int.MAX_VALUE)
    while (l <= r) {
        val mid = l + (r - l) / 2
        val square = mid * mid
        when {
            square == num -> return true
            square > num -> r = mid - 1
            else -> l = mid + 1
        }
    }
    return false
}

fun guessNumber(n: Int): Int {
    var step = n / 2
    var num = step

    while (true) {
        var result = guess(num)

        step = step / 2
        if (step == 0) step = 1

        if (result == 0)
            return num
        else if (result == 1)
            num = num + step
        else
            num = num - step
    }
}

private fun guess(number: Int): Int {
    return if (number < 1) {
        1
    } else if (number > 1) {
        -1
    } else {
        0
    }

}

fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var start = 0
    var end = letters.size - 1
    if (target >= letters[end]) {
        return letters[0]
    }
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (letters[mid] > target) {
            end = mid - 1
        } else start = mid + 1
    }
    return letters[start]
}

fun lemonadeChange(bills: IntArray): Boolean {
    val currentBills = mutableMapOf(
        5 to 0,
        10 to 0,
        20 to 0
    )
    val lemonadeCost = 5

    for (bill in bills) {
        // Adiciono a nota no mapa
        val currentBillAmount = currentBills.getOrDefault(bill, 0)
        currentBills[bill] = currentBillAmount.plus(1)

        // Preciso dar o troco?
        val lemonadeChange = bill - lemonadeCost

        if (lemonadeChange > 0) {
            // Tenho que dar o troco
            when (lemonadeChange) {
                15 -> {
                    val currentTenBillAmount = currentBills.getOrDefault(10, 0)
                    val currentFiveBillAmount = currentBills.getOrDefault(5, 0)
                    if (currentTenBillAmount >= 1) {
                        if (currentFiveBillAmount <= 0) return false
                        currentBills[5] = currentFiveBillAmount.minus(1)
                        currentBills[10] = currentTenBillAmount.minus(1)
                    } else {
                        if (currentFiveBillAmount < 2) return false
                        currentBills[5] = currentFiveBillAmount.minus(3)
                    }
                }

                10 -> {
                    val currentTenBillAmount = currentBills.getOrDefault(5, 0)
                    if (currentTenBillAmount == 0) {
                        val currentFiveBillAmount = currentBills.getOrDefault(5, 0)
                        if (currentFiveBillAmount < 2) return false
                        currentBills[5] = currentFiveBillAmount.minus(2)
                    } else {
                        currentBills[10] = currentTenBillAmount.minus(2)
                    }
                }

                5 -> {
                    val currentFiveBillAmount = currentBills.getOrDefault(5, 0)
                    if (currentFiveBillAmount == 0) return false
                    currentBills[5] = currentFiveBillAmount.minus(1)
                }
            }
        }
    }
    return true
}

fun lemonadeChangeII(bills: IntArray): Boolean {
    val currentBills = mutableMapOf(
        20 to 0,
        10 to 0,
        5 to 0
    )

    // Percorremos a fila de clientes
    for (bill in bills) {
        val currentBillAmount = currentBills.getOrDefault(bill, 0)
        currentBills[bill] = currentBillAmount.plus(1)

        var currentChange = bill - 5


        if (currentChange > 0) {
            currentBills.forEach { key, value ->
                var keyValue = value
                while (keyValue > 0 && currentChange >= key) {
                    keyValue--
                    currentChange -= key
                }
                currentBills[key] = keyValue
            }
        }

        if (currentChange > 0) {
            return false
        }
    }
    return true
}

/**
 * @param meetingStartTimeList
 * @param meetingEndTimeList
 * @return minimumRooms
 */

fun minimumRooms(startMeeting: List<Int>, endMeeting: List<Int>): Int {
    val sortedStartMeeting = startMeeting.sorted()
    val sortedEndMeeting = endMeeting.sorted()
    val listLength = sortedStartMeeting.size - 1

    var startPointer = 0
    var endPointer = 0
    var result = 0
    var rooms = 0

    while (startPointer < listLength || endPointer < listLength) {
        if (sortedStartMeeting[startPointer] <= sortedEndMeeting[endPointer]) {
            rooms++
            startPointer++
        } else {
            rooms--
            endPointer++
        }
        result = max(rooms, result)
    }
    return result
}

/**
 * @param [3,5,3,4], 5
 * @return 4
 */
fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sort()
    var numberOfBoats = 0
    var l = 0
    var r = people.size - 1
    while (l <= r) {
        if (people[r] + people[l] <= limit) {
            l++
            r--
            numberOfBoats++
        } else if (people[r] <= limit) {
            r--
            numberOfBoats++
        }
    }
    return numberOfBoats
}

fun findContentChildren(g: IntArray, s: IntArray): Int {
    // [1,2,3], s = [1,1]
    var result = 0
    g.sort()
    s.sort()
    var j = 0
    for (kid in g) {
        while (j < s.size && s[j] < kid) {
            j++
        }

        if (j >= s.size) {
            break
        } else {
            result++
        }
    }
    return result
}

fun largestNumber(nums: IntArray): String {
    val sorted = nums.sortedWith { a, b ->
        val a1 = a.toString();
        val b1 = b.toString();
        (b1 + a1).compareTo(a1 + b1);
    }

    if (sorted[0] == 0) return "0"

    val ans = StringBuilder()
    for (it in sorted) {
        ans.append(it.toString())
    }
    return ans.toString()
}

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    return numBottles + ((numBottles - 1) / (numExchange - 1))
}


lateinit var fibMemo: IntArray
fun fib(n: Int): Int {
    if (!::fibMemo.isInitialized) {
        fibMemo = IntArray(n + 1) { -1 }
    }
    if (n == 0) return 0
    if (n <= 2) return 1
    if (fibMemo[n] != -1) return fibMemo[n]
    fibMemo[n] = fib(n - 1) + fib(n - 2)
    return fibMemo[n]
}

fun fibII(n: Int): Int {
    val memoization = IntArray(size = n) { -1 }

    for (i in 0..n) {
        if (i == 0) memoization[i] = 0
        if (i == 1) memoization[i] = 1
        if (i == 2) memoization[i] = 2
        if (i > 2) {
            memoization[i] = memoization[i - 1] + memoization[i - 2]
        }
    }

    return memoization[n]
}

val gridTravellerCache: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
fun uniquePaths(m: Int, n: Int): Int {
    return gridTravellerCache.getOrPut(Pair(m, n)) {
        when {
            (m == 0 || n == 0) -> 0
            (m == 1 && n == 1) -> 1
            else -> uniquePaths(m - 1, n) + uniquePaths(m, n - 1)
        }
    }
}

fun uniquePathsII(m: Int, n: Int): Int {
    val gridTravellerCache: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
    for (i in 0..m) {
        for (j in 0..n) {
            when {
                (i == 0 || j == 0) -> {
                    gridTravellerCache[Pair(i, j)] = 0
                }

                (i == 1 && j == 1) -> {
                    gridTravellerCache[Pair(i, j)] = 1
                }

                else -> {
                    gridTravellerCache[Pair(i, j)] =
                        gridTravellerCache.getOrDefault(Pair(i - 1, j), 0) + gridTravellerCache.getOrDefault(
                            Pair(
                                i,
                                j - 1
                            ), 0
                        )
                }
            }
        }
    }
    return gridTravellerCache.getOrDefault(Pair(m, n), 0)
}

fun maxSubArray(nums: IntArray): Int {
    // Crio um array do tamanho do array de nums
    val maxSubArraySum = IntArray(nums.size) { 0 }

    // Aqui eu já determino o valor do primeiro indice, que irá corresponder ao primeiro valor de nums
    maxSubArraySum[0] = nums[0]

    // Então agora, começo a iterar no array, começando de 1
    for (i in 1 until nums.size) {
        // Então registro que no ponto i, será o maximo entre o próprio numero, ou o resultado anterior
        // mais o proximo numero
        maxSubArraySum[i] = max(nums[i], nums[i] + maxSubArraySum[i - 1])
    }

    // retorno o maximo do array
    return maxSubArraySum.max()
}

fun lengthOfLIS(nums: IntArray): Int {
    /**
     * @param {IntArray} nums representa os numeros que iremos verificar
     * 1- Crio um intArray, do tamanho que nums e preencho ele com o valor inicial de 1, porque cada numero é uma sub-sequencia
     * 2- Começo a iterar pelo array, e crio uma outra iteração com j começando em 0 até o i, não incluso
     * 3- Se o valor da posição de j for menor que o valor da posição de i, eu verifico se a subsequencia até o momento,
     * que seria dp[i] é maior que 1 + a subsequencia anterior, que seria dp[j]
     */
    val dp = IntArray(nums.size) { 1 }
    for (i in nums.indices) {
        for (j in 0 until i) {
            if (nums[j] < nums[i]) {
                dp[i] = max(dp[i], 1 + dp[j])
            }
        }
    }
    return dp.max()
}

fun rodCutting(price: IntArray, n: Int): Int {
    val dp = IntArray(n + 1) { 0 }

    for (i in 1..n) {
        var maxValue = Int.MIN_VALUE
        for (j in 0 until i) {
            maxValue = max(maxValue, price[j] + dp[i - j - 1])
        }
        dp[i] = maxValue
    }
    return dp[n]
}

fun climbStairs(n: Int): Int {
    /**
     * f(n) numero de maneiras de chegar até n
     * n = 0 f(0) = 0
     * n = 1 f(1) = 1
     * n = 2 f(2) = 2
     * n = 3 f(3) = 3
     * n = 4 f(4) = 5
     * n = 5 f(5) = 8
     */
    val dp = IntArray(n + 3) { 0 }
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    for (i in 0..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}

fun minCostClimbingStairs(cost: IntArray): Int {
    // Crio um array do tamanho do array de cost e adiciono um valor neutro, que seria 0
    val dp = IntArray(cost.size) { 0 }

    // Então começo a iteração em 2, porque posso subir 1 ou 2 degrais ao mesmo tempo
    for (i in 2 until cost.size) {
        // O custo da iteração em i, é o minimo entre 2 degrais abaixo + o custo de 2 degrais abaixo, ou de um degrau abaixo
        // mais o custo deste degrau
        dp[i] = minOf(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1])
    }

    return minOf(dp[dp.size - 2] + cost[dp.size - 2], dp[dp.size - 1] + cost[dp.size - 1])
}

fun canCross(stones: IntArray): Boolean {
    val map = mutableMapOf<Int, MutableSet<Int>>()

    map[stones[0] + 1] = mutableSetOf(1)
    for (i in 1 until stones.size - 1) {
        val stone = stones[i]

        map[stone]?.let { set ->
            set.forEach { k ->
                for (j in k - 1..k + 1) {
                    map[stone + j] = map.getOrDefault(stone + j, mutableSetOf()).also { it.add(j) }
                }
            }
        }
    }

    return map.contains(stones[stones.size - 1])
}

fun minPathSum(grid: Array<IntArray>): Int {
    /**
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     * f(i,j) = f(i-1,j), f(i,j-1) + grid[i][j]
     */
    val m = grid.size
    val n = grid[0].size
    val gridTravellerCache = Array(m) { IntArray(n) { 0 } }
    gridTravellerCache[0][0] = grid[0][0]

    // preenchendo as linhas
    for (i in 1 until m) {
        gridTravellerCache[i][0] = gridTravellerCache[i - 1][0] + grid[i][0]
    }

    // preenchendo as colunas
    for (i in 1 until n) {
        gridTravellerCache[0][i] = gridTravellerCache[0][i - 1] + grid[0][i]
    }

    // vamos popular o restante
    for (i in 1 until m) {
        for (j in 1 until n) {
            gridTravellerCache[i][j] = min(
                gridTravellerCache[i - 1][j], gridTravellerCache[i][j - 1]
            ) + grid[i][j]
        }
    }

    return gridTravellerCache[m - 1][n - 1]
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    if (numbers.size <= 2) return intArrayOf(1, 2)
    val resultIndex = IntArray(2) { -1 }
    var leftPointer = 0
    var rightPointer = numbers.size - 1
    while (leftPointer < rightPointer) {
        val twoPointersSum = numbers[leftPointer] + numbers[rightPointer]
        when {
            twoPointersSum < target -> leftPointer++
            twoPointersSum > target -> rightPointer--
            twoPointersSum == target -> {
                resultIndex[0] = leftPointer
                resultIndex[1] = rightPointer
                return resultIndex
            }
        }
    }
    return resultIndex
}

fun maxArea(height: IntArray): Int {
    if (height.isEmpty()) return 0

    val size = height.size
    var left = 0
    var right = size - 1
    var maxArea = 0

    while (left < right) {
        val area = minOf(height[left], height[right]) * (right - left)
        maxArea = maxOf(maxArea, area)

        if (height[left] < height[right])
            ++left
        else --right
    }

    return maxArea
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    // Calcular a soma dos primeiros 'k' elementos
    var currentSum = nums.take(k).sum()
    var maxSum = currentSum

    // Usar a técnica de janela deslizante para encontrar a soma máxima
    for (i in k until nums.size) {
        currentSum += nums[i] - nums[i - k] // Atualizar a soma removendo o elemento mais antigo e adicionando o novo
        maxSum = maxOf(maxSum, currentSum) // Atualizar a soma máxima, se necessário
    }

    // Calcular a média máxima
    return maxSum.toDouble() / k
}

fun lengthOfLongestSubstring(s: String): Int {
    var maxLongest = 0
    s.forEachIndexed { index, char ->
        var currentIndex = index
        val setOfChars = mutableSetOf<Char>()
        var currentChar = char
        var currentLongest = 0
        while (setOfChars.add(currentChar)) {
            currentIndex++
            currentLongest++
            if (currentIndex >= s.length) {
                break
            }
            currentChar = s[currentIndex]
        }
        maxLongest = max(maxLongest, currentLongest)
    }
    return maxLongest
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>()
    nums.forEach {
        minHeap.add(it)
        if (minHeap.size > k) minHeap.poll()
    }
    return minHeap.peek()
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    return nums.asSequence()
        .groupingBy { it }
        .eachCount()
        .asSequence()
        .sortedByDescending { it.value }
        .map { it.key }
        .take(k)
        .toList()
        .toIntArray()
}

fun splitArray(nums: IntArray, k: Int): Int {

    var maxi = nums[0]
    var sum = 0

    for (value in nums) {
        maxi = max(maxi, value)
        sum += value
    }

    // start binary search
    var start = maxi
    var end = sum
    var mid = start + (end - start) / 2

    while (start <= end) {

        val partitions = countPartitions(nums, mid)

        if (partitions > k) {
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    return start
}

private fun countPartitions(nums: IntArray, maxSum: Int): Int {

    var partitions = 1
    var subarraySum = 0

    for (value in nums) {

        if (value + subarraySum <= maxSum) {
            // insert element to current subarray
            subarraySum += value
        } else {
            // insert element to next subarray
            partitions++
            subarraySum = value
        }
    }

    return partitions
}

fun maxProduct(nums: IntArray): Int {
    if (nums.size == 0) return 0

    var currentMax = nums[0]
    var currentMin = nums[0]
    var globalMax = nums[0]

    for (i in 1 until nums.size) {
        val oldCurrentMax = currentMax
        currentMax = maxOf(nums[i], currentMax * nums[i], currentMin * nums[i])
        globalMax = maxOf(currentMax, globalMax)
        currentMin = minOf(nums[i], currentMin * nums[i], oldCurrentMax * nums[i])
    }

    return globalMax
}

fun numSquares(n: Int): Int {
    val dp = IntArray(n + 1) { it }
    val sq = IntArray(100) { (it + 1) * (it + 1) }
    for (i in 1..n)
        for (v in sq) {
            if (v > i) break
            dp[i] = minOf(dp[i], 1 + dp[i - v])
        }
    return dp[n]
}

fun maxSubarraySumCircular(nums: IntArray): Int {
    var currentMin = 0
    var currentMax = 0
    var globalMin = nums[0]
    var globalMax = nums[0]
    var total = 0

    for (n in nums) {
        currentMax = max(n, currentMax + n)
        currentMin = min(n, currentMin + n)
        total += n
        globalMax = max(globalMax, currentMax)
        globalMin = min(globalMin, currentMin)
    }

    return if (globalMax > 0) {
        max(globalMax, total - globalMin)
    } else {
        globalMax
    }
}

fun arrangeCoins(n: Int): Int {
    var n = n.toLong()
    var start = 1.toLong()
    var end = n


    while (start <= end) {
        var mid = start + (end - start) / 2
        var sum = mid * (mid + 1) / 2

        if (sum == n) return mid.toInt()
        else if (sum > n) end = mid - 1
        else start = mid + 1

    }
    return end.toInt()
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null && list2 == null) return null
    if (list1 == null) return list2
    if (list2 == null) return list1
    return if (list1.`val` < list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    } else {
        list2.next = mergeTwoLists(list2.next, list1)
        list2
    }
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    var current = head
    while (current?.next != null) {
        if (current.`val` == current.next?.`val`) {
            current.next = current.next?.next
        } else {
            current = current.next
        }
    }
    return head
}

fun findDuplicate(nums: IntArray): Int {
    val numsSet = mutableSetOf<Int>()
    for (i in nums) {
        if (!numsSet.add(i)) return i
    }
    return -1
}

fun findDuplicateTwoPointers(nums: IntArray): Int {
    var left = 0
    val right = nums.size - 1

    while (left < right) {
        if (nums[left] == nums[right]) return nums[left]

    }
    return -1
}

fun moveZeroes(nums: IntArray): Unit {
    var k = 0;
    for(i in nums.indices) {
        if(nums[i] != 0) {
            nums[k] = nums[i]
            k++
        }
    }

    while(k < nums.size) {
        nums[k] = 0
        k++
    }
}

fun reverseString(s: CharArray): Unit {
    var left = 0
    var right = s.size -1

    while (left < right) {
        val temp = s[left]
        s[left] = s[right]
        s[right] = temp
        left++
        right--
    }
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    if (k <= 0) return false
    val numsSet = mutableSetOf<Int>()

    for (i in nums.indices) {
        if (i > k) {
            numsSet.remove(nums[i - k - 1])
        }
        if (!numsSet.add(nums[i])) {
            return true
        }
    }
    return false
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val resultMutableSet = mutableSetOf<Int>()
    for (i in nums1) {
        for (j in nums2) {
            if (nums1.contains(j)) resultMutableSet.add(j)
        }
    }
    return resultMutableSet.toIntArray()
}

fun minimumAverage(nums: IntArray): Double {
    var leftPointer = 0
    var rightPointer = nums.size-1
    nums.sort()
    var minAverage = Double.MAX_VALUE
    while (leftPointer < rightPointer) {
        val currentAverage: Double = (nums[leftPointer] + nums[rightPointer]).toDouble() / 2
        minAverage = min(minAverage, currentAverage)
        leftPointer++
        rightPointer--
    }
    return minAverage
}

fun removeDuplicates(nums: IntArray): Int {
    nums.distinct().let {
        it.forEachIndexed { index, value ->
            nums[index] = value
        }
        return it.size
    }
}

fun countPairs(nums: List<Int>, target: Int): Int {
    val sortedList = nums.sorted()
    var leftPointer = 0
    var rightPointer = sortedList.size - 1
    var result = 0

    while (leftPointer < rightPointer) {
        val sum = sortedList[leftPointer] + sortedList[rightPointer]
        if (sum < target) {
            result += rightPointer - leftPointer
            leftPointer++
        } else {
            rightPointer--
        }
    }

    return result
}



