public class TaskSevenn{
public static void main(String[] args){
int total = 0;
int sum = 0;
for(int i =1; i <= 5; i++){
   sum+=(Math.pow(4, i));
}
System.out.print(sum);
for(int i =1; i <= 5; i++){
   total+=(Math.pow(8, i));
}
 System.out.print(total);
}
}
