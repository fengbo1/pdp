package pdp.pos.action;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.norm.pojo.Norm;
import pdp.pos.dao.PositionDAO;
import pdp.pos.pojo.Position;
import ccb.hibernate.HibernateSessionFactory;

public class PosAddD {
	private String[] norm;
	private String[] normprop;
	private int posid;
	private String message;
	public String[] getNorm() {
		return norm;
	}
	public void setNorm(String[] norm) {
		this.norm = norm;
	}
	public String[] getNormprop() {
		return normprop;
	}
	public void setNormprop(String[] normprop) {
		this.normprop = normprop;
	}
	public int getPosid() {
		return posid;
	}
	public void setPosid(int posid) {
		this.posid = posid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		Query query;
		String hql = "";
		String normcun = "";
		String normpropcun = "";
		int propnum=0;
		if(norm!=null&&norm.length!=0)
		{	
		  normcun =norm[0];
		 for(int i=1;i<norm.length;i++)
	    {
			normcun += "、";
			normcun += norm[i];
	    }
		}
		if(normprop!=null&&normprop.length!=0)
		{	
		  //normpropcun =normprop[0];
		  for(int i=0;i<normprop.length;i++)
	    {
			if(normprop[i]!="")
			{				
			   normpropcun += normprop[i];
			   normpropcun += "、";
			   propnum++;
			}
	    }
		  if(propnum!=0)
		  {	  
		  normpropcun=normpropcun.substring(0, normpropcun.length()-1);
		  }
		}
		if(propnum==0)
		{
			message="指标权重未填！";
			return "failed";
		}
		if(norm==null||norm.length==0)
		{
			message="指标未选！";
			return "failed";
		}
		if(norm.length!=propnum)
		{
			message="指标数量和指标权重数量不匹配！";
			return "failed";
		}
		if(propnum!=0)
		{
			
			String propstr="";
			BigDecimal result = new BigDecimal("0");
			for(int i=0;i<normprop.length;i++)
		    {
				if(normprop[i]!="")
				{
					propstr= normprop[i];	
					BigDecimal b = new BigDecimal(propstr);			 	    
			 	    result = result.add(b);
				}	
		    }
			double prop=result.doubleValue();
			
			if(prop!=1.00)
			{
				message="指标权重数量之和不等于1！";
				return "failed";
			}
		}
		PositionDAO pdao=new PositionDAO();
		Position p =new Position();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    p=pdao.findAllById(posid);
 	    
 	    p.setNormd(normcun);
 	    p.setNormpropd(normpropcun);
 	    pdao.merge(p);
 	    message="添加成功";
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
