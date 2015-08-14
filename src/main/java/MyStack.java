/**
 * Implement without using any Java collections classes
 * i.e. don't import anything from java.util.*
 *
 */
public class MyStack {
  
  
  int top = -1;
  int size = 10;
  Object[] stack = new Object[size];  
  
  /**
   * 
   * @param item
   */
    public synchronized void push(Object item){
      if(top >= size - 1) {
        throw new RuntimeException("Stack is full");
      }
      stack[++top] = item;
    }
    
    /**
     * If the stack is empty throw a StackEmptyException
     */
    public synchronized Object pop(){
      if(top == -1) {
        throw new StackEmptyException();
      }
      Object result = stack[top--];
      return result;
    }
    
    /**
     * If the stack is empty throw a StackEmptyException
     */
    public synchronized Object peek(){
      return stack[top];
    }
    
    /**
     * 
     */
    public static class StackEmptyException extends RuntimeException
    {
      
    }
    
    public static void main(String[] args) throws Exception{
    MyStack ms = new MyStack();
    
    ms.push("one");
    ms.push("two");
    
    try
    {
      assert "two".equals(ms.peek());
      assert "two".equals(ms.pop());
      assert "o1ne".equals(ms.pop());
    }
    catch(StackEmptyException e )
    {
      
    }
    ms.pop();
    //assert that ms.pop() throws an exception
  }
}