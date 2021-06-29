package com.atlassian.akif;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.plugin.webfragment.contextproviders.AbstractJiraContextProvider;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;
import com.atlassian.jira.user.ApplicationUser;

import java.util.HashMap;
import java.util.Map;


public class CommentHistory extends AbstractJiraContextProvider {

    @Override
    public Map<String, Object> getContextMap(ApplicationUser applicationUser, JiraHelper jiraHelper)
    {
        Map<String, Object> contextMap = new HashMap<>();
        Issue currentIssue = (Issue) jiraHelper.getContextParams().get("issue");
        IssueHistory issueHistory = new IssueHistory(currentIssue);

        contextMap.put("LastComment", issueHistory.getLastComment());
        contextMap.put("LastCommentDate", issueHistory.getLastCommentDate());
        contextMap.put("LastCommentAuthor", issueHistory.getLastCommentAuthor());
        contextMap.put("Generic", issueHistory.getChangeComment());

        return contextMap;
    }
}