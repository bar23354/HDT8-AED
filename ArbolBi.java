/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - sección 40
 * Roberto Barreda - 23354
 */

 //import java.util.PriorityQueue;
 class ArbolBi<E extends Comparable<E>> implements PriorityQueue<E> {
    private java.util.Vector<E> data;

    public ArbolBi() {
        data = new java.util.Vector<>();
    }
    
    /** 
     * @param value
     * @return boolean
     */
    @Override
    public boolean add(E value) {
        data.add(value);
        int index = data.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (data.get(index).compareTo(data.get(parentIndex)) >= 0) break;
            E temp = data.get(index);
            data.set(index, data.get(parentIndex));
            data.set(parentIndex, temp);
            index = parentIndex;
        }
        return true;
    }
    
    /** 
     * @return E
     */
    @Override
    public E remove() {
        if (data.isEmpty()) return null;
        E result = data.get(0);
        E last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            int index = 0;
            while (index < data.size() / 2) {
                int leftChild = 2 * index + 1;
                int rightChild = leftChild + 1;
                int minChild = leftChild;
                if (rightChild < data.size() && data.get(rightChild).compareTo(data.get(leftChild)) < 0) {
                    minChild = rightChild;
                }
                if (data.get(index).compareTo(data.get(minChild)) <= 0) break;
                E temp = data.get(index);
                data.set(index, data.get(minChild));
                data.set(minChild, temp);
                index = minChild;
            }
        }
        return result;
    }
    
    /** 
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    } 
    
    /** 
     * @return int
     */
    @Override
    public int size() {
        return data.size();
    }
}
 