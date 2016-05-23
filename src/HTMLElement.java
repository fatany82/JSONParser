
public class HTMLElement {
	
	private String viewType; 
	
	private String value;

	public HTMLElement() {
		super();
	}

	public HTMLElement(String name, String value) {
		super();
		this.viewType = name;
		this.value = value;
	}

	public String getViewType() 
	{
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	

}
