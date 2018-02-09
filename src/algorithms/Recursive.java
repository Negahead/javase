package algorithms;

public class Recursive {
    public static void main(String[] args) {
        System.out.println(recursive(5));
    }

    /**
     * there is no performance benefit using recursive,in face,loops are sometimes better for performance.
     * Recursion is not intrinsically better or worse than loops - each has advantages and disadvantages,
     *
     * Technically, iterative loops fit typical computer systems better at the hardware level: at the machine code level,
     * a loop is just a test and a conditional jump, whereas recursion (implemented naively) involves pushing a stack frame,
     * jumping, returning, and popping back from the stack. OTOH, many cases of recursion (especially those that are
     * trivially equivalent to iterative loops) can be written so that the stack push / pop can be avoided;
     * this is possible when the recursive function call is the last thing that happens in the function body before
     * returning, and it's commonly known as a tail call optimization (or tail recursion optimization). A properly
     * tail-call-optimized recursive function is mostly equivalent to an iterative loop at the machine code level.
     *
     * Comparing recursion to iteration is like comparing a phillips head screwdriver to a flat head screwdriver
     *
     * However, one concern people have with the use of recursive functions is the growth of stack space. Indeed, some
     * classes of recursive functions will grow the stack space linearly with the number of times they are called --
     * there is one class of function though, tail-recursive functions, in which stack size remains constant no matter how deep the recursion is.
     *
     * A function call (recursive or not) that is the last thing a function does is called a tail-call. Recursion using tail-calls is called tail-recursion.
     *
     * The idea of removing stack frames after tail-calls is called tail-call optimization.
     * It seems that once control is passed to the tail-called function, nothing in the stack is useful anymore.
     * The function's stack frame, while it still takes up space, is actually useless at this point,
     * therefore the tail-call optimization is to overwrite the current stack frame with the next one when making a
     * function call in tail position while keeping the original return address.
     *
     *
     * Graph algorithms are some of the most useful algorithms.
     *
     */
    private static int recursive(int i) {
        /**
         * base case,A base case is the bottom point of a recursive program where the operation is so trivial as to
         * be able to return an answer directly.
         *
         *
         * when you call a function from another function,the calling function is paused in a partially completed state,
         * All the values of the variables for that function are still stored in memory
         *
         *
         *
         * http://www.tenouk.com/Bufferoverflowc/Bufferoverflow2.html
         */
        if(i == 1) {
            return 1;
        }
        /**
         * recursive case
         */
        return i * recursive(i-1);// tail call,the return value of recursive() is used as the return value for this function.
    }
}
