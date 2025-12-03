import java.util.*;
class StateBFS {
String a,b,c;
StateBFS(String a,String b,String c){ this.a=a;this.b=b;this.c=c; }
boolean isGoal(StateBFS g){ return a.equals(g.a) && b.equals(g.b) && c.equals(g.c); }
String encode(){ return a+"|"+b+"|"+c; }
List<StateBFS> successors(){
List<StateBFS> s = new ArrayList<>();
move(a,b,c,"a","b",s);
move(a,c,b,"a","c",s);
move(b,a,c,"b","a",s);
move(b,c,a,"b","c",s);
move(c,a,b,"c","a",s);
move(c,b,a,"c","b",s);
return s;
}
private void move(String from,String to,String other,String f,String t,List<StateBFS> list){
if(!from.isEmpty()){
char disk=from.charAt(from.length()-1);
if(to.isEmpty() || disk<to.charAt(to.length()-1)){
String na=a,nb=b,nc=c;
switch(f){ case "a": na=a.substring(0,a.length()-1); break;
case "b": nb=b.substring(0,b.length()-1); break;
case "c": nc=c.substring(0,c.length()-1); break; }
switch(t){ case "a": na+=disk; break;
case "b": nb+=disk; break;
case "c": nc+=disk; break; }
list.add(new StateBFS(na,nb,nc));
}
}
}
public String toString(){ return "A:"+a+" B:"+b+" C:"+c; }
}
public class BFS_Hanoi {
public static void main(String[] args){
StateBFS start = new StateBFS("321","","");
StateBFS goal = new StateBFS("","","321");
Queue<StateBFS> q = new LinkedList<>();
HashSet<String> visited = new HashSet<>();
q.add(start);
System.out.println("BFS Traversal:");
while(!q.isEmpty()){
StateBFS cur = q.poll();
if(visited.contains(cur.encode())) continue;
visited.add(cur.encode());
System.out.println(cur);
if(cur.isGoal(goal)) break;
for(StateBFS nxt : cur.successors()) q.add(nxt);
}
}
}
