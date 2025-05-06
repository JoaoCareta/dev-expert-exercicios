class LinkedList<T>(private var value: T) {
    private var linkedListHead: Node<T>?
    private var linkedListTail: Node<T>?
    var linkedListSize: Int = 0
        private set

    init {
        val newNode = Node(this.value)
        this.linkedListHead = newNode
        this.linkedListTail = newNode
        incrementLinkedListLength()
    }

    fun linkedListAppendNode(value: T) {
        val newNode = Node(value)
        moveLinkedListTailPointer(newNode)
        incrementLinkedListLength()
    }

    fun linkedListPrependNode(value: T) {
        val newNode = Node(nodeValue = value)
        moveLinkedListHeadPointer(newNode)
        incrementLinkedListLength()
    }

    fun getElementAtIndex(index: Int): Node<T>? {
        if (index < 1 || index > linkedListSize) return null
        var currentIndex = 1
        var currentNode = linkedListHead
        while (currentIndex != index) {
            currentNode = currentNode?.nextNode
            currentIndex++
        }
        return currentNode
    }

    fun addElementAtIndex(index: Int, value: T) {
        when {
            index <= 1 -> linkedListPrependNode(value)
            index >= linkedListSize -> linkedListAppendNode(value)
            else -> {
                val newNode = Node(value)
                val targetIndex = index-1
                val nodeBeforeInsertion = getElementAtIndex(targetIndex)
                newNode.nextNode = nodeBeforeInsertion?.nextNode
                nodeBeforeInsertion?.nextNode = newNode
                incrementLinkedListLength()
            }
        }
    }

    fun indexOfElement(nodeValue: T): Int {
        var currentIndex = 1
        var currentNode = linkedListHead
        while (currentNode != null) {
            if (currentNode.nodeValue == nodeValue) return currentIndex
            currentNode = currentNode.nextNode
            currentIndex++
        }
        return -1
    }

    fun removeElementAtIndex(index: Int): Boolean {
        return when {
            (index <= 0) or (index > linkedListSize) -> false
            index == 1 -> removeElementAtBeginning()
            index == linkedListSize -> removeElementAtEnd()
            else -> {
                val previousNode = getElementAtIndex(index-1)
                previousNode?.nextNode = previousNode?.nextNode?.nextNode
                decrementLinkedListLength()
                true
            }
        }
    }

    private fun removeElementAtBeginning(): Boolean {
        linkedListHead = linkedListHead?.nextNode
        decrementLinkedListLength()
        return true
    }

    private fun removeElementAtEnd(): Boolean {
        val previousNode = getElementAtIndex(linkedListSize-1)
        linkedListTail = previousNode
        linkedListTail?.nextNode = null
        decrementLinkedListLength()
        return true
    }

    fun removeElement(nodeValue: T): Boolean {
        return if (!isEmpty()) {
            var currentNode = linkedListHead
            var currentIndex = 1
            while (currentNode != null) {
                if (currentNode.nodeValue == nodeValue) {
                    removeElementAtIndex(currentIndex)
                     return true
                }
                currentIndex += 1
                currentNode = currentNode.nextNode
            }
            return false
        } else false
    }

    fun contains(nodeValue: T): Boolean {
        return indexOfElement(nodeValue) != -1
    }

    fun isEmpty(): Boolean {
        return linkedListSize <= 0
    }

    fun clearLinkedList() {
        this.linkedListHead = null
        this.linkedListSize = 0
    }

    private fun moveLinkedListTailPointer(newNode: Node<T>) {
        linkedListTail?.nextNode = newNode
        linkedListTail = newNode
    }

    private fun moveLinkedListHeadPointer(newNode: Node<T>) {
        newNode.nextNode = linkedListHead
        linkedListHead = newNode
    }

    private fun incrementLinkedListLength() {
        linkedListSize += 1
    }

    private fun decrementLinkedListLength() {
        linkedListSize -= 1
    }

    override fun toString(): String {
        var stringLinkedList = "["
        var nodes = linkedListHead
        while (nodes != null) {
            nodes.nextNode?.let { _ ->
                stringLinkedList += "${nodes?.nodeValue.toString()} ---> "
            } ?: run {
                stringLinkedList += nodes?.nodeValue.toString()
            }
            nodes = nodes.nextNode
        }
        stringLinkedList += "]"
        return stringLinkedList
    }
}

data class Node<T>(
    var nodeValue: T,
    var nextNode: Node<T>? = null
) {
    override fun toString(): String {
        return nodeValue.toString()
    }
}