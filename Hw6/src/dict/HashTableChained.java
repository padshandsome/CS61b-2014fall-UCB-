/* HashTableChained.java */

package dict;

import List.*;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
   int size;//total number N
   int length=0;//stored length
   SList[] HashTable;


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/
  public int getPrime(int sizeEstimate)
  {
	  int prime=sizeEstimate;
	  while(!isPrime(prime))
	  {
		  prime++;
	  }
	  return prime;
  }
  public boolean isPrime(int num)
  {
	  if(num<=1) return false;
	  if(num==2) return true;
	  if(num==3) return true;
	  for(int i=2;i*i<=num;i++)
	  {
		  if(num%i==0) return false;
	  }
	  return true;
  }

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
	  size=getPrime(sizeEstimate);
	  HashTable=new SList[size];
	  for(int i=0;i<size;i++)
	  {
		  HashTable[i]=new SList();
	  }
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
	 this(100);
	 //System.out.println(size);
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
    return Math.abs(code)%size;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
	return length;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
	if(size()==0) return true;
	else return false;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
	int hashcode=compFunction(key.hashCode());
	Entry cur=new Entry();
	cur.key=key;
	cur.value=value;
	HashTable[hashcode].insertEnd(cur);
	length++;
    return cur;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
	 int hashcode=this.compFunction(key.hashCode());
	 if(HashTable[hashcode].isEmpty()) return null;
	 else return (Entry)HashTable[hashcode].front().item;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
	  int hashcode=this.compFunction(key.hashCode());
	  if(size<1) return null;
	  if(HashTable[hashcode].isEmpty()) return null;
	  else
	  {
		  SListNode idx=HashTable[hashcode].front();
		  Entry results;
		  if(idx.next==null)//说明只有一个
		  {
			  results=(Entry)idx.item;
			  idx=null;
			  return results;
		  }
		  else
		  {
			  results=(Entry)idx.item;
			  HashTable[hashcode].removeFront();
			  return results;
		  }
	  }
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
	  for(int i=0;i<size;i++)
	  {
		  HashTable[i]=new SList();
	  }
  }
  
  public static void main(String[] args)
  {
	  HashTableChained test=new HashTableChained();
	  System.out.println("TEST .getPrime(int): "+test.getPrime(6));
	  System.out.println("TEST .compFunction(int): "+test.compFunction(102));
	  test.insert(5, "hellomydear");
	  System.out.println("TEST insert&find: "+test.find(5).value);
	  test.insert(5,"kuaikuailele");
	  
	  System.out.println("TEST remove: "+test.remove(5).value);
  }

}