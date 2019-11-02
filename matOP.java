
package determ;

import static determ.Determ.choose;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Determ {
           static Scanner input ;
            static Scanner choose;
            static Scanner choose2;
            
    public static void main(String[] args) throws FileNotFoundException {
        
          Scanner input1 = new Scanner(System.in);
                    System.out.println("Enter the sourece ");
                    String path = input1.nextLine();
                    try {
         input = new Scanner (new File(path),"unicode");
         
        
             menu1(); 
            
               }catch(FileNotFoundException a){
            System.out.println("File Not Found ..!");
        } 
            catch(InputMismatchException a){
                System.out.println("Please input a Number..!");
                menu1();
            }
        catch(Exception e) {
            System.out.println("Error");
           menu1();
        }     

        
    }
    
public static void menu1 () throws FileNotFoundException{

             System.out.println("A - Main menu : ");
            System.out.println("\t1- View Information of Programme");
            System.out.println("\t2-Exit The Programme");
            choose =  new Scanner(System.in);
            int a = choose.nextInt();
             switch(a){
                  case 1:Menu(); 
                  break;
                  case 2: System.exit(0);
                  break;
                  default :System.out.println("Not Found ... Choose from the list ");
                  break;
             }
          
}
    public static void Menu() throws FileNotFoundException {
        try{
        System.out.println("B-Information menu");
        System.out.println("\t1-File Size");
        System.out.println("\t2-Number of Words");
        System.out.println("\t3-Number of charactars");
        System.out.println("\t4-Number of lines");
        System.out.println("\t5-Number of UpperCase Charactars");
        System.out.println("\t6-Number of White Spaces");
        System.out.println("\t7-Word Occurance");
        System.out.println("\t8-Back");
        
        choose2 =  new Scanner(System.in);
        int a  ;
//        if(choose2.hasNextInt()){
       while(true){
                    input = new Scanner (new File("input.txt"),"unicode");

           a = choose2.nextInt();
        switch(a) {
            case 1:System.out.println("File size is :" + Size() + "KB");
            break;
            case 2: System.out.println("Number of file's Words is :" + numOfwords());
            break;
            case 3:System.out.println("Number of Character is :" +  numOfChar());
            break;
            case 4:System.out.println("Number of lines is :" + numOfline()); 
            break;
            case 5:System.out.println("Number of UpperCase letters is " + numOfUpperCase());
            break;
            case 6:System.out.println("Number of White Spaces is " + numOfWhiteSpaces());
            break;
            case 7:System.out.println("Number of word you entered is " + Woccurance());
            break;
            case 8:menu1();
            break;
            default:System.out.println("You must Enter a Number From 1-8");
        }
        }
//       }
//        else
//          1  System.out.println("Error ... choose from the list");
        } catch(InputMismatchException a){
            System.out.println("Please input a number ..!");
            Menu();
        }
        catch(Exception a){
        System.out.println("Error");
        menu1();
    }
        
        
        
        
        }
    public static int Size() {
     int count=0;
    while (input.hasNextLine()){
        String line = input.nextLine();
        for (int i = 0; i < line.length(); i++) {
            count++;
        }
    
    }    int size = 2+2*count;     
     return size;  }
    public static int numOfChar( ){
       
        int count=0;
        String s;
        while(input.hasNextLine()){
        s = input.nextLine();
            for (int i = 0; i < s.length(); i++) 
                count++;
        }
    return count; }
    public static int numOfwords(){
          int line=0;
          String word;
         while (input.hasNext()){
              word = input.next();
             line++;
         }
    
         
    return line;
    }        
    public static int numOfline(){
        int line  = 0 ;
        while (input.hasNext()){
            String lne = input.nextLine();
          line++;
          
      }

    return line;}
    public static int numOfUpperCase() {
     int count=0;
     while (input.hasNextLine()){
         String word = input.nextLine();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)))
             count++;
        }
     }
    return count; }
    public static int numOfWhiteSpaces() {
     int count=0;
        while (input.hasNextLine()){
            String s = input.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if(Character.isWhitespace(s.charAt(i)))
                  count++;  
            }
            if (input.hasNextLine())
                count++;        
        }
    return count;
    }
    public static int Woccurance () {
    Scanner word = new Scanner (System.in);
        System.out.println("Enter the word");
//         String wrd;
         String searchedWord = word.next();
         int count = 0;
        while (input.hasNext()){
             int a =input.next().compareTo(searchedWord);
             if(a ==0 )
                 count++;
    }
    return count;}   
}

