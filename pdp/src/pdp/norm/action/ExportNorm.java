package pdp.norm.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pdp.norm.bean.NormBean;
import pdp.norm.pojo.Norm;
import pdp.util.ExportExcel;
import pdp.util.Util;

import ccb.hibernate.HibernateSessionFactory;

public class ExportNorm {
	private String Path;
	private String type;

	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String execute() throws Exception{
		String filePath = "";
		String hql = "";
		List<Norm> list;
		List<NormBean> listnb = new ArrayList<NormBean>();
		ExportExcel<NormBean> ex = new ExportExcel<NormBean>();
		String[] headers =  {"指标编号","指标类型","指标名称","所处层级",
				"目标值","分值","考核规则","考核备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		hql = "from Norm as n where n.type='"+type+"' order by n.level";
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			Norm n = list.get(i);
			NormBean nb = new NormBean();
			nb.setId(String.valueOf(n.getId()));
			nb.setType(Util.NormToString(type));
			nb.setNormname(n.getName());
			nb.setLevel("");
			nb.setTarget(n.getTarget());
			nb.setStdscore(String.valueOf(n.getScore()));
			nb.setRule(n.getRule());
			nb.setRemark(n.getRemark());
			listnb.add(nb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"zhibiaomingxi.xls";
				Path = "zhibiaomingxi.xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("kbi指标明细",headers, listnb, out);
				out.close();
				System.out.println("excel导出成功！");
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return "success";
	}
}
