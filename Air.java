/**
 * @author Your Name Here
 * CS310
 * Fall 2017
 */

import java.util.*; //for Queue interface

/**
 * YOUR COMMENTS HERE
 * 
 * For the Queue interface, see http://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
 * and http://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html
 */
class Air<T> implements Queue<T>
{
  
  
  
  /**
   * Wikipedia claims max solo record is 13
   * see http://en.wikipedia.org/wiki/Juggling_world_records#Solo_records
   * Allowing room for growth...
   */
  public static final int MAX_CAPACITY = 15;
  
  private ListItem<T> head;
  
  private ListItem<T> tail;
  
  private int size = 0;
  
  /**
   * 
   */
  
  public T getHead(){
    
    return head.item;
    
  }
  
  public T getNext(){
    
    return head.next.item;
    
  }
  
  private class ListItem<T>
  {
    
    private T item;
    
    private ListItem<T> next;
    
    private ListItem(T item){
      
      this.item = item;
      
    }
    
  }
  
  
  public boolean add(T item){
    
    if (size == MAX_CAPACITY){
      
      throw new IllegalStateException();
      
    }
    
    ListItem<T> theItem = new ListItem<>(item);
    
    if (head == null){
      
      head = theItem;
      
      tail = theItem;
      
    }
    
    else{
      
      tail.next = theItem;
      
      tail = tail.next;
      
    }
    
    size++;
    
    return true;
    
  }
  
  public boolean offer(T item){
    
    try{
      
      add(item);
      
      return true;
      
    }
    
    catch(IllegalStateException e){
      
      return false;
      
    }
  }
  
  public T remove(){
    
    if (size == 0){
      
      throw new NoSuchElementException();
      
    }
    
    T placeHolder = head.item;
    
    ListItem oldHead = head;
    
    if (size == 1){
      
      head = tail = null;
      
      size--;
      
      return placeHolder;
      
    }
    
    head = head.next;
    
    size--;
    
    return placeHolder;
    
  }
  
  public T poll(){
    
    try{
      
      T removedItem = remove();
      
      return removedItem;
      
    }
    
    catch (NoSuchElementException e){
      
      return null;
      
    }
    
  }
  
  public T element(){
    
    if (size == 0){
      
      throw new NoSuchElementException();
      
    }
    
    return head.item;
    
  }
  
  public T peek(){
    
    try{
      
      T retrievedItem = element();
      
      return retrievedItem;
      
    }
    
    catch (NoSuchElementException e){
      
      return null;
      
    }
    
  }
  
  public String toString(){
    
    ListItem<T> current = head;
    
    String theString = "" ;
    
    while (current != null){
      
      theString += current.item + "\n";
      
      current = current.next;
      
    }
    
    return theString;
    
  }
  
  public void clear(){
    
    head = tail = null;
    
    size = 0;
    
  }
  
  public boolean isEmpty(){
    
    if (size == 0){
      
      return true;
      
    }
    
    return false;
    
  }
  
  public int size(){
    
    return size;
    
  }
  
  public Object[] toArray(){
    
    Object[] theArray = new Object[size-1];
    
    ListItem<T> current = head;
    
    String theString = "" ;
    
    for (int i = 0; i < size; i++){
      
      theArray[i] = current.item;
      
      current = current.next;
      
    }
    
    return theArray;
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  /*-------------- DO NOT CHANGE ANYTHING BELOW THIS LINE --------------*/
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public boolean addAll(Collection<? extends T> c)  
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public boolean contains(Object o)
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public boolean containsAll(Collection<?> c)
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public boolean equals(Object o)
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public int hashCode()
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public Iterator<T> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public boolean remove(Object o)
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public boolean removeAll(Collection<?> c)
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public boolean retainAll(Collection<?> c)
  {
    throw new UnsupportedOperationException();
  }
  
  /**
   * DO NOT CHANGE THIS, no comment needed
   */
  public <E> E[] toArray(E[] a)
  {
    throw new UnsupportedOperationException();
  }
}
