package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int num;
        ListSet<Integer> Obj = new ListSet<Integer>();
        System.out.println ("Enter number of elements:");
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        System.out.println ("Enter " + N + " elements:");
        num = in.nextInt();
        Obj.init(num);
        for (int i = 1; i < N; i++) {
            num = in.nextInt();
            Obj.addition_tail(num);
        }
        Obj.print_list();
        
        System.out.println("Chose:");
        System.out.println("1.Add from left");
        System.out.println("2.Add from right");
        System.out.println("3.Delete");
        System.out.println("4.Search for");
        
        num = in.nextInt();
        
        while (num<=0||num>4){
        	System.out.println("Err, try again");
        	num = in.nextInt();
        }
        
        if (num == 1) {
        	System.out.println("Enter insertable:");
        	num = in.nextInt();
        	Obj.addition_head(num);
        	System.out.println("New list:");
        	Obj.print_list();
        }
        else if (num == 2) {
        	System.out.println("Enter insertable:");
        	num = in.nextInt();
        	Obj.addition_tail(num);
        	System.out.println("New list:");
        	Obj.print_list();
        }
        else if (num == 3) {
        	System.out.println("Enter deletable:");
        	num = in.nextInt();
        	if (Obj.search(num)){
        		Obj.delete_elem(num);
        		System.out.println("New list:");
        		Obj.print_list();
        	}
        	else System.out.println("Elem not found!");
        }
        else if (num == 4) {
        	System.out.println("Enter searchable:");
        	num = in.nextInt();
        	if (Obj.search(num)) System.out.println("Elem found!");
        	else System.out.println("Elem not found!");
        }
    }
}