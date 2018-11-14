package pdp.pos.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.norm.bean.PdpBean;
import pdp.norm.dao.NormDAO;
import pdp.norm.pojo.Norm;
import pdp.pos.dao.PositionDAO;
import pdp.pos.pojo.Position;
import pdp.util.Util;
import ccb.hibernate.HibernateSessionFactory;

public class PosShow {
	private int id;
	private Position pp;
	private List<PdpBean> lista;
	private List<PdpBean> listb;
	private List<PdpBean> listc;
	private List<PdpBean> listd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Position getPp() {
		return pp;
	}
	public void setPp(Position pp) {
		this.pp = pp;
	}
	public List<PdpBean> getLista() {
		return lista;
	}
	public void setLista(List<PdpBean> lista) {
		this.lista = lista;
	}
	public List<PdpBean> getListb() {
		return listb;
	}
	public void setListb(List<PdpBean> listb) {
		this.listb = listb;
	}
	public List<PdpBean> getListc() {
		return listc;
	}
	public void setListc(List<PdpBean> listc) {
		this.listc = listc;
	}
	public List<PdpBean> getListd() {
		return listd;
	}
	public void setListd(List<PdpBean> listd) {
		this.listd = listd;
	}
	public String execute() throws Exception
	{
		PositionDAO pdao = new PositionDAO();
		NormDAO ndao = new NormDAO();
		lista = new ArrayList<PdpBean>();
		listb = new ArrayList<PdpBean>();
		listc = new ArrayList<PdpBean>();
		listd = new ArrayList<PdpBean>();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		
    		pp = pdao.findAllById(id);
    		if(pp!=null)
    		{
    			String[] as = pp.getNorma().split("、");
        		String[] bs = pp.getNormb().split("、");
        		String[] cs = pp.getNormc().split("、");
        		String[] ds = pp.getNormd().split("、");
        		
        		String[] aps = pp.getNormpropa().split("、");
        		String[] bps = pp.getNormpropb().split("、");
        		String[] cps = pp.getNormpropc().split("、");
        		for(int i=0;i<as.length;i++)
        		{
        			int tempa = Integer.valueOf(as[i]);
        			Norm tempan = ndao.findAllById(tempa);
        			if(tempan!=null)
        			{
        				PdpBean temppb = new PdpBean();
        				temppb.setId(tempan.getId());
        				temppb.setName(tempan.getName());
        				temppb.setTarget(tempan.getTarget());
        				if(aps[i].equals("-1"))
        				{
        					temppb.setScore("0");
        					temppb.setZf("扣分项");
        				}
        				else
        				{
        					temppb.setScore("");
        					temppb.setZf("得分项");
        				}
        				temppb.setRule(tempan.getRule());
        				lista.add(temppb);
        			}
        		}
        		for(int i=0;i<bs.length;i++)
        		{
        			int tempb = Integer.valueOf(bs[i]);
        			Norm tempbn = ndao.findAllById(tempb);
        			if(tempbn!=null)
        			{
        				PdpBean temppb = new PdpBean();
        				temppb.setId(tempbn.getId());
        				temppb.setName(tempbn.getName());
        				temppb.setTarget(tempbn.getTarget());
        				temppb.setScore(Util.DoubleTo2(tempbn.getScore()*Double.parseDouble(bps[i])*pp.getPropb()));
        				temppb.setRule(tempbn.getRule());
        				listb.add(temppb);
        			}
        		}
        		for(int i=0;i<cs.length;i++)
        		{
        			int tempc = Integer.valueOf(cs[i]);
        			Norm tempcn = ndao.findAllById(tempc);
        			if(tempcn!=null)
        			{
        				PdpBean temppb = new PdpBean();
        				temppb.setId(tempcn.getId());
        				temppb.setName(tempcn.getName());
        				temppb.setTarget(tempcn.getTarget());
        				temppb.setScore(Util.DoubleTo2(tempcn.getScore()*Double.parseDouble(cps[i])*pp.getPropc()));
        				temppb.setRule(tempcn.getRule());
        				listc.add(temppb);
        			}
        		}
        		for(int i=0;i<ds.length;i++)
        		{
        			int tempd = Integer.valueOf(ds[i]);
        			Norm tempdn = ndao.findAllById(tempd);
        			if(tempdn!=null)
        			{
        				PdpBean temppb = new PdpBean();
        				temppb.setId(tempdn.getId());
        				temppb.setName(tempdn.getName());
        				temppb.setTarget(tempdn.getTarget());
        				temppb.setScore(String.valueOf(tempdn.getScore()));
        				temppb.setRule(tempdn.getRule());
        				listd.add(temppb);
        			}
        		}
    		}
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
}
