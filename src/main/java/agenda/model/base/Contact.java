package agenda.model.base;

import agenda.exceptions.InvalidFormatException;

public class Contact {
	private String Name;
	private String Address;
	private String Telefon;
	
	public Contact(){
		Name = "";
		Address = "";
		Telefon = "";
	}
	
	public Contact(String name, String address, String telefon) throws InvalidFormatException{
		if (!validTelefon(telefon)) throw new InvalidFormatException("Cannot convert", "Invalid phone number");
		if (!validName(name)) throw new InvalidFormatException("Cannot convert", "Invalid name");
		if (!validAddress(address)) throw new InvalidFormatException("Cannot convert", "Invalid address");
		Name = name;
		Address = address;
		Telefon = telefon;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) throws InvalidFormatException {
		if (!validName(name)) throw new InvalidFormatException("Cannot convert", "Invalid name");
		Name = name;
	}

	public static Contact fromString(String str, String delim) throws InvalidFormatException
	{
		String[] s = str.split(delim);
		if (s.length!=3) throw new InvalidFormatException("Cannot convert", "Invalid data");
		if (!validTelefon(s[2])) throw new InvalidFormatException("Cannot convert", "Invalid phone number");
		if (!validName(s[0])) throw new InvalidFormatException("Cannot convert", "Invalid name");
		if (!validAddress(s[1])) throw new InvalidFormatException("Cannot convert", "Invalid address");
		
		return new Contact(s[0], s[1], s[2]);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Name);
		sb.append("#");
		sb.append(Address);
		sb.append("#");
		sb.append(Telefon);
		sb.append("#");
		return sb.toString();
	}
	
	private static boolean validName(String str)
	{
		
		String[] s = str.split("[\\p{Punct}\\s]+");
		return s.length <= 2;
	}
	
	private static boolean validAddress(String str)
	{
		return true;
	}
	
	private static boolean validTelefon(String tel) {
		String[] s = tel.split("[\\p{Punct}\\s]+");
		return tel.charAt(0) == '+' && s.length == 2 || tel.charAt(0) == '0' && s.length == 1;
	}
	
		
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Contact)) return false;
		Contact o = (Contact)obj;
		return Name.equals(o.Name) && Address.equals(o.Address) &&
				Telefon.equals(o.Telefon);
	}
	
}
