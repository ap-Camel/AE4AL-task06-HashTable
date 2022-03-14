@SuppressWarnings("Unchecked")
public class Hash_table {
    

    public Linked_list<wordInfo> words[];
    Linked_list<wordInfo> word;

    public Hash_table(int size) {
        words = new Linked_list[size];
    }


    public int hashing(String s) {
		
		int result = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			result += s.charAt(i) << (i & 15);
		}
		return result % words.length;
	}

    public void add(String str) {
        int index = hashing(str);
        boolean found = false;

        Linked_list<wordInfo>.Node<wordInfo> temp;
        if(words[index] != null) {
            temp = words[index].head;
            for(int i = 0; i < words[index].size; i++) {
                if(temp.data.word.equals(str)) {
                    temp.data.occurences++;
                    found = true;
                }
                temp = temp.next;
            }

            if(!found) {
                words[index].add(new wordInfo(str, 1));
            }

            temp = words[index].head;
        } else {
            word = new Linked_list<wordInfo>();
            word.add(new wordInfo(str, 1));
            words[index] = word;
        }
    }

    public void print() {
        for(int i = 0; i < words.length; i++) {
            Linked_list<wordInfo>.Node<wordInfo> temp = words[i].head;
            while(temp != null) {
                System.out.println(temp.data.word + " ==> " + temp.data.occurences);
                temp = temp.next;
            }
        }
    }

}
