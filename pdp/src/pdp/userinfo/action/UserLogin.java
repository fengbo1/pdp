package pdp.userinfo.action;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.userinfo.pojo.UserInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport implements ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
    private Transaction trans;
    private String hql;
    private Query query;
    private int errNum = 0;
    private int restNum;
    
    Timestamp d = new Timestamp(System.currentTimeMillis());
    

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Transaction getTrans() {
		return trans;
	}


	public void setTrans(Transaction trans) {
		this.trans = trans;
	}


	public String getHql() {
		return hql;
	}


	public void setHql(String hql) {
		this.hql = hql;
	}


	public Query getQuery() {
		return query;
	}


	public void setQuery(Query query) {
		this.query = query;
	}
   public void setServletResponse(HttpServletResponse response)
       {
       }

	public String execute() throws Exception
	{
		  int views = 0;//访问量统计
		  Session h_session=HibernateSessionFactory.getSession();
		  trans=h_session.beginTransaction();
		  //username=new String(username.getBytes("ISO8859-1"),"UTF-8");
		  hql="from UserInfo as user where user.username='"+username+"' and user.password='"+password+"'";
		  query=h_session.createQuery(hql);
          List<UserInfo> l=query.list();
     	  if((l==null)||(l.size()<=0))
     	  {
     		  this.addFieldError("用户","用户不存在!");
			  return "failed";
     	  }
     	  else 
     	  {
     		  UserInfo u=(UserInfo)(l.get(0));
     		  id=u.getId();
     		  System.out.print("username:"+username);
     		  System.out.print("password:"+password);
     		  System.out.print("DBpwd:"+u.getPassword());
     		 if(ActionContext.getContext().getSession().get(username) == null)
 			 {
 				 errNum = 0;
 			 }
 			 else{
 				 errNum=(Integer)ActionContext.getContext().getSession().get(username);
 			 }
 			 System.out.print(ActionContext.getContext().getSession().get(username));
 			 if(errNum>=5)
 			 {
 				this.addFieldError("用户","该用户已经被锁定,请找管理员解锁");
				return "failed";
 			 }
     		  if(!password.equals(u.getPassword()))
     		  {
     			 if(errNum==0)
        		  {
        			 errNum = errNum+1;
        			 ActionContext.getContext().getSession().put(username,errNum);  
        			 this.addFieldError("用户","密码输入错误");
       			  	 return "failed";
        		  }
     			 else 
     			 {
     					restNum = 5-errNum;
     					this.addFieldError("用户","你已经输入错误"+errNum+"次，还有"+restNum+"次");
     					errNum = errNum+1;
     					ActionContext.getContext().getSession().put(username,errNum);  
     					return "failed";
     			 }
     			
     		  }
     		  
     		  
     		  System.out.print("time1"+d);
        	  ActionContext.getContext().getSession().put("username",u.getUsername());
        	  ActionContext.getContext().getSession().put("newnumber",u.getNewnumber());
        	  ActionContext.getContext().getSession().put("zhis",u.getPosition().substring(0,1));//0武汉1成都
        	  ActionContext.getContext().getSession().put("paixus",u.getPosition().substring(1,2));//30303
        	  ActionContext.getContext().getSession().put("ids",id);
        	  
        	  //访问量统计
//        	  HttpSession session=null;
//        	  session.setAttribute("user", this.getUsername());
        	  trans.commit();
        	  h_session.flush();
        	  h_session.clear();
        	  h_session.close();
        	  return "success";
     	  }
     	 
	}
	
	
}
