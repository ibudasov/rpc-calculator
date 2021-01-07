package domain

class StackStateHistory {

    private var history: List<StackOfOperands>

    init {
        history = listOf()
    }

    fun saveStackState(stackOfOperands: StackOfOperands) {

        val recreatedStack = stackOfOperands.clone()

        history = listOf(recreatedStack).plus(history)
    }

    fun getLastSavedStackStateAndRemoveItFromHistory(): StackOfOperands {
        history = history.drop(1)

        return history.first()
    }
}