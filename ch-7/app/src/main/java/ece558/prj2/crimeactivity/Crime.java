package ece558.prj2.crimeactivity;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;           //UUID is a android class, provide easy way to generate unique UUID
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Crime() {
        mId = UUID.randomUUID(); //generates a random UUID
        mDate = new Date();      //Sets the defaullt date of the crime
    }
}
