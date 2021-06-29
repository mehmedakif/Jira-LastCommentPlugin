# Jira-LastCommentPlugin
 Plugin that show last comment on Jira Issue.
#Requirments
-   Atlas SDK
-   Java JDK 8.0
#Run
 You can tun by typing 
 ```bash
 atlas-run
  ```

#Usage
- Instantiate one IssueHistory object by passing the Issue:
 ```java
   IssiueHistory issueHistory = new IssueHistory(<Issue>)
 ```
- Get the latest changes comment:
 ```java
   issueHistory.getChangeComment()
 ```


