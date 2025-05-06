import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LinkedListTest {
    @Test
    fun `given creating a new Int LinkedList with one element, then the linkedList size should be one`() {
        // Given
        val newLinkedList = LinkedList(1)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 1)
        assertTrue(newLinkedList.contains(1))
        assertFalse(newLinkedList.isEmpty())
    }

    @Test
    fun `given a linkedList, when the user append a node, then the size should increment and the list must contain the element in the correct index`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertFalse(newLinkedList.isEmpty())

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
        }

        assertTrue {
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(3) == 3)
            (newLinkedList.indexOfElement(4) == 4)
            (newLinkedList.indexOfElement(5) == 5)
        }
    }

    @Test
    fun `given a linkedList, when the user prepend a node, then the size should increment and the list must contain the element in the correct index`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListPrependNode(2)
        newLinkedList.linkedListPrependNode(3)
        newLinkedList.linkedListPrependNode(4)
        newLinkedList.linkedListPrependNode(5)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertFalse(newLinkedList.isEmpty())

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
        }

        assertTrue {
            (newLinkedList.indexOfElement(1) == 5)
            (newLinkedList.indexOfElement(2) == 4)
            (newLinkedList.indexOfElement(3) == 3)
            (newLinkedList.indexOfElement(4) == 2)
            (newLinkedList.indexOfElement(5) == 1)
        }
    }


    @Test
    fun `given a linkedList, when the user wants to get an element in a valid index, then it should return the element`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Test
        val result = newLinkedList.getElementAtIndex(3)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertFalse(newLinkedList.isEmpty())
        assertEquals(result?.nodeValue, 3)

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
        }
    }

    @Test
    fun `given a linkedList, when the user wants to get an element in an index higher than the linkedList size, then it should return null`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Test
        val result = newLinkedList.getElementAtIndex(7)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertFalse(newLinkedList.isEmpty())
        assertEquals(result?.nodeValue, null)

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
        }
    }

    @Test
    fun `given a linkedList, when the user wants to get an element in empty linkedList size, then it should return null`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.clearLinkedList()

        // Test
        val result = newLinkedList.getElementAtIndex(0)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 0)
        assertTrue(newLinkedList.isEmpty())
        assertEquals(result?.nodeValue, null)

        assertFalse {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
        }
    }

    @Test
    fun `given a linkedList, when the user wants to get an element in invalid index, then it should return null`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Test
        val result = newLinkedList.getElementAtIndex(0)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertFalse(newLinkedList.isEmpty())
        assertEquals(result?.nodeValue, null)

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
        }
    }

    @Test
    fun `given a linkedList, when the user add an element at index less then 1, then it should prepend the element`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Test
        newLinkedList.addElementAtIndex(0, 999)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 6)
        assertFalse(newLinkedList.isEmpty())

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(999) == 1)
            (newLinkedList.indexOfElement(1) == 2)
            (newLinkedList.indexOfElement(2) == 3)
            (newLinkedList.indexOfElement(3) == 4)
            (newLinkedList.indexOfElement(4) == 5)
            (newLinkedList.indexOfElement(5) == 6)
        }
    }

    @Test
    fun `given a linkedList, when the user add an element at index equals 1, then it should prepend the element`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Test
        newLinkedList.addElementAtIndex(1, 999)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 6)
        assertFalse(newLinkedList.isEmpty())

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(999) == 1)
            (newLinkedList.indexOfElement(1) == 2)
            (newLinkedList.indexOfElement(2) == 3)
            (newLinkedList.indexOfElement(3) == 4)
            (newLinkedList.indexOfElement(4) == 5)
            (newLinkedList.indexOfElement(5) == 6)
        }
    }

    @Test
    fun `given a linkedList, when the user add an element at index higher than the linkedListSize, then it should append the element`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Test
        newLinkedList.addElementAtIndex(10, 999)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 6)
        assertFalse(newLinkedList.isEmpty())

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(999) == 6)
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(3) == 3)
            (newLinkedList.indexOfElement(4) == 4)
            (newLinkedList.indexOfElement(5) == 5)
        }
    }

    @Test
    fun `given a linkedList, when the user add an element at index, then it should add the element in the correct index`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Test
        newLinkedList.addElementAtIndex(3, 999)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 6)
        assertFalse(newLinkedList.isEmpty())

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(999) == 3)
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(3) == 4)
            (newLinkedList.indexOfElement(4) == 5)
            (newLinkedList.indexOfElement(5) == 6)
        }
    }

    @Test
    fun `given a linkedList, when the user wants to remove the first element, then it should be able to removed and return true`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.linkedListAppendNode(999)

        // Test
        val result = newLinkedList.removeElementAtIndex(1)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertTrue(result)
        assertFalse(newLinkedList.isEmpty())
        assertFalse(newLinkedList.contains(1))

        assertTrue {
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(2) == 1)
            (newLinkedList.indexOfElement(3) == 2)
            (newLinkedList.indexOfElement(4) == 3)
            (newLinkedList.indexOfElement(5) == 4)
            (newLinkedList.indexOfElement(999) == 5)
        }
    }

    @Test
    fun `given a linkedList, when the user wants to remove the last element, then it should be able to removed and return true`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.linkedListAppendNode(999)

        // Test
        val result = newLinkedList.removeElementAtIndex(6)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertTrue(result)
        assertFalse(newLinkedList.isEmpty())
        assertFalse(newLinkedList.contains(999))

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
        }

        assertTrue {
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(3) == 3)
            (newLinkedList.indexOfElement(4) == 4)
            (newLinkedList.indexOfElement(5) == 5)
        }
    }

    @Test
    fun `given a linkedList, when the user pass an valid index, then it remove the element should return true`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.linkedListAppendNode(999)

        // Test
        val result = newLinkedList.removeElementAtIndex(3)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertTrue(result)
        assertFalse(newLinkedList.isEmpty())
        assertFalse(newLinkedList.contains(3))

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(4) == 3)
            (newLinkedList.indexOfElement(5) == 4)
            (newLinkedList.indexOfElement(999) == 5)
        }
    }

    @Test
    fun `given a linkedList, when the user pass an invalid index less or equals zero, then it should return false`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.linkedListAppendNode(999)

        // Test
        val result = newLinkedList.removeElementAtIndex(0)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 6)
        assertFalse(result)
        assertFalse(newLinkedList.isEmpty())

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(3) == 3)
            (newLinkedList.indexOfElement(4) == 4)
            (newLinkedList.indexOfElement(5) == 5)
            (newLinkedList.indexOfElement(999) == 6)
        }
    }

    @Test
    fun `given a linkedList, when the user pass an invalid index higher than linkedListSize, then it should return false`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.linkedListAppendNode(999)

        // Test
        val result = newLinkedList.removeElementAtIndex(10)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 6)
        assertFalse(result)
        assertFalse(newLinkedList.isEmpty())

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(3) == 3)
            (newLinkedList.indexOfElement(4) == 4)
            (newLinkedList.indexOfElement(5) == 5)
            (newLinkedList.indexOfElement(999) == 6)
        }
    }

    @Test
    fun `given an empty linkedList, when the user tries to remove an element, then it should return false`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.linkedListAppendNode(999)
        newLinkedList.clearLinkedList()

        // Run Testing
        val result = newLinkedList.removeElement(999)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 0)
        assertTrue(newLinkedList.isEmpty())
        assertFalse(result)
    }

    @Test
    fun `given an linkedList, when the user tries to remove an element which the list does not contains, then it should return false`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.linkedListAppendNode(999)

        // Run Testing
        val result = newLinkedList.removeElement(998)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 6)
        assertFalse(newLinkedList.isEmpty())
        assertFalse(newLinkedList.contains(998))
        assertFalse(result)

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
            newLinkedList.contains(999)
        }

        assertTrue {
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(3) == 3)
            (newLinkedList.indexOfElement(4) == 4)
            (newLinkedList.indexOfElement(5) == 5)
            (newLinkedList.indexOfElement(999) == 6)
        }
    }

    @Test
    fun `given an linkedList, when the user tries to remove an element which the list contains, then it should return true`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.linkedListAppendNode(999)

        // Run Testing
        val result = newLinkedList.removeElement(999)

        // Assert
        assertEquals(newLinkedList.linkedListSize, 5)
        assertFalse(newLinkedList.isEmpty())
        assertFalse(newLinkedList.contains(999))
        assertTrue(result)

        assertTrue {
            newLinkedList.contains(1)
            newLinkedList.contains(2)
            newLinkedList.contains(3)
            newLinkedList.contains(4)
            newLinkedList.contains(5)
        }

        assertTrue {
            (newLinkedList.indexOfElement(1) == 1)
            (newLinkedList.indexOfElement(2) == 2)
            (newLinkedList.indexOfElement(3) == 3)
            (newLinkedList.indexOfElement(4) == 4)
            (newLinkedList.indexOfElement(5) == 5)
        }
    }

    @Test
    fun `given a linkedList with single element, when toString is called, then it should return correct format`() {
        // Given
        val newLinkedList = LinkedList(1)

        // Test
        val result = newLinkedList.toString()

        // Assert
        assertEquals("[1]", result)
    }

    @Test
    fun `given an empty linkedList, when toString is called, then it should return empty list format`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.clearLinkedList()

        // Test
        val result = newLinkedList.toString()

        // Assert
        assertEquals("[]", result)
    }

    @Test
    fun `given a linkedList with multiple elements, when toString is called, then it should return correct format with arrows`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)

        // Test
        val result = newLinkedList.toString()

        // Assert
        assertEquals("[1 ---> 2 ---> 3 ---> 4 ---> 5]", result)
    }

    @Test
    fun `given a linkedList with different types, when toString is called, then it should return correct format`() {
        // Given
        val newLinkedList = LinkedList("Hello")
        newLinkedList.linkedListAppendNode("World")
        newLinkedList.linkedListAppendNode("!")

        // Test
        val result = newLinkedList.toString()

        // Assert
        assertEquals("[Hello ---> World ---> !]", result)
    }

    @Test
    fun `given a linkedList after removing elements, when toString is called, then it should return correct format`() {
        // Given
        val newLinkedList = LinkedList(1)
        newLinkedList.linkedListAppendNode(2)
        newLinkedList.linkedListAppendNode(3)
        newLinkedList.linkedListAppendNode(4)
        newLinkedList.linkedListAppendNode(5)
        newLinkedList.removeElement(3)
        newLinkedList.removeElement(5)

        // Test
        val result = newLinkedList.toString()

        // Assert
        assertEquals("[1 ---> 2 ---> 4]", result)
    }

    @Test
    fun `given a node with Int value, when toString is called, then it should return string representation of the number`() {
        // Given
        val node = Node(42)

        // Test
        val result = node.toString()

        // Assert
        assertEquals("42", result)
    }

    @Test
    fun `given a node with String value, when toString is called, then it should return the string value`() {
        // Given
        val node = Node("Hello World")

        // Test
        val result = node.toString()

        // Assert
        assertEquals("Hello World", result)
    }

    @Test
    fun `given a node with Boolean value, when toString is called, then it should return string representation of boolean`() {
        // Given
        val nodeTrue = Node(true)
        val nodeFalse = Node(false)

        // Test
        val resultTrue = nodeTrue.toString()
        val resultFalse = nodeFalse.toString()

        // Assert
        assertEquals("true", resultTrue)
        assertEquals("false", resultFalse)
    }

    @Test
    fun `given a node with Float value, when toString is called, then it should return string representation of the float`() {
        // Given
        val node = Node(3.14f)

        // Test
        val result = node.toString()

        // Assert
        assertEquals("3.14", result)
    }

    @Test
    fun `given a node with null value, when toString is called, then it should return string null`() {
        // Given
        val node = Node<String?>(null)

        // Test
        val result = node.toString()

        // Assert
        assertEquals("null", result)
    }

    @Test
    fun `given a node with custom object, when toString is called, then it should return string representation of the object`() {
        // Given
        data class TestObject(val id: Int, val name: String)
        val customObject = TestObject(1, "Test")
        val node = Node(customObject)

        // Test
        val result = node.toString()

        // Assert
        assertEquals("TestObject(id=1, name=Test)", result)
    }
}