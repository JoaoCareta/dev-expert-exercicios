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
        if (isEmpty()) {
            setEmptyLinkedListHeadAndTail(newNode)
        } else {
            moveLinkedListTailPointer(newNode)
        }
        incrementLinkedListLength()
    }

    fun isEmpty(): Boolean {
        return linkedListSize <= 0
    }

    private fun setEmptyLinkedListHeadAndTail(newNode: Node<T>) {
        this.linkedListHead = newNode
        this.linkedListTail = newNode
    }

    private fun moveLinkedListTailPointer(newNode: Node<T>) {
        linkedListTail?.nextNode = newNode
        linkedListTail = newNode
    }

    private fun incrementLinkedListLength() {
        linkedListSize += 1
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