import java.util.Hashtable;

public class HashTableClass {

  int hashcode;

  HashTableClass(int hashcode) {

    this.hashcode = hashcode;

  }

  public int hashCode() {

    return hashcode;

  }

  public String toString() {

    return hashcode + " ";

  }

  public static void main(String[] args) {

    Hashtable ht = new Hashtable();

    ht.put(new HashTableClass(10), "Java");

    ht.put(new HashTableClass(3), "C");

    ht.put(new HashTableClass(4), "C++");

    ht.put(new HashTableClass(5), "Ruby");

    ht.put(new HashTableClass(6), "null");

    System.out.println(ht);

  }

}