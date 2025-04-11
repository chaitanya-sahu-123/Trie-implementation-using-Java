
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("TRIE IMPLEMENTATION");
		System.out.println("Type 0 to exit");
		System.out.println("Type 1 to insert");
		System.out.println("Type 2 to check if word exists in trie");
		System.out.println("Type 3 to print all words");
		System.out.println("Type 4 to search for words with specified prefix");
		int oper=sc.nextInt();
		Trie root=new Trie();
		while(oper!=0){
    		if(oper==1){
    		    System.out.println("Enter a string to insert");
    		    String inp=sc.next();
    		    insert(root,inp);
    		}
    		else if(oper==2){
    		    System.out.println("Enter a string to check if it exists fully in the trie");
    		    String s=sc.next();
    		    System.out.println(doesExist(root,s));
    		}
    		else if(oper==3){
    		    List<String>li=new ArrayList<>();
    		    String inp="";
    		    help(root,li,inp);
    		    System.out.println("All the words in the trie are");
    		    for(String temp:li){
    		        System.out.println(temp);
    		    }
    		}
    		else if(oper==4){
    		    List<String>li=new ArrayList<>();
    		    System.out.println("Enter the prefix string");
    		    String inp=sc.nextLine();
    		    solver(root,li,inp);
    		    for(String temp:li){
    		        System.out.println(temp);
    		    }
    		    
    		}
    		System.out.println("Enter the next operation value");
    		oper=sc.nextInt();
    		sc.nextLine();
		}
	}
	public static void solver(Trie root,List<String>li,String s){
	    Trie te=root;
		for(char ci:s.toCharArray())
		{
			int ind=ci-'a';
			if(te.ch[ind]==null) return;
			te=te.ch[ind];
		}
		help(te,li,s);
	}
	public static void insert(Trie root,String s){
	    Trie te=root;
	    for(char ci:s.toCharArray()){
	        int idx=(char)(ci-'a');
	        if(te.ch[idx]==null){
	            te.ch[idx]=new Trie();
	        }
	        te=te.ch[idx];
	        te.wc++;
	    }
	    te.ended=true;
	}
	public static void help(Trie root,List<String>li,String te){
	    if(root.ended==true){
	        li.add(te);
	    }
	    for(int i=0;i<26;i++){
	        if(root.ch[i]!=null){
	            char cha=(char)(i+'a');
	            help(root.ch[i],li,te+cha);
	        }
	    }
	}
	
	public static boolean doesExist(Trie root,String s){
	    Trie te=root;
	    for(char ci:s.toCharArray()){
	        int idx=ci-'a';
	        if(te.ch[idx]==null){
	            return false;
	        }
	        te=te.ch[idx];
	    }
	    return te.ended;
	}
}

class Trie{
    int wc;
    Trie ch[];
    boolean ended;
    Trie(){
        wc=0;
        ch=new Trie[26];
        ended=false;
    }
}
