package com.ulearn.main;

public class Module {
    private final String moduleName;
    private final String[] topics;
    private int currentTopicIndex;
    private String feedback;
    private boolean isComplete;

    public Module(String moduleName) {
        this.moduleName = moduleName;
        this.topics = new String[3];
        this.feedback = "";
        this.isComplete = false;
        currentTopicIndex = -1;
    }

    public String getmoduleName() {
        return moduleName;
    }

    public boolean hasNextTopic() {
        return currentTopicIndex < 2;
    }

    public String getNextTopic() {
        currentTopicIndex++;
        return topics[currentTopicIndex];
    }

    public void addTopic(String topic) {
        if (currentTopicIndex < 2) {
            currentTopicIndex++;
            topics[currentTopicIndex] = topic;
        } else {
            System.out.println("Sorry, you cannot add more topics to this module.");
        }
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void markAsComplete() {
        this.isComplete = true;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public String getFeedback() {
        return feedback;
    }
}

