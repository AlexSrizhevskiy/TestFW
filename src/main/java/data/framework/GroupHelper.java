package data.framework;

import data.objects.GroupObjects;

public class GroupHelper {

    private NavigationHelper manager;

    public GroupHelper(NavigationHelper manager) {
        this.manager = manager;
    }

    public void createGroup(GroupObjects groupObject) {
        manager.openMainPage();
        manager.openGroupTab();
        createNewGroup();
        fillGroupForm(groupObject);
        submitGroupCreation();
        manager.openGroupTab();
    }

    public void fillGroupForm(GroupObjects groupObjects) {
        manager.inputValue("group_name", groupObjects.nameGroup);
        manager.inputValue("group_header", groupObjects.headerGroup);
        manager.inputValue("group_footer", groupObjects.footerGroup);
    }

    public void createNewGroup() {
        manager.clickByText("new");
    }

    public void submitGroupCreation() {
        manager.clickByText("submit");
    }
}
