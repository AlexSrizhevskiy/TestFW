package data.objects;

public class ContactObjects {
	public final String firstName;
	public final String lastName;
	public final String address;
	public final String homeTelNum;
	public final String mobileTelNum;
	public final String workTelNum;
	public final String email;
	public final String emailSecondary;

	public ContactObjects(String firstName, String lastName, String address, String homeTelNum, String mobileTelNum, String workTelNum, String email, String emailSecondary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homeTelNum = homeTelNum;
		this.mobileTelNum = mobileTelNum;
		this.workTelNum = workTelNum;
		this.email = email;
		this.emailSecondary = emailSecondary;
	}
}
