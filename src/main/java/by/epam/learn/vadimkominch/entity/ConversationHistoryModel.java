package by.epam.learn.vadimkominch.entity;

public class ConversationHistoryModel {

    private long startTime;
    private long endTime;
    private int convId;

    public ConversationHistoryModel() {
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getConvId() {
        return convId;
    }

    public void setConvId(int convId) {
        this.convId = convId;
    }
}
