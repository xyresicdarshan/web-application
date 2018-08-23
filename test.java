import java.sql.*;
class Xtal
{
public static void main(String xd[])
{
try
{
java.util.Scanner sc=new java.util.Scanner(System.in);
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop","root","root");
System.out.println("Enter the values I for Insert, U for Update, D for Delete, S for show");
String a=sc.next();
switch(a)
{
case"I": System.out.println("Insert");
	System.out.println("Enter the Id");
	int id=sc.nextInt();
	System.out.println("Enter name");
	String name=sc.next();
	String qr="insert into emp values(?,?)";
 	PreparedStatement ps=con.prepareStatement(qr);
	ps.setInt(1,id);
	ps.setString(2,name);
	int i=ps.executeUpdate();
	System.out.println(i+" RECORD inserted");
	if (i > 0)            
                System.out.println("Successfully Inserted");            
            else           
                System.out.println("Insert Failed");
break;
case"U": System.out.println("Update");
	System.out.println("Enter the Id");
	int id1=sc.nextInt();
System.out.println("Enter name");
String name1=sc.next();
	String q1="UPDATE emp set name=? where id=?";
 	PreparedStatement p1=con.prepareStatement(q1);
	p1.setInt(2,id1);
	p1.setString(1,name1);
	int j=p1.executeUpdate();
System.out.println(j+" RECORD Updated");
if (j > 0)            
                System.out.println("Successfully Updated");            
            else           
                System.out.println("ERROR OCCURED :");
break;
case"D": System.out.println("Delete");
System.out.println("Enter ID");
int id2=sc.nextInt();
	String q2="DELETE from emp WHERE id=?";
 	PreparedStatement p2=con.prepareStatement(q2);
	p2.setInt(1,id2);
	int k=p2.executeUpdate();
System.out.println(k+" RECORD Deleted");
if (k> 0)            
                System.out.println("One User Successfully Deleted");            
            else
                System.out.println("ERROR OCCURED :");
break;
case"S": System.out.println("Show");
	String q3="SELECT * from emp";
	Statement p3=con.createStatement();
	ResultSet rs=p3.executeQuery(q3);
if(rs.next())
{
System.out.println(rs.getInt("id")+" "+rs.getString("name"));
}
else
{
System.out.println("no records found");
}
break;
default : System.out.println("Invalid choice");
}
System.out.println();
}catch(Exception e)
{
System.out.println(e);
}
}
}
