import java.sql.Time

fun bubbleSort(numsList: MutableList<Int>): List<Int> {
    var listLimit = numsList.size - 1
    var isSorted = false
    while (!isSorted) {
        isSorted = true
        for (i in 0 until listLimit) {
            if (numsList[i] > numsList[i+1]) {
                val temp = numsList[i]
                numsList[i] = numsList[i+1]
                numsList[i+1] = temp
                isSorted = false
            }
        }
        listLimit--
    }
    return numsList
}

fun selectionSort(numsList: MutableList<Int>): List<Int> {
    var min: Int
    for (i in 0 until numsList.size) {
        min = i
        for (j in (i+1) until numsList.size) {
            if (numsList[j] < numsList[min]) {
                min = j
            }
        }
        val temp = numsList[min]
        numsList[min] = numsList[i]
        numsList[i] = temp
    }
    return numsList
}

fun insertionSort(numsList: MutableList<Int>): List<Int> {
    for (i in 0 until numsList.size) {
        for (j in i+1 until numsList.size) {
            if (numsList[i] > numsList[j]) {
                val temp = numsList[i]
                numsList[i] = numsList[j]
                numsList[j] = temp
            }
        }
    }
    return numsList
}

fun insertionSortMedium(numsList: MutableList<Int>): List<Int> {
    for (i in 0 until numsList.size) {
        var key = numsList[i]
        var j = i - 1

        // Enquanto houve um elemento atrás, e ele for maior que o elemento da frente
        while (j >= 0 && numsList[j] > key) {
            // O elemento da frente recebe o elemento de traz
            numsList[j+1] = numsList[j]
            j -= 1

        }
        // O elemento de traz, recebe o elemento da frente
        numsList[j + 1] = key
    }
    return numsList
}

fun mergeSort(array : IntArray, helper:IntArray = IntArray(array.size), low:Int = 0, high : Int = array.size-1) {
    if(low < high) {
        val middle:Int = (low+high)/2 // 1) calculating the middle element
        mergeSort(array, helper, low, middle) // 2) to sort left half
        mergeSort(array, helper, middle+1, high) // 3) to sort right half
        merge(array, helper, low, middle, high) // 4) Merge them
    }
}

private fun merge (array: IntArray, helper: IntArray, low: Int, middle:Int, high: Int) {
//    a) copying both halves into helper array
    for (i in low..high) helper[i] = array[i]

    var helperLeft = low
    var helperRight = middle + 1 // b) helper variables
    var current = low

    /*Iterate through helper array. Compare the left and right half, copying back the smaller element
    * from the two halves into original array*/

    while (helperLeft <= middle && helperRight <= high) { // c) condition to check helper left and helper right
        if (helper[helperLeft] <= helper[helperRight]) { // d) Check if value at helperLeft index is less than that of value at helper right
            array[current] = helper[helperLeft]
            helperLeft++
        } else { // e) right element is smaller than left element
            array[current] = helper[helperRight]
            helperRight++
        }
        current++
    }

//   f) copy the rest of leftside of array into target
    val remaining = middle - helperLeft
    for (i in 0..remaining) {
        array[current + i] = helper[helperLeft + i]
    }
}

fun quickSort(array: IntArray, left: Int, right: Int) {
    val index = partition (array, left, right)
    if(left < index-1) { // 2) Sorting left half
        quickSort(array, left, index-1)
    }
    if(index < right) { // 3) Sorting right half
        quickSort(array,index, right)
    }
}

private fun partition(array: IntArray, l: Int, r: Int): Int {
    var left = l
    var right = r
    val pivot = array[(left + right)/2] // 4) Pivot Point
    while (left <= right) {
        while (array[left] < pivot) left++ // 5) Find the elements on left that should be on right

        while (array[right] > pivot) right-- // 6) Find the elements on right that should be on left

        // 7) Swap elements, and move left and right indices
        if (left <= right) {
            swapArray(array, left,right)
            left++
            right--
        }
    }
    return left
}

private fun swapArray(a: IntArray, b: Int, c: Int) {
    val temp = a[b]
    a[b] = a[c]
    a[c] = temp
}