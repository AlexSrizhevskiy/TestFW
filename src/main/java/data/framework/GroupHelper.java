package data.framework;

import data.objects.GroupObjects;

public class GroupHelper {
    private NavigationHelper helper;

    public void createGroup(GroupObjects groupObject) {
		helper = new NavigationHelper();
        helper.openMainPage();
        helper.openGroupTab();
        createNewGroup();
        fillGroupForm(groupObject);
        submitGroupCreation();
        helper.openGroupTab();
    }

    public void fillGroupForm(GroupObjects groupObjects) {
        helper.inputValue("group_name", groupObjects.nameGroup);
        helper.inputValue("group_header", groupObjects.headerGroup);
        helper.inputValue("group_footer", groupObjects.footerGroup);
    }

    public void createNewGroup() {
        helper.clickByText("new");
    }

    public void submitGroupCreation() {
        helper.clickByText("submit");
    }
}
