package pdp.norm.action;

public class BeforeNormAdd {

	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String execute() throws Exception
	{	
		return "success";
	}
}
