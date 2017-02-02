package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterate element to array.
 * 
 * @author Dacharat Pankong
 *
 * @param <T>
 * 			the type of elements that returned by this iterator.
 */

public class ArrayIterator<T> implements Iterator<T> {
	 /** attribute for the array we want to iterate over */
	 private T[ ] array;
	 /** check that remove() can be use or not */
	 private boolean check;
	 /** the position in element */
	 private int cursor;
	 /**
	 * Initialize a new array iterator with the array to process.
	 * @param array is the array to iterate over
	 */
	 public ArrayIterator(T[] array) {
		 this.array = array;
		 this.check = false;
		 this.cursor = 0;
	 }
	 /**
	 * Return the next non-null element from array, if any.
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException 
	 * 				if there are no more elements to return.
	 * 
	 */
	 @Override
	 public T next( ) {
		 if(this.hasNext()){
			 T next = this.array[cursor];
			 this.check = true;
			 this.cursor++;
			 return next;
		 }else
			 throw new NoSuchElementException();
	 }
	 /**
	  * check if there is next element in array
	  * 
	  * @return true if there is next element.
	  * 		false if there is not next element. 
	  */
	 @Override
	 public boolean hasNext(){
		 for(int i = this.cursor; i<array.length; i++){
			 if(this.array[i] != null){
				 this.cursor = i;
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 /**
	  * Remove last element by setting it to null.
	  * 
	  * @throws NoSuchElementException
	  * 			if no elemnt to return.
	  */
	 public void remove(){
		 if(check){
			 array[cursor-1] = null;
			 check = false;
		 }else
			 throw new NoSuchElementException();
	 }
	 

	
}
