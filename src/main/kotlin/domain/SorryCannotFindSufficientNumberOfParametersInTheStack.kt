package domain

import domain.operation.Operation

class SorryCannotFindSufficientNumberOfParametersInTheStack(operation: Operation, position: Int) : Exception(
    "operator " + operation.operationLiteral()
            + " (position: " + position.toString()
            + "): insucient parameters"
) {}