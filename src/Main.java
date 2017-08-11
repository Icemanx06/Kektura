import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


class turazok implements Comparable<turazok>{
    String[] nev;
    String szakasz;
    int nevszam;
 

    public turazok(String[] nev,String szakasz,int nevszam) {
        this.nev = nev;
        this.szakasz = szakasz;
        this.nevszam = nevszam;
    }

    public String[] getNev() {
        return nev;
    }

    public void setNev(String[] nev) {
        this.nev = nev;
    }

    public String getSzakasz() {
        return szakasz;
    }

    public void setSzakasz(String szakasz) {
        this.szakasz = szakasz;
    }

    public int getNevszam() {
        return nevszam;
    }

    public void setNevszam(int nevszam) {
        this.nevszam = nevszam;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(szakasz).append(":");
        for (int i = 0; i < nevszam; i++) {
            sb.append(" "+nev[i]);
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final turazok other = (turazok) obj;
        if (!Objects.equals(this.nev, other.nev)) {
            return false;
        }
        if (!Objects.equals(this.szakasz, other.szakasz)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(turazok o) {
    return this.szakasz.compareTo(o.szakasz);
    }
    
    
}
public class Main {
    public static void main(String[] args) {
//        try(Scanner sc = new Scanner(new File("sample.txt"))){
        try(Scanner sc = new Scanner(new File(args[0]))){
            LinkedList<turazok> list = new LinkedList<>(); 
              LinkedList<turazok> list2 = new LinkedList<>(); 
            while(sc.hasNextLine()){
                String[] darabok = sc.nextLine().split(";");
                
               String[] nev = new String[100];
                for (int i = 1; i < darabok.length; i++) {
                    String[] utak = darabok[i].split("-");
                    int result = utak[0].compareTo(utak[1]);
                    nev[0]=darabok[0];
                    if(result < 0){
                        
                       if(list.size()> 0){  
                       for (int j = 0; j < list.size(); j++) {
                        if(list.get(j).szakasz.equals(darabok[i])){
                         int index = list.get(j).nevszam;
                         list.get(j).nev[index]= nev[0];
                         list.get(j).nevszam++;
                        }
                        
                       }
                       list.add(new turazok(nev, darabok[i],1));
                       }else{
                       list.add(new turazok(nev, darabok[i],1));
                       }                 
                    }else if(result > 0){
                        String osszefuz = utak[1]+"-"+utak[0];
                           
                       if(list.size()> 0){  
                       for (int j = 0; j < list.size(); j++) {
                        if(list.get(j).szakasz.equals(osszefuz)){
                            int index = list.get(j).nevszam;
                         list.get(j).nev[index]= nev[0];
                         list.get(j).nevszam++;
                        }
                        
                       }
                       list.add(new turazok(nev, osszefuz,1));
                       }else{
                      list.add(new turazok(nev, osszefuz,1));
                       } 
                       
                    }
                    else{
                    nev[0]=darabok[0];
                    list.add(new turazok(nev, darabok[i],1));
                    }
                }
                

            }
            int legnagyobb = 0;
            for (turazok le : list) {
                if(le.nevszam > legnagyobb){
                    legnagyobb = le.nevszam;
                }
            }
            for (turazok l : list) {
                if(l.nevszam == legnagyobb)
                    list2.add(l);
            }
            
            Collections.sort(list2);
            for (int i = 0; i < list2.size(); i++) {
                for (int j = 0; j < list2.get(i).nevszam-1; j++) {
                    if((list2.get(i).nev[j].compareTo(list2.get(i).nev[j+1]))>0){
                      String csere = list2.get(i).nev[j+1];
                      list2.get(i).nev[j+1] = list2.get(i).nev[j];
                      list2.get(i).nev[j] = csere;
                    }
                }
            }
            
            for (turazok l : list2) {
                System.out.println(l);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }
}
