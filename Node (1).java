public class Node<E> {
    
    E element;
    Node<E> next;
    public Node(E e){
        element = e;
        
        
    }
    
    public String toString(){
        
        return "" + element;
        
    }
    
}