package domain

class StackStateHistory {

    private var history: MutableList<StackOfOperands> = mutableListOf()

    fun saveStackState(stackOfOperands: StackOfOperands) {
        val clonedStack = stackOfOperands.clone()

        history.add(clonedStack as StackOfOperands)
    }

    fun getLastSavedStackStateAndRemoveItFromHistory(): StackOfOperands {
        history = history.dropLast(1).toMutableList()

        return history.last()
    }
}