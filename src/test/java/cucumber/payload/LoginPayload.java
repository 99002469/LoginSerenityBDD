package cucumber.payload;

public class LoginPayload {
	
	    private String password;

	    private String email;

	    public LoginPayload() {
	    	
	    }
	    
	    public LoginPayload(String password, String email) {
	    	this.password = password;
	    	this.email = email;
	    }
	    public void setPassword(String password){
	        this.password = password;
	    }
	    public String getPassword(){
	        return this.password;
	    }
	    public void setEmail(String email){
	        this.email = email;
	    }
	    public String getEmail(){
	        return this.email;
	    }

}
