package TestFolder;
import java.util.*;

public class WorkerAgeComparator implements Comparator<Worker>{
  public int compare(Worker o1, Worker o2){
    if(o1.age>o2.age){return -1;}
    else if(o1.age==o2.age){return 0;}
    else{return 1;}
  }
}
