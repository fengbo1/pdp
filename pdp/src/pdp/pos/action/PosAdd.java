package pdp.pos.action;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import ccb.hibernate.HibernateSessionFactory;
import pdp.norm.pojo.Norm;
import pdp.pos.dao.PositionDAO;
import pdp.pos.pojo.Position;
import pdp.util.Util;

public class PosAdd extends ActionSupport implements ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private String name;
	private String chu;
	private double propa;
	private double propb;
	private double propc;
	private String message;
	private List<Norm> listnorm;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public double getPropa() {
		return propa;
	}
	public void setPropa(double propa) {
		this.propa = propa;
	}
	public double getPropb() {
		return propb;
	}
	public void setPropb(double propb) {
		this.propb = propb;
	}
	public double getPropc() {
		return propc;
	}
	public void setPropc(double propc) {
		this.propc = propc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Norm> getListnorm() {
		return listnorm;
	}
	public void setListnorm(List<Norm> listnorm) {
		this.listnorm = listnorm;
	}
	public String execute() throws Exception
	{
		PositionDAO pdao = new PositionDAO();
		Position p = new Position();
		Query query;
		String hql = "";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    BigDecimal b1 = new BigDecimal(Double.valueOf(propa));
 	    BigDecimal b2 = new BigDecimal(Double.valueOf(propb));
 	    BigDecimal b3 = new BigDecimal(Double.valueOf(propc));
 	    
 	    double prop = b1.add(b2).add(b3).doubleValue();
 	    if(name.equals(""))
		  {
			 this.addFieldError("用户","岗位名为空");
			  	 return "failed";
		  } 
		  else if(chu.equals("")||chu.equals("wu"))
		  {
			 this.addFieldError("用户","处室为空");
		  	 return "failed";
		  }
		  else if(propa==0.00)
		  {
			 this.addFieldError("用户",Util.NormToString("propa")+"权重为空");
		  	 return "failed";
		  }
		  else if(propb==0.00)
		  {
			 this.addFieldError("用户",Util.NormToString("propb")+"权重为空");
		  	 return "failed";
		  }
		  else if(propc==0.00)
		  {
			 this.addFieldError("用户",Util.NormToString("propc")+"权重为空");
		  	 return "failed";
		  }
		  else if (prop!=1.00)
		  {
			  this.addFieldError("用户","权重之和不为1");
			   return "failed";
		  }
 	    Position ptmp = pdao.findAllByNameAndChu(name, chu);
 	    if(ptmp!=null)
 	    {
 	    	if(ptmp.getStatus()<2)
 	    	{
 	    		p = ptmp;
 	    		p.setName(name);
 	 	 	    p.setChu(chu);
 	 	 	    p.setPropa(propa);
 	 	 	    p.setPropb(propb);
 	 	 	    p.setPropc(propc);
 	 	 	    p.setStatus(1);
 	 	 	    pdao.merge(p);
 	    	}
 	    	else
 	    	{
 	    		this.addFieldError("用户","已有名称"+name+"为处室为"+Util.ChuToString(chu)+"的岗位，请勿重复添加！");
 	    	}
 	    }
 	    else
 	    {
 	    	p.setName(name);
 	 	    p.setChu(chu);
 	 	    p.setPropa(propa);
 	 	    p.setPropb(propb);
 	 	    p.setPropc(propc);
 	 	    p.setStatus(1);
 	 	    pdao.merge(p);
 	    }
 	   
 	    
 	    message="添加成功";
 		hql = "from Norm as n where n.type='norma' order by level";
		System.out.println(hql);
		query = session.createQuery(hql);
		listnorm = query.list();
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
}
