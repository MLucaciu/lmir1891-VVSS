package agenda.model.base;

public class User {
	private String username;
	private String password;
	private String name;
	
	public User(String name, String username, String password)
	{
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public String getName(){ return name;}
	public String getUsername(){ return username; }
	
	public boolean isPassword(String password)
	{
		return this.password.equals(password);
	}
	
	public boolean setPassword(String oldPasswd, String newPasswd)
	{
		if (oldPasswd.equals(password))
		{
			password = newPasswd;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name +
				"#" +
				username +
				"#" +
				password;
	}
	
	public static User fromString(String s)
	{
		String[] str = s.split("#");
		try
		{
			return new User(str[0], str[1], str[2]);
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof User)) return false;
		User u = (User)obj;
		return u.name.equals(name) && u.username.equals(username) && u.password.equals(password);
	}
}
