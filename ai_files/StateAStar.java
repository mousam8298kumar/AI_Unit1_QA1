import java.util.*;
class StateAStar{
String a,b,c;
StateAStar(String a,String b,String c){ this.a=a;this.b=b;this.c=c; }
boolean isGoal(StateAStar g){ return a.equals(g.a)&&b.equals(g.b)&&c.equals(g.c); }
String encode(){ return a+"|"+b+"|"+c; }
List<StateAStar> successors(){
List<StateAStar> s = new ArrayList<>();
move(a,b,c,"a","b",s);
move(a,c,b,"a","c",s);
move(b,a,c,"b","a",s);
move(b,c,a,"b","c",s);
move(c,a,b,"c","a",s);
move(c,b,a,"c","b",s);
return s;
}
private void move(String from,String to,String other,String f,String t,List<StateAStar> list){
if(!from.isEmpty()){
char disk=from.charAt(from.length()-1);
if(to.isEmpty()||disk<to.charAt(to.length()-1)){
String na=a,nb=b,nc=c;
switch(f){ case "a": na=a.substring(0,a.length()-1); break;
case "b": nb=b.substring(0,b.length()-1); break;
case "c": nc=c.substring(0,c.length()-1); break; }
switch(t){ case "a": na+=disk; break;
case "b": nb+=disk; break;
case "c": nc+=disk; break; }
list.add(new StateAStar(na,nb,nc));
}
}
}
public String toString(){ return "A:"+a+" B:"+b+" C:"+c; }
}
public class AStar_Hanoi{
static int h(StateAStar s){ return 3 - s.c.length(); }
public static void main(String[] args){
StateAStar start=new StateAStar("321","","");
StateAStar goal =new StateAStar("","","321");
PriorityQueue<StateAStar> pq = new PriorityQueue<>(Comparator.comparingInt(x->h(x)));
HashSet<String> visited = new HashSet<>();
pq.add(start);
System.out.println("A* Search Traversal:");
while(!pq.isEmpty()){
StateAStar cur = pq.poll();
if(visited.contains(cur.encode())) continue;
visited.add(cur.encode());
System.out.println(cur);
if(cur.isGoal(goal)) break;
for(StateAStar nxt:cur.successors()) pq.add(nxt);
}
}
}
