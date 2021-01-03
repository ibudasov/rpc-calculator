package Domain

class StackStateHistory {

    private var history: List<Stack>

    init {
        history = listOf()
    }

    fun saveStackState(stack: Stack) {

        val recreatedStack = stack.clone()

        history = listOf(recreatedStack).plus(history)
    }

    fun getLastSavedStackStateAndRemoveItFromHistory(): Stack {
        val last = history.last()

        history = history.drop(1)

        return last
    }
}