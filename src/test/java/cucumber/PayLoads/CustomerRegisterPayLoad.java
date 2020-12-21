package cucumber.PayLoads;

public class CustomerRegisterPayLoad {
	
	public String name;

	public String contactName;

	public String phoneNumber;

	public String emailId;

	public String contactMethod;

	public String additionalInfo;

    public CustomerRegisterPayLoad() {
    	
    }
    
    public CustomerRegisterPayLoad(String name, String contactName, String phoneNumber, 
    		String emailId, String contactMethod, String additionalInfo) {
    	this.name = name;
    	this.contactName = contactName;
    	this.phoneNumber = phoneNumber;
    	this.emailId = emailId;
    	this.contactMethod = contactMethod;
    	this.additionalInfo = additionalInfo;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setContactName(String contactName){
        this.contactName = contactName;
    }
    public String getContactName(){
        return this.contactName;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setEmailId(String emailId){
        this.emailId = emailId;
    }
    public String getEmailId(){
        return this.emailId;
    }
    public void setContactMethod(String contactMethod){
        this.contactMethod = contactMethod;
    }
    public String getContactMethod(){
        return this.contactMethod;
    }
    public void setAdditionalInfo(String additionalInfo){
        this.additionalInfo = additionalInfo;
    }
    public String getAdditionalInfo(){
        return this.additionalInfo;
    }

}
