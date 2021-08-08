/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hostel;

import java.io.*;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 *
 * @Samiran
 */

@WebServlet(name = "Hostel", urlPatterns = {"/Hostel"})
public class Hostel extends HttpServlet//hostel-sservlet
{
    
    static ArrayList std_name=new ArrayList();//STUDENT REGISTRATION
    static ArrayList std_id=new ArrayList();
    static ArrayList std_pwd=new ArrayList();
    static ArrayList room=new ArrayList();//STORING ROOM VALUES
    static String statusid="";
    static String hellostatus="";
    String name,id,pwd;
    static int f;
    
    
    //ADMIN FUNCTIONS
    public void doGetA(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html>    \n" +
"<head>  \n" +
"<style>\n" +
"body {\n" +
"  background-image: url('alogin.jpg');\n" +
"}\n" +
"</style>\n" +
"    <title>ADMIN LOGIN</title>    \n" +
"    <link rel=\"stylesheet\" type=\"text/css\" href=\"alogin.css\">    \n" +
"</head>    \n" +
"<body> \n" +
" \n" +
"    <h1>ADMIN ACCESS</h1>\n" +
"<ul>\n" +
"  <li><a href=\"Welcome.html\">LOGOUT</a></li>\n" +
"  <li><a href=\"admin-page.html\">Admin-Login</a></li>\n" +
"  <li><a href=\"Student-page.html\">Student Login</a></li>\n" +

"  <li><a href=\"insert.html\">INSERT</a></li>\n" +
"  <li><a href=\"update.html\">UPDATE</a></li>\n" +
"  <li><a href=\"#\" onclick=\"fun()\">DELETE</a></li>\n" +
"  <li><a href=\"Welcome.html\">HOME</a></li>\n" +
"  \n" +
"</ul>\n" +
" \n" +
"<table>\n" +
" <caption><b>CHECK IN TABLE</b></caption>\n" +
"<tr>\n" +
"	<th>#ID</th>\n" +
"	<th>TYPE</th>\n" +
"	<th>LOCATION</th>\n" +
"	<th>CHARGE</th>\n" +
"	<th>ROOM STATUS</th>\n" +
"	<th>PAYMENT STATUS</th>\n" +
"	\n" +
"</tr>");
        for(int i=0;i<room.size();)  
{
 
      pw.println(" <tr>\n" +
"    <td>"+room.get(i)+" </td>\n" +
"    <td> "+room.get(i+1)+"</td>\n" +
"    <td> "+room.get(i+2)+"</td>\n" +
"    <td> "+room.get(i+3)+"</td>\n" +
"    <td> "+room.get(i+4)+"</td>\n" +
"    <td>Not Paid</td>\n" +"    \n" +
        "  </tr>");
   
         i=i+5;
  
}
       
        //DELETE BUTTON
        pw.println(
"            </table>\n" +

 
"<div class=\"login\" id=\"DEL\"> \n" +
"    \n" +
"   <form action=\"Hostel\" method=\"POST\"> \n" +
"        <label><b>ROOM ID</b></label><br>   \n" +
"        <input type=\"text\" name=\"DRI\" id=\"DRI\" placeholder=\"ROOM ID\" > <br> \n " +
"        <input type=\"submit\" name=\"submit\" id=\"del\" value=\"DELETE\" style=\"margin-top:5px;\">\n" +
"   </form>\n" +
"    \n" +
"</div>\n" +
"<script>document.getElementById(\"DEL\").style.display=\"none\";\n" +
"function fun(){\n" +//DISPLAYING DELETE BUTTON
" document.getElementById(\"DEL\").style.display=\"block\";   \n" +
"}\n" +
"</script>"      +
"</body>\n" +
"</html>");
    
    }
    //STUDENT TABLE
    public void doGetSt(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        pw.println("<html>\n" +
"<head>\n" +
"<style>\n" +
"body {\n" +
"  background-image: url('sbg2.jpg');\n" +
"}\n" + 
"</style>\n" +
"	<title>CheckIn Table</title>\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"welcome.css\">    \n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<ul>\n" +
"  <li><a href=\"Welcome.html\">LOGOUT</a></li>\n" +
"  <li><a href=\"admin-page.html\">Admin-Login</a></li>\n" +
"  <li><a href=\"Student-page.html\">Student Login</a></li>\n" +
"  <li><a href=\"#\">  <form action=\"Hostel\" method=\"POST\"><button type=\"submit\" name=\"submit\" value=\"Checkin\" style=\"background-color:#2bbded; border:none; font-weight:bold; font-size:20px; text-decoration: underline;\"  >AVAILABLE ROOMS</button></form></a></li>\n" +
"  <li><a href=\"Welcome.html\">HOME</a></li>\n" +
"  \n" +
"</ul>\n" +"<h2><p style=\"margin-left:30px;\"><b>Hello </b>"+hellostatus+",</p></h2>"+
"\n" +
"<table >\n" +
" <caption><b>CHECK IN TABLE</b></caption>\n" +
"<tr>\n" +
"	<th>#ID</th>\n" +
"	<th>TYPE</th>\n" +
"	<th>LOCATION</th>\n" +
"	<th>CHARGE</th>\n" +
"	<th>PAYMENT STATUS</th>\n" +
"	<th>CHECKOUT</th>\n" +
"	\n" +
"</tr>");
        
        for(int i=0;i<room.size();)  
{
    if(statusid.equals(room.get(i+4))){
          pw.println(" <tr>\n" +
"    <td>"+room.get(i)+" </td>\n" +
"    <td> "+room.get(i+1)+"</td>\n" +
"    <td> "+room.get(i+2)+"</td>\n" +
"    <td> "+room.get(i+3)+"</td>\n" + 
"    <td>Not Paid</td>\n" + 
"         <td><a href=\"#\"><form action=\"Hostel\" method=\"POST\"><button type=\"submit\" name=\"submit\" value=\"checkout"+room.get(i)+"\" style=\"background-color:#2bbded; border:none; font-weight:bold; font-size:20px; text-decoration: underline;\">Checkout</button></form></a></td>\n" +
"              </tr>\n" );
            
        }
    i=i+5;}
        pw.println(
"            </table>\n" +

        
"</body>\n" +
"</html>");
   
    }
    
    public void doGetSRA(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html>\n" +
"<head>\n" +
"<style>\n" +
"body {\n" +
"  background-image: url('sbg2.jpg');\n" +
"}\n" +
"</style>\n" +
"	<title>CheckIn Table</title>\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"welcome.css\">    \n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<ul>\n" +
"  <li><a href=\"Welcome.html\">LOGOUT</a></li>\n" +
"  <li><a href=\"admin-page.html\">Admin-Login</a></li>\n" +
"  <li><a href=\"Student-page.html\">Student Login</a></li>\n" +
"  <li><a href=\"#\">  <form action=\"Hostel\" method=\"POST\"><button type=\"submit\" name=\"submit\" value=\"Checkin\" style=\"background-color:#2bbded; border:none; font-weight:bold; font-size:20px; text-decoration: underline;\">AVAILABLE ROOMS</button></form></a></li>\n" +
"  <li><a href=\"Welcome.html\">HOME</a></li>\n" +
"  \n" +
"</ul>" +
"\n" +"\n"+"<h2><p style=\"margin-left:30px;\"><b>Hello </b>"+hellostatus+",</p></h2>"+
"<table >\n" +
" <caption><b>CHECK IN TABLE</b></caption>\n" +
"<tr>\n" +
"	<th>#ID</th>\n" +
"	<th>TYPE</th>\n" +
"	<th>LOCATION</th>\n" +
"	<th>CHARGE</th>\n" +
"	<th>PAYMENT STATUS</th>\n" +
"	<th>CHECK IN</th>\n" +
"	\n" +
"</tr>");
        int j=0; 
for(int i=0;i<room.size();)  
{
  
    if(room.get(i+4).equals("Available"))
    {
          pw.println(" <tr>\n" +
"    <td>"+room.get(i)+" </td>\n" +
"    <td> "+room.get(i+1)+"</td>\n" +
"    <td> "+room.get(i+2)+"</td>\n" +
"    <td> "+room.get(i+3)+"</td>\n" +
"        <td>Not Paid</td>\n" +
"<td><a href=\"#\"><form action=\"Hostel\" method=\"POST\"><button type=\"submit\" class=\"mybutton\" name=\"submit\" value=\"check-in"+j+"\" style=\"background-color:#2bbded; border:none; font-weight:bold; font-size:20px; text-decoration: underline;\">CHECK-IN</button></form></a></td>\n" +

"    \n" +
"  </tr>");
    
    }
    i=i+5;
    j++; //to get the exact indexes of rooms available
  
}
        
pw.println(
"</table>\n" +
"\n" +
"</body>\n" +
"</html>\n" +
"\n" +
"");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        String chk_btn=req.getParameter("submit");//VAALUE OF CLICKED PARAM
        
        if(chk_btn.equals("SIGN UP"))//STUDENT REGISTRATION
        {
            f=1;
            name = req.getParameter("Fname");
            id= req.getParameter("Uname");
            pwd= req.getParameter("Pass");
            
            res.sendRedirect("Student-page.html");
            
        }
        
        else if(chk_btn.equals("LOG IN"))//STUDENT SIGN IN
        {
            String id= req.getParameter("Uname");
            String pwd= req.getParameter("Pass");
            int c=0;
            
            if(id.equalsIgnoreCase("Sam") && pwd.equals("1234"))
            {
                c=2;
                statusid=" Taken by "+id;
                hellostatus =id;
                doGetSt(req,res);
            }
            else if(c!=2)
            {
            for(int i=0;i<std_id.size();i++)
            {
                if(id.equals(std_id.get(i)) && pwd.equals(std_pwd.get(i)))
                {
                    c=1;
                    statusid=" Taken by "+id;
                    hellostatus=id;
                    doGetSt(req,res);//FUNCTION CALL
                }
            
            }
            }
            if(c==0)
            {
                pw.println("<html>\n" +
"    \n" +
"    <body>\n" +
"        <script>\n" +
"            alert(\"INVALID USERNAME or Password\");\n" +
                        "location.replace(\"Student-page.html\")\n"+
"            </script>\n" +
"    </body>\n" +
"    \n" +
"</html>");
            }
        }
        
        else if(chk_btn.equals("ADMIN-LOGIN"))//ADMIN SIGN IN
        {
            String usr= req.getParameter("Uname");
            String pwd= req.getParameter("Pass");

            if(usr.equalsIgnoreCase("admin") && pwd.equals("1234"))
            {
                
                doGetA(req,res);
            }
            else
            {
               
                pw.println("<html>\n" +
"    \n" +
"    <body>\n" +
"        <script>\n" +
"            alert(\"INVALID USERNAME or Password\");\n" +
                        "location.replace(\"admin-page.html\")\n"+
"            </script>\n" +
"    </body>\n" +
"    \n" +
"</html>");
            }
        }
        
        else if (chk_btn.equals("INSERT"))//INSERT ROOMS
        {
            int f = 0;
            id = req.getParameter("RI");
            pwd = req.getParameter("RT");
            String rl = req.getParameter("RL");
            String rc = req.getParameter("RC");
            for(int i=0;i<room.size();i=i+5)
            {
                if(id.equals(room.get(i)))
                {
                    f=1;
                    break;
                }
            }
            if(f==0)
            {
            room.add(id);
            room.add(pwd);
            room.add(rl);
            room.add(rc);
            room.add("Available");
           
            doGetA(req,res);
            
            }
            else
            {
                 pw.println("<html>\n" +
"    \n" +
"    <body>\n" +
"        <script>\n" +
"            alert(\"ROOM ID EXISTS \");\n" +
                        "location.replace(\"insert.html\")\n"+
"            </script>\n" +
"    </body>\n" +
"    \n" +
"</html>");
        }  
        }      
        
         else if (chk_btn.equals("UPDATE"))//UPDATING ROOMS
        { 
            int c=0;
            
            id = req.getParameter("RI");
            pwd = req.getParameter("RT");
            String rl = req.getParameter("RL");
            String rc = req.getParameter("RC");
            
            
            for(int i=0;i<room.size();i=i+5)
            {
                if(id.equals(room.get(i)))//CHECKING ROOM ID EXISTS
                {
                    c=1;
                    room.set(i,id);
                room.set(i+1,pwd);
                room.set(i+2,rl);
                room.set(i+3,rc);
              
                doGetA(req,res);
                }
            }
            if(c==0)
            {
                pw.println("<html>\n" +
"    \n" +
"    <body>\n" +
"        <script>\n" +
"            alert(\"ROOM ID DOES NOT EXISTS\");\n" +
                        "location.replace(\"update.html\")\n"+
"            </script>\n" +
"    </body>\n" +
"    \n" +
"</html>");
                
            }
            
        }
        
        else if(chk_btn.equals("DELETE"))//DELETING ROOMS
        {
           id = req.getParameter("DRI");
           int c=0;
           for(int i=0;i<room.size();i=i+5)//TO REMOVE ALL THE ELEMENTS IN THAT ROW
           {
               if(id.equals(room.get(i)))
               {
                   c=1;
                   room.remove(i);
                   room.remove(i);
                   room.remove(i);
                   room.remove(i);
                   room.remove(i);
                   break;
               }
           }
           if(c==1)
           {
               doGetA(req,res);
           }
           else
           {
              pw.println("<html>\n" +
"    \n" +
"    <body>\n" +
"        <script>\n" +
"            alert(\"Room id does not exist\");\n" +
                        
"            </script>\n" +
"    </body>\n" +
"    \n" +
"</html>");
              doGetA(req,res);
              
           }
        }
        
         else if(chk_btn.equals("Checkin"))//STUDENT LOBBY TO AVAILABLE ROOM
        {
           doGetSRA(req,res); 
        }
        
         else if(chk_btn.startsWith("check-in"))//AVAILABLE ROOM TO STUDENT LOBBY 
        {
           String s=chk_btn.substring(8);//
           int n=Integer.parseInt(s);
           room.set((n*5)+4,statusid); //accesing 5elements together
           
           doGetSt(req,res);
        }   
        
        else if(chk_btn.startsWith("checkout"))//STUDENT LOGIN TO STUDENT LOGIN
        {
           
           String s=chk_btn.substring(8);
           for(int i=0;i<room.size();i=i+5)
           {
               if(s.equals(room.get(i)))
               {
                   room.set(i+4,"Available");
                   
                   break;
               }
           }
           doGetSt(req,res);
        }   
    }
    
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
        PrintWriter pw = res.getWriter();
        Hostel ob=new Hostel();//CREATING OBJECTS
        ob.doGet(req, res);        
        
        if(f==1)
        {
            f=0;            //ADDING DATA INTO LIST
            std_name.add(ob.name);
            std_id.add(ob.id);
            std_pwd.add(ob.pwd);
        }
                      
        
        pw.close();
    }
}
