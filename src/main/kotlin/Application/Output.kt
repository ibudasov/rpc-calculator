package Application

import Domain.Stack

interface Output {

    /**
     * Having stack as an output gives me a lot of possibilities: I can transform it to a
     * string and output in in CLI, or encode to JSON and output in web
     */
    fun outputStack(stack: Stack)
}