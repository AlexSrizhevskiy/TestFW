package data;

import objects.GroupObjects;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{

	@Test
	public void validGroupCanBeCreated() throws Exception {
		GroupObjects validGroup = new GroupObjects("asd", "asdasf", "asdasfsadf");
		createGroup(validGroup);
	}

	@Test
	public void groupWithEmptyDataCanBeCreated() throws Exception {
		GroupObjects emptyData = new GroupObjects("", "", "");
		createGroup(emptyData);
	}

}
