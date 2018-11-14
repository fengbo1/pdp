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

public class PosAddB {
	private String[] norm;
	private String[] normprop;
	private int posid;
	private String message;
	private List<Norm> list;
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
	public List<Norm> getList() {
		return list;
	}
	public void setList(List<Norm> list) {
		this.list = list;
	}
	public String execute() throws Exception
	{
		Query query;
		String rst = "success";
		String hql = "";
		String normcun = "";
		String normpropcun = "";
		int propnum=0;
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
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
			rst = "failed";
		}
		else if(norm==null||norm.length==0)
		{
			message="指标未选！";
			rst =  "failed";
		}
		else if(norm.length!=propnum)
		{
			message="指标数量和指标权重数量不匹配！";
			rst =  "failed";
		}
		else if(propnum!=0)
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
				rst =  "failed";
			}
		}
		
 	   if(rst.equals("failed"))
	    {
	    	 hql = "from Norm as n where n.type='normb'";
	    }
	    else
	    {
	    	PositionDAO pdao=new PositionDAO();
			Position p =new Position();
			
	 	    p=pdao.findAllById(posid);
	 	    
	 	    p.setNormb(normcun);
	 	    p.setStatus(3);
	 	    p.setNormpropb(normpropcun);
	 	    pdao.merge(p);
	 	    message="添加成功";
	    	 hql = "from Norm as n where n.type='normc'";
	    }
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return rst;
	}
}
