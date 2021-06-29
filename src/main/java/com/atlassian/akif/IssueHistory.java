package com.atlassian.akif;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.changehistory.ChangeHistory;
import com.atlassian.jira.issue.changehistory.ChangeHistoryManager;
import com.atlassian.jira.issue.comments.CommentManager;
import org.ofbiz.core.entity.GenericValue;

import java.util.Date;
import java.util.List;

public class IssueHistory
{
    Issue issue;
    List<ChangeHistory> changeHistoryList;
    ChangeHistoryManager changeHistoryManager = ComponentAccessor.getChangeHistoryManager();
    CommentManager commentManager = ComponentAccessor.getCommentManager();

    IssueHistory(Issue _issue)
    {
      this.issue = _issue;
      this.changeHistoryList = changeHistoryManager.getChangeHistories(issue);
    }

    public String getChangeHistoryList()
    {
        List<GenericValue> changeItems = changeHistoryList.get(changeHistoryList.size()-1).getChangeItems();
        GenericValue lastChange = changeItems.get(changeItems.size()-1);
        if(lastChange.containsKey("comment"))
        {
            return lastChange.get("comment").toString();
        }
        return "Yorum yok.";
    }



    String getChangeAuthor()
    {
        return changeHistoryList.get(changeHistoryList.size()-1).getAuthorKey();
    }

    String getLastComment()
    {
        return commentManager.getLastComment(issue).getBody();
    }

    String getLastCommentAuthor()
    {
        return commentManager.getLastComment(issue).getAuthorFullName();
    }

    Date getLastCommentDate()
    {
        return commentManager.getLastComment(issue).getCreated();
    }
}
